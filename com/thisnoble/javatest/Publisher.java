package com.thisnoble.javatest;

import com.thisnoble.javatest.Event;
import com.thisnoble.javatest.Processor;

public class Publisher {

        void publish(Event event){
        	System.out.println("Event published::");
        	System.out.println("Event Message::"+event.getEventMessage());
        	System.out.println("Event Type::"+event.getEventType());
        }
}