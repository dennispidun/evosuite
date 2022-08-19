package gen;
import java.io.StringWriter;

import de.uni_hildesheim.sse.model.validation.IvmlValidationVisitor;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.persistency.IVMLWriter;
import de.uni_hildesheim.sse.utils.messages.Message;

/**
 * Diese Klasse demonstriert die Verwendung des Models und der
 * zugehoerigen Komponenten.
 * 
 * @author El-Sharkawy
 * 
 */
public class Tutorial {

    /**
     * Demonstriert die Verwendung des Models.
     * 
     * @param args Die Kommandozeilenparameter werden ignoriert.
     * @throws ValueDoesNotMatchTypeException Wird geworfen, wenn der Wert
     *     fuer eine neu angelegte Variable nicht passt. In diesem Fall wenn in
     *     Zeile 84 kein double Wert uebergeben wird.
     */
    public static void main(String[] args)
        throws ValueDoesNotMatchTypeException {
        
        /*
         * Erstellt ein neues Projekt mit einem Namen. Dieses Projekt ist das
         * oberste Element der zuerstellenden Datei. Fuer den Namen des Projekts
         * (und der noch kommenden Elemente) gelten die gleichen Regeln wie fuer
         * Java Elemente.
         * Grob: Vergleichbar mit einer Klasse.
         */
        Project project = new Project("Ein_Projekt");

        /*
         * Fügt eine neue Variable hinzu vom Typ Integer hinzu. Für ein Element
         * muss immer angegeben werden, wer der Parent ist (also wo das Element
         * spaeter hinzugefuegt wird). Das Element muss dann nochmal separat dem
         * Parent (hier das Projekt) hinzugefuegt werden.
         * Für Variable Deklarationen muss zusaetzlich der Datentyp
         * spezifiziert werden.
         */
        DecisionVariableDeclaration variableDeclaration =
            new DecisionVariableDeclaration("eine_integer_Variable",
                IntegerType.TYPE, project);
        variableDeclaration.setValue("12");
        project.add(variableDeclaration);
        
        /*
         * Zusammengesetzte Datentypen koennen mit Compounds realisiert werden.
         * Compounds sind vergleichbar mit (inneren) Klassen.
         * Zunaechst muss der Name des erstelleten Datentyps angegeben werden.
         */
        Compound compound = new Compound("C", project);
        project.add(compound);
        // Innere Variablen (Attribute) hinzufuegen
        DecisionVariableDeclaration attribut =
            new DecisionVariableDeclaration("str", StringType.TYPE, compound);
        compound.add(attribut);
        /*
         * Nun koennen beliebig viele Instanzen vom neuen Compound erzeugt
         * werden.
         */
        DecisionVariableDeclaration cmp1 =
            new DecisionVariableDeclaration("cmp1", compound, project);
        DecisionVariableDeclaration cmp2 =
            new DecisionVariableDeclaration("cmp2", compound, project);
        project.add(cmp1);
        project.add(cmp2);
        
        /*
         * Variablen koennen auch gleich Initialisert werden. Dazu gibt es
         * verschiedene setValue Methoden. Am einfachsten ist es einen String
         * mit dem gewuenschten Wert zu uebergeben.
         */
        DecisionVariableDeclaration doubleDeclaration =
            new DecisionVariableDeclaration("eine_double_Variable",
                RealType.TYPE, project);
        doubleDeclaration.setValue("1.2");
        project.add(doubleDeclaration);
        
        /*
         * Das Projekt kann ueber sogenannte Visitoren ausgegeben, gespeichert
         * oder validiert (Pruefung, ob das Projekt korrekt zusammengebaut
         * wurde, ob legitime Namen verwendet wurden, etc.) werden.
         * Mehr zum Thema Visitoren kann auf Wikipedia nachgelesen werden:
         * http://de.wikipedia.org/wiki/Besucher_%28Entwurfsmuster%29
         */
        /*
         * Ueberprüfung ob ein gueltiges Projekt erstellt wurde (Validation).
         */
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        project.accept(validator);
        // Wenn ErrorCount ungleich 0 ist, dann ist das Projekt ungueltig
        boolean hatFehler = validator.getErrorCount() > 0;
        if (hatFehler) {
            System.out.println("Ungültiges Projekt:");
            for (int i = 0; i < validator.getErrorCount(); i++) {
                Message errorMessage = validator.getMessage(i);
                System.out.println(" - " + errorMessage.getDescription());
            }
        } else {
            /*
             * Ausgabe und Speichern: Zum Ausgeben und des Projekts muss ein
             * neuer IVMLWriter erzeugt werden, welcher wiederum einen Writer
             * als Parameter erwartet. Soll das Projekt in der Konsole
             * ausgegeben werden, so ist ein StringWriter ausreichend, zum
             * Speichern sollte ein FileWriter genutzt werden.
             */
            StringWriter sWriter = new StringWriter();
            IVMLWriter iWriter = new IVMLWriter(sWriter);
            // Projekt -> Writer
            project.accept(iWriter);
            // Ausgabe auf der Konsole
            System.out.println(sWriter.toString());
        }
    }

}
