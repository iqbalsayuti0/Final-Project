package strategy.delivery;

public class SepedaDelivery implements DeliveryStrategy{
    private double tarifPerKm = 1000;
    private final int kecepatan = 15;
    
    @Override
    public double hitungOngkir(double jarak){
        return tarifPerKm * jarak;
    }
    
    @Override
    public String getInfoArmada(){
        return "Sepeda (" + kecepatan + " km/jam)";
    }
}