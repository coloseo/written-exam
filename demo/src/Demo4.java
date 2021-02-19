import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author SamKK
 * @version 1.0
 * @date 2021/2/18 23:45
 */
public class Demo4 {
    public static void main(String[] args) {
        String inner = "[{\n" +
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
        List<Object> parses = (List) JSON.parse(inner);
        List<Object> result = new ArrayList<>();
        Set<String> out = new HashSet<>();
        for (int i = 0; i < parses.size(); i++) {
            Object ob = parses.get(i);
            Map<String, String> map = JSONObject.parseObject(JSONObject.toJSONString(ob), Map.class);
            String value = map.get("serial");
            if (out.contains(value)) {
                continue;
            }
            result.add(ob);
            out.add(value);
        }
        System.out.println(JSONArray.toJSON(result));
    }
}
