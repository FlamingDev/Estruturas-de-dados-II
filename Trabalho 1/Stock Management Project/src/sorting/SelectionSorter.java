package sorting;

import interfaces.SortingKey;

public class SelectionSorter<T> extends Sorter<T>{

    @Override
    public void sort(T[] array, SortingKey<T> key, int ordem) {
        for (int i = 0; i < array.length; i++){
            int min_index = i;
            for (int j = i+1; j < array.length; j++){
                if ((compare(array[j], array[min_index], key)*ordem) < 0){
                    min_index = j;
                }
            }
            swap(array, i, min_index);
        }
    }

}
