package org.fastest.atcal;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Cristian on 06/05/15.
 */
public class RecordType extends ATCALType {

    private final Map<String, ATCALType> fields;

    public RecordType(Map<String, ATCALType> fields) {
        this.fields = fields;
    }

    public Optional<ATCALType> getFieldType(String field) {
        return Optional.ofNullable(fields.get(field));
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "fields=" + fields +
                '}';
    }
}
