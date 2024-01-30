package testdoubles;

import com.example.BankService;

public class CustomBankServiceSpy implements BankService {
    private boolean throwException = false;

    public CustomBankServiceSpy(boolean throwException) {
        this.throwException = throwException;
    }

    @Override
    public void pay(String id, double amount) {
        if (throwException) {
            throw new RuntimeException("Payment failed");
        }
        System.out.println("Custom BankService: Payment successful for " + id + ", amount: " + amount);
    }
}
