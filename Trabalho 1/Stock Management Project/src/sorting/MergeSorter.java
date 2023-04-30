package sorting;

import interfaces.SortingKey;

import java.util.Arrays;

public class MergeSorter<T> extends Sorter<T>{

    @Override
    public void sort(T[] array, SortingKey<T> key, int ordem) {
        int length = array.length;
        if (length <= 1){
            return;
        }
        int middle = length/2;
        T[] leftArray = Arrays.copyOf(array, middle);
        T[] rightArray = Arrays.copyOf(array, length-middle);
        for (int i = 0, j = 0; i < length; i++){
            assignments++;
            if (i < middle){
                leftArray[i] = array[i];
            }
            else{
                rightArray[j] = array[i];
                j++;
            }
        }
        sort(leftArray,  key, ordem);
        sort(rightArray,  key,  ordem);
        merge(leftArray, rightArray, array, key, ordem);
    }

    public void merge(T[] leftArray, T[] rightArray, T[] array, SortingKey<T> key, int ordem){
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize){
            assignments++;
            if ((compare(leftArray[l],rightArray[r], key) * ordem) < 0){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize){
            assignments++;
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize){
            assignments++;
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
