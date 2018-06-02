package Parser;

public class With implements Flang{

	String name =  "";
	Flang named ;
	Flang body ;
	
	public With(String name , Flang named , Flang body ){
		
		this.name = name ;
		this.named = named ;
		this.body = body ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Flang getNamed() {
		return named;
	}

	public void setNamed(Flang named) {
		this.named = named;
	}

	public Flang getBody() {
		return body;
	}

	public void setBody(Flang body) {
		this.body = body;
	}
	
	
	
}
