import java.util.Scanner;
import java.util.Arrays;
public class Good {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i= 0; i<arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        int count = 0, sum = 0;
        Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++){
            sum += find(arr,0, n-1, i, count);
        }
        System.out.println(sum);
        scanner.close();
    }
    public static int find(int[] arr, int start, int end, int i, int count) {
        if (start == i)
            start++;
        if (end == i)
            end--;
        if (start >= end)
            return count;
        if (arr[start] + arr[end] == arr[i])
            count++;
        else if (arr[start] + arr[end] > arr[i])
            return find(arr, start, end - 1, i, count);
         else
            return find(arr, start + 1, end, i, count);
        return count;
    }
}