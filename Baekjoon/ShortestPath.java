import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class Node implements Comparable<Node>{
    public int end, weight;
    public Node(int end, int weight){
        this.end = end; this.weight = weight;
    }
    @Override
    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}
public class ShortestPath {
    static int V, E, K;
    static ArrayList<ArrayList<Node>> a;
    static boolean[] check;
    static int[] dist;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        E = scanner.nextInt();
        K = scanner.nextInt();
        a = new ArrayList<>();
        for(int i = 0; i <= V; i++)
            a.add(new ArrayList<>());
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < E; i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            a.get(u).add(new Node(v ,w));
        }
        StringBuilder sb = new StringBuilder();
        dijkstra(K);
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
        scanner.close();
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        check = new boolean[V + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;
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
    }
}