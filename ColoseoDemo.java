package cn.coloseo;

public class ColoseoDemo {
    public static void main(String[] args) {
        /*编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。*/
        String s = "abcd";
        String[] split = s.split("");
        String[] strings = reverse1(split,split.length);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        String s1 = sb.toString();
        System.out.println(s1);


    }

    public static String[] reverse1(String[] split,int len){
        if (len>1) {
            for (int i = 0; i < len - 1; i++) {
                String temp = split[i];
                split[i] = split[i+1];
                split[i+1] = temp;
            }
            len--;
            reverse1(split, len);
        }
        return split;
    }
}
