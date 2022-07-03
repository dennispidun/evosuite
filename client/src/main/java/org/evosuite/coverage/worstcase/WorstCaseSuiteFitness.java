package org.evosuite.coverage.worstcase;

import org.evosuite.testcase.execution.ExecutionResult;
import org.evosuite.testsuite.TestSuiteChromosome;
import org.evosuite.testsuite.TestSuiteFitnessFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorstCaseSuiteFitness extends TestSuiteFitnessFunction {
    private final List<WorstCaseCoverageTestFitness> allWorstCases = new ArrayList<>();

    public WorstCaseSuiteFitness() {
        allWorstCases.addAll(new WorstCaseCoverageFactory().getCoverageGoals());
    }

    @Override
    public double getFitness(TestSuiteChromosome suite) {
        double fitness = 0.0;
        List<ExecutionResult> executionResults = runTestSuite(suite);
        Set<WorstCaseCoverageTestFitness> coveredWorstCases = new HashSet<>();
        for(WorstCaseCoverageTestFitness goal : allWorstCases) {
            for(ExecutionResult result : executionResults) {
                if(goal.isCovered(result)) {
                    coveredWorstCases.add(goal);
                    break;
                }
            }
        }
        fitness = allWorstCases.size() - coveredWorstCases.size();

        suite.setNumOfCoveredGoals(this, coveredWorstCases.size());
        if (!allWorstCases.isEmpty())
            suite.setCoverage(this, (double) (allWorstCases.size() - coveredWorstCases.size()) / (double) allWorstCases.size());
        else
            suite.setCoverage(this, 1.0);
        updateIndividual(suite, fitness);
        return fitness;
    }
}
