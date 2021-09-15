import java.util.ArrayList;

public class Stocks implements Subject {
	private String name;
	private double price;
	private ArrayList<ShareHolders> holder;
	
	public Stocks(String name, double price){
		this.name = name;
		this.price = price;
		holder = new ArrayList<ShareHolders>();
	}

	@Override
	public void regisShareHolder(ShareHolders newHolder) {
		holder.add(newHolder);
		System.out.println("New Holder added to "+name);
		
	}

	@Override
	public void removShareHolder(ShareHolders delHolder) {
		holder.remove(delHolder);
		
	}

	@Override
	public void notifShareHolder() {
		for (ShareHolders shareHolders : holder) {
			shareHolders.update(name, price);
		}
		
	}
	
	public void setPrice(double newPrice) {
		double oldPrice = price;
		this.price = newPrice;
		System.out.println("Stock "+name+" Changed to "+newPrice);
		double percent = Math.abs((newPrice-oldPrice)/newPrice)*100;
		if(percent > 5) {
			this.notifShareHolder();
		}
	}

}
