
public class Test {

	public static void main(String[] args) {
		Account iru = new Account("Iru", 12345, 1);
		Account ira = new Account("Ira", 12346, 2);
		
		Permission perm;
		PermissionFact fact = new PermissionFactory();
		
		perm = iru.info(fact);
		perm.displayPerInfo();
		
		System.out.println(" ");
		
		perm = ira.info(fact);
		perm.displayPerInfo();
	}

}
