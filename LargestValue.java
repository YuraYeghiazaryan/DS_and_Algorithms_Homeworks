package largestValueRec;

public class LargestValue {
    public static void main(String[] args) {
        int[] arr = {4,5,1,53,25,7,58,26,13};
        LargestValue largeValue = new LargestValue();
        int max = largeValue.find(arr, arr.length);
        System.out.println(max);
        System.out.println(largeValue.find1(arr, 0, arr.length-1));

    }
    public int find(int[] arr, int length){
        if (length == 1){
            return arr[0];
        }
        return Math.max(arr[length - 1], find(arr, length - 1));
    }
    public  int find1(int[] arr, int leftIndex, int rightIndex){
        if(leftIndex == rightIndex){
            return arr[rightIndex];
        }
        int mid = (leftIndex + rightIndex) / 2;

        int max1 = find1(arr, leftIndex, mid);
        int max2 = find1(arr, mid+1, rightIndex);
        return Math.max(max1, max2);
    }
}
