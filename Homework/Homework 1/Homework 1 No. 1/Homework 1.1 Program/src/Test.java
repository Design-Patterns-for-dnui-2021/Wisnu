public class Test {

	public static void main(String[] args) {
		Person wis = new Person("Wis");
		Person kris = new Person("Kris");
		
		wis.registerObserver(kris);
		kris.registerObserver(wis);
		
		wis.beat();

	}

}
