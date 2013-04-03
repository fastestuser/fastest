import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;

public class Principal {

	
	
	public static void main(String[] args) {
		String s = "[cA1212,cdsad1,cdsad]";
		DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode("\\cross");
		DefaultMutableTreeNode root = nodo1;
		DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode("A");
		DefaultMutableTreeNode nodo3 = new DefaultMutableTreeNode("B");
		DefaultMutableTreeNode nodo4 = new DefaultMutableTreeNode("C");
		nodo1.add(nodo2);
		nodo1.add(nodo3);
		nodo1.add(nodo4);
		
		/*
		DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode("\\power");
		DefaultMutableTreeNode root = nodo1;
		
		DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode("\\cross");
		nodo1.add(nodo2);
		
		nodo1 = new DefaultMutableTreeNode("\\powerA");
		nodo2.add(nodo1);
	
		nodo1 = new DefaultMutableTreeNode("\\powerB");
		nodo2.add(nodo1);
		nodo2 = new DefaultMutableTreeNode("\\num");
		nodo1.add(nodo2);
		
		
		nodo1=root;
		nodo1=(DefaultMutableTreeNode) root.getChildAt(0);
		nodo1=(DefaultMutableTreeNode) nodo1.getChildAt(0);
		nodo2= new DefaultMutableTreeNode("A");
		nodo1.add(nodo2);
		String s = "{[{a111},{xxx,b33,b33}]}";
		*/
		/*
		DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode("\\cross");
		DefaultMutableTreeNode root = nodo1;
		
		String s = "[{c,c,c},{c}]";
		DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode("\\powerA");
		nodo1.add(nodo2);
		nodo2 = new DefaultMutableTreeNode("\\powerB");
		nodo1.add(nodo2);
		
		nodo1 = (DefaultMutableTreeNode) root.getChildAt(0);
		nodo2 =  new DefaultMutableTreeNode("A");
		nodo1.add(nodo2);
		
		nodo1 = (DefaultMutableTreeNode) root.getChildAt(1);
		nodo2 =  new DefaultMutableTreeNode("B");
		nodo1.add(nodo2);
		*/
		

		
		
		/*
		DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode("\\power");
		DefaultMutableTreeNode root = nodo1;
		String s = "{[c,c],[c,c]}";
		DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode("\\cross");
		nodo1.add(nodo2);
		
		nodo1 = new DefaultMutableTreeNode("A");
		nodo2.add(nodo1);
		nodo1 = new DefaultMutableTreeNode("B");
		nodo2.add(nodo1);
	*/
		
		

		
		DefaultMutableTreeNode n = new DefaultMutableTreeNode("\\cross");
		DefaultMutableTreeNode n1 = new DefaultMutableTreeNode("\\power");
		DefaultMutableTreeNode n15 = new DefaultMutableTreeNode("\\num");
		
		DefaultMutableTreeNode n2 = new DefaultMutableTreeNode("\\cross");
		DefaultMutableTreeNode n25 = new DefaultMutableTreeNode("\\power");
		DefaultMutableTreeNode n26 = new DefaultMutableTreeNode("\\power");
		DefaultMutableTreeNode n255 = new DefaultMutableTreeNode("\\num");
		DefaultMutableTreeNode n266 = new DefaultMutableTreeNode("\\num");
		
		
		n1.add(n15);
		n.add(n1);n.add(n2);
		n2.add(n25);n2.add(n26);n25.add(n255);n26.add(n266);
		s = "[{cA1212,99},VV]";
		ConstantCreator parser = new ConstantCreator(s,n);
		//String salida0 = parser.fullCte(n);
		
		String salida = parser.getSalida();
		//System.out.println("SALIDA0\n" + salida0);
		System.out.println("ENTRADA\n" + s);
		System.out.println("SALIDA\n" + salida);
		
		/*String cadena = "{sass},{9_sss}{{sss}}";
		Pattern patron = Pattern.compile("(\\w+)");
		
		Matcher m = patron.matcher(cadena);
		
		m.find(7);
		System.out.println(m.group());
		m.find();
		System.out.println(m.group());
		*/
		/*String cadena = "{sass},_G888{[fdsf[fdsf,sdf]]9_sss,dds,AAA}{{sss}}";
		Pattern patron = Pattern.compile("(\\w+)");
		
		Matcher m = patron.matcher(cadena);

		s = cadena.replaceAll("(\\w+)", "c");
		System.out.println(cadena);
		System.out.println(s);
		*/
		
	}

}
