package com.akka.distribute;

import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.metrics.ClusterMetricsChanged;
import akka.cluster.metrics.ClusterMetricsExtension;
import akka.cluster.metrics.NodeMetrics;
import akka.cluster.metrics.StandardMetrics;
import akka.cluster.metrics.StandardMetrics.Cpu;
import akka.cluster.metrics.StandardMetrics.HeapMemory;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.Option;

public class MetricsListener extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	Cluster cluster = Cluster.get(getContext().system());

	ClusterMetricsExtension extension = ClusterMetricsExtension.get(getContext().system());

	@Override
	public void preRestart(Throwable reason, Option<Object> message) throws Exception {
		extension.subscribe(getSelf());
	}

	@Override
	public void postStop() throws Exception {

		extension.unsubscribe(getSelf());

	}

	@Override
	public void onReceive(Object msg) throws Exception {

		if (msg instanceof ClusterMetricsChanged) {
			ClusterMetricsChanged clusterMetrics = (ClusterMetricsChanged) msg;
			for (NodeMetrics nodeMetrics : clusterMetrics.getNodeMetrics()) {

			}

		}

	}

	void logHeap(NodeMetrics nodeMetrics) {
		HeapMemory heap = StandardMetrics.extractHeapMemory(nodeMetrics);
		if (heap != null) {
			log.info("Used heap: " + ((double) heap.used()) / 1024 / 1024);
		}
	}

	void logCpu(NodeMetrics nodeMetrics) {
		Cpu cpu = StandardMetrics.extractCpu(nodeMetrics);
		if (cpu != null && cpu.systemLoadAverage().isDefined()) {
			log.info("Load: processors  )" + cpu.systemLoadAverage().get() + cpu.processors());
		}
	}

}
