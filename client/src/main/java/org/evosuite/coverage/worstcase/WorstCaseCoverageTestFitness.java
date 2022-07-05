package org.evosuite.coverage.worstcase;

import org.evosuite.Properties;
import org.evosuite.testcase.TestChromosome;
import org.evosuite.testcase.TestFitnessFunction;
import org.evosuite.testcase.execution.ExecutionResult;
import org.evosuite.testcase.statements.ConstructorStatement;
import org.evosuite.testcase.statements.EntityWithParametersStatement;
import org.evosuite.testcase.statements.MethodStatement;
import org.evosuite.testcase.statements.Statement;

import java.util.Objects;
import java.util.Set;

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
        double fitness = 1.0;

        long time = Math.abs(10 - result.getExecutionTime());
        if (result.hasTimeout()) {
            time = Properties.TIMEOUT;
        }
        double timeFitness = (double) time / (double) 10;

        int hasSeenMethodCall = 0;
        Set<Integer> exceptionPositions = result.getPositionsWhereExceptionsWereThrown();
        for(Statement stmt : result.test){
            if(stmt instanceof MethodStatement){
                EntityWithParametersStatement ps = (EntityWithParametersStatement) stmt;
                String className = ps.getDeclaringClassName();
                String methodName = ps.getMethodName() + ps.getDescriptor();
                if(this.className.equals(className) && this.methodName.equals(methodName)){
                    hasSeenMethodCall += 1;
                }
            }
            if(exceptionPositions.contains(stmt.getPosition())){
                break;
            }
        }

        double methodCallFitness = hasSeenMethodCall == 1 ? 0.0 : 1.0;

        fitness = (timeFitness * 0.5 + methodCallFitness * 0.5);

        int testSize = result.test.size();
        return fitness;
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
