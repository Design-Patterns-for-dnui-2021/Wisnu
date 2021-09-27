public abstract class TV {
	private String brand;
	
	public String getBrand() {return brand;}
	public void setBrand(String newBrand) {brand = newBrand;}
	
	public void play() {
		System.out.println("Play a "+getBrand());
	}

}
