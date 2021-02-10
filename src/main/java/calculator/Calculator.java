package calculator;

import visitor.Evaluator;

public class Calculator {

    /*
     For the moment the calculator only contains a print method and an eval method
     It would be useful to complete this with a read method, so that we would be able
     to implement a full REPL cycle (Read-Eval-Print loop) such as in Scheme, Python, R and other languages.
     To do so would require to implement a method with the following signature, converting an input string
     into an arithmetic expression:
     public Expression read(String s)
    */

    public void print(Expression e, Notation n) throws OperationException {
        int res = eval(e);
        System.out.println("The result of evaluating expression " + e.toString(n));
        System.out.println("is: " + res + ".");
        System.out.println();
    }

    public void print(Expression e) throws OperationException {
        print(e, Notation.INFIX);
    }

    public void printExpressionDetails(Expression e, Notation n) throws OperationException {
        print(e, n);
        System.out.print("It contains " + e.countDepth() + " levels of nested expressions, ");
        System.out.print(e.countOps() + " operations");
        System.out.println(" and " + e.countNbs() + " numbers.");
        System.out.println();
    }

    public void printExpressionDetails(Expression e) throws OperationException {
        printExpressionDetails(e, Notation.INFIX);
    }

    public int eval(Expression e) throws OperationException {
        // create a new visitor to evaluate expressions
        Evaluator v = new Evaluator();
        // and ask the expression to accept this visitor to start the evaluation process
        e.accept(v);
        // and return the result of the evaluation at the end of the process
        return v.getResult();
    }

    /*
     We could also have other methods, e.g. to verify whether an expression is syntactically correct
     public Boolean validate(Expression e)
     or to simplify some expression
     public Expression simplify(Expression e)
    */
}
