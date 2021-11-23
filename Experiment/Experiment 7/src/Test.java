
public class Test {

	public static void main(String[] args) {
		
		//create tv and washMachine object
		Device tv = new TV("LG", 200);
		Device washMachine = new WashingMachine("Samsung", 150);
		
		//create the adapter
		Socket socket = new ThreePhaseAdapter(tv);
		socket.plug();
		
		System.out.println("---------------------------");
		socket = new ThreePhaseAdapter(washMachine);
		socket.plug();
		
	}

}