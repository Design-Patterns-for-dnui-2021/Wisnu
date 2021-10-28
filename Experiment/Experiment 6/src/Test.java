public class Test {

	public static void main(String[] args) {
		PrintSpooler app = PrintSpooler.getInstance();
		app.addTask(1, "How to Basic.pdf", 1);
		app.addTask(2, "We Live in a Society.pdf", 1);
		app.addTask(3, "Object in Motion tend to Stay in Motion.pdf", 1);
		
		app.display();
		
		app.priority(2, 3);
		app.delete(1);
		
		System.out.println("Updated Tasks: ");
		app.display();
		
		//Error Exception
		PrintSpooler app2 = PrintSpooler.getInstance();

	}

}
