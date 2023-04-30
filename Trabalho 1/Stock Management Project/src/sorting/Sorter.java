/** @author Breno Roberto Reis Vidigal
 */

package sorting;

import interfaces.SortingKey;

/**
 * Classe para definir o esqueleto de um método de ordenação
 * @param <T> Classe na qual a classe irá basear suas comparações
 */

public abstract class Sorter<T> {
    /**
     * @value valores que irão medir a complexidade das execuções
     */
    protected long comparisons = 0;
    protected long assignments = 0;

    public Sorter() {
    }

    /**
     *
     * @param array Array a ser ordenado
     * @param ordem se ordem > 0, a ordem será crescente. Caso contrário, será decrescente
     * @param key chave de ordenação
     */

    public abstract void sort(T[] array, SortingKey<T> key, int ordem);

    /**
     * Troca posições de dados dentro do array
     * @param array onde haverá a troca de posições
     * @param i índice do dado que será trocado
     * @param j índice do dado que irá ocupar a posição "i"
     * @throws IllegalArgumentException se índices forem valores negativos
     */
    protected void swap(T[] array, int i, int j) throws IllegalArgumentException{
        if (i < 0 || j < 0){
            throw new IllegalArgumentException("Índices não podem ser negativos");
        }
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        assignments += 3;
    }

    /**
     * Incrementa o contador de comparações e chama o método compareTo dos parâmetros
     * @param thing parâmetro do tipo T
     * @param other outra instância de T
     * @param key classe que implementa a interface SortingKey e possui seu método "compare"
     * @return 1 se a > b, -1 se a < b e 0 se a == b
     */
    protected int compare(T thing, T other, SortingKey<T> key){
        comparisons++;
        return key.compare(thing, other);
    }
    /*
        Obs: compare é uma delegação do método compare da key, portanto,
        será necessário passar uma chave do mesmo tipo para o método sort.
        Obs2: Cada implementação concreta de Sorter fará chamadas a este método compare,
        passando a key do método sort como argumento para o compare.
     */

    /**
     *
     * @return o número de comparações feitas pelo algoritmo
     */
    public long getComparisons() {
        return comparisons;
    }

    /**
     *
     * @return o número de atribuições feitas pelo algoritmo
     */
    public long getAssignments() {
        return assignments;
    }

}