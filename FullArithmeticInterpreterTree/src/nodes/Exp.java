package nodes;

import visitors.ExpVisitor;

public interface Exp {
	public abstract void accept(ExpVisitor v);
}
