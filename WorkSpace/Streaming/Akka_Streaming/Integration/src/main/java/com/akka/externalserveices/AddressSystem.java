package com.akka.externalserveices;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class AddressSystem {

	public CompletionStage<Optional<String>> lookupEmail(String handle)
	// #email-address-lookup
	{
		return CompletableFuture.completedFuture(Optional.of(handle + "@somewhere.com"));
	}

	// #phone-lookup
	public CompletionStage<Optional<String>> lookupPhoneNumber(String handle)
	// #phone-lookup
	{
		return CompletableFuture.completedFuture(Optional.of("" + handle.hashCode()));
	}
}