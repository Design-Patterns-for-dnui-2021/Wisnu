
public class ThreePhaseAdapter implements Socket {
	private Device device;
	
	public ThreePhaseAdapter(Device newDevice) {
		this.device = newDevice;
	}
	
	@Override
	public void plug() {
		int voltase = device.getVolt();
		System.out.println("Plug in the "+device.getName());
		if (voltase > 150) {
			System.out.println("Adapting the voltage. "+device.getVolt()+"Voltage is too High");
			device.setVolt(voltase - 50);
		} else if (voltase < 150) {
			System.out.println("Adapting the voltage. "+device.getVolt()+"Voltage is too Low");
			device.setVolt(voltase + 50);
		}
		device.turnOn();
	}

}