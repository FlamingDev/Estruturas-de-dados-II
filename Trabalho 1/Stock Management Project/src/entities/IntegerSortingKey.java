/**
 * implementação de uma chave para ordenação de inteiros
 * Pode ser passada como argumento para ordenar um vetor de Integers
 */
package entities;

import interfaces.SortingKey;

public class IntegerSortingKey implements SortingKey<Integer> {

    @Override
    public int compare(Integer thing, Integer other) {
        return thing.compareTo(other);
    }
}
