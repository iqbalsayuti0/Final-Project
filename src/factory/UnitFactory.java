package factory;

import menu.Menu;
import strategy.delivery.DeliveryStrategy;

public interface UnitFactory {
    Menu pesanMenu(String namaMenu, String opsi);
    DeliveryStrategy pilihDelivery(String opsiDelivery);
}
