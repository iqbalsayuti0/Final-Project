package factory;

import menu.*;
import strategy.delivery.*;

public class RestoranFactory implements UnitFactory{
    
    @Override
    public Menu pesanMenu(String namaMenu, String opsi){
        switch (namaMenu.toLowerCase()){
            case "ayam":
                return new DimsumAyam(opsi);
            case "udang":
                return new DimsumUdang(opsi);
            case "ayamudang":
                return new DimsumAyamUdang(opsi);
            default:
                throw new IllegalArgumentException("Menu tidak tersedia.");
        }
    }
    
    @Override
    public DeliveryStrategy pilihDelivery(String opsiDelivery){
        switch (opsiDelivery.toLowerCase()){
            case "sepeda":
                return new SepedaDelivery();
            case "motor":
                return new MotorListrikDelivery();
            case "mobil":
                return new MobilBoxDelivery();
            default:
                throw new IllegalArgumentException("Delivery tidak tersedia.");
        }
    }
}
