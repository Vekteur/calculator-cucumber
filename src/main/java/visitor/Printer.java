package visitor;

import calculator.*;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Printer extends Visitor{

    private String computedValue;
    private Notation notation;

    public Printer(Notation notation) {
        this.notation = notation;
    }


    @Override
    public void visit(MyNumber n) {
        this.computedValue = n.toString();
    }

    @Override
    public void visit(Operation o) throws OperationException {
        ArrayList<String> evaluatedArgs = new ArrayList<>();
        //first loop to recursively evaluate each subexpression
        for(Expression a:o.args) {
            a.accept(this);
            evaluatedArgs.add(computedValue);
        }

        Stream<String> s = evaluatedArgs.stream();
        switch (this.notation) {
            case INFIX: computedValue = "( " +
                    s.reduce((s1,s2) -> s1 + " " + o.getSymbol() + " " + s2).get() +
                    " )";
                    break;
            case PREFIX: computedValue = o.getSymbol() + " " +
                    "(" +
                    s.reduce((s1,s2) -> s1 + ", " + s2).get() +
                    ")";
                    break;
            case POSTFIX: computedValue = "(" +
                    s.reduce((s1,s2) -> s1 + ", " + s2).get() +
                    ")" +
                    " " + o.getSymbol();
                    break;
            default: computedValue = "This case should never occur.";
        }

    }

    public String getResult(){
        return this.computedValue;
    }
}
