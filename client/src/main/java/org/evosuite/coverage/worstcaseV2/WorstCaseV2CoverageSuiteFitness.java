package org.evosuite.coverage.worstcaseV2;

import org.evosuite.testcase.TestChromosome;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testcase.execution.ExecutionResult;
import org.evosuite.testsuite.TestSuiteChromosome;
import org.evosuite.testsuite.TestSuiteFitnessFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorstCaseV2CoverageSuiteFitness extends TestSuiteFitnessFunction {
    private final List<TestFitnessFunction> goals = new ArrayList<>();

    public WorstCaseV2CoverageSuiteFitness() {
        goals.addAll(new WorstCaseV2CoverageFactory().getCoverageGoals());
    }

    @Override
    public double getFitness(TestSuiteChromosome suite) {
        double fitness;
        List<ExecutionResult> executionResults = runTestSuite(suite);

        Set<TestFitnessFunction> coveredWorstCases = new HashSet<>();
        for(TestFitnessFunction goal : goals) {
            for(ExecutionResult result : executionResults) {
                TestChromosome chromosome = new TestChromosome();
                chromosome.setTestCase(result.test);
                chromosome.setLastExecutionResult(result);
                chromosome.setChanged(false);
                if(goal.getFitness(chromosome, result) == 0.0) {
                    coveredWorstCases.add(goal);
                    break;
                }
            }
        }
        fitness = goals.size() - coveredWorstCases.size();
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
