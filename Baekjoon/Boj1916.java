import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class Node implements Comparable<Node> {
    public int end, weight;
    public Node(int end, int weight){
        this.end = end; this.weight = weight;
    }
    @Override
    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}
public class Boj1916 {
    static int N, M;
    static ArrayList<ArrayList<Node>> a ;
    static int[] dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        a = new ArrayList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i<=N; i++)
            a.add(new ArrayList<>());
        for(int i = 0; i < M; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int weight = scanner.nextInt();
            a.get(start).add(new Node(end, weight));
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int res = dijkstra(start, end);
        System.out.println(res);
        scanner.close();
    }
    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        boolean[] check = new boolean[N + 1];
        dist[start]= 0;
        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            int cur = currNode.end;
            if(!check[cur]){
                check[cur] = true;
                for(Node node : a.get(cur)){
                    if(!check[node.end] && dist[node.end] > dist[cur] + node.weight){
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}