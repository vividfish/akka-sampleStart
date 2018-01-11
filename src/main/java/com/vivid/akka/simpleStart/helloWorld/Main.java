package com.vivid.akka.simpleStart.helloWorld;

import java.io.IOException;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * 
 * @author luoxin
 * @Time 创建时间：2018年1月10日 上午11:17:23
 * @Version
 */

public class Main {

	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("iot-system");

		try {
			// Create top level supervisor
			ActorRef supervisor = system.actorOf(HelloWorld.props(), "iot-supervisor");

			System.out.println("Press ENTER to exit the system");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			system.terminate();
		}
	}
}
