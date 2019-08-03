import java.lang.*;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int icase = 0;
        while (t-- > 0){
            icase ++;
            long n = sc.nextLong();
            long result = Math.min(getNext(n)-n,n-getPre(n));
            System.out.println("Case #" + icase + ": " + result);
        }
    }
    public static long getPre(long n){
        int cnt = 0;
        long num[] = new long[20];
        do{
            num[cnt++] = n%10;
            n = n / 10;
        }while (n > 0);

        for(int i=cnt-1; i>=0; i--){
            if(num[i] % 2 == 1){
                num[i] --;
                for(int j=i-1; j>=0; j--){
                    num[j] = 8;
                }
                break;
            }
        }
        long ans = 0;
        for(int i=cnt-1; i>=0; i--){
            ans = ans * 10 + num[i];
        }
        return ans;
    }
    public static long getNext(long n){
        int cnt = 0;
        long num[] = new long[20];
        do{
            num[cnt++] = n % 10;
            n /= 10;
        }while (n > 0);

        num[cnt++] = 0;

        for(int i=cnt-1; i>=0; i--){
            if(num[i] % 2 == 1){
                if(num[i] == 9){
                    int j = i+1;
                    while (num[j] == 8) j++;
                    num[j] += 2;
                    while ((--j) >= 0){
                        num[j] = 0;
                    }
                }
                else{
                    num[i]++;
                    for(int j=i-1; j>=0; j--){
                        num[j] = 0;
                    }
                }
                break;
            }
        }
        long ans = 0;
        for(int i=cnt-1; i>=0; i--){
            ans = ans * 10 + num[i];
        }
        return ans;
    }
}