public class Test {

	public static void main(String[] args) {
		Window basicWindow = new Chrome();
		basicWindow = new Horizontal(basicWindow);
		basicWindow = new Vertical(basicWindow);
		System.out.println("This is "+basicWindow.getDesc());
		System.out.println("Now : \n"+basicWindow.addScroll());

	}

}
