package com.akka.transformation;

import java.util.ArrayList;
import java.util.List;

import com.akka.transformation.TransformMessages.TransformationJob;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedActor;

public class TransformationFrontend extends UntypedActor implements TransformMessages {

	List<ActorRef> list = new ArrayList<>();
	int counter = 0;

	@Override
	public void onReceive(Object message) throws Exception {

		if (message instanceof TransformationJob) {
			TransformationJob job = (TransformationJob) message;
			getSender().tell(new JobFailed("Service unavailable, try again later", job), getSender());

		} else if (message instanceof TransformationJob) {
			TransformationJob job = (TransformationJob) message;
			counter++;
			list.get(counter % list.size()).forward(job, getContext());
		} else if (message.equals(BACKEND_REGISTRATION)) {
			getContext().watch(getSender());
			list.add(getSender());
		} else if (message instanceof Terminated) {
			Terminated terminated = (Terminated) message;
			list.remove(terminated.getActor());

		} else {
			unhandled(message);
		}

	}

}
