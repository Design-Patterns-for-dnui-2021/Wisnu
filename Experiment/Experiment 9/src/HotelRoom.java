
public class HotelRoom {

	private RoomState state;
	private String name;
	
	public HotelRoom(String name) {
		this.name=name;
		this.state = new RoomAvailable();
	}
	
	public String getName() {
		return name;
	}
	
	public void showInfo() {
		System.out.println("Hotel Room : "+getName());
		this.state.roomInfo();
	}
	
	public void changeState(RoomState state) {
		this.state = state;
	}
}