import java.lang.*;
import java.util.Scanner;
public class Solution {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i=0; i<t; i++){
            int a = input.nextInt();
            int B = input.nextInt();
            int N = input.nextInt();
            solove(input,a+1,B);
        }
        input.close();
    }

    public static void solove(Scanner input, int l, int r) {
        int mid = (l + r) >> 1;
        System.out.println(mid);
        String s = input.next();
        if(s.equals("CORRECT")){
            return;
        }
        else if(s.equals("TOO_SMALL")){
            solove(input,mid+1,r);
        }
        else{
            solove(input,l,mid-1);
        }
    }
}
