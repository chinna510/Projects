package com.akka.future;

import akka.actor.ActorSystem;
import akka.agent.Agent;
import akka.dispatch.ExecutionContexts;
import akka.dispatch.Mapper;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

public class AgentCreation {

	ActorSystem system = ActorSystem.create("ActorSystem");
	LoggingAdapter log = Logging.getLogger(system, this);

	public void test() throws InterruptedException {
		ExecutionContext context = ExecutionContexts.global();
		Agent<Integer> agent = Agent.create(5, context);

		// getting Agent Value
		Integer result = (Integer) agent.get();
		log.info("Actor Value : " + result);

		// getting Future of Agents Value
		Future<Integer> future = agent.future();
		log.info("Actor Future : " + future);

		// Updating Agent Value with New Value
		agent.send(7);
		Thread.sleep(1000);
		Integer result1 = (Integer) agent.get();
		log.info("Actor Value : " + result1);

		// Updating Agent Value with Upgraded Value
		agent.send(new Mapper<Integer, Integer>() {
			@Override
			public Integer apply(Integer i) {
				return i * 2;
			}
		});
		Thread.sleep(1000);
		Integer result2 = (Integer) agent.get();
		log.info("Actor Value : " + result2);

		// Agent Altering

		Future<Integer> alter1 = agent.alter(7);
		Thread.sleep(1000);
		Integer result3 = (Integer) agent.get();
		log.info("Actor Value : " + result3);

		// With Mapper Function
		Future<Integer> alter2 = agent.alter(new Mapper<Integer, Integer>() {
			@Override
			public Integer apply(Integer i) {
				return i * 2;
			}
		});
		Thread.sleep(1000);
		Integer result4 = (Integer) agent.get();
		log.info("Actor Value : " + result4);
	}

	public static void main(String[] args) throws InterruptedException {
		AgentCreation fm = new AgentCreation();
		fm.test();
	}

}
