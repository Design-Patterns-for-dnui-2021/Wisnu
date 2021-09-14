public class Harrier extends Aircraft {

	@Override
	public void info() {
	 
		System.out.println("This Aircraft Type = Harrier");
		System.out.print("TakeOff Type = ");
		this.doTakeOff();
		System.out.print("Flight Type = ");
		this.doFlight();
		System.out.print("\n");
	}
	 
}
 
