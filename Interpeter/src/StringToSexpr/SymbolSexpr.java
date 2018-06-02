package StringToSexpr;

public class SymbolSexpr implements Sexpr  {

	String s = "";
	
	public SymbolSexpr(String expr){
		this.s = expr;		
	}

	@Override
	public String toString() {
		return s;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	
	
}
