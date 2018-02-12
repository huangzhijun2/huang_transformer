package com.huang.test;

public class Demo1 {
    public static void main(String[] args) {
        String[] arg = new String[]{"-d","2018-02-11"};

        String ss = processArgs(arg);
        System.out.println(ss);

    }
    private static String processArgs(String[] args){
        String date = null;
        for(int i=0;i<args.length;i++){
            if("-d".equals(args[i])){
                if(i+1<args.length){
                    date = args[++i];
                    break;
                }
            }
        }
        return date;
    }

}
