package com.akka.Routing;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.ConsistentHashingPool;
import akka.routing.ConsistentHashingRouter.ConsistentHashMapper;

public class ConsistentHashingPoolEx {


public void test(){
	
	final ConsistentHashMapper hashMapper = new ConsistentHashMapper() {
		  public Object hashKey(Object message) {
		    if (message instanceof Evict) {
		      return ((Evict) message).key;
		    } else {
		      return null;
		    }
		  }
		};
		ActorSystem system=ActorSystem.create("HashEx");
		ActorRef cache = system.actorOf(
			    new ConsistentHashingPool(10).withHashMapper(hashMapper).props(
			        Props.create(Cache.class)), 
			  "cache");
			
	
}
}
