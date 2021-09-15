public class Holder implements ShareHolders {
	private String hname;
	
	public Holder(String name) {
		this.hname = name;
	}

	@Override
	public void update(String name, double price) {
		System.out.println(hname +" has known that stock: ["+name+"] is fluctuates to 5%, now is at "+price );
		
	}
}
