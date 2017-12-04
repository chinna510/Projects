package com.akka.extension;

import akka.actor.UntypedActor;

public class MyActor extends UntypedActor {

	@Override
	public void onReceive(Object msg) throws Exception {

		System.out.println("-> " + msg);
		CountExtension.CountExtensionProvider.get(getContext().system()).increment();

	}

}
