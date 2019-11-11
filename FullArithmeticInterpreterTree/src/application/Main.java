package application;

import interpreter.MyArithmeticExpressionsParser;
import nodes.Exp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.EmptyLineException;
import util.MyScanner;
import util.ScannerWithoutDelimiter;
import visitors.EvalExpVisitor;
import visitors.ExpVisitor;
import visitors.WriteExpVisitor;

public class Main {
	public static void main(String args[]) {
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while((line=br.readLine())!=null) {
				MyScanner scanner = new ScannerWithoutDelimiter(line);
				MyArithmeticExpressionsParser interpreter = new MyArithmeticExpressionsParser(scanner);
				try{
					Exp result = interpreter.parseExp();
					System.out.println("Vecchia println: " + result);
					ExpVisitor v1 = new EvalExpVisitor();
					result.accept(v1);
					System.out.println("Output EvalExp: " + ( (EvalExpVisitor)v1).getResult());
					ExpVisitor v2 = new WriteExpVisitor();
					result.accept(v2);
					System.out.println("Output WriteExp: " + ((WriteExpVisitor)v2).getResult());
				}catch (IllegalArgumentException e) {
					System.out.println("Syntax error: " + e.getMessage());
				}catch(EmptyLineException e){
					System.out.println("Empty line");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
