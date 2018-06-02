package _Main;

import Eval.Eval;
import Parser.Flang;
import Parser.Num;
import Parser.ParseFlang;
import StringToSexpr.Sexpr;
import StringToSexpr.StringToSexpr;

class Main {
	
	public static void main(String[] args) {
		
		String s= "{with {x 6} {* {+ 5 6} x}}";
		System.out.println(run(s));
		
		String s1= "{call {fun {x} {* x x}} 6}";
		System.out.println(run(s1));
		
		String s2= "{call {fun {x} {* {with {y 7} {+ y y}} x}} 1}";
		System.out.println(run(s2));
		
		String s3= "{call {with {x 8} {fun {y} {* x y}}} 5}";
		System.out.println(run(s3));
	}
	
	public static int run(String s ){
	
		Sexpr afterParse = StringToSexpr.StringToSexpr(s);
		Flang flang = ParseFlang.sExprToFlang(afterParse);
		try {
			Flang number = Eval.eval(flang);
			
			if (number instanceof Num){
				return ((Num) number).getNum();
			}
			else {
				throw new Exception("eval return not a number");
			}
			
		} catch (Exception e) {
			System.out.println("free indentifaer");
			e.printStackTrace();
		}
		return -1;
	}
}