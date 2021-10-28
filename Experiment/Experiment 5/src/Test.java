
public class Test {

	public static void main(String[] args) {
		Chef chef = new Chef();
		Chicken chicken = new Chicken(chef);
		MuttonString mutton = new MuttonString(chef);
		Customer Wis = new Customer(chicken, mutton);
		
		Wis.chicken();
		Wis.mutton();
	}

}
