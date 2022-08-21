package org.evosuite.coverage.worstcaseV1;

import org.evosuite.testcase.TestChromosome;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testcase.execution.ExecutionResult;
import org.evosuite.testsuite.TestSuiteChromosome;
import org.evosuite.testsuite.TestSuiteFitnessFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Fitness function for a whole test suite for all methods
 */
public class WorstCaseCoverageSuiteFitness extends TestSuiteFitnessFunction {
    private final List<TestFitnessFunction> goals = new ArrayList<>();

    public WorstCaseCoverageSuiteFitness() {
        goals.addAll(new SimpleWorstCaseCoverageFactory().getCoverageGoals());
    }

    @Override
    public double getFitness(TestSuiteChromosome suite) {
        double fitness;
        // run test suite and gather execution results
        List<ExecutionResult> executionResults = runTestSuite(suite);

        // check if the generated test suites satisfies our defined goals
        Set<TestFitnessFunction> coveredWorstCases = new HashSet<>();
        for(TestFitnessFunction goal : goals) {
            for(ExecutionResult result : executionResults) {
                TestChromosome chromosome = new TestChromosome();
                chromosome.setTestCase(result.test);
                chromosome.setLastExecutionResult(result);
                chromosome.setChanged(false);
                // a goal is covered if it reaches 0 as its fitness value
                if(goal.getFitness(chromosome, result) == 0.0) {
                    coveredWorstCases.add(goal);
                    break;
                }
            }
        }
        // whole test suite fitness is defined as a goal coverage value
        fitness = goals.size() - coveredWorstCases.size();

        // set coverage data
        if (!goals.isEmpty())
            suite.setCoverage(this, (double) coveredWorstCases.size() / (double) goals.size());
        else
            suite.setCoverage(this, 1.0);
        System.out.println("this.getCov2: " + suite.getCoverage());

        suite.setNumOfCoveredGoals(this, coveredWorstCases.size());
        suite.setNumOfNotCoveredGoals(this, goals.size() - coveredWorstCases.size());

        updateIndividual(suite, fitness);
        return fitness;
    }

}
