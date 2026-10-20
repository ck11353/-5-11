package question5;

public class Service {
    private int amount;
    private String transactionId;

    public boolean catchException() {
        try {
            new PaymentProcessor().paymentMethod(amount, transactionId);
            return true;
        } catch (InsufficientFundsException e) {
            System.out.println("余额不足，流水号为[" + e.getTransactionId() + "]");
            return false;
        } catch (IllegalArgumentException e) {
            throw new SystemMaintenanceException("支付金额不能为负数", e);
        } catch (Exception e) {
            System.out.println("发生未知异常:[" + e.getMessage() + "]");
            return false;
        } finally {
            System.out.println("执行资源清理任务...");
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        service.transactionId = "123456";
        int a[] = {-1, 99999, 500, 1, 100, 1000, 10000};
        for (int i = 0; i < a.length; i++) {
            try {
                service.amount = a[i];
                service.catchException();
            } catch (SystemMaintenanceException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
            System.out.println();
        }
    }
}
