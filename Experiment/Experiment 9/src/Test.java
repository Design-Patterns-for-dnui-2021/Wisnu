
public class Test{

	public static void main(String[] args) {
		
		HotelRoom hotelroom21 = new HotelRoom("21");
		hotelroom21.showInfo();
		
		hotelroom21.changeState(new RoomReserved());
		hotelroom21.showInfo();
		
		hotelroom21.changeState(new RoomOccupied());
		hotelroom21.showInfo();
		
		hotelroom21.changeState(new RoomAvailable());
		hotelroom21.showInfo();
	}

}