package sorting;

import interfaces.SortingKey;

public class HeapSorter<T> extends Sorter<T>{

    @Override
    public void sort(T[] array, SortingKey<T> key, int ordem) {
        int n = array.length;
        // construindo o max heap
        for (int i = (n/2)-1; i >= 0; i--){
            heapify(array, n, i, key, ordem);
        }
        // deletando os elementos um por um
        for (int i = n-1; i > 0; i--){
            swap(array, 0, i);
            heapify(array, i, 0, key, ordem);
        }
    }

    private void heapify(T[] array, int n, int i, SortingKey<T> key, int ordem){
        int root = i;
        int left = i*2 + 1;
        int right = i*2 + 2;
        // fazendo as verificações do maior elemento que deveria ocupar a raiz
        if (left < n && (compare(array[left], array[root], key)*ordem) > 0){
            root = left;
        }
        if (right < n && (compare(array[right], array[root], key)*ordem) > 0){
            root = right;
        }
        // se a raíz não está na posição certa, trocamos pelo maior nó filho
        if (root != i){
            swap(array, i, root);
            heapify(array, n, root, key, ordem);
        }
    }
}
