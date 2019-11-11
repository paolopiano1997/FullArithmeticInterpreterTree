package visitors;

import nodes.*;

public interface ExpVisitor{
	public void visit(MultExp e);
	public void visit(DivExp e);
	public void visit(PlusExp e);
	public void visit(MinusExp e);
	public void visit(PotExp e);
	public void visit(NumExp e);
}
