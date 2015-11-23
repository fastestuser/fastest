package client.blogic.testing.ttree.strategies.ftsdl.Values;

import net.sourceforge.czt.z.ast.AxPara;
import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;

import common.z.SpecUtils;
import common.z.TClass;
import common.z.czt.visitors.TClassNodeUnfolder;
	
public class TClassNodeValue extends NodeValue{
	private TClassNode value;
	// If this represents a class, definition is null.
	// If this represents an operation, definition is
	// the unfolded AxPara from the specification.
	// This is used when searching for expressions to apply tactics
	// or to check if an expression is in the operation.
	private AxPara definition;
	
	public TClassNodeValue(TClassNode value, Controller c)
	{		
		this(value, c, null);
	}
	
	// To be used when storing complete operations where also the definition from the spec
	// has to be loaded.
	public TClassNodeValue(TClassNode value, Controller c, AxPara definition)
	{
		super(value);
		this.definition = definition;
		
		// The node is stored unfolded.
		TClassNodeUnfolder unfolder = new TClassNodeUnfolder(value, c);
		value.acceptVisitor(unfolder);
		TClass tClass = unfolder.getTClassUnfolded();
		value.setValue(tClass);
		this.value = value;
	}
	
	public TClassNode getValue()
	{
		return value;
	}

	public AxPara getDefinition()
	{
		return definition;
	}
	
	public AxPara getAxPara()
	{
		if (definition != null)
		{
			return definition;
		}
		else
		{
		    return value.getValue().getMyAxPara();	
		}
	}
	
	@Override
	public String toString() {
		return SpecUtils.getAxParaName(value.getValue().getMyAxPara());
	}
}
