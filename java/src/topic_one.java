import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.List;

public class topic_one {

    // 面试岗位:Java后端工程师-邱嘉祺 微信/电话:18941149987

    // 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置

    public static void main(String[] args) {

        // 字符串s
        String s = "abcdef";

        // 倒置后的字符串newStr
        String newStr = "";

        // 从后往前倒置
        for (int i = s.length()-1 ; i >= 0 ; i--) {
            // 每获取到便新增newStr
            newStr += s.charAt(i);
        }

        // 打印输出结果
        System.out.println(newStr);

    }

}
