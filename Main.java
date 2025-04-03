public class Main {
    public int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p - 1;
        for(int j = p; j <= (r -1); j++){
            if (A[j] <= x){
                i += 1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp2 = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp2;
        return i+1;
    }
    public int[] quickSort(int[] A, int p, int r){
        if (p < r){
            int q = partition(A, p, r);
            quickSort(A, p, q-1);
            quickSort(A, q+1, r);
        }
        return A;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        int[] array = {13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
        int p = 0;
        int r = array.length - 1;
        obj.quickSort(array, p, r);
        System.out.print("Sorted Array: ");
        for (int i = 0; i <= r; i ++){
            System.out.print(array[i] + ", ");
        }
        System.out.print("\b\b");
    }
}
