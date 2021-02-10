package calculator;

import java.util.List;

final public class Minus extends Operation
{

  public /*constructor*/ Minus(List<Expression> elist) throws IllegalConstruction {
	super(elist);
	symbol = "-";
	neutral = 0;
	}
  
  public int op(int l, int r) throws OperationException {
  	return (l-r);
  }
}
