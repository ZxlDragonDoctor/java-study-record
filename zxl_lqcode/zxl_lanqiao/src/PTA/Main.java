package PTA;

import java.util.*;
import java.io.*;

public class Main{
    static long mod = (int)1e9 + 7;
    static int[] stack = new int[300010];
    static int top = 0;
    public static void leftDfs(Tree v,Tree[] t){
        int index = v.value;
        stack[top++] = index;
        if(v.l==null&&v.r==null){
            return;
        }
        if(v.l!=null){
            int linx = v.l.value;
            leftDfs(t[linx],t);
        }
        if(v.r!=null){
            int rinx = v.r.value;
            leftDfs(t[rinx],t);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,r;
        n = sc.nextInt();
        r = sc.nextInt();
        Tree[] t = new Tree[n+1];
        for(int i=1;i<n+1;i++){
            t[i] = new Tree(i);
        }
        for(int i=0;i<n-1;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(t[x].l!=null){
                t[x].r = t[y];
            }else{
                t[x].l = t[y];
            }
        }
        leftDfs(t[r],t);
        for (int i = 0; i < top; i++) {
            System.out.println(stack[i]);
        }

    }
}

class Tree{
    int value;
    Tree l;
    Tree r;
    public Tree(int v){
        value = v;
    }
}
