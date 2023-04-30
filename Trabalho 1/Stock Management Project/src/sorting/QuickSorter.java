package sorting;

import interfaces.SortingKey;

public class QuickSorter<T> extends Sorter<T>{

    @Override
    public void sort(T[] array, SortingKey<T> key, int ordem) {
        quickSort(array, 0, array.length-1, key, ordem);
    }

    public void quickSort(T[] array, int low, int high, SortingKey<T> key, int ordem){
        if (low < high){
            int pivot = partition(array,low,high,key, ordem);
            quickSort(array,low,pivot-1,key, ordem);
            quickSort(array,pivot+1,high,key, ordem);
        }
    }

    public int partition(T[] array, int low, int high, SortingKey<T> key, int ordem){
        T pivot = array[high]; // pivô na direita
        int j = low; // vamos achar a posição certa do pivô partindo da esquerda
        int i = j-1;
        for (; j < high; j++){
            if ((compare(array[j], pivot, key)*ordem) < 0){
                i++;
                swap(array, i, j);
            }
        }
        i++;

        swap(array, i, j); // botando o pivô na posição certa
        return i;
    }
}
