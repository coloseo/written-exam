package pers.xqs.algorithm;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JSON转树 {
    @Test
    public void json2TreeTest() {
        String json = "[\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"中国\",\n" +
                "      \"code\": \"110\",\n" +
                "      \"parent\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"name\": \"北京市\",\n" +
                "      \"code\": \"110000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"3\",\n" +
                "      \"name\": \"河北省\",\n" +
                "      \"code\": \"130000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"4\",\n" +
                "      \"name\": \"四川省\",\n" +
                "      \"code\": \"510000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"5\",\n" +
                "      \"name\": \"石家庄市\",\n" +
                "      \"code\": \"130001\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"6\",\n" +
                "      \"name\": \"唐山市\",\n" +
                "      \"code\": \"130002\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"7\",\n" +
                "      \"name\": \"邢台市\",\n" +
                "      \"code\": \"130003\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"8\",\n" +
                "      \"name\": \"成都市\",\n" +
                "      \"code\": \"510001\",\n" +
                "      \"parent\": \"510000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"9\",\n" +
                "      \"name\": \"简阳市\",\n" +
                "      \"code\": \"510002\",\n" +
                "      \"parent\": \"510000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"10\",\n" +
                "      \"name\": \"武侯区\",\n" +
                "      \"code\": \"51000101\",\n" +
                "      \"parent\": \"510001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"11\",\n" +
                "      \"name\": \"金牛区\",\n" +
                "      \"code\": \"51000102\",\n" +
                "      \"parent\": \"510001\"\n" +
                "    }\n" +
                "  ]";
        System.out.println(jsonToTree(json));

    }

    public static String jsonToTree(String json) {
        List<Addr> addrs = JSON.parseArray(json, Addr.class);
        Map<String, Addr> collect = addrs.stream().collect(Collectors.toMap(Addr::getCode, x -> x));
        Addr root = null;
        for (String code : collect.keySet()) {
            Addr addr = collect.get(code);
            if (!"".equals(addr.getParent())) {
                String parentCode = addr.getParent();
                Addr parent = collect.get(parentCode);
                List<Addr> children = parent.getChildren();
                if (children == null) {
                    children = new ArrayList<>();
                }
                children.add(addr);
                parent.setChildren(children);
            } else {
                root = addr;
            }
        }

        return JSON.toJSONString(root);
    }

    /*

    结果格式后
    {
    "children":[
        {
            "children":[
                {
                    "code":"130001",
                    "id":"5",
                    "name":"石家庄市",
                    "parent":"130000"
                },
                {
                    "code":"130002",
                    "id":"6",
                    "name":"唐山市",
                    "parent":"130000"
                },
                {
                    "code":"130003",
                    "id":"7",
                    "name":"邢台市",
                    "parent":"130000"
                }
            ],
            "code":"130000",
            "id":"3",
            "name":"河北省",
            "parent":"110"
        },
        {
            "children":[
                {
                    "children":[
                        {
                            "code":"51000102",
                            "id":"11",
                            "name":"金牛区",
                            "parent":"510001"
                        },
                        {
                            "code":"51000101",
                            "id":"10",
                            "name":"武侯区",
                            "parent":"510001"
                        }
                    ],
                    "code":"510001",
                    "id":"8",
                    "name":"成都市",
                    "parent":"510000"
                },
                {
                    "code":"510002",
                    "id":"9",
                    "name":"简阳市",
                    "parent":"510000"
                }
            ],
            "code":"510000",
            "id":"4",
            "name":"四川省",
            "parent":"110"
        },
        {
            "code":"110000",
            "id":"2",
            "name":"北京市",
            "parent":"110"
        }
    ],
    "code":"110",
    "id":"1",
    "name":"中国",
    "parent":""
}
     */
}
