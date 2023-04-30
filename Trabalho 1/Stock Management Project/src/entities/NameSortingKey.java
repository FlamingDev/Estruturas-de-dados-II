/**
 * chave para comparação de produtos com base em sua categoria
 */
package entities;

import interfaces.SortingKey;

public class NameSortingKey implements SortingKey<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
