package strategy.delivery;

public class MotorListrikDelivery implements DeliveryStrategy{
    private final double tarifPerKm = 1500;
    private final int kecepatan = 35;
    
    @Override
    public double hitungOngkir(double jarak){
        return tarifPerKm * jarak;
    }
    
    @Override
    public String getInfoArmada(){
        return "Motor Listrik (" + kecepatan + " km/jam)";
    }
}
