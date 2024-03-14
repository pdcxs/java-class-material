public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            boolean isChange = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isChange = true;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

            if (!isChange) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 4, 0, 1, -1, 10, 5};
        printArray(arr);
        BubbleSort.sort(arr);
        printArray(arr);
    }

    static void printArray(int[] arr) {
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.append("]").toString());
    }
}
