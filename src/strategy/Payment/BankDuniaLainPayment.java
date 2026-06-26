package strategy.Payment;

public class BankDuniaLainPayment implements PaymentStrategy{
    private final double adminFee = 0.5;
   
    @Override
    public double hitungTotalAkhir(double totalHarga) {
        return totalHarga + (totalHarga * adminFee);
    }

    @Override
    public String getNamaMetode() {
        return "Bank Dunia Lain";
    }
}
