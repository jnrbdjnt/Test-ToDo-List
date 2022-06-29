// jdk 1.8

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TestToDoList {
    static Scanner kbd = new Scanner(System.in);
    static List<String> currentList = new ArrayList<>();
    
    static String separator1 = "------------------------";
    static String separator2 = "========================";

    static int pilihMenu() {
        char[] menuDaftarKey = {
            '1', '2', '3', '0'
        };
        String[] menuDaftarTxt = {
            "Tambah", // selalu ada
            "Tampilkan Daftar",
            "Hapus",
            "Selesai", // selalu ada
        };
        String pilihanKeyMenu = "";
        
        System.out.println('\n');
        System.out.println(separator2);
        System.out.println("Daftar Tugas");
        System.out.println(separator1);
        
        for (int i = 0; i < menuDaftarTxt.length; i++) {
            switch (menuDaftarKey[i]) {
                case '2':
                case '3': 
                    if (currentList.size() <= 0) 
                        continue;
            }
            pilihanKeyMenu += " " + menuDaftarKey[i];
            System.out.println(menuDaftarKey[i] + ". " + menuDaftarTxt[i]);
        }

        System.out.println();
        while (true) {
            int idxOf;
            
            System.out.print(
                "Pilih (" + 
                pilihanKeyMenu.substring(1).replace(" ", "/") + 
                "): "
            );
            idxOf = pilihanKeyMenu.indexOf((kbd.nextLine().trim() + "-").charAt(0));
            if (idxOf >= 0) 
                return pilihanKeyMenu.charAt(idxOf);
        }
    }

    static void addItem() {
        String item;
        
        System.out.println("\n\nMenambah Tugas");
        System.out.println(separator1);
        System.out.println("(Baris kosong = selesai)");
        while (true) {
            System.out.print(currentList.size() + 1);
            System.out.print(". ");
            item = kbd.nextLine();
            if (item.trim().isEmpty())
                return;
            
            currentList.add(item);
        }
    }

    static void showList() {
        int number = 0;
        
        System.out.println("\n\nDaftar Semua Tugas");
        System.out.println(separator1);
        for (String item : currentList) {
            System.out.println(++number + ". " + item);
        }
        System.out.println(separator1);
    }

    static void removeItem() {
        int idx;
        int idxMax = currentList.size();
        String klmt = "/0=batal) ";
        
        System.out.println("\n\nMenghapus Tugas");
        System.out.println(separator1);
        System.out.print("Nomor tugas yg ingin dihapus (1");
        if (idxMax > 1)
            klmt = ".." + idxMax + klmt;
        
        System.out.print(klmt);
        idx = kbd.nextInt(); kbd.nextLine();
        if (1 <= idx && idx <= idxMax)
            currentList.remove(idx-1);
        
        System.out.println(separator1);
    }

    ////////////////////////////////////////////////////////

    public static void main(String[] args) {
        
        __loop:
        while (true) {
            switch (pilihMenu()) {
            case '1':
                addItem();
                break;
            case '2':
                showList();
                break;
            case '3':
                removeItem();
                break;
            default: // == selesai
                break __loop;
            }
        }
        kbd.close();
    }

}