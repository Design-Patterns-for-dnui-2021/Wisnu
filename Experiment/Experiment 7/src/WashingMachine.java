
public class WashingMachine extends Device {
	private String washingmachineName;
	
	public WashingMachine(String washingmachineName, int voltase) {
		this.washingmachineName = washingmachineName;
		this.voltase = voltase;
	}
	
	@Override
	public void turnOn() {
		System.out.println(this.washingmachineName+" is Turned on");
	}
	
	@Override
	public void turnOff() {
		System.out.println(this.washingmachineName+" is Turned on");
	}

	@Override
	public String getName() {
		return washingmachineName;
	}
}