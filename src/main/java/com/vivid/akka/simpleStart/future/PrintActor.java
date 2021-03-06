package com.vivid.akka.simpleStart.future;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * 
 * @author luoxin
 * @Time 创建时间：2018年1月10日 下午5:04:31
 * @Version
 */

public class PrintActor extends UntypedActor {

	private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object o) throws Throwable {
		log.info("akka.future.PrintActor.onReceive:" + o);
		if (o instanceof Integer) {
			log.info("print:" + o);
		} else {
			unhandled(o);
		}
	}

}