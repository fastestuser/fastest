package client.presentation.commands;

import client.presentation.ClientTextUI;
import client.blogic.management.Controller;
import client.blogic.testing.refinement.ConcreteTCase;
import compserver.abstraction.capture.execution.CompilationInfo;
import client.blogic.management.ii.events.CTCaseRunRequested;
import client.blogic.management.ii.EventAdmin;

public class RunConcreteTCaseCommand implements Command{
    /**
     * Runs this command.
     * @param clientTextUI
     * @param args
     */
    @Override
    public void run(ClientTextUI clientTextUI, String args){
	try{
        Controller controller = clientTextUI.getMyController();
	// Por ahora solo corre un caso por vez
	String parts[] = args.split("[ ]+",2);
	String ctcName = parts[0];
	String runCode = parts[1].substring(1,parts[1].length()-1);
	runCode = runCode.replace("(.*)",ctcName);

	// We look for the concrete case with name ctcName
	ConcreteTCase ctCase = controller.getOpTCaseRefinedMap().get(ctcName); 
	if(ctCase==null){
		System.out.println(ctcName+" is not the name of a refined case");
		return;
	}

	// We check that the concrete case have the capture code
	if(ctCase.getAbsLawName()==null){
		System.out.println(ctcName+" was not modified to capure the output of the UUT");
		System.out.println("You must use the addcapturecode command before attempting to run this case.");
		return;
	}

	// We obtain the CompilationInfo 
	//CompilationInfo cInfo = controller.getCompilationInfo();
	CompilationInfo cInfo = null; //pueso para zafar del error
	if(cInfo==null){
		System.out.println("The information of compilation has not been loaded.");
		System.out.println("You must set this information before try to run "+ctcName);
	}


	boolean someEventAnnounced = false;
	CTCaseRunRequested event = new CTCaseRunRequested(runCode, cInfo);
	EventAdmin eventAdmin = EventAdmin.getInstance();
	eventAdmin.announceEvent(event);
	someEventAnnounced = true;
	
	if(someEventAnnounced)
		synchronized(clientTextUI){
		clientTextUI.wait();
	}
	}
	catch(Exception e){
		e.printStackTrace(System.out);
	}

    }
}