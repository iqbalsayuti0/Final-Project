package strategy.Payment;

public class QrisPayment implements PaymentStrategy{
    private final double adminFee = 0.0;
   
    @Override
    public double hitungTotalAkhir(double totalHarga) {
        return totalHarga + (totalHarga * adminFee);
    }

    @Override
    public String getNamaMetode() {
        return "QRIS";
    }
}
