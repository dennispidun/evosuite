package org.evosuite.jmh;

import org.evosuite.Properties;
import org.evosuite.junit.UnitTestAdapter;
import org.evosuite.junit.writer.TestSuiteWriterUtils;
import org.evosuite.runtime.vnet.NonFunctionalRequirementRule;
import org.evosuite.testcase.TestCase;
import org.evosuite.testcase.TestCodeVisitor;
import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.Map;

public class JMHTestAdapter implements UnitTestAdapter {

    @Override
    public String getImports() {
        String imports = "";
        if ((Properties.ECLIPSE_PLUGIN) && (!Properties.TARGET_CLASS.equals("EvoSuiteTest")))
            imports += "import " + org.evosuite.annotations.EvoSuiteTest.class.getName() + ";\n";
        if (!Properties.TARGET_CLASS.equals("Test"))
            imports += "import org.junit.Test;\n";
        imports += "import static org.junit.Assert.*;\n";

        imports += "import org.openjdk.jmh.annotations.*;\n" +
                    "import org.openjdk.jmh.runner.RunnerException;\n";
        return imports;
    }

    @Override
    public String getClassDefinition(String testName) {
        return "public class " + testName;
    }

    private String getJUnitTestShortName() {
        if (Properties.ECLIPSE_PLUGIN) {
            String res = "";
            if (Properties.TARGET_CLASS.equals("EvoSuiteTest"))
                res = org.evosuite.annotations.EvoSuiteTest.class.getName();
            else
                res = "EvoSuiteTest";
            res += " (checked = false)";
            return res;
        } else {
            if (Properties.TARGET_CLASS.equals("Test"))
                return "org.junit.Test";
            else
                return "Test";
        }
    }

    @Override
    public String getMethodDefinition(String testName) {
        StringBuilder builder = new StringBuilder();
        builder.append("    @Benchmark");
        builder.append("\n");
        builder.append("  @" + getJUnitTestShortName());
        //TODO remove once JUnit is fixed. See comments in Scaffolding regarding Timeout rule
        builder.append("(timeout = " + (Properties.TIMEOUT + 1000) + ")");
        builder.append("\n");
        builder.append("    public void " + testName + "() ");
        return builder.toString();
    }

    @Override
    public String getSuite(List<String> suites) {
        StringBuilder builder = new StringBuilder();
        builder.append("import org.junit.runner.RunWith;\n");
        builder.append("import org.junit.runners.Suite;\n\n");

        for (String suite : suites) {
            if (suite.contains(".")) {
                builder.append("import ");
                builder.append(suite);
                builder.append(";\n");
            }
        }
        builder.append("\n");

        builder.append("@RunWith(Suite.class)\n");
        builder.append("@Suite.SuiteClasses({\n");
        boolean first = true;
        for (String suite : suites) {
            if (!first) {
                builder.append(",\n");
            }
            first = false;
            builder.append("  ");
            builder.append(suite.substring(suite.lastIndexOf(".") + 1));
            builder.append(".class");
        }
        builder.append("})\n");

        builder.append(getClassDefinition("GeneratedTestSuite"));
        builder.append(" {\n");
        builder.append("}\n");
        return builder.toString();
    }

    @Override
    public String getTestString(int id, TestCase test, Map<Integer, Throwable> exceptions) {
        return test.toCode(exceptions);
    }

    @Override
    public String getTestString(int id, TestCase test, Map<Integer, Throwable> exceptions, TestCodeVisitor visitor) {
        visitor.setExceptions(exceptions);
        test.accept(visitor);
        visitor.clearExceptions();
        return visitor.getCode();
    }

    @Override
    public void addNFR(StringBuilder builder) {
        builder.append(TestSuiteWriterUtils.METHOD_SPACE);
        builder.append("@").append(org.junit.Rule.class.getCanonicalName()).append("\n");
        builder.append(TestSuiteWriterUtils.METHOD_SPACE);
        builder.append("public ").append(NonFunctionalRequirementRule.class.getName()).append(" nfr = new ").append(NonFunctionalRequirementRule.class.getName()).append("();\n\n");
    }

    @Override
    public Class<?> testAnnotation() {
        return Benchmark.class;
    }

    @Override
    public Class<?> beforeAll() {
        return org.junit.BeforeClass.class;
    }

    @Override
    public Class<?> beforeEach() {
        return org.junit.Before.class;
    }

    @Override
    public Class<?> afterAll() {
        return org.junit.AfterClass.class;
    }

    @Override
    public Class<?> afterEach() {
        return org.junit.After.class;
    }
}
