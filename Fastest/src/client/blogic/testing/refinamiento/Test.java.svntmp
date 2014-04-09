package client.blogic.testing.refinamiento;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	private static void resolverPreamble(String preamble){

		String REGEX = "^(\\w*)\\.@PREAMBLE$";

		Pattern p = Pattern.compile(REGEX,Pattern.MULTILINE);
		Matcher m = p.matcher(preamble);
		String s = new String();
		while(m.find()) {
			s = m.replaceFirst("$1");
			m = p.matcher(s);
		}
		System.out.println(s);
	}
	public static void main(String[] args) {
		try{
			final Process p = Runtime.getRuntime().exec("ls /home/joaquin/"); 
			BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		}
		catch (Exception e){ 
			e.printStackTrace();
		}
	}
}

//		    try
//		    {
//		        String lscmd = "ls";
//		        Process p=Runtime.getRuntime().exec(lscmd);
//		        p.waitFor();
//		        BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
//		        String line=reader.readLine();
//		        while(line!=null)
//		        {
//		            System.out.println(line);
//		            line=reader.readLine();
//		        }
//		    }
//		    catch(IOException e1) {
//		        System.out.println("Pblm found1.");
//		    }
//		    catch(InterruptedException e2) {
//		        System.out.println("Pblm found2.");
//		    }

//		    System.out.println("finished.");
//		}
//
//
//
//}
