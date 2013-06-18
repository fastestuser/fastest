
import java.io.*; 
public class Test {


	public static void main(String[] args) { 
		String setlogOutput = "";

		try{
			String[] cmd = {"prolog" , "-q"};
			final Process proc = Runtime.getRuntime().exec(cmd); 
			OutputStream out = proc.getOutputStream();

			String goal = "consult(setlog4617).\nset_prolog_flag(toplevel_print_options, [quoted(true), portray(true)]).\nuse_module(library(dialect/sicstus/timeout)).\nsetlog_consult('./lib/SetLog/setlogTTF.slog').\ntime_out(setlog(\nSRVTYPE = {hS,sC,cOM,vOM,sDA,rDA,tD,rA,gMR,lDM,eP,mSP} &DTYPE = {sD,hD,mD} &PDCANS = {cR,cD,oM,nD,aSD,aMD,mSE,iCS,lS} &BIN = {nO,yES} &SPARAM = {hGT,iLP,aICST} &OMODE = {sAFETY,nOM,dIAG} &set(BYTE) &Srv in SRVTYPE &Om in OMODE &Acquiring in BIN &PrepData in BIN &PrepDataType in DTYPE &NAT = int(0, 2147483647) &Page ein NAT &Ia ein NAT &Fa ein NAT &LpckDT in PDCANS &Csc ein NAT &Sdwp ein NAT &Time ein NAT &ProcessingCmd in BIN &St in DTYPE &ProcessingCmd = yES &Srv = tD &St = mD &Om = nOM &PrepData = yES &PrepDataType = mD &apply(Csrs,mD,VAR1) &VAR1 ein NAT &VAR1 > 0 &apply(TotCSR,mD,VAR2) &VAR2 ein NAT &VAR3 is VAR2-VAR1 &INT = int(-2147483648, 2147483647) &VAR3 ein INT &VAR4 is VAR3+1 &VAR4 ein INT &VAR5 is VAR4*2 &VAR5 ein INT &Fa =< VAR5 &VAR6 = int(33,160) &VAR6 neq {} &VAR7 is VAR3*2 &VAR7 ein INT &VAR8 is Ia+VAR7 &VAR8 ein INT &VAR9 is Ia+Fa &VAR9 ein INT &VAR10 = int(VAR8,VAR9) &VAR10 = {} &list(Lpck) &is_pfun(Csrs) &is_pfun(TotCSR) &is_pfun(Mem) &is_pfun(Sparam)\n,_CONSTR),1000,_RET).";

			System.out.println("ddddddddd  " + goal.getBytes());
			out.write(goal.getBytes());
			out.close();

			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String s;
			System.out.println("**********************************************************************************************");
			System.out.println("SETLOG OUT:\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
				if (s.equals("false.") || s.equals("_RET = time_out.") || s.startsWith("ERROR:")) //No encontro solucion
					return;
				if ((!s.equals("")) && (!s.startsWith("true.")) && (!s.startsWith("_CONSTR"))) {
					setlogOutput = setlogOutput.concat(s + "\n");
				}else if(s.startsWith("_CONSTR")){
					setlogOutput = s +"\n"+ setlogOutput;
					break;
				}
			}
			System.out.println("SETLOG OUT:\n" + setlogOutput);
			System.out.println("**********************************************************************************************\n");

		}
		catch (Exception e){ 
			e.printStackTrace(); 
		}


	}
}
