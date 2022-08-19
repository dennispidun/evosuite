package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Superclass for numeric values.
 * @author Marcel Lueder
 *
 */
abstract class NumberValue extends BasisDatatypeValue {
    
    /**
     * Constructor for a new NumberValue.
     * @param type type of the Value
     */
    protected NumberValue(IDatatype type) {
        super(type);
    }
    
    @Override
    protected String stringValueOf(Object object) {
        String value = super.stringValueOf(object);
        return null == value ? null : "" + value;
    }
}
