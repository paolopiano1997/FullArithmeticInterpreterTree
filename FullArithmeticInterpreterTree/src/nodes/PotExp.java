package nodes;

import visitors.ExpVisitor;

public class PotExp extends OpExp{

	public PotExp(Exp l, Exp r) {
		super(l, r);
	}

	@Override
	public String myOp() {
		return "^";
	}

	@Override
	public void accept(ExpVisitor v) {
		v.visit(this);
	}

}
