
public class Account {

	private String name;
	private int accnum;
	private int acclvl;
	
	Account(String newName, int newAccnum, int newAcclvl){
		name=newName;
		accnum=newAccnum;
		acclvl=newAcclvl;
	}
	
	Permission info(PermissionFact fact) {
		System.out.println("Logged in as: " + name);
		System.out.println("Account No: " + accnum);
		System.out.println("Permission Level: " + acclvl);
		return fact.getPermission(acclvl);
	}
}
