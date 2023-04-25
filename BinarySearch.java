package binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 6, 9,24, 67, 68, 83, 94, 100};
        BinarySearch binary = new BinarySearch();
        int index = binary.search(6, arr, 0, 8);
        System.out.println(index);

    }
    public int search(int target, int[] arr, int leftIndex, int rightIndex){
        if (leftIndex > rightIndex){
            return -1;
        }
        int mid = (leftIndex + rightIndex) / 2;
        if (arr[mid] == target){
            return mid;
        }
        if (target < arr[mid]){
            return search(target, arr, leftIndex, mid);
        } else{
            return search(target, arr, mid+1, rightIndex);
        }
    }
}
