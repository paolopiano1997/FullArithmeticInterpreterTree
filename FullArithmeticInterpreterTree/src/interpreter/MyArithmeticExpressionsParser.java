
package interpreter;

import nodes.*;
import util.EmptyLineException;
import util.MyScanner;
import util.MyToken;

public class MyArithmeticExpressionsParser {
	private MyScanner scanner;
	private MyToken currentToken;
	
	private int count = 0;
	
	
	/**
	 * Constructs an interpreter that interprets arithmetic expressions
	 * @param scanner Support scanner to create Token
	 */
	public MyArithmeticExpressionsParser(MyScanner scanner) {
		this.scanner=scanner;
		currentToken = scanner.getNextToken();
	}
	
	
	/**
	 * Returns the evaluation of the arithmetic expression contained in the scanner
	 * @return Evaluation of the arithmetic expression
	 * @throws EmptyLineException Represents an empty line
	 */
	public Exp parseExp() throws EmptyLineException {
		System.out.println("LEVEL 4 - EXP: Invoco level 3 - TERM, currentToken="+ currentToken);
		Exp t1 = parseTerm();
		while(currentToken!=null) {
			if(currentToken.equals("+") || currentToken.equals("-")) {
				String op=currentToken.toString();
				System.out.println("LEVEL 4 - EXP: Current token '" + currentToken +"'");
				currentToken = scanner.getNextToken();
				Exp t2 = parseTerm();
				if(t2!=null)
					t1 = getOpExp(t1,t2,op);
				else return null;
			}
			else return t1;
		}
		return t1;
	}
	
	
	private Exp parseTerm() throws EmptyLineException  {
		System.out.println("LEVEL 3 - TERM: Invoco level 2 - POT, currentToken="+ currentToken);
		Exp p1 = parsePot();
		while(currentToken!=null) {
			if(currentToken.equals("*") || currentToken.equals(":")) {
				String op=currentToken.toString();
				System.out.println("LEVEL 3 - TERM: Current token '" + currentToken + "'");
				currentToken = scanner.getNextToken();
				Exp p2 = parsePot();
				if(p2!=null)
					p1 = getOpExp(p1,p2,op);
				else return null;
			}
			else return p1;
		}
		return p1;
	}

	private Exp parsePot() throws EmptyLineException {
		System.out.println("LEVEL 2 - POT, currentToken="+ currentToken);
		Exp f1 = parseFactor();
		if(currentToken!=null && currentToken.equals("^")) {
				String op=currentToken.toString();
				System.out.println("LEVEL 2 - POT: Current token '" + currentToken +"'");
				currentToken = scanner.getNextToken();
				Exp p2=parsePot();
				if(p2!=null)
					f1 = getOpExp(f1,p2,op);
				else return null;
		}
		else return f1;
		return f1;
	}

	private Exp getOpExp(Exp l, Exp r, String op) {
		if(op.equals("+"))
			return new PlusExp(l,r);
		else if(op.equals("-"))
			return new MinusExp(l,r);
		else if(op.equals(":"))
			return new DivExp(l,r);
		else if(op.equals("*"))
			return new MultExp(l,r);
		else if(op.equals("^"))
			return new PotExp(l,r);
		else throw new IllegalArgumentException("OpExp");
	}


	private Exp parseFactor() throws EmptyLineException {
		if(currentToken!=null && currentToken.equals("(")) {
			System.out.println("LEVEL 1 - FACTOR: Current token '('");
			currentToken=scanner.getNextToken();
			System.out.println("LEVEL 1 - FACTOR: Chiamo Level 3 - EXP");
			Exp innerExp = parseExp();
			if(currentToken!=null && currentToken.equals(")")) {
				System.out.println("LEVEL 1 - FACTOR: Current token ')'");
				currentToken = scanner.getNextToken();
				return innerExp;
			}
			else throw new IllegalArgumentException("Missing ')'");
		}
		else if(currentToken!=null && currentToken.isNumber()){
			System.out.println("LEVEL 1 - FACTOR: Current token number: " + currentToken);
			int value = currentToken.getAsInt();
			currentToken=scanner.getNextToken();
			return new NumExp(value);
		}
		else if(count==0)
			throw new EmptyLineException();
		else throw new IllegalArgumentException(currentToken != null ? ("Unexpected '" + currentToken +"' at token n° " + (count+1)) : ("Missing token after token n° " + count));
	}

}
