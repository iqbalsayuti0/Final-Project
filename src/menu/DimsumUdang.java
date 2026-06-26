package menu;

public class DimsumUdang implements Menu{
    private final double hargaDasar = 6000;
    private String caraMasak;
    
    public DimsumUdang(String caraMasak){
        this.caraMasak = caraMasak;
    }
    
    @Override
    public String getNama(){
        return "Dimsum Udang (" + caraMasak + ")";
    }
    
    @Override
    public double getHarga(){
        return hargaDasar;
    }
}
