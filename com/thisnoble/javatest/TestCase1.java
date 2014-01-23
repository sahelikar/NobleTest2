package com.thisnoble.javatest;


import com.thisnoble.javatest.Event;
import com.thisnoble.javatest.OrchestratorImpl;


public class TestCase1 {
	
 public static void main(String args[]){

	 
	 	
	 	
	 	Event ev2 = new Event();
	 	ev2.setEventMessage("Event 2");
	 	ev2.setEventType("B");
	 	
	 	Event ev3 = new Event();
	 	ev3.setEventMessage("Event 3");
	 	ev3.setEventType("C");
	 	
	 	Runnable t1 = new Runnable() {
	        public void run() {
	        	Event ev1 = new Event();
	    	 	ev1.setEventMessage("Event 1");
	    	 	ev1.setEventType("A");
	    	 	OrchestratorService serv1 = new OrchestratorService();
	        	serv1.service(ev1);
	        }
	 	};
		
	 	Runnable t2 = new Runnable() {
	        public void run() {
	        	Event ev1 = new Event();
	    	 	ev1.setEventMessage("Event 2");
	    	 	ev1.setEventType("B");
	    	 	OrchestratorService serv1 = new OrchestratorService();
	        	serv1.service(ev1);
	        }
	 	};
	 	
	 	Runnable t3 = new Runnable() {
	        public void run() {
	        	Event ev1 = new Event();
	    	 	ev1.setEventMessage("Event 3");
	    	 	ev1.setEventType("C");
	    	 	OrchestratorService serv1 = new OrchestratorService();
	        	serv1.service(ev1);
	        }
	 	};
	 	
	 	Runnable t4 = new Runnable() {
	        public void run() {
	        	Event ev1 = new Event();
	    	 	ev1.setEventMessage("Event 4");
	    	 	ev1.setEventType("D");
	    	 	OrchestratorService serv1 = new OrchestratorService();
	        	serv1.service(ev1);
	        }
	 	};
	 	
	 	new Thread(t1).start();
	    new Thread(t2).start();	
	    new Thread(t3).start();
	    new Thread(t4).start();
		new Thread(t4).start();
		
		
		/*
		 * Collating events after a wait.
		 * In practical scenario we can design a scheduler which will collate and publish events in specified intervals
		 */
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Event collatedEvent = OrchestratorImpl.CollateEvents();
		
		Publisher pub = new Publisher();
		pub.publish(collatedEvent);

	 
 }
}
