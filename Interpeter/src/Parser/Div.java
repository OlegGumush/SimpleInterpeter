package Parser;

public class Div extends Operator  {
	Flang left;
	Flang right ;
	
	public Div(Flang left , Flang right){
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "Div ["+left + " " +right + "]";
	}
	
}
