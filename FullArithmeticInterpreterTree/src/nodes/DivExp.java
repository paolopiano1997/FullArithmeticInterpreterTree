package nodes;

import visitors.ExpVisitor;

public class DivExp extends OpExp{

	public DivExp(Exp l, Exp r) {
		super(l, r);
	}

	@Override
	public String myOp() {
		return ":";
	}

	@Override
	public void accept(ExpVisitor v) {
		v.visit(this);
	}

}
