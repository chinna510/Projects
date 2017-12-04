package com.akka.distribute;

import java.awt.Event;
import java.util.concurrent.TimeUnit;

import org.jboss.netty.util.internal.SharedResourceMisuseDetector;

import akka.actor.PoisonPill;
import akka.actor.ReceiveTimeout;
import akka.cluster.sharding.ShardRegion;
import akka.japi.Procedure;
import akka.persistence.UntypedPersistentActor;
import akka.util.Timeout;
import scala.concurrent.duration.Duration;

public class Counter extends UntypedPersistentActor {
	int count = 0;

	@Override
	public void preStart() throws Exception {
		// TODO Auto-generated method stub
		super.preStart();
		context().setReceiveTimeout(Duration.create(120, TimeUnit.SECONDS));
	}

	@Override
	public String persistenceId() {
		return "Counter-" + getSelf().path().name();
	}

	@Override
	public void onReceiveCommand(Object msg) throws Exception {

		if (msg instanceof Get)
			getSender().tell(count, getSelf());
		else if (msg == CounterOp.INCREMENT)
			persist(new CounterChanged(+1), new Procedure<CounterChanged>() {

				@Override
				public void apply(CounterChanged event) throws Exception {
					updateState(event);
				}
			});
		else if (msg == CounterOp.DECREMENT)
			persist(new CounterChanged(-1), new Procedure<CounterChanged>() {

				@Override
				public void apply(CounterChanged event) throws Exception {
					updateState(event);

				}
			});
		else if (msg.equals(ReceiveTimeout.getInstance()))
			getContext().parent().tell(new ShardRegion.Passivate(PoisonPill.getInstance()), getSelf());
		else {
			unhandled(msg);
		}
	}

	@Override
	public void onReceiveRecover(Object msg) throws Exception {

		if (msg instanceof CounterChanged) {
			updateState((CounterChanged) msg);
		} else {
			unhandled(msg);
		}

	}

	private void updateState(CounterChanged event) {
		count = count + event.delta;
	}

}