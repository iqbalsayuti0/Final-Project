package factory;

import strategy.Payment.*;

public class PaymentFactory {

    public static PaymentStrategy pilihPayment(int pilihan) {
        
        switch (pilihan) {
            case 1:
                return new CashPayment();
            case 2:
                return new QrisPayment();
            case 3:
                return new BankGwePayment();
            case 4:
                return new BankDuniaLainPayment();
            default:
                throw new IllegalArgumentException("Metode pembayaran tidak tersedia.");
        }
    }
}