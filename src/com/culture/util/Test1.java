package com.culture.util;

import java.util.Scanner;

public class Test1
{
//    public static void main(String[] args)
//    {
//            String string = "abcbaa";
//            char[] chars = string.toCharArray();
//            int length = string.length();
//            int dp[][] = new int[length+1][length+1];
// 
//            for(int i=0; i<length; i++)
//            {
//                for(int j=0; j<length; j++)
//                {
//                    if(chars[i] == chars[length - j - 1])
//                    {
//                        dp[i+1][j+1] = dp[i][j] + 1;
//                    }
//                    else
//                    {
//                        dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j])>dp[i][j]? Math.max(dp[i][j+1],dp[i+1][j]):dp[i][j];
//                    }
//                }
//            }
//            System.out.print(length - dp[length][length]);
//    }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int groups = sc.nextInt();
            while (groups-- > 0){
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] res = new int[2*n];
                for(int i=0;i<2*n;i++){
                    int tmp = i + 1;
                    for(int j = 0; j < k;j++){
                        if (tmp <= n) tmp = 2*tmp - 1;
                        else tmp = 2 * (tmp - n);
                    }
                    res[tmp - 1]=sc.nextInt();
                }
                 //输出
                if(res.length> 0) System.out.print(res[0]);
                for(int i = 1;i< 2*n;i++){
                    System.out.print(" "+res[i]);
                }
                System.out.println();
          }
    }
}