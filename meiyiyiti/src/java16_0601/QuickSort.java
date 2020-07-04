package java16_0601;

public class QuickSort {
    public int findKth(int[] a, int n, int K) {
        quickSort(a);
        if(K <= n) {
            return a[n - K];
        }
        return -1;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void quickSort(int[] array) {

        quickSortHelp(array, 0, array.length - 1);
    }

    private void quickSortHelp(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = patition(array, left, right);
        quickSortHelp(array, left, index - 1);
        quickSortHelp(array, index + 1, right);
    }

    private int patition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            while (i < j && array[j] >= baseValue) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, i, right);
        return i;
    }
}


