package Dp;

import java.util.Scanner;
//leetcode 72.编辑距离
@SuppressWarnings({"all"})
class Solution {
    public int min(int a,int b,int c){
      if(a<b){
          if(a<c){
              return a;
          }else {
              return c;
          }
      }
      if(a>b){
          if(b<c){
              return b;
          }else {
              return c;
          }
      }
      if(b<c){
          return b;
      }else {
          return c;
      }
    }
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int [][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                dp[i][j] = 0;
            }
        }
        //给定初值
        dp[0][0] = 0;
        for(int i=1;i<=len1;i++){
            dp[i][0] = dp[i-1][0]+1;
        }
        for(int j=1;j<=len2;j++){
            dp[0][j] = dp[0][j-1]+1;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[len1][len2];
    }

    public  static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s =scanner.next();
        String p =scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.minDistance(s,p));
    }
}