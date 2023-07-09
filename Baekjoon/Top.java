import java.util.*;
import java.io.*;
class Node{
    public int num;
    public int height;
    public Node(int num, int height){
        this.num = num; this.height = height;
    }
}
public class Top {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack = new Stack<>();
        int[] answer = new int[N];
        for(int i = 1; i<= N; i++){
            int height = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
                answer[i-1] = 0;
                stack.push(new Node(i, height));
            }else{
                while(!stack.isEmpty()){
                   Node node = stack.peek();
                    if (node.height > height) {
                        answer[i - 1] = node.num;
                        break;
                    }else {
                        stack.pop();
                    }
                }
                stack.push(new Node(i, height));
            }
        }
        for(int i = 0; i < N; i++)
            System.out.print(answer[i] + " ");
        bw.close();
        br.close();
    }
}