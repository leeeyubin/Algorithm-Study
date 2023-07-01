import java.util.*;
public class Picture {
    static int n, m;
    static int[][] arr;
    static ArrayList<Integer> a = new ArrayList<>();
    static boolean[][] visited;
    static int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static void bfs(int x, int y, int count){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while(!q.isEmpty()) {
             int[] temp = q.poll();
             int tempX = temp[0];
             int tempY = temp[1];
             for(int i = 0; i < move.length; i++){
                 int movedX = move[i][0] + tempX;
                 int movedY = move[i][1] + tempY;

                 if(movedX >= 0 && movedX < n && movedY >= 0 && movedY < m && !visited[movedX][movedY] && arr[movedX][movedY] != 0){
                     count++;
                     visited[movedX][movedY] = true;
                     q.offer(new int[]{movedX, movedY});
                 }
             }
        }
        a.add(count);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        boolean zero = true;

        for(int i = 0; i< n; i++)
            for(int j = 0; j < m; j++){
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] == 1) {
                    zero = false;
                }
            }

        if(zero == true){
            System.out.println("0");
            System.out.println("0");
            System.exit(0);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    int count = 1;
                    bfs(i, j, count);
                }
            }
        }
        Collections.sort(a);
        System.out.println(a.size());
        System.out.println(a.get(a.size() - 1));
        scanner.close();
    }
}