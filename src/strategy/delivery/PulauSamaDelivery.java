package strategy.delivery;

public class PulauSamaDelivery implements DeliveryStrategy{
    private final double tarifPerKg = 20000;
    
    @Override
    public double hitungOngkir(double berat){
        return tarifPerKg * berat;
    }
    
    @Override
    public String getInfoArmada(){
        return "Pengiriman pulau sama";
    } 
}