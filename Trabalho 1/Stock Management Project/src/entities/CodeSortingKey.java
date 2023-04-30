/**
 * chave para comparação de produtos com base em seu ID
 */
package entities;

import interfaces.SortingKey;

public class CodeSortingKey implements SortingKey<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getID().compareTo(p2.getID());
    }
}
