package org.evosuite.coverage.worstcaseV1;

import org.evosuite.testcase.TestFitnessFunction;
import org.objectweb.asm.Type;
import org.evosuite.Properties;
import org.evosuite.setup.TestUsageChecker;
import org.evosuite.testsuite.AbstractFitnessFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The WorstCaseCoverageFactory is responsible for creating goals.
 * This version creates the goals based on its methods and defines
 * exactly one goal per method for the class under test.
 */
public class SimpleWorstCaseCoverageFactory extends AbstractFitnessFactory<TestFitnessFunction> {

    @Override
    public List<TestFitnessFunction> getCoverageGoals() {
        List<TestFitnessFunction> goals = new ArrayList<>();
        String className = Properties.TARGET_CLASS;
        Class<?> clazz = Properties.getTargetClassAndDontInitialise();

        Set<String> methods = getUsableMethods(clazz);

        for(String method : methods) {
            goals.add(new WorstCaseCoverageTestFitness(className, method));
        }

        return goals;
    }

    protected Set<String> getUsableMethods(Class<?> clazz) {
        Set<String> methods = new LinkedHashSet<>();
        Method[] allMethods= clazz.getDeclaredMethods();
        for (Method m : allMethods) {
            if (TestUsageChecker.canUse(m)) {
                String methodName = m.getName()+ Type.getMethodDescriptor(m);
                methods.add(methodName);
            }
        }
        return methods;
    }
}
