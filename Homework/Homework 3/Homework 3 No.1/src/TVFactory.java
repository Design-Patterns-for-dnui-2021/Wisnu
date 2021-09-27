public class TVFactory {
	public TV produceTV(String newTVType) {
		TV newTV = null;
		
		if(newTVType.equalsIgnoreCase("Hisense")) {
			return new HisenseTV();
		}else if(newTVType.equalsIgnoreCase("Haier")) {
			return new HaierTV();
		}else
			System.out.println("Enter Hisense/Haier!");
			return null;
	}
}
