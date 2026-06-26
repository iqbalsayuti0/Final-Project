package menu;

public class DimsumAyamUdang implements Menu{
    private final double hargaDasar = 5000;
    private String caraMasak;
    
    public DimsumAyamUdang(String caraMasak){
        this.caraMasak = caraMasak;
    }
    
    @Override
    public String getNama(){
        return "Dimsum Ayam Udang (" + caraMasak + ")";
    }
    
    @Override
    public double getHarga(){
        return hargaDasar;
    }
}
