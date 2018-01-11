package com.vivid.akka.simpleStart.helloWorld;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * 
 * @author luoxin
 * @Time 创建时间：2018年1月10日 上午10:45:20
 * @Version
 */

public class HelloWorld extends AbstractActor {

	private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

	public static Props props() {
		return Props.create(HelloWorld.class);
	}

	@Override
	public void preStart() {
		log.info("IoT Application started");
	}

	@Override
	public void postStop() {
		log.info("IoT Application stopped");
	}

	// No need to handle any messages
	@Override
	public Receive createReceive() {
		return receiveBuilder().build();
	}
}
