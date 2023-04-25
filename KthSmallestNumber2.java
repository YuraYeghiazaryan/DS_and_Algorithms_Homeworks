public class KthSmallestNumber2 {
    public static void main(String[] args) {
        int[] arr = {5, 0, 1, 53, 25, 7, 58, 26, 13};
        int min1 =find(4, arr);
        System.out.print("The result of second way: ");
        System.out.println(min1);
    }

    public static int find(int k, int[] arr){
        // copy array
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);

        return finder(k, newArr, 0, arr.length - 1);
    }
    private static int finder(int k, int[] arr, int leftIndex, int rightIndex){

        int pivotIndex = sortByPivot(arr, leftIndex, rightIndex);

        // if before pivotIndex there are k and many elements,
        // so  the k-th smallest element in arr[leftIndex: pivotIndex - 1]

        if (pivotIndex + 1 - leftIndex > k){
            return finder(k, arr, leftIndex, pivotIndex-1);

            // if the pivotIndex equals k
            // so the pivot element is the k-th smallest
        } else if ( pivotIndex + 1 - leftIndex == k) {
            return arr[pivotIndex];

        // if before pivotIndex there aren't k elements
        // so the k-th smallest element in arr[pivotIndex + 1: rightIndex]
        } else{
            return finder(k - (pivotIndex + 1), arr, pivotIndex + 1, rightIndex);
        }

    }

    /** swapping to elements */
    private static void swap(int[] arr, int left, int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    /** The method take the first element us pivot and sorting array by pivot
     * @result  arr[0], arr[1] ... < pivot < arr[pivotIndex+1], ...
     * @return index of pivot*/
    private static int sortByPivot(int[] arr, int leftIndex, int rightIndex){
        int pivot = arr[leftIndex];

        while (rightIndex  > leftIndex) {
            boolean b = true;
            if (pivot > arr[rightIndex]){
                swap(arr, leftIndex, rightIndex);
                while(b & rightIndex > leftIndex ){
                    if (pivot < arr[leftIndex]){
                        swap(arr, leftIndex, rightIndex);
                        b = false;
                    }else leftIndex++;
                }
            }else rightIndex--;
        }
        return leftIndex;
    }
}
