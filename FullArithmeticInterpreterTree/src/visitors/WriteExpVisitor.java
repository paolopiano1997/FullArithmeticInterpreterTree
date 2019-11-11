package visitors;

import nodes.DivExp;
import nodes.MinusExp;
import nodes.MultExp;
import nodes.NumExp;
import nodes.OpExp;
import nodes.PlusExp;
import nodes.PotExp;

public class WriteExpVisitor implements ExpVisitor{
	private String currentExp = "";
	private int level = 0;
	
	public String getResult() {
		return currentExp;
	}
	
	private void visitOpExp(OpExp e){
		e.getLeft().accept(this);
		String left = getResult();
		e.getRight().accept(this);
		String right = getResult();
		currentExp =  "( "  + left + " " + e.myOp() + " " + right +  " )" ;
		level++;
	}
	
	@Override
	public void visit(MultExp e) {
		visitOpExp(e);
		
	}

	@Override
	public void visit(DivExp e) {
		visitOpExp(e);
		
	}

	@Override
	public void visit(PlusExp e) {
		visitOpExp(e);
		
	}

	@Override
	public void visit(MinusExp e) {
		visitOpExp(e);
		
	}

	@Override
	public void visit(PotExp e) {
		visitOpExp(e);
		
	}

	@Override
	public void visit(NumExp e) {
		currentExp= "" + e.getValue();
	}

}
