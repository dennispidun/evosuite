package org.evosuite.coverage.worstcase;

import com.examples.with.different.packagename.ForParamMethod;
import org.evosuite.EvoSuite;
import org.evosuite.Properties;
import org.evosuite.SystemTestBase;
import org.evosuite.ga.metaheuristics.GeneticAlgorithm;
import org.evosuite.strategy.TestGenerationStrategy;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testsuite.TestSuiteChromosome;
import org.junit.Test;


public class WorstCaseCoverageFitnessFunctionSystemTest extends SystemTestBase {

    @Test
    public void name() {
        EvoSuite evosuite = new EvoSuite();

        String targetClass = ForParamMethod.class.getCanonicalName();
        Properties.TARGET_CLASS = targetClass;
        //Properties.STRATEGY = Properties.Strategy.ONEBRANCH;

//        Properties.CRITERION = new Properties.Criterion[]{
//                Properties.Criterion.WORSTCASE
//        };
        Properties.OUTPUT_VARIABLES = "TARGET_CLASS,criterion,Coverage,Covered_Goals,Total_Goals";
        Properties.STATISTICS_BACKEND = Properties.StatisticsBackend.CSV;

        String[] command = new String[]{
                "-class", targetClass,
                "-criterion", "WORSTCASE",
                "-generateSuite"
        };

        Object result = evosuite.parseCommandLine(command);
        GeneticAlgorithm<?> ga = getGAFromResult(result);
        TestSuiteChromosome best = (TestSuiteChromosome) ga.getBestIndividual();

        System.out.println("EvolvedTestSuite:\n" + best);
        for(TestFitnessFunction goal : TestGenerationStrategy.getFitnessFactories().get(0).getCoverageGoals()) {
            System.out.println("Goal: "+goal);
        }
    }
}