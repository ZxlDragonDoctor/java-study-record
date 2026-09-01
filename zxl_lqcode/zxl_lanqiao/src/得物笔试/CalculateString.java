package 得物笔试;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculateString {
    public static void main(String[] args) {
        // 123@3#1
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        String dst = "";
        dst = arr.replaceAll("#",",");
        dst = dst.replaceAll("@",",");
        String[] split = dst.split(",");
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            ans.add(Integer.parseInt(split[i]));
        }
        for (int i = 0; i < arr.length(); i++) {
            if(arr.charAt(i)=='#'){
                int mid = i;
                Integer a = 0;
                for(int l = mid-1;l>=0;l--){
                    if(arr.charAt(l)=='@' || arr.charAt(l) == '#'){
                        a = Integer.parseInt(arr.substring(l+1,mid));
                        break;
                    }
                    if(l==0){
                        a = Integer.parseInt(arr.substring(0,mid));
                        break;
                    }
                }
                Integer b = 0;
                for(int r = mid + 1;r<arr.length();r++){
                    if(arr.charAt(r)=='@' || arr.charAt(r)=='#'){
                        b = Integer.parseInt(arr.substring(mid+1,r));
                        break;
                    }
                    if(r==arr.length()-1){
                        b = Integer.parseInt(arr.substring(mid+1));
                        break;
                    }

                }
                Integer replaceNum = a - (a&b);
                ans.add(replaceNum);
                ans.remove(a);
                ans.remove(b);
            }
        }
        int sum = 0;
        for (Integer t :
                ans) {
            sum += t;

        }
        int q = 1 + (123-(123&3))+6;
        System.out.println(q);
        System.out.println(sum);

    }
}
