package Parser;

public class Call implements Flang {
	
	Flang fun ;
	Flang args ;
	
	
	public Call(Flang fun , Flang args ){
		this.fun = fun;
		this.args = args;
	}


	public Flang getFun() {
		return fun;
	}


	public void setFun(Flang fun) {
		this.fun = fun;
	}


	public Flang getArgs() {
		return args;
	}


	public void setArgs(Flang args) {
		this.args = args;
	}
	
	
}
