package gen;

import java.io.StringWriter;

import de.uni_hildesheim.sse.model.validation.IvmlValidationVisitor;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.persistency.IVMLWriter;

/**
 * Erzeugt zufaellig ein groesseres Projekt.
 * Um den Code hier zu verstehen, empfiehlt es sich vorher mal das
 * {@link Tutorial} anzuschauen.
 * 
 * @author El-Sharkawy
 *
 */
public class Generator {

    private static final int ANZAHL_VARIABLEN = 5000;
    private static final IDatatype[] VERWENDETE_DATENTYPEN =
        {IntegerType.TYPE, RealType.TYPE, StringType.TYPE, BooleanType.TYPE};
    
    /**
     * Generiert ein neues Projekt mit den Einstellungen von oben und gibt
     * dieses auf der Konsole aus.
     * @param args Die Kommandozeilenparameter werden ignoriert.
     */
    public static void main(String[] args) {
        long startZeit = System.currentTimeMillis();
        Project project = new Project("a_project");
        for (int i = 0; i < ANZAHL_VARIABLEN; i++) {
            int typeNr = i % VERWENDETE_DATENTYPEN.length;
            IDatatype typ = VERWENDETE_DATENTYPEN[typeNr];
            DecisionVariableDeclaration declaration
                = new DecisionVariableDeclaration("var_" + i, typ, project);
            project.add(declaration);
        }

        // Ausgabe nur wenn das Projekt keine fehler enthaelt.
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        project.accept(validator);
        if (validator.getErrorCount() == 0) {
            StringWriter sWriter = new StringWriter();
            IVMLWriter iWriter = new IVMLWriter(sWriter);
            project.accept(iWriter);
            System.out.println(sWriter);
        }
        
        long endZeit = System.currentTimeMillis();
        double dauer = (endZeit - startZeit) / 1000.0;
        System.out.println("Generierung dauerte " + dauer + " Sekunden.");
    }

}
