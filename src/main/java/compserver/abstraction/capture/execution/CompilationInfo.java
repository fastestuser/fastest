package compserver.abstraction.capture.execution;


/**
 * Instances of this class encapsulates the information of compilation
 */
public class CompilationInfo{
	public CompilationInfo(String targetLanguage,String platform, String compiler,String compileOptions, String workingDirectory){
		this.targetLanguage = targetLanguage;
		this.platform = platform;
		this.compiler = compiler;
		this.compileOptions = compileOptions;
		this.workingDirectory = workingDirectory;
	}
	/**
	* Gets the language in which is encoded the UUT
	* @return
	*/
	public String getTargetLanguage(){
		return targetLanguage;
	}
	/**
	* Gets the platform in which run the UUT
	* @return
	*/
	public String getPlatform(){
		return platform;     
	}
	/**
	* Gets the compiler
	* @return
	*/
	public String getCompiler(){
		return compiler;     
	}
	/**
	* Gets the option that must be set in the compiler
	* @return
	*/
	public String getCompileOptions(){
		return compileOptions;     
	}
	/**
	* Gets the directory in which is stored the UUT
	* @return
	*/
	public String getWorkingDirectory(){
		return workingDirectory;
	}
	private String targetLanguage;
	private String platform;
	private String compiler;
	private String compileOptions;
	private String workingDirectory;
}