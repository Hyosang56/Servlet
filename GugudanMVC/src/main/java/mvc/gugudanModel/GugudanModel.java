package mvc.gugudanModel;

public class GugudanModel {
	public String GetResult(String gu) {
		String result = "";
		int guNum = Integer.parseInt(gu);
		
		for (int i=1; i<10; i++) {
			result +=guNum +" * "+i+" = "+
					(guNum*i)+"<br>";
		}
		return result;
	}

}
