
public class PermissionFactory implements PermissionFact {

	@Override
	public Permission getPermission(int acclvl) {
		switch (acclvl) {
		case 1:
			return new Admin();
		case 2:
			return new Staff();
		default: 
			throw new Error("Invalid permission level");
	}
	}

}
