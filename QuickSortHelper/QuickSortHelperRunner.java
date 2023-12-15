import java.util.Arrays;

public class QuickSortHelperRunner {
    public static void main(String[] args) {
        int[] arr = {37,2,6,4,89,8,10,12,68,45};
        QuickSortHelperRunner q = new QuickSortHelperRunner();
        System.out.println(Arrays.toString(q.quickSortHelper(arr, 0, arr.length-1)));

    }
    public int[] quickSortHelper(int[] arr, int left_index, int right_index){
        System.out.println(left_index);

        if (right_index == 0 || left_index > arr.length - 1) {

            return arr;
        }
        int start = left_index ;
        int end = right_index;
        int pivot = arr[left_index];

        while (right_index  > left_index) {
            boolean b = true;
            if (pivot > arr[right_index]){
                  swap(arr, left_index, right_index);
                  //left_index++;
                while(b & right_index > left_index ){
                    if (pivot < arr[left_index]){
                        swap(arr, left_index, right_index);
                       // right_index--;
                        b = false;
                    }else left_index++;
                }
            }else right_index--;
        }

        quickSortHelper(arr, start, right_index-1);
        quickSortHelper(arr, left_index+1, end);
        return arr;
    }

    public int[] swap(int[] arr, int left, int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
        return arr;
    }
    

}
