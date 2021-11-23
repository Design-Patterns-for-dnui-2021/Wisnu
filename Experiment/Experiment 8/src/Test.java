public class Test {
	
    public static void main(String[] args) {
    	
    	//Create Object Transaction
        BankTransaction transaction = new DepositTransferMoney();
        transaction.performTransaction();

        //Perform Transaction
        transaction = new WithdrawMoney();
        transaction.performTransaction();
    }
    
}