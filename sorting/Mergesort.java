import java.util.Random;

public class Mergesort {
    private int[] numbers;
    private int[] helper;

    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }

    private void mergesort(int low, int high) {
        // Check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = (low + high) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
    }

    public static void main(String args[]) {
        Mergesort ms = new Mergesort();
            for (int i = 500; i <= 30000; i=i+500){
            Random r = new Random();
            int MAX = i;
            int[] data = new int[MAX];
            for(int j=0; j<data.length; j++)
                data[j] = r.nextInt(data.length*10);

            long start = System.nanoTime();
            ms.sort(data);
            long end = System.nanoTime();
            //for(int i=0; i<data.length; i++)
            //    System.out.print(data[i]+" ");
            //System.out.println();
            // System.out.printf("Tempo para ordenar %d elementos: %d ns\n",MAX,end-start);
            System.out.printf("%d\n", end-start);
        }
    }
}
