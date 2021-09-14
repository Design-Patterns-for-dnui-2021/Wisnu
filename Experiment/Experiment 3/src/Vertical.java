public class Vertical extends ScrollingDecorator {

	public Vertical(Window newWindow) {
		super(newWindow);
	}
	
	public String getDesc() {
		return tempWindow.getDesc();
	}
	
	public String addScroll() {
		return tempWindow.addScroll() + "add Vertical Scrolling \n";
	}

}
