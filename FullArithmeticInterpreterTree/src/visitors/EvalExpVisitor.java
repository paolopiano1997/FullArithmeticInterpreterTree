package visitors;

import nodes.DivExp;
import nodes.MinusExp;
import nodes.MultExp;
import nodes.NumExp;
import nodes.PlusExp;
import nodes.PotExp;

public class EvalExpVisitor implements ExpVisitor{
	private int value;
	
	public int getResult() {
		return value;
	}

	@Override
	public void visit(MultExp e) {
		e.getLeft().accept(this);
		int arg1=getResult();
		e.getRight().accept(this);
		int arg2=getResult();
		value=arg1*arg2;
	}

	@Override
	public void visit(DivExp e) {
		e.getLeft().accept(this);
		int arg1=getResult();
		e.getRight().accept(this);
		int arg2=getResult();
		value=arg1/arg2;
	}

	@Override
	public void visit(PlusExp e) {
		e.getLeft().accept(this);
		int arg1=getResult();
		e.getRight().accept(this);
		int arg2=getResult();
		value=arg1+arg2;
	}

	@Override
	public void visit(MinusExp e) {
		e.getLeft().accept(this);
		int arg1=getResult();
		e.getRight().accept(this);
		int arg2=getResult();
		value=arg1-arg2;
	}

	@Override
	public void visit(PotExp e) {
		e.getLeft().accept(this);
		int arg1=getResult();
		e.getRight().accept(this);
		int arg2=getResult();
		value=(int)Math.pow(arg1, arg2);
	}

	@Override
	public void visit(NumExp e) {
		value=e.getValue();
	}
	
}
