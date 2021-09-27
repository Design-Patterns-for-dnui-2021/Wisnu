public abstract class Pet {
	private String sound;
	private String type;
	
	public String getType() {return type;}
	public String getSound() {return sound;}
	
	public void setType(String newType) {type = newType;}
	public void setSound(String newSound) {sound = newSound;}
	
	public void displayPetInfo() {
		System.out.println("This pet type is "+getType());
		System.out.println("The Pet Sound is "+getSound());
	}
}
