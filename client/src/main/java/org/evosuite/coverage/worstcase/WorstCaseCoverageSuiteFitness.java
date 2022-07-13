package org.evosuite.coverage.worstcase;

import org.evosuite.testcase.TestChromosome;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testcase.execution.ExecutionResult;
import org.evosuite.testsuite.TestSuiteChromosome;
import org.evosuite.testsuite.TestSuiteFitnessFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorstCaseCoverageSuiteFitness extends TestSuiteFitnessFunction {
    private final List<TestFitnessFunction> goals = new ArrayList<>();

    public WorstCaseCoverageSuiteFitness() {
        goals.addAll(new WorstCaseCoverageFactory().getCoverageGoals());
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
            suite.setCoverage(this, (double) (goals.size() - coveredWorstCases.size()) / (double) goals.size());
        else
            suite.setCoverage(this, 1.0);

        suite.setNumOfCoveredGoals(this, coveredWorstCases.size());

        updateIndividual(suite, fitness);
        return fitness;
    }
}
