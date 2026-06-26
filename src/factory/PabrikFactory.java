package factory;

import menu.*;
import strategy.delivery.*;

public class PabrikFactory implements UnitFactory{

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
    public DeliveryStrategy pilihDelivery(String opsiDelivery) {
        switch (opsiDelivery.toLowerCase()){
            case "pulau sama":
                return new PulauSamaDelivery();
            case "beda pulau":
                return new BedaPulauDelivery();
            case "dunia lain":
                return new DuniaLainDelivery();
            default:
                throw new IllegalArgumentException("Delivery tidak tersedia.");
        }
    }    
}