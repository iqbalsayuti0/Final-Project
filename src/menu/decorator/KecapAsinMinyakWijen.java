package menu.decorator;

import menu.Menu;

public class KecapAsinMinyakWijen extends AddOnDecorator{
    private final double hargaAddon = 3000;

    public KecapAsinMinyakWijen(Menu menu){
        super(menu);
    }
    
    @Override
    public String getNama() {
        return menuDidekor.getNama() + " + Kecap Asin & Minyak Wijen";
    }

    @Override
    public double getHarga() {
        return menuDidekor.getHarga() + hargaAddon;
    }
}
