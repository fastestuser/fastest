package client.blogic.management;

import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.IIComponent;
import client.blogic.management.ii.events.*;
import client.blogic.testing.atcal.ConcreteTCase;
import client.blogic.testing.atcal.ConcreteTCaseRun;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.TTreeNode;
import client.blogic.testing.ttree.strategies.TTreeStrategy;
import client.blogic.testing.ttree.tactics.Tactic;
import client.blogic.testing.ttree.visitors.SchemeTTreeFinder;
import client.blogic.testing.ttree.visitors.TCaseNodeAdder;
import client.presentation.ClientTextUI;
import client.presentation.ClientUI;
import common.fastest.FastestUtils;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import common.z.AbstractTCase;
import common.z.Scheme;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.czt.visitors.ContainsTermVerifier;
import common.z.czt.visitors.SchemeUnfolder;
import common.z.czt.visitors.TClassNodeUnfolder;
import compserver.abstraction.capture.execution.CompilationInfo;
import compserver.prunning.PruneUtils;
import compserver.prunning.TreePruner;
import net.sourceforge.czt.session.SectionManager;
import net.sourceforge.czt.z.ast.*;
import nlg.base.designation.DesignationRepo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//import client.blogic.testing.ttree.visitors.TCaseDadFinder;


/**
 * Maintains references to the specification (both folded and unfolded
 * ocurrences), test trees, abstract test cases, the list of operations to be
 * tested (together with the strategy of tactics application and tactics list
 * for each operation) and, if any, the functions of abstraction and refinement.
 *
 * @author Pablo Rodriguez Monetti
 */
public final class Controller extends IIComponent {

    private SectionManager sectionManager;
    private String nomTexFileSpec;
    private Spec originalSpec;
    //private Spec unfoldedSpec;
    // Repository of the loaded operations from the loaded specification
    private Collection<String> loadedOpsRep;
    // Repository of the operations that the user wants to test
    private Collection<String> opsToTestRep;
    // Repository of the classes that the user wants to test
    private Collection<String> classToTestRep;
    // Repository of the operations that the user marks as predicates
    private Collection<String> schemaPredicatesRep;
    // Map from operations to tactic strategies
    private Map<String, TTreeStrategy> opTTreeStrategyMap;
    // Map from operations names, or test classes names, to repositories
    // of tactics
    private Map<String, List<Tactic>> tacticMap;
    // Map from operations to test trees
    private Map<String, TClassNode> opTTreeMap;
    // Map from operations to list of predicates whose conjunction is the
    // predicate of the VIS of the operation
    private Map<String, List<Pred>> dnfPredListMap;
    //Map from operations to refined test cases
    private Map<String, ConcreteTCase> opRefTCaseMap;
    //Map from abstract test case name to refined test cases
    private Map<String, ConcreteTCase> absTCaseRefTCaseMap;
    //Map from concrete test case name to the abstracted run results
    private Map<String, ConcreteTCaseRun> concreteTCaseRunMap;
    //Indicates the selected refinement law
    private String selectedRefLaw;
    // Indicates how many abstract test cases are being calculated
    private int pendingAbsTCases;
    // Indicates how many abstract test cases are being refined
    //private int pendingCTCases;
    // Indicates how many abstract test clases are being trying to be pruned
    private int pendingPrunnings;
    // Indicates how many test trees are being considered for obtaining abstract
    // test cases
    private int pendingTTrees;
    // lista de tipos libres
    private List<FreePara> freeParas;
    // Son los nombres de los tipos basicos
    private List<String> basicTypeNames;
    //Los tipos definidos por el usuario
    private HashMap<String, String> userDefinedTypes;
    // Gives the values assigned to the variables defined in axiomatic
    // definitions
    private Map<RefExpr, Expr> axDefsValues;
    // Gives the varibles (together with their types), defined in axiomatic
    // definitions, which do not have a value assigned by default (in the
    // predicate of the axiomatic definition) and that expect the user to
    // give that value
    private Map<String, Expr> axDefsRequired;
    // Indicates, for each variable x listed in axDefsValues, the list of
    // predicates that contains the variable x
    Map<String, List<Pred>> axDefsRequiredPreds;
    // Indicates, for each predicate of an axiomatic definition, the list of
    // variables, of not basic type, defined in axiomatic definitions
    Map<Pred, List<String>> axDefsPredVars;
    // Indicates, for each variable defined in axiomatic definitions, to which
    // a user has assigned a value V, the list of declaration of constants used
    // in V
    Map<String, ZDeclList> auxiliarDecls;
    // Indicates the list of variables, taken from axDefsRequired, for which
    // the user has assigned a value and a test class, that contains the variable
    // in its predicate, has been pruned. These variables are not allowed to
    // have their values setted with setaxdefs commands.
    List<String> blockedAxDefs;
    // Gives the variables, whose type is basic, defined in axiomatic
    // definition
    private Map<String, List<String>> basicAxDefs;

    // Environment configuration with compilers and interpreters settings.
    private CompilationInfo compilationInfo;

    private Lock myLock;
    long inicio;
    long inicioPoda;
    private Collection<TClass> leaves;
    // The maximun number of evaluations to be performed in order to find a test
    // case for a given test class
    private int maxEval;
    // The finite model size for basic types
    private int finiteModelSize;
    // The place where fuzz binary is located
    private String fuzzPath;
    //private CompilationInfo compilationInfo;
    // The maximum number of classes that the DNF tactic produce when used
    private int maxDNFClasses;
    //If the predicate of the VIS of an operation contains more than
    private int maxDNFPredsToMultiply;
    private int maxPredsToAnalize;
    //The timeout used in prolog, for setlog to find a case for a class
    private int setlogTimeout = 100; //Default value
    //Setlog File, shouled be in setlog folder
    private String setlogFile = "setlog4617.pl"; //Default value
    //Option to determine if the translation from Z to setlog is printed on screen
    private boolean setlogPrint = false;
	//Option to determine if the tactis applied using FTSDL are printed on screen
	private boolean ftsdlPrint = false;
    // Repositorio de designaciones
    private DesignationRepo desigRepo;


    /**
     * Creates a new instance of Controller
     */
    public Controller() {
        sectionManager = null;
        nomTexFileSpec = null;
        originalSpec = null;
        loadedOpsRep = null;
        opsToTestRep = null;
        classToTestRep = new ArrayList<String>();
        schemaPredicatesRep = new ArrayList<String>();
        opTTreeStrategyMap = null;
        tacticMap = null;
        opTTreeMap = new HashMap<String, TClassNode>();
        dnfPredListMap = new HashMap<String, List<Pred>>();
        opRefTCaseMap = new HashMap<String, ConcreteTCase>();
        absTCaseRefTCaseMap = new HashMap<String, ConcreteTCase>();
        concreteTCaseRunMap = new HashMap<String, ConcreteTCaseRun>();
        selectedRefLaw = null;
        pendingAbsTCases = 0;
        pendingPrunnings = 0;
        pendingTTrees = 0;
        freeParas = null;
        basicTypeNames = null;
        userDefinedTypes = null;
        axDefsValues = null;
        axDefsRequired = null;
        axDefsRequiredPreds = null;
        axDefsPredVars = null;
        auxiliarDecls = new HashMap<String, ZDeclList>();
        blockedAxDefs = new ArrayList<String>();
        basicAxDefs = null;
        compilationInfo = null;
        myLock = new ReentrantLock(); //solo constructor
        inicio = 0;
        inicioPoda = 0;
        leaves = new ArrayList<TClass>();
        FastestUtils.resetTacticsNumbersMap();
        try {
            //
            //URL url = ClientTextUI.class.getResource("ClientTextUI.class");
            //String urlStr = url.toString();
            String configFile = "/conf/fastest.conf";
            BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(configFile)));
            String line;
            while ((line = in.readLine()) != null) {
                String lineParts[] = line.split("=");
                if (lineParts.length == 2) {
                    lineParts[0] = lineParts[0].trim();
                    lineParts[1] = lineParts[1].trim();
                    if (lineParts[0].equals("MAX_EVAL")) {
                        Integer i = Integer.decode(lineParts[1]);
                        maxEval = i.intValue();
                    } else if (lineParts[0].equals("DEF_SIZE_FINITE_SET")) {
                        Integer i = Integer.decode(lineParts[1]);
                        finiteModelSize = i.intValue();
                    } else if (lineParts[0].equals("FUZZ_PATH")) {
                        fuzzPath = lineParts[1];
                    } else if (lineParts[0].equals("MAX_DNF_CLASSES")) {
                        maxDNFClasses = Integer.decode(lineParts[1]);
                    } else if (lineParts[0].equals("MAX_DNF_PREDS_TO_MULTIPLY")) {
                        maxDNFPredsToMultiply = Integer.decode(lineParts[1]);
                    } else if (lineParts[0].equals("MAX_PREDS_TO_ANALIZE")) {
                        maxPredsToAnalize = Integer.decode(lineParts[1]);
                    } else if (lineParts[0].equals("SETLOG_TIMEOUT")) {
                        setlogTimeout = Integer.decode(lineParts[1]);
                    } else if (lineParts[0].equals("SETLOG_FILE")) {
                        setlogFile = lineParts[1];
                    } else if (lineParts[0].equals("SETLOG_PRINT")) {
                        if (lineParts[1].equalsIgnoreCase("true"))
                            setlogPrint = true;
                    } else if (lineParts[0].equals("FTSDL_PRINT")) {
						if (lineParts[1].equalsIgnoreCase("true"))
							ftsdlPrint = true;
					}
                }
            }
            in.close();

        } catch (Exception e) {
            System.out.println("Error reading configuration file.");
        }
    }

    /**
     * Manages an implicit invocation event.
     *
     * @param event_
     * @throws java.lang.IllegalArgumentException if event_ is neither instance of
     *                                            AllTCaseGenerated, AllTTreeGenerated, TCaseGenerated nor TTreeGenerated.
     */
    public void manageEvent(Event_ event_) throws IllegalArgumentException {
        myLock.lock();
        String opName;
        if (event_ instanceof TTreeGenerated) {
            TTreeGenerated tTreeGenerated = (TTreeGenerated) event_;
            opName = tTreeGenerated.getOpName();
            TClassNode tClassNode = tTreeGenerated.getTTree();
            if (FastestUtils.isSelectedOperation(this, opName)) {
                opTTreeMap.put(opName, tClassNode);
            }

            boolean allTTreeGnrtd = true;

            boolean isTClass = false;
            Iterator<String> iter = classToTestRep.iterator();
            while (iter.hasNext()) {
                if (iter.next().equals(opName)) {
                    isTClass = true;
                    iter.remove();
                }
            }

            Iterator<String> opNameIt = opsToTestRep.iterator();
            while (opNameIt.hasNext() && allTTreeGnrtd) {
                if (!opTTreeMap.containsKey(opNameIt.next())) {
                    allTTreeGnrtd = false;
                }
            }

            if (isTClass) {
                iter = classToTestRep.iterator();
                if (iter.hasNext()) {
                    allTTreeGnrtd = false;
                }
            }

            if (allTTreeGnrtd) {
                try {
                    EventAdmin eventAdmin = EventAdmin.getInstance();
                    AllTTreesGenerated allTTreeEvent = new AllTTreesGenerated();
                    eventAdmin.announceEvent(allTTreeEvent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (event_ instanceof PruneTTreeRequested) {
            PruneTTreeRequested pruneTTreeRequested = (PruneTTreeRequested) event_;
            //leaves = pruneTTreeRequested.getLeaves();
            Collection<TClass> auxLeaves = pruneTTreeRequested.getLeaves();
            Iterator<TClass> tClassIt = auxLeaves.iterator();
            while (tClassIt.hasNext()) {
                TClass auxTClass = tClassIt.next();
                leaves.add(auxTClass);
                pendingPrunnings++;
            }
            if (inicioPoda == 0) {
                Calendar cal = Calendar.getInstance();
                inicioPoda = cal.getTimeInMillis();
            }
        } else if (event_ instanceof PruneTClassRequested) {
            /*if (pendingPrunnings == 0){
            Calendar cal = Calendar.getInstance();
            inicioPoda = cal.getTimeInMillis();
            }
            pendingPrunnings++;*/
        } else if (event_ instanceof RefLawSelected) {
            RefLawSelected refLawSelected = (RefLawSelected) event_;
            this.selectedRefLaw = refLawSelected.getRefLawName();
        }
        //		else if (event_ instanceof AllTCasesRefineRequested) {
        //			//			refining = true;
        //			//			try {
        //			//				AllTCasesRefineRequested allTCasesRefineRequested = (AllTCasesRefineRequested) event_;
        //			//				AllTCasesRequested allTCasesRequested =	new AllTCasesRequested(allTCasesRefineRequested.getOpName(),allTCasesRefineRequested.getTTree(), getMaxEval());
        //			//				EventAdmin eventAdmin = EventAdmin.getInstance();
        //			//				eventAdmin.announceEvent(allTCasesRequested);
        //			//			} catch (Exception e) {
        //			//				e.printStackTrace();
        //			//			}
        //		}
        else if (event_ instanceof RunCTCFinished) {
            try {
                ClientUI clientUI = getMyClientUI();
                if (clientUI instanceof ClientTextUI) {
                    synchronized (clientUI) {
                        clientUI.notify();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //		else if (event_ instanceof TCaseAbstracted) {
        //			TCaseAbstracted caseAbstracted = (TCaseAbstracted) event_;
        //			String brotherName = caseAbstracted.getBrotherName();
        //			AbstractTCase cOutput = caseAbstracted.getAbstractTCase();
        //			String opNameSource = caseAbstracted.getOpName();
        //			TClassNode tClassNode = opTTreeMap.get(opNameSource);
        //			String dadName = tClassNode.acceptVisitor(new TCaseDadFinder(brotherName));
        //			Boolean correctlyadded = tClassNode.acceptVisitor(new TCaseNodeAdder(dadName, cOutput));
        //			System.out.println(dadName + " test case abstraction -> SUCCESS.");
        //			pendingCTCases--;
        //			if (pendingCTCases == 0) {
        //				try {
        //					ClientUI clientUI = getMyClientUI();
        //					if (clientUI instanceof ClientTextUI) {
        //						synchronized (clientUI) {
        //							clientUI.notify();
        //						}
        //					}
        //
        //				} catch (Exception e) {
        //					e.printStackTrace();
        //				}
        //			}
        //		}
        //		else if (event_ instanceof ScriptModified) {
        //			// We must actualize all the maps with ConcreteTCase's information
        //			pendingCTCases--;
        //			ScriptModified scriptModified = (ScriptModified) event_;
        //			ConcreteTCase ctCase = scriptModified.getConcreteTCase();
        //			String ctcName = ctCase.getConcreteTCaseName();
        //
        //			Map<String, ConcreteTCase> auxMap = new HashMap<String, ConcreteTCase>();
        //			Set<Map.Entry<String, ConcreteTCase>> set = absTCaseRefTCaseMap.entrySet();
        //			Iterator<Map.Entry<String, ConcreteTCase>> iterator = set.iterator();
        //			boolean founded = false;
        //			while (iterator.hasNext() && !founded) {
        //				Map.Entry<String, ConcreteTCase> mapEntry = iterator.next();
        //				ConcreteTCase auxCTCase = mapEntry.getValue();
        //				String absTCaseName = mapEntry.getKey();
        //				String ctcAuxName = auxCTCase.getConcreteTCaseName();
        //				if (ctcAuxName.equals(ctcName)) {
        //					auxMap.put(absTCaseName, auxCTCase);
        //					founded = true;
        //				}
        //			}
        //			absTCaseRefTCaseMap.putAll(auxMap);
        //
        //			Set<Map.Entry<String, List<ConcreteTCase>>> set2 = opRefTCaseMap.entrySet();
        //			Iterator<Map.Entry<String, List<ConcreteTCase>>> iterator2 = set2.iterator();
        //			while (iterator2.hasNext()) {
        //				Map.Entry<String, List<ConcreteTCase>> mapEntry = iterator2.next();
        //				List<ConcreteTCase> auxCTCases = mapEntry.getValue();
        //				//String opNameSpec = mapEntry.getKey();
        //				for (int i = 0; i < auxCTCases.size(); i++) {
        //					ConcreteTCase auxCTCase = auxCTCases.get(i);
        //					String auxCTCName = auxCTCase.getConcreteTCaseName();
        //					if (auxCTCName.equals(ctcName)) {
        //						auxCTCases.set(i, ctCase);
        //					}
        //				}
        //			}
        //			if (pendingCTCases == 0) {
        //				processFinished();
        //			}
        //		}
        else if (event_ instanceof PrunningResult) {
            PrunningResult prunningResult = (PrunningResult) event_;
            String tClassName = prunningResult.getTClassName();
            String theoremName = prunningResult.getTheoremName();
            List<String> params = prunningResult.getParams();
            boolean result = prunningResult.getResult();
            if (result) {
                System.out.print("Test Objective " + tClassName + " pruned by \n"
                        + theoremName + "(");
                for (int i = 0; i < params.size() - 1; i++) {
                    System.out.print(params.get(i) + ", ");
                }
                System.out.println(params.get(params.size() - 1) + ")\n");
                TreePruner treePruner = new TreePruner(this);
                boolean pruned = treePruner.pruneFrom(tClassName);

                blockSetAxDefCmd(tClassName);

            } else {
                System.out.println("Fastest cannot prune " + tClassName);
            }
            pendingPrunnings--;
            if (pendingPrunnings == 0) {
                // We check if appears new leaves. In that case we try to prune
                // them. In the other case we finish the pruning.
                Collection<TClass> newLeaves = PruneUtils.obtainTClasses(this);
                Iterator<TClass> tClassItOld = leaves.iterator();
                Iterator<TClass> tClassItNew = newLeaves.iterator();
                List<TClass> newList = new ArrayList<TClass>();
                List<TClass> oldList = new ArrayList<TClass>();
                while (tClassItNew.hasNext()) {
                    newList.add(tClassItNew.next());
                }
                while (tClassItOld.hasNext()) {
                    oldList.add(tClassItOld.next());
                }
                newList.removeAll(oldList);
                if (newList.size() > 0) {
                    Collection<TClass> alternativeLeaves = new ArrayList<TClass>();
                    for (int i = 0; i < newList.size(); i++) {
                        alternativeLeaves.add(newList.get(i));
                    }

                    try {
                        PruneTTreeRequested pruneTTreeRequested = new PruneTTreeRequested(alternativeLeaves);
                        EventAdmin eventAdmin = EventAdmin.getInstance();
                        eventAdmin.announceEvent(pruneTTreeRequested);
                    } catch (Exception e) {
                        e.printStackTrace(System.out);
                        System.out.println("Illegal Access");
                    }
                } else {
                    Calendar cal = Calendar.getInstance();
                    long fin = cal.getTimeInMillis();
                    System.out.println("Elapsed time (prunett): " + (fin - inicioPoda) + " miliseconds.");
                    // We reset inicioPoda
                    inicioPoda = 0;
                    try {
                        ClientUI clientUI = getMyClientUI();
                        if (clientUI instanceof ClientTextUI) {
                            synchronized (clientUI) {
                                clientUI.notify();
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        } else if (event_ instanceof AllTCasesGenerated) {
            ClientUI clientUI = getMyClientUI();
            if (clientUI instanceof ClientTextUI) {
                synchronized (clientUI) {
                    clientUI.notify();
                }
            }
        } else if (event_ instanceof AllTTreesGenerated) {
            ClientUI clientUI = getMyClientUI();
            if (clientUI instanceof ClientTextUI) {
                synchronized (clientUI) {
                    clientUI.notify();
                }
            }
        } else if (event_ instanceof AllTCasesRequested) {
            pendingTTrees++;
        }
        //		else if (event_ instanceof TCaseAddCaptureCodeRequested) {
        //			Calendar cal = Calendar.getInstance();
        //			inicio = cal.getTimeInMillis();
        //			pendingCTCases++;
        //		}
        //		 else if (event_ instanceof TCaseAbstractRequested) {
        //			pendingCTCases++;
        //		}
        else if (event_ instanceof NotTClassLeavesFounded) {
            pendingTTrees--;
            if (pendingTTrees == 0) {
                //				if (!refining) {
                //					System.out.println("Error managing event NotTClassLeavesFounded in Controller");
                //					processFinished();
                //				}

            }
        } else if (event_ instanceof TCaseRequested) {
            TCaseRequested tCaseStrategyEvent = (TCaseRequested) event_;
            opName = tCaseStrategyEvent.getOpName();
            //TClass tClass = tCaseStrategyEvent.getTClass();
			/*Movido a genalltca command, por problemas de sincronización:
			if (pendingAbsTCases == 0) {
				Calendar cal = Calendar.getInstance();
				inicio = cal.getTimeInMillis();
			}
			 */

            pendingAbsTCases++;
        } else if (event_ instanceof TCaseGenerated) {
            TCaseGenerated tCaseGenerated = (TCaseGenerated) event_;
            opName = tCaseGenerated.getOpName();
            TClass tClass = tCaseGenerated.getTClass();
            String tClassName = tClass.getSchName();
            AbstractTCase abstractTCase = tCaseGenerated.getAbstractTCase();

            if (abstractTCase == null) {
                System.out.println(tClassName + " test case generation -> FAILED.");

            } else if (abstractTCase.getMyAxPara() == null) { //El nodo debe ser pruneado

                TTreeNode tClassNode = FastestUtils.getTTreeNode(this, tClassName);
                TClassNode dadNode = tClassNode.getDadNode();
                if (dadNode != null) { //Si no es el VIS pruneamos el nodo
                    boolean result = (new TreePruner(this)).pruneFrom(tClassName);
                    //if (result) {
                    //	System.out.println("Node pruned: " + tClassName);
                    //}

                    //Debemos llamar genalltca en el padre, si es que todos sus hijos fueron pruneados
                    //y no es el VIS
                    TClassNode dadOfDadNode = dadNode.getDadNode();
                    if (dadOfDadNode != null) { //No es el VIS
                        Collection<? extends TTreeNode> childsNodeRep = dadNode.getChildren();
                        Iterator<? extends TTreeNode> childsNodeIt = childsNodeRep.iterator();
                        Boolean allChildsPruned = new Boolean(true);
                        while (childsNodeIt.hasNext() && allChildsPruned.booleanValue() == true) {
                            TTreeNode child = childsNodeIt.next();
                            if (child instanceof TClassNode) {
                                allChildsPruned = ((TClassNode) child).isPruned();
                            }
                        }
                        if (allChildsPruned) {
                            //pendingAbsTCases++;
                            EventAdmin eventAdmin = null;
                            try {
                                eventAdmin = EventAdmin.getInstance();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            TClassNodeUnfolder tClassNodeUnfolder = new TClassNodeUnfolder(dadNode, this);
                            dadNode.acceptVisitor(tClassNodeUnfolder);
                            TClass dadClass = tClassNodeUnfolder.getTClassUnfolded();
                            TCaseRequested tCaseRequested = new TCaseRequested(opName, dadClass, maxEval);
                            eventAdmin.announceEvent(tCaseRequested);
                            //salimos
                            pendingAbsTCases--;
                            myLock.unlock();
                            return;
                        }
                    }
                }
            } else {
                System.out.println(tClassName + " test case generation -> SUCCESS.");
                TClassNode tClassNode = opTTreeMap.get(opName);
                Boolean correctlyadded = tClassNode.acceptVisitor(new TCaseNodeAdder(tClassName, abstractTCase));
            }
            pendingAbsTCases--;
            //System.out.println("Quedan: "+pendingAbsTCases);
            if (pendingAbsTCases == 0) {
                pendingTTrees = 0;
                //				if (refining) {
                //					try {
                //						EventAdmin eventAdmin = EventAdmin.getInstance();
                //						eventAdmin.announceEvent(new AllTCasesRefined());
                //					} catch (Exception e) {
                //						e.printStackTrace();
                //					}
                //				} else {
                processFinished();
                //}
            }
        } else if (event_ instanceof FastestResetted) {
            sectionManager = null;
            nomTexFileSpec = null;
            originalSpec = null;
            loadedOpsRep = null;
            opsToTestRep = null;
            classToTestRep = new ArrayList<String>();
            schemaPredicatesRep = new ArrayList<String>();
            opTTreeStrategyMap = null;
            tacticMap = null;
            opTTreeMap.clear();
            dnfPredListMap.clear(); //dejar asi
            opRefTCaseMap.clear(); //dejar asi
            absTCaseRefTCaseMap.clear(); //dejar asi
            selectedRefLaw = null;
            pendingAbsTCases = 0;
            pendingPrunnings = 0;
            pendingTTrees = 0;
            freeParas = null;
            basicTypeNames = null;
            userDefinedTypes = null;
            axDefsValues = null;
            axDefsRequired = null;
            axDefsRequiredPreds = null;
            axDefsPredVars = null;
            auxiliarDecls.clear(); //dejaar asi
            blockedAxDefs.clear(); //dejar asi
            basicAxDefs = null;
            inicio = 0;
            inicioPoda = 0;
            leaves = new ArrayList<TClass>();
            FastestUtils.resetTacticsNumbersMap();
        } else {
            throw new IllegalArgumentException();
        }
        myLock.unlock();
    }

    /**
     * Blocks the chance to set the values, with a setaxdef command, of the
     * variables, defined in axiomatic definitions, that appear in the predicate
     * of the specified test class.
     *
     * @param tClassName the name of the test class C for which the variables,
     *                   defined in axiomatic definitions and contained in the predicate of C,
     *                   will be blocked to be setted through a setaxdef command
     */
    private void blockSetAxDefCmd(String tClassName) {
        // We block the setaxdef command for those axiomatic definitions
        // that are contained in the predicate of this pruned test class

        Set<Map.Entry<String, TClassNode>> set = opTTreeMap.entrySet();
        Iterator<Map.Entry<String, TClassNode>> iterator = set.iterator();
        //String opName;
        Scheme tClassScheme = null;
        while (iterator.hasNext() && tClassScheme == null) {
            Map.Entry<String, TClassNode> mapEntry = iterator.next();
            //opName = mapEntry.getKey();
            TClassNode opTTreeRoot = mapEntry.getValue();
            tClassScheme = opTTreeRoot.acceptVisitor(new SchemeTTreeFinder(tClassName, 0));
        }

        AxPara tClassAxPara = tClassScheme.getMyAxPara();
        Pred tClassAxParaPred = SpecUtils.getAxParaPred(tClassAxPara);
        ContainsTermVerifier ctVerifier = new ContainsTermVerifier();
        Set<Map.Entry<RefExpr, Expr>> axDefsValuesSet = axDefsValues.entrySet();
        Iterator<Map.Entry<RefExpr, Expr>> axDefsValuesIt = axDefsValuesSet.iterator();

        while (axDefsValuesIt.hasNext()) {
            Map.Entry<RefExpr, Expr> entry = axDefsValuesIt.next();
            RefExpr varNameRefExpr = entry.getKey();
            ctVerifier.setTerm(varNameRefExpr);
            if (tClassAxParaPred.accept(ctVerifier)) {
                blockedAxDefs.add(varNameRefExpr.getName().toString());
            }
        }

    }

    /**
     * Sets the reference to the system's ClientIU object.
     *
     * @param clientUI
     */
    @Override
    public void setMyClientUI(ClientUI clientUI) {
        myClientUI = clientUI;
        clientUI.setMyController(this);
    }

    /**
     * Sets the folded (original) specification of the system under test.
     *
     * @param spec
     */
    public void setOriginalSpec(Spec spec) {
        originalSpec = spec;
    }

    /**
     * Gets the folded (original) specification of the system under test.
     *
     * @return
     */
    public Spec getOriginalSpec() {
        return originalSpec;
    }

    /**
     * Sets the unfolded specification of the system under test.
     * @param spec
     */
    //	public void setUnfoldedSpec(Spec spec) {
    //		unfoldedSpec = spec;
    //	}

    /**
     * Gets the unfolded specification of the system under test.
     *
     * @return
     */
    public Spec getUnfoldedSpec() {
        Collection<String> opNames = this.getOpsToTestRep();
        Collection<String> schPredNames = this.getSchemaPredicatesRep();
        //System.out.println(SpecUtils.termToLatex(originalSpec));
        return (Spec) originalSpec.accept(new SchemeUnfolder(opNames, schPredNames));
        //return originalSpec;
    }

    /**
     * Sets the repository of the operations to be tested.
     *
     * @param opRep
     */
    public void setOpsToTestRep(Collection<String> opRep) {
        opsToTestRep = opRep;
    }

    /**
     * Gets the repository of the operations to be tested.
     *
     * @return
     */
    public Collection<String> getOpsToTestRep() {
        return opsToTestRep;
    }

    /**
     * Sets the repository of the clases to be tested.
     *
     * @param opRep
     */
    public void setClassToTestRep(Collection<String> classRep) {
        classToTestRep = classRep;
    }

    /**
     * Gets the repository of the operations to be tested.
     *
     * @return
     */
    public Collection<String> getClassToTestRep() {
        return classToTestRep;
    }

    /**
     * Sets the repository of the schemas marked as predicates
     *
     * @param opRep
     */
    public void setSchemaPredicatesRep(Collection<String> schemaPredicatesRep) {
        this.schemaPredicatesRep = schemaPredicatesRep;
    }

    /**
     * Gets the repository of the schemas marked as predicates
     *
     * @return
     */
    public Collection<String> getSchemaPredicatesRep() {
        return schemaPredicatesRep;
    }

    /**
     * Sets the repository of the operations loaded with the specification.
     *
     * @param opRep
     */
    public void setLoadedOpsRep(Collection<String> opRep) {
        loadedOpsRep = opRep;
    }

    /**
     * Gets the repository of the operations loaded with the specification.
     *
     * @return
     */
    public Collection<String> getLoadedOpsRep() {
        return loadedOpsRep;
    }

    /**
     * Sets the structure that maps operation names to associated strategies
     * of tactic application.
     *
     * @param opMap
     */
    public void setOpTTreeStrategyMap(Map<String, TTreeStrategy> opMap) {
        opTTreeStrategyMap = opMap;
    }

    /**
     * Gets the structure that maps operation names to associated strategies of
     * tactic application.
     *
     * @return
     */
    public Map<String, TTreeStrategy> getOpTTreeStrategyMap() {
        return opTTreeStrategyMap;
    }

    /**
     * Sets the structure that maps operation, and test classes names, to
     * associated tactics repositories.
     *
     * @param opMap the structure that maps operation, and test classes names, to
     *              associated tactics repositories.
     */
    public void setTacticMap(Map<String, List<Tactic>> opMap) {
        tacticMap = opMap;
    }

    /**
     * Returns the structure that maps operation, and test classes names, to
     * associated tactics repositories.
     *
     * @return the structure that maps operation, and test classes names, to
     * associated tactics repositories.
     */
    public Map<String, List<Tactic>> getTacticMap() {
        return tacticMap;
    }

    /**
     * Sets the structure that maps operation names to associated test trees.
     *
     * @param opMap the structure that maps operation names to associated test trees.
     */
    public void setOpTTreeMap(Map<String, TClassNode> opMap) {
        opTTreeMap = opMap;
    }

    /**
     * Gets the structure that maps operation names to associated test trees.
     *
     * @return
     */
    public Map<String, TClassNode> getOpTTreeMap() {
        return opTTreeMap;
    }

    /**
     * Sets the SectionManager object with which the specification was loaded.
     * It is needed for typechecking tasks.
     *
     * @param manager the SectionManager object with which the specification was
     *                loaded.
     */
    public void setTypeCheckerManager(SectionManager manager) {
        sectionManager = manager;
    }

    /**
     * Returns the SectionManager object with which the specification was loaded.
     * It is needed for typechecking tasks.
     *
     * @return the SectionManager object with which the specification was loaded.
     */
    public SectionManager getTypeCheckerManager() {
        return sectionManager;
    }

    /**
     * Sets the maximum number of evaluations to be performed in order to try
     * to obtain a test class for each test class.
     *
     * @param maxEval
     */
    public void setMaxEval(int maxEval) {
        this.maxEval = maxEval;
    }

    /**
     * Returns the maximum number of evaluations to be performed in order to try
     * to obtain a test class for each test class.
     *
     * @return the maximum number of evaluations to be performed in order to try
     * to obtain a test class for each test class.
     */
    public int getMaxEval() {
        return maxEval;
    }

    /**
     * Sets the finite model size to be used in the generation of test cases.
     *
     * @param finiteModelSize
     */
    public void setFiniteModelSize(int finiteModelSize) {
        this.finiteModelSize = finiteModelSize;
    }

    /**
     * Returns the finite model size to be used in the generation of test cases.
     *
     * @return the finite model size to be used in the generation of test cases.
     */
    public int getFiniteModelSize() {
        return finiteModelSize;
    }

    /**
     * Sets the structure that indicates the variables defined in axiomatic
     * definitions that requires the user to give a value.
     *
     * @param axDefsRequired the structure that indicates the variables defined in axiomatic
     *                       definitions that requires the user to give a value.
     */
    public void setAxDefsRequired(Map<String, Expr> axDefsRequired) {
        this.axDefsRequired = axDefsRequired;
    }

    /**
     * Returns the structure that indicates the variables defined in axiomatic
     * definitions that requires the user to give a value.
     *
     * @return the structure that indicates the variables defined in axiomatic
     * definitions that requires the user to give a value.
     */
    public Map<String, Expr> getAxDefsRequired() {
        return axDefsRequired;
    }

    /**
     * Sets the structure that maps variables defined in axiomatic definitions
     * to their values.
     *
     * @param axDefsValues the structure that maps variables defined in axiomatic definitions
     *                     to their values.
     */
    public void setAxDefsValues(Map<RefExpr, Expr> axDefsValues) {
        this.axDefsValues = axDefsValues;
    }

    /**
     * Returns the structure that maps variables defined in axiomatic definitions
     * to their values.
     *
     * @return the structure that maps variables defined in axiomatic definitions
     * to their values.
     */
    public Map<RefExpr, Expr> getAxDefsValues() {
        return axDefsValues;
    }

    /**
     * Sets the list of variables of basic types, defined in axiomatic
     * definitions.
     *
     * @param basicAxDefs the list of variables of basic types, defined in axiomatic
     *                    definitions.
     */
    public void setBasicAxDefs(Map<String, List<String>> basicAxDefs) {
        this.basicAxDefs = basicAxDefs;
    }

    /**
     * Returns the list of variables of basic types, defined in axiomatic
     * definitions.
     *
     * @return the list of variables of basic types, defined in axiomatic
     * definitions.
     */
    public Map<String, List<String>> getBasicAxDefs() {
        return basicAxDefs;
    }

    /**
     * Sets the structure that maps variables, defined in axiomatic definitions,
     * for which the user has to enter a value, to the predicates of axiomatic
     * definitions in which they appear.
     *
     * @param axDefsRequiredPreds the structure that maps variables, defined in
     *                            axiomatic definitions, for which the user has to enter a value, to the
     *                            predicates of axiomatic definitions in which they appear.
     */
    public void setAxDefsRequiredPreds(Map<String, List<Pred>> axDefsRequiredPreds) {
        this.axDefsRequiredPreds = axDefsRequiredPreds;
    }

    /**
     * Returns the structure that maps variables, defined in axiomatic definitions,
     * for which the user has to enter a value, to the predicates of axiomatic
     * definitions in which they appear.
     *
     * @return the structure that maps variables, defined in
     * axiomatic definitions, for which the user has to enter a value, to the
     * predicates of axiomatic definitions in which they appear.
     */
    public Map<String, List<Pred>> getAxDefsRequiredPreds() {
        return axDefsRequiredPreds;
    }

    /**
     * Sets the structure that indicates, for each predicate of an axiomatic
     * definition, the list of variables, of not basic type, defined in
     * axiomatic definitions.
     *
     * @param axDefsPredVars the structure that indicates, for each predicate of
     *                       an axiomatic definition, the list of variables, of not basic type,
     *                       defined in axiomatic definitions.
     */
    public void setAxDefsPredVars(Map<Pred, List<String>> axDefsPredVars) {
        this.axDefsPredVars = axDefsPredVars;
    }

    /**
     * Returns the structure that indicates, for each predicate of an axiomatic
     * definition, the list of variables, of not basic type, defined in
     * axiomatic definitions.
     *
     * @return the structure that indicates, for each predicate of an axiomatic
     * definition, the list of variables, of not basic type, defined in
     * axiomatic definitions.
     */
    public Map<Pred, List<String>> getAxDefsPredVars() {
        return axDefsPredVars;
    }

    /**
     * Sets the structure that indicates, for each variable defined in axiomatic
     * definitions, to which a user has assigned a value V, the list of
     * declaration of constants used in V
     *
     * @param axDefsPredVars the structure that indicates, for each variable defined in axiomatic
     *                       definitions, to which a user has assigned a value V, the list of
     *                       declaration of constants used in V
     */
    public void setAuxiliarDecls(Map<String, ZDeclList> auxiliarDecls) {
        this.auxiliarDecls = auxiliarDecls;
    }

    /**
     * Returns the structure that indicates, for each variable defined in axiomatic
     * definitions, to which a user has assigned a value V, the list of
     * declarations of constants used in V.
     *
     * @return the structure that indicates, for each variable defined in axiomatic
     * definitions, to which a user has assigned a value V, the list of
     * declarations of constants used in V
     */
    public Map<String, ZDeclList> getAuxiliarDecls() {
        return auxiliarDecls;
    }

    /**
     * Sets the structure that indicates the list of variables, taken from
     * axDefsRequired, for which the user has assigned a value and a test class,
     * that contains the variable in its predicate, has been pruned. These
     * variables are not allowed to have their values setted with setaxdefs
     * commands.
     *
     * @param blockedAxDefs he structure that indicates the list of variables,
     *                      taken from axDefsRequired, for which the user has assigned a value and a
     *                      test class, that contains the variable in its predicate, has been pruned.
     *                      These variables are not allowed to have their values setted with
     *                      setaxdefs commands.
     */
    public void setBlockedAxDefs(List<String> blockedAxDefs) {
        this.blockedAxDefs = blockedAxDefs;
    }

    public Map<String, ConcreteTCase> getOpTCaseRefinedMap() {
        return opRefTCaseMap;
    }

    /**
     * Returns the structure that indicates the list of variables, taken from
     * axDefsRequired, for which the user has assigned a value and a test class,
     * that contains the variable in its predicate, has been pruned. These
     * variables are not allowed to have their values setted with setaxdefs
     * commands.
     *
     * @return the structure that indicates the list of variables, taken from
     * axDefsRequired, for which the user has assigned a value and a test class,
     * that contains the variable in its predicate, has been pruned. These
     * variables are not allowed to have their values setted with setaxdefs
     * commands.
     */
    public List<String> getBlockedAxDefs() {
        return blockedAxDefs;
    }

    /**
     * Gets the selected refinement law from the repository.
     *
     * @return
     */
    public String getSelRefLaw() {
        return selectedRefLaw;
    }

    public Map<String, ConcreteTCase> getAbsTCaseConcrTCaseMap() {
        return this.absTCaseRefTCaseMap;
    }

    public Map<String, ConcreteTCaseRun> getConcreteTCaseRunMap() {
        return concreteTCaseRunMap;
    }

    public void setCompilationInfo(CompilationInfo compilationInfo) {
		this.compilationInfo = compilationInfo;
	}

	public CompilationInfo getCompilationInfo() {
		return compilationInfo;
	}

    private void processFinished() {
        Calendar cal = Calendar.getInstance();
        long fin = cal.getTimeInMillis();
        System.out.println("Elapsed time: " + (fin - inicio) + " miliseconds.");
        try {
            ClientUI clientUI = getMyClientUI();
            if (clientUI instanceof ClientTextUI) {
                synchronized (clientUI) {
                    clientUI.notify();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFuzzPath(String fuzzPath) {
        this.fuzzPath = fuzzPath;
    }

    public String getFuzzPath() {
        return fuzzPath;
    }

    /**
     * Checks if a string is contained in the repository of selected operations
     *
     * @param controller a reference to the Controller
     * @param opName     the string to search in the repository
     * @return
     */
    public boolean isSelectedOperation(String opName) {
        Collection<String> selectedOpsRep = getOpsToTestRep();
        Iterator<String> it = selectedOpsRep.iterator();
        boolean hasFound = false;
        while (it.hasNext() && !hasFound) {
            if (it.next().equals(opName)) {
                hasFound = true;
            }
        }
        return hasFound;
    }

    /**
     * Checks if a string is contained in the repository of selected predicates
     *
     * @param controller a reference to the Controller
     * @param opName     the string to search in the repository
     * @return
     */
    public boolean isSelectedPredicate(String opName) {
        Collection<String> schemaPredicates = this.getSchemaPredicatesRep();
        Iterator<String> it = schemaPredicates.iterator();
        boolean hasFound = false;
        while (it.hasNext() && !hasFound) {
            if (it.next().equals(opName)) {
                hasFound = true;
            }
        }
        return hasFound;
    }


    public void putInSchemaDNFPredList(String schemaName, List<Pred> predList) {
        dnfPredListMap.put(schemaName, predList);
    }

    public List<Pred> getSchemaDNFPredList(String schemaName) {
        return dnfPredListMap.get(schemaName);
    }

    public void clearSchemaDNFPredList() {
        dnfPredListMap.clear();
    }

    public int getMaxDNFClasses() {
        return maxDNFClasses;
    }

    public int getMaxDNFPredsToMultiply() {
        return maxDNFPredsToMultiply;
    }

    public int getMaxPredsToAnalize() {
        return maxPredsToAnalize;
    }

    public int getSetlogTimeout() {
        return setlogTimeout;
    }

    public String getSetlogFile() {
        return setlogFile;
    }

    public boolean getSetlogPrint() {
        return setlogPrint;
    }
    
    public boolean getftsdlPrint(){
		return ftsdlPrint;        
	}

    public List<String> getBasicTypeNames() {
        return basicTypeNames;
    }

    public void setBasicTypeNames(List<String> basicTypeNames) {
        this.basicTypeNames = basicTypeNames;
    }

    public List<FreePara> getFreeParas() {
        return freeParas;
    }

    public void setFreeParas(List<FreePara> freeParas) {
        this.freeParas = freeParas;
    }

    public String getNomTexFileSpec() {
        return nomTexFileSpec;
    }

    public void setNomTexFileSpec(String nomTexFileSpec) {
        this.nomTexFileSpec = nomTexFileSpec;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public void setUserDefinedTypes(HashMap<String, String> userDefinedTypes) {
        this.userDefinedTypes = userDefinedTypes;

    }

    public HashMap<String, String> getUserDefinedTypes() {
        return this.userDefinedTypes;

    }

    public DesignationRepo getDesigRepo() {
        return desigRepo;
    }

    public void setDesigRepo(DesignationRepo desigRepo) {
        this.desigRepo = desigRepo;
    }

}
