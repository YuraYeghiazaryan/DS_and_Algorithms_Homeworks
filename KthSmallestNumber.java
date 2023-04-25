public class KthSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {5, 0, 1, 53, 25, 7, 58, 26, 13};
        SmallestNumber smallNum = new SmallestNumber();
        int min = smallNum.find(arr, 4);
        System.out.println(min);

    }


    /** The function copies an array, and pass 0 to function finder,
     * and call it */
    public int find(int[] arr, int k){
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return finder(newArr, k, 0);
    }

    /** The function find k-th smallest number in an array
     startIndex in first time must be 0 */
    private int finder(int[] arr, int k, int startIndex) {

        if (k < 1) {
            return -1;
        }

        // find first small element
        int minIndex = startIndex;

        for (int i = startIndex + 1; i < arr.length; i++){
            if (arr[i] < arr[minIndex]){
                minIndex = i;
            }
        }

        // swap first and smallest

        int tmp = arr[startIndex];
        arr[startIndex] = arr[minIndex];
        arr[minIndex] = tmp;

        // repeat before k==1

        if (k == 1){
            return arr[startIndex];
        }else{
            return finder(arr, k - 1, startIndex + 1);
        }

    }
