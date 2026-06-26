package strategy.Payment;

public class CashPayment implements PaymentStrategy{
    private final double adminFee = 0.0;
   
    @Override
    public double hitungTotalAkhir(double totalHarga) {
        return totalHarga + (totalHarga * adminFee);
    }

    @Override
    public String getNamaMetode() {
        return "Cash";
    }
}