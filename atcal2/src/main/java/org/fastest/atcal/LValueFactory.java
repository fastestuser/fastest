package org.fastest.atcal;

import com.google.common.collect.Maps;
import org.fastest.atcal.apl.APLArray;
import org.fastest.atcal.apl.APLLValue;
import org.fastest.atcal.apl.APLVar;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Cristian on 25/06/15.
 */
public class LValueFactory {

    private final Map<String, APLLValue> lvalues = Maps.newHashMap();

    public APLLValue newVar(String name, ATCALType type){
        if(lvalues.containsKey(name)) {
            return lvalues.get(name);
        } else {
            APLLValue newVar = new APLVar(name, type);
            lvalues.put(name, newVar);
            return newVar;
        }
    }

    public APLLValue newArray(String name, ATCALType type){
        if(lvalues.containsKey(name)) {
            return lvalues.get(name);
        } else {
            APLLValue newVar = new APLArray(name, type);
            lvalues.put(name, newVar);
            return newVar;
        }
    }

    public Collection<APLLValue> getLValues() {
        return lvalues.values();
    }
}
