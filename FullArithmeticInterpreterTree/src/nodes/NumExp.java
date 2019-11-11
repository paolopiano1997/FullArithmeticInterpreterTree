package nodes;

import visitors.ExpVisitor;

public class NumExp implements Exp{
	private int value;
	
	public NumExp(int value) {
		this.value=value;
	}
	
	@Override
	public void accept(ExpVisitor v) {
		v.visit(this);
	}

	
	@Override
	public String toString() {
		return ""+value;
	}
	
	
	public int getValue() {
		return value;
	}
}
