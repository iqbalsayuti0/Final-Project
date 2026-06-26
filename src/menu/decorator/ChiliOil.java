package menu.decorator;

import menu.Menu;

public class ChiliOil extends AddOnDecorator{
    private final double hargaAddon = 1500;

    public ChiliOil(Menu menu){
        super(menu);
    }
    
    @Override
    public String getNama() {
        return menuDidekor.getNama() + " + Chili Oil";
    }

    @Override
    public double getHarga() {
        return menuDidekor.getHarga() + hargaAddon;
    }
}