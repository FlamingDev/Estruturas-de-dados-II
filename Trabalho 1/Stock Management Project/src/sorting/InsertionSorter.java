package sorting;

import interfaces.SortingKey;

public class InsertionSorter<T> extends Sorter<T> {

    @Override
    public void sort(T[] array, SortingKey<T> key, int ordem) {
        for (int i = 1; i < array.length; i++){
            T temp = array[i];
            int j = i-1;
            while (j >= 0 && (compare(array[j],temp, key) * ordem) > 0){
                assignments++;
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }
}
