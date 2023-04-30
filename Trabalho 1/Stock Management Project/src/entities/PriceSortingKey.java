/**
 * Classe para ordenação de Products com base em seu preço
 */
package entities;

import interfaces.SortingKey;

public class PriceSortingKey implements SortingKey<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getPrice().compareTo(p2.getPrice());
    }
}
