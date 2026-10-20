package question5;

public class InsufficientFundsException extends Exception {
    private String transactionId;
    InsufficientFundsException(String message,String transactionId){
        super(message);
        this.transactionId = transactionId;
    }
    public String getTransactionId() {
        return transactionId;
    }
}
