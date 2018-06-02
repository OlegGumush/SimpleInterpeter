package Parser;

public class Mult extends Operator  {
	
	public Mult(Flang left , Flang right){
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "Mult ["+left + " " +right + "]";
	}
}
