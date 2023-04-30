package application;

import entities.*;
import interfaces.SortingKey;
import sorting.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args){
        try{
            Instant begin = Instant.now();
            final int MAX_SIZE = 10000; // quantidade máxima para o tamanho do vetor
            BufferedReader reader = new BufferedReader(new FileReader("products.csv"));
            String line;
            Product[] products = new Product[MAX_SIZE];
            int i = 0;
            reader.readLine(); // pulando o cabeçalho do arquivo csv
            while ((line = reader.readLine()) != null && i < MAX_SIZE){
                String[] lines = line.split(",");
                products[i] = new Product(lines[4], Integer.parseInt(lines[0],1,lines[0].length(),10), Float.parseFloat(lines[6])); // nome, ID e Preço
                i++;
            }

            Sorter<Product> sorter = new QuickSorter<>(); // definindo o método de ordenação
            SortingKey<Product> key = new NameSortingKey(); // definindo qual vai ser o critério de ordenação
            sorter.sort(products, key,1);
            Instant end = Instant.now();
            for (Product p : products){
                System.out.println(p);
            }
            System.out.println("Critério de ordenação: PREÇO");
            System.out.println("Duração em segundos: " + (double)Duration.between(begin,end).toMillis()/1000);
            System.out.println("Comparações feitas: " + sorter.getComparisons());
            System.out.println("Atribuições feitas: " + sorter.getAssignments());
            System.out.println("Total de operações simples: " + (sorter.getComparisons()+sorter.getAssignments()));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}