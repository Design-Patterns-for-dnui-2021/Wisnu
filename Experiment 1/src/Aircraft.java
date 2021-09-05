public class Aircraft {
	private TakeOffType takeoff;
	private FlightType flight;
//	private String nothing;
	 
	public void setTakeOff(TakeOffType takeoff) {
		
		this.takeoff = takeoff;
	 
	}
	 
	public void setFlight(FlightType flight) {
		
		this.flight = flight;
	 
	}
	
//	public void setNothing(String nothing) {
//		
//		this.nothing = nothing;
//		
//	}
//	
//	public String getNothing() {
//		return this.nothing;
//	}
	
	public void doTakeOff() {
		
		this.takeoff.doTakeOff();
	 
	}
	 
	public void doFlight() {
	 
		this.flight.doFlight();
	}
	 
	public void info() {
	
		System.out.println("TakeOff = Nothing");
		System.out.println("Flight = Nothing");
	}
	 
}
 
