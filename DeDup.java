import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class DeDup {
    public void deDup(Map<String,String> m2){
        Map<String,String> m3 = new HashMap<>();
        for(String key:m2.keySet()){
            if(!m3.containsValue(m2.get(key))){
                m3.put(key,m2.get(key));
            }
        }
        System.out.println("去重后：" + m3);
    }
    @Test
    public void test(){
        Map<String,String> m1 = new HashMap<>();
        m1.put("张三","0001");
        m1.put("李四","0002");
        m1.put("王五","0003");
        m1.put("王五2","0003");
        m1.put("赵四","0004");
        m1.put("小明","005");
        m1.put("小张","006");
        m1.put("小李","006");
        m1.put("小李2","006");
        m1.put("赵四2","0004");
        System.out.println("去重前：" + m1);
        deDup(m1);
    }
}