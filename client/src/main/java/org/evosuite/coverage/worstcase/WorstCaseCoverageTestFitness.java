package org.evosuite.coverage.worstcase;

import org.evosuite.Properties;
import org.evosuite.testcase.TestChromosome;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testcase.execution.ExecutionResult;

import java.util.Objects;

public class WorstCaseCoverageTestFitness extends TestFitnessFunction {

    private final String className;
    private final String methodName;

    public WorstCaseCoverageTestFitness(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }


    /*
        0 => GUT
        1 => SCHLECHT
     */
    @Override
    public double getFitness(TestChromosome individual, ExecutionResult result) {

        long time = Properties.TIMEOUT - result.getExecutionTime() - 100;

        if (result.hasTimeout()) {
            time = Properties.TIMEOUT;
        }

        int testSize = result.test.size();
        return time + testSize; // 0
    }

    @Override
    public int compareTo(TestFitnessFunction other) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorstCaseCoverageTestFitness that = (WorstCaseCoverageTestFitness) o;
        return Objects.equals(className, that.className) && Objects.equals(methodName, that.methodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, methodName);
    }

    @Override
    public String getTargetClass() {
        return this.className;
    }

    @Override
    public String getTargetMethod() {
        return this.methodName;
    }
}
