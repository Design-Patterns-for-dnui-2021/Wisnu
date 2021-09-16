public class Person extends Subject implements Observer, Member {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public void action() {
		System.out.println(this.name+" know that other member is attacked now "+this.name+" is Doing action");
		
	}

	@Override
	public void update() {
		this.action();
		
	}
	
	public void beat() {
		System.out.println(this.name+" is attacked");
		this.notifyObservers();
	}

}
