package menu.decorator;

import menu.Menu;

public class SaosMentai extends AddOnDecorator{
    private final double hargaAddon = 2000;
    
    public SaosMentai(Menu menu){
        super(menu);
    }

    @Override
    public String getNama() {
        return menuDidekor.getNama() + " + Saos Mentai";
    }

    @Override
    public double getHarga() {
        return menuDidekor.getHarga() + hargaAddon;
    }    
}