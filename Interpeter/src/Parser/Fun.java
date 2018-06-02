package Parser;

public class Fun implements Flang {

	String name ;
	Flang body ;
	
	public Fun (String name , Flang body){
		this.name = name ;
		this.body = body; 
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Flang getBody() {
		return body;
	}

	public void setBody(Flang body) {
		this.body = body;
	}

	
}

