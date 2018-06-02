package Parser;

public class Add extends Operator {

	public Add(Flang left , Flang right){
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Add ["+left + " " +right + "]";
	}
}
