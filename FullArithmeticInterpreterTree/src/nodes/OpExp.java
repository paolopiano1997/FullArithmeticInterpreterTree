package nodes;

import visitors.ExpVisitor;

public abstract class OpExp implements Exp{
	private Exp left, right;
	
	
	public OpExp(Exp l,Exp r) {
		this.left=l;
		this.right=r;
	}
	
	public abstract String myOp();
	
	
	@Override
	public String toString() {
		return left.toString() + myOp() + right.toString();
	}
	
	@Override
	public abstract void accept(ExpVisitor v);
	
	
	public Exp getLeft() {
		return left;
	}

	public Exp getRight() {
		return right;
	}
	
	

}
