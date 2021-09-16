import java.util.ArrayList;

public abstract class Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
	
}
