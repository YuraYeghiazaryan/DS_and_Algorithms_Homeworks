package smallestNumberRec;

public class SmallestNumber {
    public static void main(String[] args) {
        int[] arr = {5, 0, 1, 53, 25, 7, 58, 26, 13};
        SmallestNumber smallNum = new SmallestNumber();
        int min = smallNum.find(arr, 4, 0);
        System.out.println(min);

    }

    /** The function find k-th smallest number in an array
     startIndex in first time must be 0 */
    public int find(int[] arr, int k, int startIndex) {

        // copying array

        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);

        if (k < 1) {
            return -1;
        }

        // find first small element
        int minIndex = startIndex;

        for (int i = startIndex + 1; i < newArr.length; i++){
            if (newArr[i] < newArr[minIndex]){
                minIndex = i;
            }
        }

        // swap first and smallest

        int tmp = newArr[startIndex];
        newArr[startIndex] = newArr[minIndex];
        newArr[minIndex] = tmp;

        // repeat before k==1

        if (k == 1){
            return newArr[startIndex];
        }else{
            return find(arr, k - 1, startIndex + 1);
        }

    }


}
