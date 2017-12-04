package com.akka.persistance;

import java.util.Arrays;

import akka.japi.Procedure;
import akka.persistence.SnapshotOffer;
import akka.persistence.UntypedPersistentActor;
import scala.Option;

public class ExamplePersistentActor extends UntypedPersistentActor {

	public String persistenceId() {

		return "simple-id-1";
	}

	ExampleState state = new ExampleState();

	public int getNumEvents() {
		return state.size();
	}

	@Override
	public void onReceiveCommand(Object msg) throws Exception {
		if (msg instanceof Evt) {
			state.update((Evt) msg);
		} else if (msg instanceof SnapshotOffer) {

			state = (ExampleState) ((SnapshotOffer) msg).snapshot();
		} else {
			unhandled(msg);
		}

	}

	@Override
	public void onReceiveRecover(Object msg) throws Exception {
		if (msg instanceof Cmd) {
			final String data = ((Cmd) msg).getData();
			final Evt evt1 = new Evt(data + "-" + getNumEvents());
			final Evt evt2 = new Evt(data + "-" + (getNumEvents() + 1));
			persistAll(Arrays.asList(evt1, evt2), new Procedure<Evt>() {
				public void apply(Evt evt) throws Exception {
					state.update(evt);
					if (evt.equals(evt2)) {
						getContext().system().eventStream().publish(evt);
					}
				}
			});
		} else if (msg.equals("snap")) {
			saveSnapshot(state.copy());
		} else if (msg.equals("print")) {
			System.out.println(state);
		} else {
			unhandled(msg);
		}
	}

	

}
