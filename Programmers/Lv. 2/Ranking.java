import java.util.*;
public class Ranking {
    private HashMap<String, List<Integer>> hs = new HashMap<String, List<Integer>>();
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] result = solution(info, query);
        System.out.println(Arrays.toString(result));
    }
    public static int[] solution(String[] info, String[] query) {
        Ranking ranking = new Ranking();
        return ranking.queries(info, query);
    }
    private int[] queries(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int i = 0; i < info.length; i++) {
            String[] myInfo = info[i].split(" ");
            makeSentence(myInfo, "", 0);
        }
        for (List<Integer> list : hs.values()) {
            Collections.sort(list);
        }
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] str = query[i].split(" ");
            answer[i] = hs.containsKey(str[0]) ? binarySearch(str[0], Integer.parseInt(str[1])) : 0;
        }
        return answer;
    }
    private int binarySearch(String key, int score) {
        List<Integer> list = this.hs.get(key);
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < score)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return list.size() - left;
    }
    private void makeSentence(String[] myInfo, String s, int i) {
        if (i == 4) {
            if (!this.hs.containsKey(s)) {
                List<Integer> list = new ArrayList<>();
                this.hs.put(s, list);
            }
            this.hs.get(s).add(Integer.parseInt(myInfo[4]));
            return;
        }
        makeSentence(myInfo, s +  "-", i + 1);
        makeSentence(myInfo, s + myInfo[i], i + 1);
    }
}
