package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetLeastNumbers {
    private int[] res;
    private int[] array;

    public int[] getLeastNumbers(int[] arr, int k) {
        res = new int[k];
        array = arr;
        shuffleArray();
        int pivot;
        int start = 0;
        int end = array.length - 1;
        while (true) {
            pivot = partition(start, end);
            if (pivot == k) {
                break;
            } else if (pivot > k) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }
        }
        // Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void shuffleArray() {
        List<Integer> intList = new ArrayList<>();
        for (int i : array) {
            intList.add(i);
        }
        Collections.shuffle(intList);
        for (int i = 0; i < array.length; i++) {
            array[i] = intList.get(i);
        }
    }

    private int partition(int start, int end) {
        int pivot = start;
        int left = start + 1;
        int right = end;
        while (!(left > right) && left <= end) {
            if (array[left] >= array[pivot] && array[right] <= array[pivot]) {
                swap(left, right);
                left++;
                right--;
            } else if (array[left] >= array[pivot]) {
                right--;
            } else if (array[right] <= array[pivot]) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        swap(right, pivot);
        return right;
    }

    private void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    @Test
    public void test() {
        GetLeastNumbers gln = new GetLeastNumbers();
        gln.getLeastNumbers(new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4}, 0);
    }
}
