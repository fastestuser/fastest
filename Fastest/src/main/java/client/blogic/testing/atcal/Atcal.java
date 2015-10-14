package client.blogic.testing.atcal;

import client.blogic.testing.atcal.z.ast.CZTTranslator;
import client.blogic.testing.atcal.z.ast.ZExpr;
import client.blogic.testing.atcal.z.ast.ZExprSchema;
import client.blogic.testing.atcal.z.ast.ZVar;
import com.google.common.io.Resources;
import common.z.AbstractTCase;
import common.z.SpecUtils;
import common.z.czt.UniqueZLive;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.base.util.UnmarshalException;
import net.sourceforge.czt.parser.circus.ParseUtils;
import net.sourceforge.czt.parser.util.ParseException;
import net.sourceforge.czt.session.FileSource;
import net.sourceforge.czt.z.ast.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cristian on 3/31/15.
 */
public class Atcal {

    /**
     * Helper function to translate the abstract test case from CZT to ATCAL representation.
     *
     * @param atc a CZT abstract test case
     * @return an ATCAL abstract test case
     */
    public static ZExprSchema ATCToZExpr(AbstractTCase atc) {
        final CZTTranslator cztTranslator = new CZTTranslator();
        ArrayList<ZVar> translatedVars = new ArrayList<ZVar>();
        for (Map.Entry<RefExpr, Expr> varExpr : atc.getVarExpMap().entrySet()) {
            ZExpr expr = varExpr.getValue().accept(cztTranslator);
            translatedVars.add(new ZVar(varExpr.getKey().getName().toString(), expr));
        }
        return new ZExprSchema(translatedVars.toArray(new ZVar[translatedVars.size()]));
    }

    /**
     * Parses an abstract test case from a tex file to ATCAL's Z AST.
     *
     * @param filename the name of the file to parse
     * @return an instance of Z schema using ATCAL's AST
     */
    public static ZExprSchema parseATCFile(String filename) {
        try {
            final CZTTranslator cztTranslator = new CZTTranslator();
            ZLive zLive = UniqueZLive.getInstance();
            URL specFile = Resources.getResource(filename);
            Spec spec = (Spec) ParseUtils.parse(new FileSource(specFile.getFile()), zLive.getSectionManager());
            ZParaList o = (ZParaList) (spec.getSect().get(0).getChildren()[2]);
            AxPara axPara = (AxPara) (o.get(1));
            Pred p = SpecUtils.getAxParaPred(axPara);
            List<ZVar> translatedVars = SpecUtils.getAssignedValues(p).entrySet().stream().map(
                    mapEntry -> new ZVar(mapEntry.getKey(), mapEntry.getValue().accept(cztTranslator))
            ).collect(Collectors.toList());
            return new ZExprSchema(translatedVars.toArray(new ZVar[translatedVars.size()]));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnmarshalException e) {
            e.printStackTrace();
        }
        return null;
    }
}
