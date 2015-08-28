package client.blogic.testing.ttree.strategies.ftsdl.Values;

import client.blogic.testing.ttree.strategies.ftsdl.FTTerm;
import client.blogic.testing.ttree.strategies.ftsdl.ISETerm;
import client.blogic.testing.ttree.strategies.ftsdl.NRTerm;
import client.blogic.testing.ttree.strategies.ftsdl.SPTerm;

public class NodeValue {

    public static NodeValue VOID = new NodeValue(new Object());

    private Object value;

    public NodeValue(Object value) {
        this.value = value;
    }
    
    public Object getValue()
    {
    	return value;
    }

    public boolean isInteger()
    {
    	return (value instanceof Integer);
    }
    
    public Integer asInteger() {
        return (Integer)value;
    }
    
    public boolean isBoolean()
    {
    	return (value instanceof Boolean);
    }
    
    public Boolean asBoolean() {
        return (Boolean) value;
    }

    public String toString() {
    	if (value instanceof FTTerm)
    		return ((FTTerm) value).getExp();
    	
    	if (value instanceof ISETerm)
    		return ((ISETerm) value).getExp();
    	
    	if (value instanceof SPTerm)
    		return ((SPTerm) value).getExp();
    	
    	if (value instanceof NRTerm)
    		return ((NRTerm) value).getExp();
    	
        return String.valueOf(value);
    }
}