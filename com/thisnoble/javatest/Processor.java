package com.thisnoble.javatest;


import com.thisnoble.javatest.Event;

public class Processor implements INobleEventListener, Runnable{
	
	Event event = new Event();

	

   public boolean interestedIn(Event ev){
	   
    	if(ev.getEventType().equals("A")||ev.getEventType().equals("B")||ev.getEventType().equals("D")){
    		
    		this.event = ev;
    		return true;
    	}
    	else{
    		return false;
    	}
    }

		@Override
		public void processEvent() {
			this.event.setIsProcessed(true) ;
			
		}
		
		public Event sendProcessedEvent(){
			return this.event;
		}

		@Override
		public void run() {
			processEvent();
			
		}
}