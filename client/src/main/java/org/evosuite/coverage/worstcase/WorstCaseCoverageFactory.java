package org.evosuite.coverage.worstcase;

import org.evosuite.testcase.TestFitnessFunction;
import org.objectweb.asm.Type;
import org.evosuite.Properties;
import org.evosuite.setup.TestUsageChecker;
import org.evosuite.testsuite.AbstractFitnessFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WorstCaseCoverageFactory extends AbstractFitnessFactory<TestFitnessFunction> {

    @Override
    public List<TestFitnessFunction> getCoverageGoals() {
        List<TestFitnessFunction> goals = new ArrayList<>();
        String className = Properties.TARGET_CLASS;
        Class<?> clazz = Properties.getTargetClassAndDontInitialise();

        Set<String> constructors = getUsableConstructors(clazz);
        Set<String> methods = getUsableMethods(clazz);

//        for(String constructor : constructors)
//            goals.add(new WorstCaseCoverageTestFitness(className, constructor));

        for(String method : methods) {
            goals.add(new WorstCaseExecutionTimeCoverageTestFitness(className, method));
        }

        return goals;
    }

    protected Set<String> getUsableConstructors(Class<?> clazz) {
        Set<String> constructors = new LinkedHashSet<>();
        Constructor<?>[] allConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : allConstructors) {
            if (TestUsageChecker.canUse(c)) {
                String methodName = "<init>" + Type.getConstructorDescriptor(c);
                constructors.add(methodName);
            }
        }
        return constructors;
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
