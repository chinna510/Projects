package com.akka.Persistance;

import akka.actor.ActorSelection;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Function;
import akka.japi.Procedure;
import akka.persistence.UntypedPersistentActorWithAtLeastOnceDelivery;

public class MyPersistentActor3 extends UntypedPersistentActorWithAtLeastOnceDelivery {
	private final ActorSelection destination;
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	public String persistenceId() {

		return "persistence-id";
	}

	public MyPersistentActor3(ActorSelection destination) {
		this.destination = destination;
	}

	@Override
	public void onReceiveCommand(Object message) throws Exception {
		log.info("Recieved Message " + message);
		if (message instanceof String) {
			String s = (String) message;
			persist(new MsgSent(s), new Procedure<MsgSent>() {
				public void apply(MsgSent evt) {
					updateState(evt);
				}
			});
		} else if (message instanceof Confirm) {
			Confirm confirm = (Confirm) message;
			persist(new MsgConfirmed(confirm.deliveryId), new Procedure<MsgConfirmed>() {
				public void apply(MsgConfirmed evt) {
					updateState(evt);
				}
			});
		} else {
			unhandled(message);
		}
	}

	@Override
	public void onReceiveRecover(Object event) throws Exception {
		updateState(event);
	}

	void updateState(Object event) {
		if (event instanceof MsgSent) {
			final MsgSent evt = (MsgSent) event;
			deliver(destination, new Function<Long, Object>() {
				public Object apply(Long deliveryId) {
					return new Msg(deliveryId, evt.s);
				}
			});
		} else if (event instanceof MsgConfirmed) {
			final MsgConfirmed evt = (MsgConfirmed) event;
			confirmDelivery(evt.deliveryId);
		}
	}

}
