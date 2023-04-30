/**
 * representa uma chave de ordenação genérica.
 * @param <T> tipo a ser ordenado
 */

package interfaces;


public interface SortingKey<T> {
    /**
     *
     * @param thing objeto a ser comparado
     * @param other outro objeto do mesmo tipo T
     * @return 1 se a > b, -1 se a < b e 0 se a == b (método compareTo da interface Comparable)
     */
    int compare(T thing, T other);
}

/* Observações:
       obs1: O método compare foi usado nessa implementação para comparar produtos,
       portanto, foi necessário criar uma classe pra cada atributo-chave da classe Product.
       obs2: compare é uma delegação do método compareTo que será usado, no caso de objetos,
       para comparar seus atributos, sendo eles wrapper classes que implementam a interface Comparable,
       como Integer, Float, Double, String
       obs3: Com essa implementação também é possível ordenar vetores de Integers, e outras wrapper classes
       que implementam a interface Comparable
     */