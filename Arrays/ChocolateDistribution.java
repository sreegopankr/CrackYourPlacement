import java.util.*;

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        a.sort((p,q) -> p-q);
        
        int i=0, j=m-1;
        long minDiff = Integer.MAX_VALUE;
        
        while(j<n){
            minDiff = Math.min(minDiff, (a.get(j) - a.get(i)));
            i++;
            j++;
        }
        return minDiff;
    }
}