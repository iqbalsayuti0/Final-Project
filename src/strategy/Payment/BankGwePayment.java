package strategy.Payment;

public class BankGwePayment implements PaymentStrategy{
    private final double adminFee = 0.015;
   
    @Override
    public double hitungTotalAkhir(double totalHarga) {
        return totalHarga + (totalHarga * adminFee);
    }

    @Override
    public String getNamaMetode() {
        return "Bank Gwe";
    }
}
