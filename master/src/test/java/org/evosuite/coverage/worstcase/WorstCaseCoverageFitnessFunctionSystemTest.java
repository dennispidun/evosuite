package org.evosuite.coverage.worstcase;

import com.examples.with.different.packagename.ForParamMethod;
import com.examples.with.different.packagename.HighConstant;
import org.evosuite.EvoSuite;
import org.evosuite.Properties;
import org.evosuite.SystemTestBase;
import org.evosuite.ga.metaheuristics.GeneticAlgorithm;
import org.evosuite.strategy.TestGenerationStrategy;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testsuite.TestSuiteChromosome;
import org.junit.Assert;
import org.junit.Test;

public class WorstCaseCoverageFitnessFunctionSystemTest extends SystemTestBase {

    @Test
    public void name() {
        EvoSuite evosuite = new EvoSuite();

        String targetClass = HighConstant.class.getCanonicalName();
        Properties.TARGET_CLASS = targetClass;
        Properties.CRITERION = new Properties.Criterion[]{
                Properties.Criterion.WORSTCASE
        };

        String[] command = new String[] { "-generateSuite", "-class", targetClass, "-Dalgorithm", "MONOTONIC_GA"};
        Object result = evosuite.parseCommandLine(command);
        GeneticAlgorithm<?> ga = getGAFromResult(result);
        TestSuiteChromosome best = (TestSuiteChromosome) ga.getBestIndividual();

        System.out.println("EvolvedTestSuite:\n" + best);
        for(TestFitnessFunction goal : TestGenerationStrategy.getFitnessFactories().get(0).getCoverageGoals()) {
            System.out.println("Goal: "+goal);
        }
        int goals = TestGenerationStrategy.getFitnessFactories().get(0).getCoverageGoals().size(); // assuming single fitness function
        Assert.assertEquals(2, goals );
        Assert.assertEquals("Non-optimal coverage: ", 1d, best.getCoverage(), 0.001);
    }
}