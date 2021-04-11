import java.util.*;

public class topic_five {

    //把下面给出的扁平化json数据用递归的方式改写成组织树的形式
    //  [
    //    {
    //      "id": "1",
    //      "name": "中国",
    //      "code": "110",
    //      "parent": ""
    //    },
    //    {
    //      "id": "2",
    //      "name": "北京市",
    //      "code": "110000",
    //      "parent": "110"
    //    },
    //    {
    //      "id": "3",
    //      "name": "河北省",
    //      "code": "130000",
    //      "parent": "110"
    //    },
    //    {
    //      "id": "4",
    //      "name": "四川省",
    //      "code": "510000",
    //      "parent": "110"
    //    },
    //    {
    //      "id": "5",
    //      "name": "石家庄市",
    //      "code": "130001",
    //      "parent": "130000"
    //    },
    //    {
    //      "id": "6",
    //      "name": "唐山市",
    //      "code": "130002",
    //      "parent": "130000"
    //    },
    //    {
    //      "id": "7",
    //      "name": "邢台市",
    //      "code": "130003",
    //      "parent": "130000"
    //    },
    //    {
    //      "id": "8",
    //      "name": "成都市",
    //      "code": "510001",
    //      "parent": "510000"
    //    },
    //    {
    //      "id": "9",
    //      "name": "简阳市",
    //      "code": "510002",
    //      "parent": "510000"
    //    },
    //    {
    //      "id": "10",
    //      "name": "武侯区",
    //      "code": "51000101",
    //      "parent": "510001"
    //    },
    //    {
    //      "id": "11",
    //      "name": "金牛区",
    //      "code": "51000102",
    //      "parent": "510001"
    //    }
    //  ];


    public static void main(String[] args) {

        List<String> idList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

        List<String> nameList = Arrays.asList("中国", "北京市", "河北省", "四川省", "石家庄市", "唐山市", "邢台市", "成都市", "简阳市", "武侯区", "金牛区");

        List<String> codeList = Arrays.asList("110", "110000", "130000", "510000", "130001", "130002", "130003", "510001", "510002", "51000101", "51000102");

        List<String> parentList = Arrays.asList("", "110", "110", "110", "130000", "130000", "130000", "510000", "510000", "510000", "510000");

        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0 ; i < idList.size() ; i++){
            Map map = new HashMap();
            map.put("id", idList.get(i));
            map.put("name", nameList.get(i));
            map.put("code", codeList.get(i));
            map.put("parent", parentList.get(i));
            list.add(map);
        }

        // 初始化
        System.out.println("原数据:" + list);

        for (Map map : list) {
            if (!("").equals(map.getOrDefault("parent", ""))) {
                String parent = (String) map.get("parent");
                for (Map map1 : list) {
                    if (parent.equals(map1.get("code"))) {
                        map1.put("child", map);
                    }
                }
            }
        }

        System.out.println(list);

    }

}
