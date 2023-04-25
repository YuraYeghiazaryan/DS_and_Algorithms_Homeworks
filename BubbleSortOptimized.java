import java.util.Arrays;

public class BubbleSortOptimized {
    public static void main(String[] args) {
        int[] arr = {13, 6, 34, 5, 7, 2, 10, 28, 11};
        find(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void find(int[] arr){

        for (int i = 0; i < arr.length - 1; i++){
            boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    flag = false;
                }
            }
            if (flag){
                return;
            }
        }

    }
}
