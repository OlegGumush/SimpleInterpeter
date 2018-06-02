package Eval;

import Parser.Add;
import Parser.Call;
import Parser.Div;
import Parser.Flang;
import Parser.Fun;
import Parser.Id;
import Parser.Mult;
import Parser.Num;
import Parser.Sub;
import Parser.With;

public class Eval {

	public static Flang subs(Flang expr , String from , Flang to) {

		if(expr instanceof Num){
			return expr;
		}
		else if(expr instanceof Id){
			if(((Id) expr).getId().equals(from)){
				return to;
			}else {
				return expr;
			}
		}
		else if(expr instanceof Add){
			Flang left =((Add) expr).getLeft();
			Flang right =((Add) expr).getRight();

			return new Add(subs (left , from , to) , subs(right , from , to));
		}
		else if(expr instanceof Sub){
			Flang left =((Sub) expr).getLeft();
			Flang right =((Sub) expr).getRight();

			return new Sub(subs (left , from , to) , subs(right , from , to));
		}
		else if(expr instanceof Mult){
			Flang left =((Mult) expr).getLeft();
			Flang right =((Mult) expr).getRight();

			return new Mult(subs (left , from , to) , subs(right , from , to));	
		}
		else if(expr instanceof Div){
			Flang left =((Div) expr).getLeft();
			Flang right =((Div) expr).getRight();

			return new Div(subs (left , from , to) , subs(right , from , to));
		}
		else if (expr instanceof Fun){
			String funName = ((Fun) expr).getName();
			Flang body = ((Fun) expr).getBody();
			
			if (funName.equals(from)){
				return expr;
			}else {
				return new Fun(funName , subs(body , from , to ));
			}
		}
		else if (expr instanceof With){
			
			//always subs in named
			Flang named = subs(((With) expr).getNamed() , from , to);
			Flang body = ((With) expr).getBody();
			String name = ((With) expr).getName();
			
			if(name.equals(from)){
				return new With(name , named , body);
			}else {
				return new With(name , named , subs(body , from , to));
			}
		}
		else if(expr instanceof Call){
			
			Flang fun = subs(((Call) expr).getFun(),from , to);
			Flang args = subs(((Call) expr).getArgs(),from , to);

			return new Call(fun , args);		
		}

		return null;
	}
	
	

	public static Flang eval(Flang expr) throws Exception{

		if(expr instanceof Num){
			return ((Num) expr);
		}
		else if(expr instanceof Id){
			throw new Exception();
		}
		else if(expr instanceof Add){
			return arithOP('+' , eval(((Add) expr).getLeft()) , eval(((Add) expr).getRight()));
		}
		else if(expr instanceof Sub){
			return arithOP('-' , eval(((Sub) expr).getLeft()) , eval(((Sub) expr).getRight()));
		}
		else if(expr instanceof Mult){
			return arithOP('*' , eval(((Mult) expr).getLeft()) , eval(((Mult) expr).getRight()));
		}
		else if(expr instanceof Div){
			return arithOP('/' , eval(((Div) expr).getLeft()) , eval(((Div) expr).getRight()));
		}
		else if (expr instanceof Fun){
			return expr;
		}
		else if (expr instanceof With){
			return eval( subs (((With) expr).getBody() , ((With) expr).getName() , eval(((With) expr).getNamed()) ));
		}
		else if(expr instanceof Call){
			
			Flang fun = eval(((Call) expr).getFun());
			
			if(fun instanceof Fun){
				Flang args = eval(((Call) expr).getArgs());
				String id = ((Fun) fun).getName();
				Flang body = ((Fun) fun).getBody();
				
				return eval(subs (body  , id , args));
	
			}else {
				throw new Exception("call should get a function");
			}
		}
		return null;
	}


	private static Flang arithOP(char c, Flang left, Flang right) throws Exception {

		if (numToNumber(left) && numToNumber(right) ){

			if(c == '+'){
				return new Num( ((Num)left).getNum() + ((Num)right).getNum() );
			}else if (c == '*'){
				return new Num( ((Num)left).getNum() * ((Num)right).getNum() );
			}else if (c == '-'){
				return new Num( ((Num)left).getNum() - ((Num)right).getNum() );
			}else if (c == '/'){
				return new Num( ((Num)left).getNum() / ((Num)right).getNum() );
			}
		}
		throw new Exception("Function arithOp , expected a number");
	}


	private static boolean numToNumber(Flang expr) {
		
		if(expr instanceof Num){
			return true;
		}
		return false;
	}
}