import com.alibaba.fastjson.JSONArray;

import java.util.HashSet;
import java.util.Set;


// 对下面的 json 字符串 serial 相同的进行去重。
public class jsonRemoval {
    public static void main(String[] args){
        String str = "[{\n" +
                "    \"name\": \"张三\",\n" +
                "    \"serial\": \"0001\"\n" +
                "  }, {\n" +
                "    \"name\": \"李四\",\n" +
                "    \"serial\": \"0002\"\n" +
                "  }, {\n" +
                "    \"name\": \"王五\",\n" +
                "    \"serial\": \"0003\"\n" +
                "  }, {\n" +
                "    \"name\": \"王五2\",\n" +
                "    \"serial\": \"0003\"\n" +
                "  }, {\n" +
                "    \"name\": \"赵四\",\n" +
                "    \"serial\": \"0004\"\n" +
                "  }, {\n" +
                "    \"name\": \"小明\",\n" +
                "    \"serial\": \"005\"\n" +
                "  }, {\n" +
                "    \"name\": \"小张\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"小李\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"小李2\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"赵四2\",\n" +
                "    \"serial\": \"0004\"\n" +
                "  }]";
        JSONArray jsonArray = JSONArray.parseArray(str);
        JSONArray results = JSONArray.parseArray("[]");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            if (set.contains(jsonArray.getJSONObject(i).get("serial")) ==false){
                set.add(jsonArray.getJSONObject(i).get("serial").toString());
                results.add(jsonArray.getJSONObject(i));
            }
        }
        System.out.println(results);
    }
}
