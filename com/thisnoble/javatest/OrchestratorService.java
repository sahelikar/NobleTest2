package com.thisnoble.javatest;

import java.util.ArrayList;


public class OrchestratorService {
	
	public void service(Event ev){
	
	Processor proc1 = new Processor();
	 
	 OrchestratorImpl orcImpl = new OrchestratorImpl();
	 orcImpl.receive(ev);
	 orcImpl.register(proc1);
	 
	 OrchestratorImpl.addEvents(proc1.sendProcessedEvent());}

}
