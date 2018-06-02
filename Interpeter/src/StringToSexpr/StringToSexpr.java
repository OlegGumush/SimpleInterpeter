package StringToSexpr;

public class StringToSexpr {
	
	public static Sexpr StringToSexpr(String expr){
		
		return StringToSexpr(expr , 1 , expr.length());
	}
	/**
	 * 
	 * @param expr sub string
	 * @param start index
	 * @param end index
	 * @return List of Sexpr
	 */
	public static Sexpr StringToSexpr(String expr , int start , int end) {
		
		ListSexpr listSexpr = new ListSexpr();
		
		for (int i = start; i < end; i++) {
			
			//new sub String/List
			if (expr.charAt(i) == '{'){
				try {
					//find end of scope
					int endIndex = findEndOfScope(expr , i);
					listSexpr.add(StringToSexpr(expr , i+1 , endIndex));
					i = endIndex+1;
				} catch (Exception e) {
					System.out.println("Bad expretion");
					e.printStackTrace();
				}				
			}
			else if(expr.charAt(i) != ' ' || expr.charAt(i) != '}' || expr.charAt(i) != '{'){
				try {
					int endIndexOfElement = getEndIndexOfElement(expr , i);
					listSexpr.add(getElement(expr , i , endIndexOfElement));		
					i = endIndexOfElement;
					
				} catch (Exception e) {
					System.out.println("Bad expretion");
					e.printStackTrace();
				}
			}
		}
		return listSexpr;
	}

	/**
	 * 
	 * @param expr string
	 * @param startIndexOfElement 
	 * @param endIndexOfElement
	 * @return Sexpr
	 */
	public static Sexpr getElement(String expr, int startIndexOfElement, int endIndexOfElement) {
		
		String temp = "";
		
		for (int j = startIndexOfElement; j < endIndexOfElement; j++) {
			
			if(expr.charAt(j) != ' '){
				temp += expr.charAt(j);
			}
		}
		
		return parseToSexpr(temp);
	}

	/**
	 * 
	 * @param temp 
	 * @return return String->Sexpr element / List/Number/Symbol
	 */
	public static Sexpr parseToSexpr(String temp) {
		
		int counter =0;
		for (int i = 0; i < temp.length(); i++) {
			if(temp.charAt(i) >= '0' && temp.charAt(i) <= '9'){
				counter ++;
			}
		}
		
		if(counter == temp.length()){
			return new NumberExpr(temp);
		}
		
		return new SymbolSexpr(temp);
	}

	/**
	 * 
	 * @param expr
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public static int getEndIndexOfElement(String expr, int i) throws Exception {
				
		for (int j = i; j < expr.length(); j++) {
			
			if (expr.charAt(j) == ' ' || expr.charAt(j) == '}'  || expr.charAt(j) == '{') {
				return j;
			}
		}
		
		throw new Exception();
	}

	/**
	 * find latest scope of this sub string
	 * @param expr
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public static int findEndOfScope(String expr , int i) throws Exception{
			
		int counter =0 ;
		
		for (int j = i; j < expr.length() ; j++) {
			
			if (expr.charAt(j) == '{') {
				counter ++;
			} 
			if (expr.charAt(j) == '}') {
				counter --;
				
				if (counter ==0){
					return j;
				}
			}
		}
		throw new Exception();
	}
}









