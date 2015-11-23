/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client.presentation.commands;

import java.io.*;
import java.util.*;
import client.blogic.testing.ttree.tactics.Tactic;


import client.presentation.ClientTextUI;

/**
 * An instance of this class allows the user to see the list and explanation of
 * the available tactics.
 * @author Pablo Rodriguez Monetti
 */
public class ShowTacticsCommand implements Command{ 

    static String description = "";

    /**
     * Runs this command.
     * @param clientTextUI
     * @param args
     */    
    @Override
    public void run(ClientTextUI clientTextUI, String args){
        if(description.equals("")){
            try{             
                List<String> tacticNameList = new ArrayList<String>();

		//		URL url = ClientTextUI.class.getResource("ClientTextUI.class"); //MODIFICADO
		//		String urlStr = url.toString(); //MODIFICADO
		//		String currentDir = urlStr.substring(9,urlStr.indexOf("fastest.jar")); //MODIFICADO
                String currentDir = ""; //MODIFICADO
                File file = new File(currentDir + "lib/conf/listoftactics.conf");
                BufferedReader in = new BufferedReader(new FileReader(file));
                String line;
                while((line = in.readLine())!= null){
                    tacticNameList.add(line);
                }
                in.close();
                StringBuilder descriptionAux = new StringBuilder();
                for(int i=0; i<tacticNameList.size(); i++){
                    String tacticName = tacticNameList.get(i);
                    Class tacticClass = Class.forName("client.blogic.testing.ttree.tactics." + tacticName + "Tactic");
            			Object object = tacticClass.newInstance();
        			if (object instanceof Tactic){
                        Tactic tactic = (Tactic) object;
                        descriptionAux.append("\n");
                        descriptionAux.append(tactic.getDescription());
                    }
                }
                description = descriptionAux.toString();
            }
    		catch(Exception e){
    			e.printStackTrace();
            }
        } 
        System.out.println(description);
    }   
}
