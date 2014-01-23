package com.thisnoble.javatest;

import java.util.ArrayList;

import com.thisnoble.javatest.Event;
import com.thisnoble.javatest.Orchestrator;
import com.thisnoble.javatest.Processor;

public final class OrchestratorImpl implements Orchestrator {
	
	private Event event  = new Event();
	
	private static ArrayList<Event> eventList = new ArrayList<Event>();
	
	public static ArrayList<Event> getEventList() {
		return eventList;
	}

	public static void setEventList(ArrayList<Event> eventList) {
		OrchestratorImpl.eventList = eventList;
	}

	/*private static OrchestratorImpl orchestratorImpl;
	
	private OrchestratorImpl() {
		
	}
	
	public static OrchestratorImpl getInstance(){
		if(orchestratorImpl==null){
			orchestratorImpl = new OrchestratorImpl();
			
		}
		return orchestratorImpl;
	}
*/
	@Override
	public void register(Processor processor) {
		if(processor.interestedIn(event)){
			processor.processEvent();
			
		}
	}

	@Override
	public void receive(Event event) {
		this.event = event;
		
	}
	
	public static synchronized void addEvents(Event event){
		eventList.add(event);
	}
	
	public synchronized static Event CollateEvents() {	
		
		  
	
		
		String collatedEventString ="";
		Event collatedEvent =  new Event();
		for(Event event:eventList){
			if(event.getIsProcessed()){
				collatedEventString  = collatedEventString+event.getEventType()+"::"+event.getEventMessage()+";";
			}
		}
		collatedEvent.setEventType("Collated");
		collatedEvent.setEventMessage(collatedEventString);
		
		return collatedEvent;
		}

		
	

}
