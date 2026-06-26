package strategy.delivery;

public class MobilBoxDelivery implements DeliveryStrategy{
    private final double tarifPerKm = 3000;
    private final int kecepatan = 40;
    
    @Override
    public double hitungOngkir(double jarak){
        return tarifPerKm * jarak;
    }
    
    @Override
    public String getInfoArmada(){
        return "Mobil Box Listrik (" + kecepatan + " km/jam)";
    }
}
