import java.util.Queue;
import java.util.LinkedList;
public class TwoQueue {
    public int solution(int[] queue1, int[] queue2){
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int answer = 0, count = 0;
        long sum1 = 0, sum2 = 0;
        for(int i =0; i<queue1.length; i++){
            q1.offer(queue1[i]);
            sum1 += queue1[i];
        }
        for(int i=0; i<queue2.length;i++){
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        long total = (sum1 + sum2) / 2;
        while(true){
            int temp;
            if(total > sum1){
                temp = q2.poll();
                q1.offer(temp);
                sum1 += temp;
                sum2 -= temp;
                answer++;
            }
            if(total > sum2){
                temp = q1.poll();
                q2.offer(temp);
                sum1 -= temp;
                sum2 += temp;
                answer++;
            }
            count++;
            if(sum1 == sum2)
                break;
            if(count > 300000)
                return -1;
        }
        return answer;
    }
}