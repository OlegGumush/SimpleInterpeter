package Parser;

public class For {
	
	String id;
	String op;
	Flang cond ;
	Flang then ;
	Flang elseThen ;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public Flang getCond() {
		return cond;
	}
	public void setCond(Flang cond) {
		this.cond = cond;
	}
	public Flang getThen() {
		return then;
	}
	public void setThen(Flang then) {
		this.then = then;
	}
	public Flang getElseThen() {
		return elseThen;
	}
	public void setElseThen(Flang elseThen) {
		this.elseThen = elseThen;
	}
	
	
	
	
	
}
