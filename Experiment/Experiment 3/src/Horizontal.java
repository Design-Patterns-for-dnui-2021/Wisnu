public class Horizontal extends ScrollingDecorator {

	public Horizontal(Window newWindow) {
		super(newWindow);
	}
	
	public String getDesc() {
		return tempWindow.getDesc();
	}
	
	public String addScroll() {
		return tempWindow.addScroll() + "add Horizontal Scrolling \n";
	}

}
