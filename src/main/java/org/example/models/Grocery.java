package org.example.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public void startGrocery() {

        Scanner scanner = new Scanner(System.in);

        int num;

        do {
            num = scanner.nextInt();
            scanner.nextLine();

            switch (num) {
                case 0:
                    break;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
            }

        }

        while (num !=0);
    }
    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
                System.out.println(item + " listeye eklendi.");
            } else {
                System.out.println(item + " zaten listede var.");
            }
        }
        printSorted();
    }


    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
                System.out.println(item + " listeden çıkarıldı.");
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
        printSorted();
    }


    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }


    public static void printSorted() {
        groceryList.sort(String::compareToIgnoreCase);
        System.out.println("Güncel Pazar Listesi: ");
        for (String item : groceryList) {
            System.out.println("- " + item);
        }
    }

}
