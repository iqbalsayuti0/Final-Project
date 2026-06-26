package strategy.delivery;

public class BedaPulauDelivery implements DeliveryStrategy{
    private final double tarifPerKg = 30000;
    
    @Override
    public double hitungOngkir(double berat){
        return tarifPerKg * berat;
    }
    
    @Override
    public String getInfoArmada(){
        return "Pengiriman beda pulau";
    }
}
