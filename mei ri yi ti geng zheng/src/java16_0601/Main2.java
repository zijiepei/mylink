package java16_0601;

public class Main2 {
    public void quickSort(int[] array) {
        quickSortHelper(array,0,array.length - 1);
    }

    private void quickSortHelper(int[] array, int left,int right) {
        if(left - right >= 0) {
            return;
        }
        int index = patition(array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1,right);
    }

    private int patition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while (i < j) {
            while (i < j && array[i] <= base) {
                i++;
            }
            while (i < j && array[j] >= base) {
                j--;
            }
            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int findKth(int[] a, int n, int K) {
        quickSort(a);
        return a[n - K];
    }
}
