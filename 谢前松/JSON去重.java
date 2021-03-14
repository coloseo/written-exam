package pers.xqs.algorithm;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JSON去重 {


    @Test
    public void jsonTest() {
        String json = "[{\n" +
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

        System.out.println(duplicateRemoval(json));

    }

    public static String duplicateRemoval(String json) {
        Map<String, String> map = JSON.parseArray(json, User.class)
                .stream()
                .collect(Collectors.toMap(User::getSerial, User::getName, (oldValue, newValue) -> oldValue));
        List<User> users = new ArrayList<>(map.size());
        for (String key : map.keySet()) {
            users.add(new User(key, map.get(key)));
        }
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getSerial().compareTo(o2.getSerial());
            }
        });
        return JSON.toJSONString(users);
    }
    /*
    结果
    [{"name":"张三","serial":"0001"},{"name":"李四","serial":"0002"},{"name":"王五","serial":"0003"},{"name":"赵四","serial":"0004"},{"name":"小明","serial":"005"},{"name":"小张","serial":"006"}]

     */
}
