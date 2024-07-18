// class Solution {
//     public int maxProfit(int[] prices) {
//         int bp = prices[0];
//         int profit=0;
//         for(int i=1;i<prices.length;i++){
//             if(prices[i]<bp){
//                 bp=prices[i];
//             }
//             else{
//                 int sp = prices[i];
//                 profit = Math.max(profit,sp-bp);
//             }
            
//         }

//         return profit;
//     }
// }