package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        startGrocery();
    }

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLütfen bir seçenek seçin:");
            System.out.println("1 - Listeye ürün ekle");
            System.out.println("2 - Listeden ürün çıkar");
            System.out.println("3 - Listeyi görüntüle (sıralı)");
            System.out.println("0 - Uygulamayı durdur");

            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Tampon temizleme

            switch (choice) {
                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz (tek eleman veya virgülle ayırarak birden çok eleman): ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;

                case 2:
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz (tek eleman veya virgülle ayırarak birden çok eleman): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;

                case 3:
                    printSorted();
                    break;

                case 0:
                    System.out.println("Uygulama durduruluyor...");
                    running = false;
                    break;

                default:
                    System.out.println("Geçersiz seçim! Lütfen 0, 1, 2 veya 3 girin.");
                    break;
            }
        }

        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",\\s*"); // Virgülle ayır ve boşlukları temizle
        for (String item : items) {
            if (!checkItemIsInList(item)) {
                groceryList.add(item.trim());
            } else {
                System.out.println("\"" + item.trim() + "\" zaten listede mevcut.");
            }
        }
        Collections.sort(groceryList);
        System.out.println("Güncel liste: " + groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",\\s*"); // Virgülle ayır ve boşlukları temizle
        for (String item : items) {
            if (checkItemIsInList(item)) {
                groceryList.remove(item.trim());
                System.out.println("\"" + item.trim() + "\" listeden çıkarıldı.");
            } else {
                System.out.println("\"" + item.trim() + "\" listede bulunamadı.");
            }
        }
        Collections.sort(groceryList);
        System.out.println("Güncel liste: " + groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim());
    }

    public static void printSorted() {
        System.out.println("Sıralı liste:");
        if (groceryList.isEmpty()) {
            System.out.println("Liste boş.");
        } else {
            Collections.sort(groceryList);
            for (String item : groceryList) {
                System.out.println("- " + item);
            }
        }
    }

}
