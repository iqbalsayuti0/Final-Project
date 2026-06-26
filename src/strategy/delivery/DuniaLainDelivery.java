package strategy.delivery;

public class DuniaLainDelivery implements DeliveryStrategy{
    private final double tarifPerKg = 50000;
    
    @Override
    public double hitungOngkir(double berat){
        return tarifPerKg * berat;
    }
    
    @Override
    public String getInfoArmada(){
        return "Pengiriman dunia lain";
    }
}