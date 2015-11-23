package pruebas;

import java.io.*;
import java.util.*;



class TextModule{
	private String content;
	private String key;

	public TextModule(String key, String content){
		this.key = key;
		this.content = content;
	}

	public String getKey(){
		return key;
	}

	public String getContent(){
		return content;
	}

}



class _2MILSorter{
	public static void main(String[] args) {
		if(args.length!=1){
			System.out.println("Ingresar nombre de dos archivos!!!!");
			return;
		}
		try{	
			String linea = "";
			List<TextModule> moduleList = new ArrayList<TextModule>();
			//			int nroTextModules = 0;
			//			int nroHTextModules = 0;
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			StringBuilder moduleStr = new StringBuilder();
			String keyStr = "";
			while((linea = in.readLine())!= null)	 {	
				//int lineLength = linea.length();
				if(linea.startsWith("\\begin{module}")){
					moduleStr.append(linea + "\n");
					keyStr = linea.substring(15);
				}
				else if(linea.startsWith("\\begin{hmodule}")){
					moduleStr.append(linea + "\n");
					keyStr = linea.substring(16);
				}
				else if(linea.equals("\\end{module}") || linea.equals("\\end{hmodule}")){
					moduleStr.append(linea + "\n");
					TextModule module = new TextModule(keyStr, moduleStr.toString());
					int i=0;
					for(i=0; i< moduleList.size(); i++){
						TextModule auxTextModule = moduleList.get(i);
						String auxTextModuleKey = auxTextModule.getKey();
						if(auxTextModuleKey.compareTo(keyStr) > 0){
							break;
						}
					}
					moduleList.add(i, module);
					moduleStr.setLength(0);
				}
				else if(!moduleStr.equals("")){
					moduleStr.append(linea + "\n");
				}

			}
			in.close();
			int moduleListSize = moduleList.size(); 


			for(int i=0; i< moduleListSize; i++){
				TextModule auxTextModule = moduleList.get(i);
				System.out.println(auxTextModule.getContent());
				System.out.println("\n");
			}



		}
		catch(Exception e){
			e.printStackTrace();
		}
	}






} 
