package com.akka.Persistance;

import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Procedure;
import akka.persistence.SnapshotOffer;
import akka.persistence.UntypedPersistentActor;

public class MyPersistentActor1 extends UntypedPersistentActor {
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	public String persistenceId() {

		return "SOme-ID";
	}

	private ExampleState state = new ExampleState();

	@Override
	public void onReceiveCommand(Object msg) throws Exception {
		// log.info("RECIEVED MESSAGE : " + msg);
		final Procedure<String> replyToSender = new Procedure<String>() {

			public void apply(String event) throws Exception {
				sender().tell(event, self());
			}
		};

		persistAsync(String.format("evt-%s-1", msg), replyToSender);
		persistAsync(String.format("evt-%s-2", msg), replyToSender);
		//deferAsync(String.format("evt-%s-3", msg), replyToSender);
		persistAsync(String.format("evt-%s-4", msg), replyToSender);
		persistAsync(String.format("evt-%s-5", msg), replyToSender);
		deferAsync(String.format("evt-%s-6", msg), replyToSender);
	}

	@Override
	public void onReceiveRecover(Object msg) throws Exception {
		log.info("RECIEVED MESSAGE : " + msg);
		if (msg instanceof Evt) {
			log.info("RECIEVED MESSAGE : " + msg);
			state.update((Evt) msg);
		} else if (msg instanceof SnapshotOffer) {
			state = (ExampleState) ((SnapshotOffer) msg).snapshot();
		} else {
			unhandled(msg);
		}

	}

}
