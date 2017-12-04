package com.akka.FSM;

import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyFSM extends MyFSMBase {
	public final Object flush = new Object();
	private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object o) {

		if (getState() == State.IDLE) {

			if (o instanceof SetTarget)
				init(((SetTarget) o).ref);

			else
				whenUnhandled(o);

		} else if (getState() == State.ACTIVE) {

			if (o == flush)
				setState(State.IDLE);

			else
				whenUnhandled(o);
		}
	}

	public void transition(State old, State next) {
		if (old == State.ACTIVE) {
			getTarget().tell(new Object(), getSelf());
		}
	}

	private void whenUnhandled(Object o) {
		if (o instanceof Queue && isInitialized()) {
			enqueue(((Queue) o).o);
			setState(State.ACTIVE);

		} else {
			log.warning("received unknown message {} in state {}", o, getState());
		}
	}
}
