public class Fighter extends Aircraft {

	@Override
	public void info() {
	 
		System.out.println("This Aircraft Type = Fighter");
		System.out.print("TakeOff Type = ");
		this.doTakeOff();
		System.out.print("Flight Type = ");
		this.doFlight();
		System.out.print("\n");
	}
	 
}
 
