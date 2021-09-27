import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
		PetFactory petfactory = new PetFactory();
		Pet newPet = null;
		String sound = "";
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("You can Create Pet (Dog, Cat, Bird)");
		System.out.print("Enter The  Pet Sound : ");
		sound = userInput.nextLine();
		System.out.println("");
		newPet = petfactory.createPet(sound);
		newPet.displayPetInfo();
	}

}
