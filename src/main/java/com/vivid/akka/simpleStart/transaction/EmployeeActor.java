package com.vivid.akka.simpleStart.transaction;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.transactor.Coordinated;
import scala.concurrent.stm.Ref;
import scala.concurrent.stm.japi.STM;

/**
 * 
 * @author luoxin
 * @Time 创建时间：2018年1月10日 下午5:16:14
 * @Version
 */

public class EmployeeActor extends UntypedActor {

	private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	private Ref.View<Integer> count = STM.newRef(20);// 员工账户

	@Override
	public void onReceive(Object o) throws Throwable {
		if (o instanceof Coordinated) {
			Coordinated coordinated = (Coordinated) o;
			int downCount = (int) coordinated.getMessage();// 员工增加的工资

			try {// 注意这里异常要及时处理，否则异常会一直扩散，导致回退到系统刚启动时的初始状态！
				coordinated.atomic(() -> STM.increment(count, downCount));// Employee增加工资
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if ("getCount".equals(o)) {
			getSender().tell(count.get(), getSelf());
		} else {
			unhandled(o);
		}
	}

}