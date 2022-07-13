package org.evosuite.coverage.worstcase;

import com.examples.with.different.packagename.ForParamMethod;
import org.evosuite.EvoSuite;
import org.evosuite.Properties;
import org.evosuite.SystemTestBase;
import org.evosuite.ga.metaheuristics.GeneticAlgorithm;
import org.evosuite.runtime.RuntimeSettings;
import org.evosuite.strategy.TestGenerationStrategy;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testsuite.TestSuiteChromosome;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorstCaseCoverageFitnessFunctionSystemTest extends SystemTestBase {

    @Test
    public void name() {
        EvoSuite evosuite = new EvoSuite();

        String targetClass = ForParamMethod.class.getCanonicalName();
        Properties.TARGET_CLASS = targetClass;
        Properties.CRITERION = new Properties.Criterion[]{
                Properties.Criterion.WORSTCASE
        };

        RuntimeSettings.maxNumberOfIterationsPerLoop = 100_000;

        String[] command = new String[] { "-generateSuite", "-class", targetClass, "-Dalgorithm", "MONOTONIC_GA"};
        Object result = evosuite.parseCommandLine(command);
        GeneticAlgorithm<?> ga = getGAFromResult(result);
        TestSuiteChromosome best = (TestSuiteChromosome) ga.getBestIndividual();

        System.out.println("EvolvedTestSuite:\n" + best);
        for(TestFitnessFunction goal : TestGenerationStrategy.getFitnessFactories().get(0).getCoverageGoals()) {
            System.out.println("Goal: "+goal);
        }
        int goals = TestGenerationStrategy.getFitnessFactories().get(0).getCoverageGoals().size(); // assuming single fitness function
        assertEquals(1, goals );
        assertEquals("Non-optimal coverage: ", 0d, best.getCoverage(), 0.001);
    }

    @Test
    public void name2() {
        long start = System.currentTimeMillis();

        ForParamMethod forParamMethod0 = new ForParamMethod();
        int int0 = forParamMethod0.sum(1378);
        assertEquals(948753, int0);

        long end = System.currentTimeMillis();
        assertEquals(2300, end-start, 230);
    }
}