package StringToSexpr;

public class NumberExpr implements  Sexpr  {

	int x ;
	
	public NumberExpr (String expr){
		
		x = Integer.parseInt(expr);
	}

	@Override
	public String toString() {
		return ""+x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
	
}
