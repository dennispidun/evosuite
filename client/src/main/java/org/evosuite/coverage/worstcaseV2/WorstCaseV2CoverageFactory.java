package org.evosuite.coverage.worstcaseV2;

import org.evosuite.TestGenerationContext;
import org.evosuite.coverage.TestFitnessFactory;
import org.evosuite.coverage.branch.BranchPool;
import org.evosuite.instrumentation.LinePool;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testsuite.AbstractFitnessFactory;

import java.util.*;

public class WorstCaseV2CoverageFactory extends AbstractFitnessFactory<TestFitnessFunction> {

    @Override
    public List<TestFitnessFunction> getCoverageGoals() {
        List<TestFitnessFunction> goals = new ArrayList<>();

        long start = System.currentTimeMillis();

        BranchPool branchPool = BranchPool.getInstance(TestGenerationContext.getInstance().getClassLoaderForSUT());
        for (String className : branchPool.knownClasses()) {
            // Only lines in CUT
            if (!isCUT(className))
                continue;

            /*
                TODO: calculate complexity (how many branches) for every method in the class and
                 pick thos classes which have significantly higher complexity
             */
        }
        goalComputationTime = System.currentTimeMillis() - start;
        return goals;
    }
}
