public abstract class ScrollingDecorator implements Window {
	protected Window tempWindow;
	
	public ScrollingDecorator(Window newWindow) {
		tempWindow = newWindow;
	}
	
	public String getDesc() {
		return tempWindow.getDesc();
	}
	
	public String addScroll() {
		return tempWindow.addScroll();
	}
	
}
