import factory.*;
import java.util.Scanner;
import menu.Menu;
import menu.decorator.*;
import order.Order;
import strategy.delivery.DeliveryStrategy;
import strategy.Payment.*;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        UnitFactory factory = null;
        PaymentStrategy payment = null;
        
        System.out.println("========== ACCEPT'N SEND ==========\n");
        
        // PEMILIHAN UNIT
        System.out.println("Pilih Unit:");
        System.out.println("1. Restoran (tersedia goreng/kukus)");
        System.out.println("2. Pabrik (only frozen food)");
        System.out.print("Pilihan : ");
        
        int unit = input.nextInt();
        input.nextLine();
        
        if (unit == 1){
            factory = new RestoranFactory();
        }else {
            factory = new PabrikFactory();
        }
        
        // PILIH MENU
        System.out.println("\nMenu");
        System.out.println("1. Dimsum Ayam      | 4000/buah");
        System.out.println("2. Dimsum Udang     | 6000/buah");
        System.out.println("3. Dimsum Ayam Udang| 5000/buah");
        
        System.out.print("Jumlah jenis menu yang dipesan : ");
        int jumlahJenisMenu = input.nextInt();
        input.nextLine();
        
        Menu[] daftarMenu = new Menu[jumlahJenisMenu];
        int[] daftarJumlah = new int[jumlahJenisMenu];
        
        for (int m = 0; m < jumlahJenisMenu; m++){
            System.out.println("\nMenu ke-" + (m + 1));
            System.out.print("Pilihan : ");
            
            int pilihMenu = input.nextInt();
            input.nextLine();
            
            String namaMenu = "";
            switch (pilihMenu){
                case 1 -> namaMenu = "ayam";
                case 2 -> namaMenu = "udang";
                case 3 -> namaMenu = "ayamudang";
            }
            
            //OPSI MENU
            String opsi;
            if (unit == 1){
                System.out.println("\nCara Masak");
                System.out.println("1. Goreng");
                System.out.println("2. Kukus");
                
                System.out.print("pilihan : ");
                int pilihMasak = input.nextInt();
                input.nextLine();
                
                opsi = (pilihMasak == 1) ? "Goreng" : "Kukus";
            }else {
                opsi = "Frozen";
            }
            
            Menu menu = factory.pesanMenu(namaMenu, opsi);
            
            //JUMLAH
            System.out.print("\nJumlah porsi : ");
            int jumlah = input.nextInt();
            
            //ADD ON
            System.out.println("\nAdd-On");
            System.out.println("1. Saos Mentai                  |2000/bungkus");
            System.out.println("2. Chili Oil                    |1500/bungkus");
            System.out.println("3. Kecap Asin + Minyak Wijen    |3000/bungkus");
            System.out.print("Jumlah Add-On (0-3) : ");
            int jumlahAddon = input.nextInt();
            input.nextLine();
            
            for (int i = 1; i <= jumlahAddon; i++){
                System.out.println("\nAdd-On " +i);
                System.out.print("Pilihan : ");
                
                int addon = input.nextInt();
                input.nextLine();
                
                switch (addon){
                    case 1 -> menu = new SaosMentai(menu);
                    case 2 -> menu = new ChiliOil(menu);
                    case 3 -> menu = new KecapAsinMinyakWijen(menu);
                }
            }
            
            daftarMenu[m] = menu;
            daftarJumlah[m] = jumlah;
        }
        
        //DELIVERY
        String opsiDelivery = "";
        if (unit == 1){
            System.out.println("\nDelivery");
            System.out.println("1. Sepeda   |1000/km");
            System.out.println("2. Motor    |1500/km");
            System.out.println("3. Mobil    |3000/km");
            System.out.print("Pilihan : ");
            
            int pilih = input.nextInt();
            
            switch (pilih){
                case 1 -> opsiDelivery = "sepeda";
                case 2 -> opsiDelivery = "motor";
                case 3 -> opsiDelivery = "mobil";
            }
        }else {
            System.out.println("\nDelivery");
            System.out.println("1. Pulau sama   |20k/KG");
            System.out.println("2. Beda pulau   |30k/KG");
            System.out.println("3. Dunia lain   |50k/KG");
            System.out.print("pilihan : ");
            
            int pilih = input.nextInt();
            
            switch (pilih){
                case 1 -> opsiDelivery = "pulau sama";
                case 2 -> opsiDelivery = "beda pulau";
                case 3 -> opsiDelivery = "dunia lain";
            }
        }
        
        DeliveryStrategy delivery = factory.pilihDelivery(opsiDelivery);
        
        //PARAMETER ONGKIR
        double parameter;
        
        if (unit == 1){
            System.out.println("\nMasukkan jarak (Km) : ");
        }else {
            System.out.println("\nMasukkan berat (Kg) : ");
        }
        
        String inputParameter = input.next();
        inputParameter = inputParameter.replace(",", ".");
        parameter = Double.parseDouble(inputParameter);
        
        while (parameter <= 0){
            System.out.print("Input harus lebih dari 0, masukkan lagi : ");
            inputParameter = input.next();
            inputParameter = inputParameter.replace(",", ".");
            parameter = Double.parseDouble(inputParameter);
        }
        
        //PAYMENT
        System.out.println("\nPembayaran");
        System.out.println("1. Cash             |0%");
        System.out.println("2. QRIS             |0%");
        System.out.println("3. Bank Gwe         |1.5%");
        System.out.println("4. Bank Dunia Lain  |5%");
        System.out.print("Pilihan : ");
        
        int bayar = input.nextInt();
        
        switch(bayar){
            case 1 -> payment = new CashPayment();
            case 2 -> payment = new QrisPayment();
            case 3 -> payment = new BankGwePayment();
            case 4 -> payment = new BankDuniaLainPayment();
        }
        
        //ORDER
        Order order = new Order(daftarMenu, daftarJumlah, delivery, payment, parameter);
        order.cetakStruk();
        input.close();
    }
}
