import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		TVFactory tvfactory = new TVFactory();
		TV newTV = null;
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please type the brand : ");
		
		if(userInput.hasNextLine()) {
			String tvOption = userInput.nextLine();
			
			newTV = tvfactory.produceTV(tvOption);
		}
		
		newTV.play();
			
	}
	
}
