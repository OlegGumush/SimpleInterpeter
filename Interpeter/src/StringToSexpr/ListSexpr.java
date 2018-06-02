package StringToSexpr;

import java.util.ArrayList;

public class ListSexpr implements Sexpr {

	ArrayList<Sexpr> list = new ArrayList<>();
	
	public void add(Sexpr expr){
		list.add(expr);
	}

	@Override
	public String toString() {
		return list.toString();
	}

	public ArrayList<Sexpr> getList() {
		return list;
	}

	public void setList(ArrayList<Sexpr> list) {
		this.list = list;
	}
	
	public Sexpr getElementAt(int index){
		return list.get(index);
	}
	
	
}
