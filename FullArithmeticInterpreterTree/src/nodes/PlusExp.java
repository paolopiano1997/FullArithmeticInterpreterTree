package nodes;

import visitors.ExpVisitor;

public class PlusExp extends OpExp{

	public PlusExp(Exp l, Exp r) {
		super(l, r);
	}

	@Override
	public String myOp() {
		return "+";
	}

	@Override
	public void accept(ExpVisitor v) {
		v.visit(this);
	}

}
