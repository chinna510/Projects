package com.akka.stream;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import akka.stream.javadsl.Tcp.OutgoingConnection;

public class MyClass {

	private CompletableFuture<Optional<Integer>> p;
	private OutgoingConnection conn;

	public MyClass(CompletableFuture<Optional<Integer>> p, OutgoingConnection conn) {
		super();
		this.p = p;
		this.conn = conn;
	}

	public void close() {
		p.complete(Optional.empty());
	}

	public OutgoingConnection getConn() {
		return conn;
	}

	public void setConn(OutgoingConnection conn) {
		this.conn = conn;
	}

	public CompletableFuture<Optional<Integer>> getP() {
		return p;
	}

	public void setP(CompletableFuture<Optional<Integer>> p) {
		this.p = p;
	}

}
