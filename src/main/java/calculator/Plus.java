package calculator;

import java.util.List;

final public class Plus extends Operation
{

  public /*constructor*/ Plus(List<Expression> elist) throws IllegalConstruction {
	super(elist);
	symbol = "+";
	neutral = 0;
	}

  public int op(int l, int r) throws OperationException {
  	return (l+r);
  }
}
