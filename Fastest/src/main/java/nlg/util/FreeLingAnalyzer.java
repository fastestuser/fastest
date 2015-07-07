package nlg.util;

import edu.upc.freeling.HmmTagger;
import edu.upc.freeling.ListSentence;
import edu.upc.freeling.ListSentenceIterator;
import edu.upc.freeling.ListWord;
import edu.upc.freeling.Maco;
import edu.upc.freeling.MacoOptions;
import edu.upc.freeling.Nec;
import edu.upc.freeling.Senses;
import edu.upc.freeling.Sentence;
import edu.upc.freeling.Splitter;
import edu.upc.freeling.Tokenizer;
import edu.upc.freeling.Ukb;
import edu.upc.freeling.Util;

public class FreeLingAnalyzer {

	private static final String FREELINGDIR = "/usr/local";
	private static final String DATA = FREELINGDIR + "/share/freeling/";
	private static final String LANG = "es";
    
	/**
	 * Realiza analisis oracion usando las librerias de FreeLing
	 */
	public Sentence analyze(String line) {
		Sentence ret = null;
		
		// realizo algunas validaciones previas
		line = line.trim();
		
		// verifica que el texto de la designacion tenga solo un punto
		// al final de la misma. de no tenerlo lo agrego para el correcto
		// funcionamiento del analizador.
		int count = line.length() - line.replace(".", "").length();
		if (count == 0) {
			line = line + ".";
		} else if (count > 1 || line.charAt(line.length() - 1) != '.') {
			return null;
		}

		System.loadLibrary("freeling_javaAPI");

		Util.initLocale("default");

		// Create options set for maco analyzer.
		// Default values are Ok, except for data files.
		MacoOptions op = new MacoOptions(LANG);

		op.setActiveModules(false, true, true, true, true, true, true, true,
				true, true);

		op.setDataFiles("", DATA + LANG + "/locucions.dat", DATA + LANG
				+ "/quantities.dat", DATA + LANG + "/afixos.dat", DATA + LANG
				+ "/probabilitats.dat", DATA + LANG + "/dicc.src", DATA + LANG
				+ "/np.dat", DATA + "common/punct.dat");

		// Create analyzers.
		Tokenizer tk = new Tokenizer(DATA + LANG + "/tokenizer.dat");
		Splitter sp = new Splitter(DATA + LANG + "/splitter.dat");
		Maco mf = new Maco(op);

		HmmTagger tg = new HmmTagger(DATA + LANG + "/tagger.dat", true, 2);
		Nec neclass = new Nec(DATA + LANG + "/nerc/nec/nec-ab-poor1.dat");
		Senses sen = new Senses(DATA + LANG + "/senses.dat"); // sense dictionary
		Ukb dis = new Ukb(DATA + LANG + "/ukb.dat"); // sense disambiguator

		// Extract the tokens from the line of text.
		ListWord l = tk.tokenize(line);

		// Split the tokens into distinct sentences.
		ListSentence ls = sp.split(l, false);

		// Perform morphological analysis
		mf.analyze(ls);

		// Perform part-of-speech tagging.
		tg.analyze(ls);

		// Perform named entity (NE) classificiation.
		neclass.analyze(ls);

		sen.analyze(ls);
		dis.analyze(ls);

		ListSentenceIterator sIt = new ListSentenceIterator(ls);
		if (sIt.hasNext()) {
			ret = sIt.next();
		}

		return ret;
	}
}
