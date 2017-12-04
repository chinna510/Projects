package com.akka.Persistance;

import akka.japi.Procedure;
import akka.persistence.UntypedPersistentActor;

public class MyPersistentActor extends UntypedPersistentActor {

	public String persistenceId() {

		return "persist-id-1";
	}

	@Override
	public void onReceiveCommand(Object msg) throws Exception {
		sender().tell("msg", self());
		persistAsync(String.format("evt-%s-1", msg), new Procedure<String>() {

			public void apply(String event) throws Exception {
				sender().tell(event, self());
			}
		});
		persistAsync(String.format("evt-%s-2", msg), new Procedure<String>() {

			public void apply(String event) throws Exception {
				sender().tell(event, self());
			}
		});
	}

	@Override
	public void onReceiveRecover(Object msg) throws Exception {

	}

}
