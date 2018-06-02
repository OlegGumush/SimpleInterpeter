package Parser;

import StringToSexpr.ListSexpr;
import StringToSexpr.NumberExpr;
import StringToSexpr.Sexpr;
import StringToSexpr.SymbolSexpr;

public class ParseFlang {
		
	public static Flang sExprToFlang(Sexpr expr) {
		
		if(expr instanceof NumberExpr){
			return new Num(((NumberExpr) expr).getX());
		}
		else if(expr instanceof SymbolSexpr) {
			return new Id(((SymbolSexpr) expr).getS());
		}
		else if (expr instanceof ListSexpr){
			
			String firstWord = ((SymbolSexpr)((ListSexpr) expr).getElementAt(0)).getS();
			
			if (firstWord.equals("+") || firstWord.equals("-") || firstWord.equals("/") || firstWord.equals("*")) {
				
				return buildOperator(firstWord , expr);
			}
			else if(firstWord.equals("with")){				
				
				return buildWith(firstWord , expr);
			}
			else if (firstWord.equals("call")){
				
				return buildCall(firstWord , expr);
			}
			else if(firstWord.equals("fun")){
				
				return buildFun(firstWord , expr);
			}
			else if (firstWord.equals("for")){			
			
				return buildFor(firstWord , expr);
			}
		}
		
		return null;
	}

	private static Flang buildFor(String firstWord, Sexpr expr) {
		
		String id ;
		Flang cond ;
		Flang then ;
		Flang elseThen ;
		
		Sexpr listId = ((ListSexpr) expr).getElementAt(2);
		if (listId instanceof ListSexpr){
			Sexpr exprId = ((ListSexpr) listId).getElementAt(0);
			if(exprId instanceof SymbolSexpr){
				id = ((SymbolSexpr) exprId).getS();
			}
		}
		
		return null;
	}

	private static Flang buildFun(String firstWord, Sexpr expr) {
		String id = "";
		Sexpr nameList = ((ListSexpr) expr).getElementAt(1);
		Sexpr body = ((ListSexpr) expr).getElementAt(2);
		
		if(nameList instanceof ListSexpr){
			Sexpr sexprId = ((ListSexpr) nameList).getElementAt(0);
			if (sexprId instanceof SymbolSexpr){
				id = ((SymbolSexpr) sexprId).getS();
			}
		}
		else {
			System.out.println("Bad fun syntax");
		}
		
		return new Fun(id , sExprToFlang(body));
	}

	private static Flang buildCall(String firstWord, Sexpr expr) {
		Sexpr fun = ((ListSexpr) expr).getElementAt(1);
		Sexpr args = ((ListSexpr) expr).getElementAt(2);

		return new Call(sExprToFlang(fun), sExprToFlang(args));
	}

	private static Flang buildWith(String firstWord, Sexpr expr) {
		String name = "";
		Sexpr named = null;
		
		Sexpr nameAndNamedList = ((ListSexpr) expr).getElementAt(1);
		
		if(nameAndNamedList instanceof ListSexpr){
			Sexpr sexpName = ((ListSexpr) nameAndNamedList).getElementAt(0);
			named = ((ListSexpr) nameAndNamedList).getElementAt(1);
			
			if(sexpName instanceof SymbolSexpr){
				name = ((SymbolSexpr) sexpName).getS();
			}
			else {
				System.out.println("Bad with syntax");
			}
		}
		else {
			System.out.println("Bad with syntax");
		}
		
		Sexpr body = ((ListSexpr) expr).getElementAt(2);
		
		return new With(name , sExprToFlang(named), sExprToFlang(body));
	}

	private static Flang buildOperator(String firstWord, Sexpr expr) {
		
		Flang left = sExprToFlang(((ListSexpr) expr).getElementAt(1));
		Flang right = sExprToFlang(((ListSexpr) expr).getElementAt(2));
		
		if (firstWord.equals("+")){
			return new Add(left ,right);
		}
		else if(firstWord.equals("-")){
			return new Sub(left ,right);
		}
		else if(firstWord.equals("*")){
			return new Mult(left ,right);
		}
		else if (firstWord.equals("/")){
			return new Div(left ,right);
		}
		else {
			System.out.println("Bad syntax");
			return null;
		}	
	}
}