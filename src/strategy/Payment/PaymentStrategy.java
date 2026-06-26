package strategy.Payment;

public interface PaymentStrategy {
    double hitungTotalAkhir(double totalHarga);
    String getNamaMetode();
}
