package order;

import menu.Menu;
import strategy.delivery.DeliveryStrategy;
import strategy.Payment.PaymentStrategy;

public class Order {
    private Menu[] daftarMenu;
    private int[] daftarJumlah;
    private DeliveryStrategy delivery;
    private PaymentStrategy payment;
    private double parameterKirim;

    public Order(Menu[] daftarMenu, int[] daftarJumlah, DeliveryStrategy delivery, PaymentStrategy payment, double paramKirim) {
        this.daftarMenu = daftarMenu;
        this.daftarJumlah = daftarJumlah;
        this.delivery = delivery;
        this.payment = payment;
        this.parameterKirim = paramKirim;
    }
    
    public double hitungTotalKeseluruhan(){
        double subtotal = 0;
        
        for (int i = 0; i < daftarMenu.length; i++){
            subtotal += daftarMenu[i].getHarga() * daftarJumlah[i];
        }
        
        double ongkir = delivery.hitungOngkir(parameterKirim);
        return payment.hitungTotalAkhir(subtotal + ongkir);
    }
    
    public void cetakStruk(){
        System.out.println("\n========== STRUK ==========");
        
        for (int i = 0; i < daftarMenu.length; i++){
            System.out.println("Menu " + (i + 1) + "        : " + daftarMenu[i].getNama());
            System.out.println("Harga Satuan   : Rp " + daftarMenu[i].getHarga());
            System.out.println("Jumlah         : " + daftarJumlah[i]);
            System.out.println("Subtotal       : Rp " + (daftarMenu[i].getHarga() * daftarJumlah[i]));
            System.out.println();
        }
        
        System.out.println("Delivery       : " + delivery.getInfoArmada());
        System.out.println("Ongkir         : Rp " + delivery.hitungOngkir(parameterKirim));
        System.out.println("Pembayaran     : " + payment.getNamaMetode());
        System.out.println("Total Bayar    : Rp " + hitungTotalKeseluruhan());
        System.out.println("===========================\n");
    }
}
