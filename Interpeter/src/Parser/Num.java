package Parser;

public class Num implements Flang  {

	int num;
	
	public Num(int x){
		this.num = x;
	}
	
	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public String toString() {
		return "["+num+"]";
	}
}
