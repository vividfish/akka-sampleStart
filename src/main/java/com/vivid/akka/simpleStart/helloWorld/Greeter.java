package com.vivid.akka.simpleStart.helloWorld;

import akka.actor.UntypedActor;

/**
 * 
 * @author luoxin
 * @Time 创建时间：2018年1月10日 上午11:15:56
 * @Version
 */

public class Greeter extends UntypedActor {

	public static enum Msg {
		GREET, DONE;
	}

	@Override
	public void onReceive(Object msg) throws InterruptedException {
		if (msg == Msg.GREET) {
			System.out.println("Hello World!");
			Thread.sleep(1000);
			getSender().tell(Msg.DONE, getSelf());
		} else
			unhandled(msg);
	}

}
