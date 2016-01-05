package jplTests;

import com.sun.jna.Library;
import com.sun.jna.Native;
import jpl.Atom;
import jpl.Query;
import jpl.Term;
import jpl.Variable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;


/**
 * Created by Cristian on 21/07/15.
 */
public class JPLTest {

//    @Test
    public void test0() {
        String t0 = "consult('src/test/java/jplTests/test.pl')";
        assert (Query.hasSolution(t0));
        if (!Query.hasSolution(t0)) {
            System.out.println(t0 + " failed");
            // System.exit(1);
        }
        System.out.println("passed");
    }

//    @Test
    public void test1() {

        // Load swipl symbol definitions into global symbol namespace to make them available to other dynamic libraries.
        // This is required due to java not making them globally available by default.
        Native.loadLibrary("swipl", Library.class);

        String t0 = "use_module(library(dialect/sicstus/timeout))";
        String t1 = "consult('lib/setlog/setlog4617.pl')";
        String t2 = "setlog_consult('lib/setlog/setlogTTF.slog')";
        String t3 = "consult_lib";
        String t4 = "set_prolog_flag(toplevel_print_options, [quoted(true), portray(true)])";
        String t5 = "time_out(setlog(set(UID) &\n" +
                " set(NAME) &\n" +
                " set(ACCNUM) &\n" +
                " dom(Clients,VAR0) &\n" +
                " U in VAR0 &\n" +
                " Clients neq {} &\n" +
                " {[U,Name]} neq {} &\n" +
                " {[U,Name]} = Clients &\n" +
                " is_pfun(Clients) &\n" +
                " is_pfun(Balances) &\n" +
                " is_rel(Owners),CONSTR),2000,RET)";
        assert (Query.hasSolution(t0));
        assert (Query.hasSolution(t1));
        assert (Query.hasSolution(t2));
        assert (Query.hasSolution(t3));
        assert (Query.hasSolution(t4));
        assert (Query.hasSolution(t5));

        System.out.println(Query.oneSolution(t5));
        List<Hashtable> t = Arrays.asList(Query.nSolutions(t5, 2));
        System.out.println(t);
    }

//    @Test
    public void test2() {

        // Load database
        Query l = new Query("consult", new Term[]{new Atom("src/test/java/jplTests/test2.pl")});
        l.hasSolution();

        Query q2 =
                new Query(
                        "child_of",
                        new Term[]{new Atom("joe"), new Atom("ralf")}
                );

        System.out.println(
                "child_of(joe,ralf) is " +
                        ( q2.hasSolution() ? "provable" : "not provable" )
        );

        Variable X = new Variable("X");
        Query q4 = new Query(
                "descendent_of",
                new Term[]{X, new Atom("joe")}
        );

        while(q4.hasMoreSolutions()) {
            System.out.println(q4.nextSolution().toString());
        }

    }

}
