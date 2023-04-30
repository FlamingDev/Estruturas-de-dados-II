package sorting;

import interfaces.SortingKey;

public class SISorter<T> extends Sorter<T>{
    private double percentage;

    public SISorter(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public void sort(T[] array, SortingKey<T> key, int ordem) {
        int n = array.length;
        int quantity = (int)Math.round(percentage/100 * n);
        System.out.println(quantity);
        for (int i = 0; i < quantity; i++){
            int min = i;
            for (int j = i+1; j < quantity; j++){
                if ((compare(array[j], array[min],key)*ordem) < 0){
                    min = j;
                }
            }
            swap(array, i, min);
        }
        for (int i = n - quantity; i < n; i++){
            int min = i;
            for (int j = i+1; j < n; j++){
                if ((compare(array[j], array[min], key)*ordem) < 0){
                    min = j;
                }
            }
            swap(array, i, min);
        }
        InsertionSorter<T> insertionSorter = new InsertionSorter<>();
        insertionSorter.sort(array, key, ordem);
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
