package client.blogic.testing.refinement;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class DescriptiveErrorListener extends BaseErrorListener {
	private boolean hasErrors;
	
    public DescriptiveErrorListener(){
    	this.hasErrors = false;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e)
    {
    	hasErrors = true;
    	System.out.println("Error: "+msg+".");
    }
    
    public boolean hasErrors(){
    	return hasErrors;
    }
}
