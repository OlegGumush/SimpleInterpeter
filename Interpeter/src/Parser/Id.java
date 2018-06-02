package Parser;

public class Id  implements Flang {

	String id ;
	
	public Id(String id){
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "[" + id + "]";
	}
	
	
}
