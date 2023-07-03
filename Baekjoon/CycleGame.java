import java.util.*;
public class CycleGame {
    static int n, m;
    static int[] root;
    public static int find(int x){
        if(root[x] == x)
            return x;
        else return find(root[x]);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b)
            root[b] = a;
        else root[a] = b;
    }
    public static boolean isCycle(int x, int y) {
        return find(x)== find(y);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        root = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;

        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (isCycle(start, end)) {
                System.out.println(i + 1);
                return;
            }
            else union(start, end);
        }
        System.out.println(0);
        scanner.close();
    }
}
