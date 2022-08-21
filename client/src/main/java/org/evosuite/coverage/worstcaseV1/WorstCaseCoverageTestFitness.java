package org.evosuite.coverage.worstcaseV1;

import org.evosuite.testcase.TestChromosome;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testcase.execution.ExecutionResult;
import org.evosuite.testcase.statements.EntityWithParametersStatement;
import org.evosuite.testcase.statements.MethodStatement;
import org.evosuite.testcase.statements.Statement;

import java.util.Objects;
import java.util.Set;

/**
 * Fitness function for a single test on a single method
 */
public class WorstCaseCoverageTestFitness extends TestFitnessFunction {

    private final String className;
    private final String methodName;

    // 50ms as a hard coded limit to find complex test cases
    private static long CURRENT_MAX_EXECUTION_TIME = 50;
    private static double CURRENT_MAX_TIME_PMC = 0.0;

    public WorstCaseCoverageTestFitness(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    @Override
    public double getFitness(TestChromosome individual, ExecutionResult result) {
        double fitness = 0;


        // count how often we see our desired methodName
        int methodCalls = 0;
        Set<Integer> exceptionPositions = result.getPositionsWhereExceptionsWereThrown();
        for(Statement stmt : result.test){
            if(stmt instanceof MethodStatement){
                EntityWithParametersStatement ps = (EntityWithParametersStatement) stmt;
                String className = ps.getDeclaringClassName();
                String methodName = ps.getMethodName() + ps.getDescriptor();
                if(this.className.equals(className) && this.methodName.equals(methodName)){
                    methodCalls += 1;
                }
            }
            if(exceptionPositions.contains(stmt.getPosition())){
                break;
            }
        }

        // calculate time per method call
        double timePerMethodCall = methodCalls == 0 ? 0 : Math.round(result.getExecutionTime() / (double) methodCalls);

        // calculate a method call fitness to prefer less calls to the method
        double methodCallFitness = methodCalls >= 1 ? normalize((methodCalls-1)*0.25) : 1.0;

        // calculate a testSizeFitness which basically also prefers smaller test cases
        int testSize = result.test.size();
        double testSizeFitness = 1.0;
        if (testSize <= 10) {
            testSizeFitness = testSize * (-0.1) + 1;
        } else if (testSize <= 20) {
            testSizeFitness = 0;
        } else if (testSize <= 60) {
            testSizeFitness = testSize * 0.025 - 0.5;
        }

        // get everything together and have a weighted total fitness
        fitness = normalize(Math.max(CURRENT_MAX_EXECUTION_TIME - result.getExecutionTime(), 0)) * 0.3
                + normalize(Math.max(CURRENT_MAX_TIME_PMC - timePerMethodCall, 0)) * 0.3
                + testSizeFitness * 0.2
                + methodCallFitness * 0.2;

        // overwrite known maxExecTime and timePerMethodCall if one of them is bigger than the old one
        // this makes sure, that for a new generation, we can focus on slower tests
        if (result.getExecutionTime() > CURRENT_MAX_EXECUTION_TIME || timePerMethodCall > CURRENT_MAX_TIME_PMC) {
            CURRENT_MAX_EXECUTION_TIME = result.getExecutionTime();
            CURRENT_MAX_TIME_PMC = timePerMethodCall;
        }

        if (fitness == 0.0) {
            individual.getTestCase().addCoveredGoal(this);
        }

        return fitness;
    }

    // tried to write maximizationFitnessFunctions, but without any luck, seems to not work.
    @Override
    public boolean isMaximizationFunction() {
        return false;
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
