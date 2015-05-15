package org.fastest.atcal;

import org.fastest.atcal.apl.APLExpr;
import org.fastest.atcal.z.ast.ZExpr;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Cristian on 06/05/15.
 */
public class RecordType implements ATCALType {


    private final Map<String, ATCALType> fields;

    public RecordType(Map<String, ATCALType> fields) {
        this.fields = fields;
    }

    public Optional<ATCALType> getFieldType(String field){
        return Optional.ofNullable(fields.get(field));
    }

    public APLExpr fromZExpr(ZExpr expr) throws Exception {
        throw new Exception();
    }
}
