package com.akka.extension;

import akka.actor.AbstractExtensionId;
import akka.actor.ExtendedActorSystem;
import akka.actor.Extension;
import akka.actor.ExtensionId;
import akka.actor.ExtensionIdProvider;

public class CountExtension extends AbstractExtensionId<CountExtensionImpl> implements ExtensionIdProvider {

	public final static CountExtension CountExtensionProvider = new CountExtension();

	private CountExtension() {
	}

	@Override
	public CountExtensionImpl createExtension(ExtendedActorSystem arg0) {
		return new CountExtensionImpl();
	}

	@Override
	public ExtensionId<? extends Extension> lookup() {

		return CountExtension.CountExtensionProvider;
	}

}
