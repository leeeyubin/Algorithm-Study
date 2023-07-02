import java.util.*;
public class Knight {
    static int n, width;
    static int[][] pos = {{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}};
    static int[] start, end;
    static int arr[][];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        start = new int[2];
        end = new int[2];
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            width = scanner.nextInt();
            arr = new int[width][width];
            start[0] = scanner.nextInt();
            start[1] = scanner.nextInt();
            end[0] = scanner.nextInt();
            end[1] = scanner.nextInt();

            bfs(width, start, end);
            result[i] = arr[end[0]][end[1]];
        }
        for(int i = 0; i < n; i++)
            System.out.println(result[i]);

        scanner.close();
    }
    public static void bfs(int width, int[] start, int[] end){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int startX = temp[0];
            int startY = temp[1];

            if(startX == end[0] && startY == end[1])
                return;

            for(int i = 0; i < pos.length; i++){
                int movedX = pos[i][0] + startX;
                int movedY = pos[i][1] + startY;

                if(movedX >= 0 && movedX < width && movedY >= 0 && movedY < width && arr[movedX][movedY] == 0){
                   arr[movedX][movedY] = arr[startX][startY] + 1;
                    q.offer(new int[]{movedX, movedY});
                }
            }
        }
    }
}
