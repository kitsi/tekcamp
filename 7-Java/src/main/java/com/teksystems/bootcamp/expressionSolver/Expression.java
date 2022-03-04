package com.teksystems.bootcamp.expressionSolver;

public class Expression extends Term{
    private Term term1;
    private Term term2;
    private Operation operation;

    public Expression(Term term1, Term term2, Operation operation) {
        this.term1 = term1;
        this.term2 = term2;
        this.operation = operation;
    }
}
