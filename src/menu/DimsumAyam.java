package menu;

public class DimsumAyam implements Menu{
    private final double hargaDasar = 4000;
    private String caraMasak;
    
    public DimsumAyam(String caraMasak){
        this.caraMasak = caraMasak;
    }
    
    @Override
    public String getNama(){
        return "Dimsum Ayam (" + caraMasak + ")";
    }
    
    @Override
    public double getHarga(){
        return hargaDasar;
    }
}