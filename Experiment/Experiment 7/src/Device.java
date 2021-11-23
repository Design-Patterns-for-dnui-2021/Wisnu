
public abstract class Device {
	protected int voltase;
	
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract String getName();
	
	public void setVolt(int newVoltase) {
		this.voltase = newVoltase;
	}
	
	public int getVolt() {
		return voltase;
	}
}