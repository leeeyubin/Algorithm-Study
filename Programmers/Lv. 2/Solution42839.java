import java.util.HashSet;
import java.util.Iterator;

public class Solution42839 {
    public int solution(String numbers) {
        HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        permutation("", numbers, hs);
        Iterator<Integer> it = hs.iterator();
        while(it.hasNext()){
            int n = it.next();
            if(n == 2)
                count++;
            if(n%2!=0 && isPrime(n)){
                count++;
            }
        }
        return count;
    }
    public boolean isPrime(int n){
        if(n == 0 || n == 1)
            return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
    public void permutation(String currPermutation, String numbers, HashSet<Integer> hs){
        int num = numbers.length();
        if(!currPermutation.isEmpty())
            hs.add(Integer.valueOf(currPermutation));
        for(int i = 0; i<num; i++)
        permutation(currPermutation + numbers.charAt(i), numbers.substring(0,i) + numbers.substring(i+1, num), hs);
    }
}