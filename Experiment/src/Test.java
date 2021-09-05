
public class Test {

	public static void main(String[] args) {

		//Just A Nothing Test
//		Aircraft nothing = new Aircraft();
//		nothing.setNothing("Nothing");
//		nothing.setTakeOff(null);
//		nothing.setFlight(null);
		
//		System.out.println("This Aircraft Type = "+ nothing.getNothing());
//		nothing.info();
//		System.out.print("\n");
		
		Helicopter helicopter = new Helicopter();
		helicopter.setTakeOff(new Vertical());
		helicopter.setFlight(new SubSonic());
		helicopter.info();
		System.out.print("\n");
		
		AirPlane airplane = new AirPlane();
		airplane.setTakeOff(new LongDistance());
		airplane.setFlight(new SubSonic());
		airplane.info();
		System.out.print("\n");
		
		Fighter fighter = new Fighter();
		fighter.setTakeOff(new LongDistance());
		fighter.setFlight(new SuperSonic());
		fighter.info();
		System.out.print("\n");
		
		Harrier harrier = new Harrier();
		harrier.setTakeOff(new Vertical());
		harrier.setFlight(new SuperSonic());
		harrier.info();
		System.out.print("\n");
		
	}

}
