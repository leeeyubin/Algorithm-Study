import java.util.*;
public class GoTravel {
    static int[] root;
    public static int find(int x){
        if(root[x] == x)
            return x;
        else return find(root[x]);
    }
    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        root[rootA] = rootB;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cityNumber = scanner.nextInt();
        int cityTravel = scanner.nextInt();
        int[][] connection = new int[cityNumber + 1][cityNumber + 1];

        root = new int[cityNumber + 1];
        for (int i = 0; i < cityNumber; i++)
            root[i] = i;

        for (int i = 1; i <= cityNumber; i++) {
            for (int j = 1; j <= cityNumber; j++) {
                connection[i][j] = scanner.nextInt();
                if (connection[i][j] == 1 && connection[j][i] == 0)
                    union(i, j);
            }
        }

        int[] goTravel = new int[cityTravel];
        for (int i = 0; i < cityTravel; i++)
            goTravel[i] = scanner.nextInt();


        for (int i = 0; i < cityTravel - 1; i++) {
            if (find(goTravel[i]) != find(goTravel[i + 1])) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
        scanner.close();
    }
}
