package Parser;

public class Sub extends Operator  {

	
	public Sub(Flang left , Flang right){
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Sub ["+left + " " +right + "]";
	}

	
	
	
}
