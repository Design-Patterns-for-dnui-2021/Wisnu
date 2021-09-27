public class PetFactory {
	public Pet createPet(String sound) {
		Pet newPet = null;
		
		if(sound.equalsIgnoreCase("Meow")) {
			return new Cat();
		}else if(sound.equalsIgnoreCase("Bark")) {
			return new Dog();
		}else if(sound.equalsIgnoreCase("Chirp")) {
			return new Bird();
		}else { 
			System.out.println("Use Bark, Chirp, or Meow!");
			return null;
		}
	}

}
