package com.akka.persistance;

import java.util.ArrayList;

import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Procedure;
import akka.persistence.UntypedPersistentActor;

public class ExamplePersistentActor1 extends UntypedPersistentActor {
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	public String persistenceId() {

		return "persistance-id-2";
	}

	private ArrayList<Object> received = new ArrayList<Object>();

	@Override
	public void onReceiveRecover(Object msg) throws Exception {
		if (msg instanceof String) {
			received.add(msg);

		} else {
			unhandled(msg);
		}

	}

	public void onReceiveCommand(Object msg) throws Exception {
		if (msg.equals("boom")) {
			throw new Exception("boom");

		} else if (msg.equals("print")) {
			log.info("Recieved" + received);
			System.out.println("Recievd" + received);
		} else if (msg instanceof String) {
			String s = (String) msg;
			persist(s, new Procedure<String>() {

				public void apply(String evt) throws Exception {
					received.add(evt);

				}
			});

		} else {
			unhandled(msg);
		}

	}

}
