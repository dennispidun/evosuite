package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;

/**
 * Class for a variable value.
 * @author jaehne
 * @author Holger Eichelberger
 *
 */
public class Variable extends Leaf {
    private AbstractVariable nestedVariable;
    
    /**
     * The constructor for this class.
     * @param nestedVariable The nested variable should be embedded in the current constraint.
     */
    public Variable(AbstractVariable nestedVariable) {
        this.nestedVariable = nestedVariable;
    }

    /**
     * Getter for the nestedVariable.
     * @return The nested variable should not be null.
     */
    public AbstractVariable getVariable() {
        return nestedVariable;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public IDatatype inferDatatype() {
        IDatatype result = nestedVariable.getType();
        // this does not work using a visitor due to the implicit
        // dispatch of the delegating types :(
        // define a method in IDatatype for this???
        if (result instanceof DerivedDatatype) {
            result = ((DerivedDatatype) result).getBasisType();
        } else if (result instanceof Reference) {
            result = ((Reference) result).getType();
        }
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitVariable(this); // no further operations!
    }
    
    @Override
    public boolean equals(Object obj) {
        //Two objects are equal if they instances of the same class and have the same hashCode
        boolean equals = false;
        
        if (obj instanceof Variable) {
            equals = this.hashCode() == obj.hashCode();
        }
        
        return equals;
    }

    @Override
    public int hashCode() {
        //Two Variables are equal, if the nestedVariables are equal
        return nestedVariable.hashCode();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getAttributesCount() {
        return nestedVariable.getAttributesCount();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Attribute getAttribute(int index) {
        return nestedVariable.getAttribute(index);
    }

    @Override
    public String toString() {
        return nestedVariable.toString();
    }
    
    /**
     * Returns the qualifier for accessing the variable, e.g., an expression
     * to be put before. For usual variables, the qualifier is always <b>null</b>.
     * 
     * @return the qualifier (may be <b>null</b>)
     */
    public ConstraintSyntaxTree getQualifier() {
        return null;
    }
}
