package menu.decorator;

import menu.Menu;
        
public abstract class AddOnDecorator implements Menu{
    protected Menu menuDidekor;
    
    public AddOnDecorator(Menu menu){
        this.menuDidekor = menu;
    }
}
