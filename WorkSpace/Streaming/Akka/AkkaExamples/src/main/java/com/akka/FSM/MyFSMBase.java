package com.akka.FSM;

import java.util.*;

import com.akka.FSM.MyFSMBase.State;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public abstract class MyFSMBase extends UntypedActor {

	protected enum State {
		IDLE, ACTIVE;
	}

	private State state = State.IDLE;
	private ActorRef target;
	private List<Object> queue;

	protected void init(ActorRef target) {
		this.target = target;
		queue = new ArrayList<Object>();
	}

	protected void setState(State s) {
		if (state != s) {
			transition(state, s);
			state = s;
		}
	}

	protected void enqueue(Object o) {
		if (queue != null)
			queue.add(o);
	}

	public void transition(State old, State next) {
		if (old == State.ACTIVE) {
			getTarget().tell(new Object(), getSelf());
		}
	}

	protected List<Object> drainQueue() {
		final List<Object> q = queue;
		if (q == null)
			throw new IllegalStateException("drainQueue(): not yet initialized");
		queue = new ArrayList<Object>();
		return q;
	}

	protected boolean isInitialized() {
		return target != null;
	}

	protected State getState() {
		return state;
	}

	protected ActorRef getTarget() {
		if (target == null)
			throw new IllegalStateException("getTarget(): not yet initialized");
		return target;
	}

}
