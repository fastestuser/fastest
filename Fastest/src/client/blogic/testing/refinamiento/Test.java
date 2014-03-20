package client.blogic.testing.refinamiento;

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

		resolverPreamble("joa.@PREAMBLE\ngg.@PREAMBLE");


	}

}
