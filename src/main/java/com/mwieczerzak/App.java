package com.mwieczerzak;

import com.mwieczerzak.repository.ProductRepository;
import com.mwieczerzak.devices.input.BarcodeScanner;
import com.mwieczerzak.devices.output.LCD;
import com.mwieczerzak.devices.output.Printer;
import com.mwieczerzak.dto.Product;
import com.mwieczerzak.model.Cart;
import com.mwieczerzak.model.Cashbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App implements LCD, Printer, BarcodeScanner {

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private Cashbox cashbox;
    private Scanner scanner;
    private Cart cart;
    private ProductRepository productRepository;

    public App() {
        cashbox = new Cashbox();
        scanner = new Scanner(System.in);
        cart = new Cart();
        productRepository = new ProductRepository();
    }

    public void start() {
        while (true) {
            System.out.println("Enter barcode");
            String in = scanner.nextLine();
            readBarcode(in);
            if (in.equalsIgnoreCase("exit"))
                break;
        }
    }

    public void readBarcode(String barcode) {
        try {
            if (barcode.equalsIgnoreCase("exit")) {
                displayAll(cart);
                printAllProducts(cart);
            } else {
                Product product = productRepository.findByBarcode(Long.valueOf(barcode));
                System.out.println(product);
                cart.add(product);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid barcode");
        } catch (RuntimeException e) {
            System.out.println("Product not found");
        }
    }

    public void displayAll(Cart cart) {
        for (Product product : cart.getCartProducts()) {
            System.out.println(product);
        }
        System.out.println("Total " + cashbox.getTotalPrice(cart));

    }

    public void printAllProducts(Cart cart) {
        try {
            File file = new File("receipt.txt");
            PrintWriter printWriter = new PrintWriter(file);
            for (Product product : cart.getCartProducts()) {
                printProduct(printWriter, product);
            }
            printWriter.println("Total " + cashbox.getTotalPrice(cart));
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Some problem with file saving");
        }
    }

    public void printProduct(PrintWriter printWriter, Product product) {
        printWriter.println(product.getName());
        printWriter.println(product.getPrice());
        printWriter.println();
    }

}