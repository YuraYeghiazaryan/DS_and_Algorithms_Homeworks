package largestValueRec;

public class LargestValue {
    public static void main(String[] args) {
        int[] arr = {4,5,1,53,25,7,58,26,13};
        LargestValue largeValue = new LargestValue();
        int max = largeValue.find(arr, arr.length);
        System.out.println(max);

    }
    public int find(int[] arr, int length){
        if (length == 1){
            return arr[0];
        }
        return Math.max(arr[length - 1], find(arr, length - 1));
    }
}
