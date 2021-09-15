
public class Test {

	public static void main(String[] args) {
		Stocks aapl = new Stocks("AAPL",100);
		Stocks ibm = new Stocks("IBM",100);
		Holder wis = new Holder("Wis");
		Holder kris = new Holder("Kris");
		
		aapl.regisShareHolder(wis);
		aapl.regisShareHolder(kris);
		aapl.setPrice(98);
		aapl.setPrice(92);
		ibm.regisShareHolder(wis);
		ibm.regisShareHolder(kris);
		ibm.setPrice(98);
		ibm.setPrice(92);

	}

}
