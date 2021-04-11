import java.util.*;

public class topic_four {

    // 对下面的 json 字符串 serial 相同的进行去重。

    //[{
    //    "name": "张三",
    //    "serial": "0001"
    //  }, {
    //    "name": "李四",
    //    "serial": "0002"
    //  }, {
    //    "name": "王五",
    //    "serial": "0003"
    //  }, {
    //    "name": "王五2",
    //    "serial": "0003"
    //  }, {
    //    "name": "赵四",
    //    "serial": "0004"
    //  }, {
    //    "name": "小明",
    //    "serial": "005"
    //  }, {
    //    "name": "小张",
    //    "serial": "006"
    //  }, {
    //    "name": "小李",
    //    "serial": "006"
    //  }, {
    //    "name": "小李2",
    //    "serial": "006"
    //  }, {
    //    "name": "赵四2",
    //    "serial": "0004"
    //  }];

    public static void main(String[] args) {

        List<String> nameList = Arrays.asList("张三", "李四", "王五", "王五2", "赵四", "小明", "小张", "小李", "小李2", "赵四2");

        List<String> codeList = Arrays.asList("0001", "0002", "0003", "0003", "0004", "005", "006", "006", "006", "0004");

        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0 ; i < nameList.size() ; i++){
            Map map = new HashMap();
            map.put("name", nameList.get(i));
            map.put("serial", codeList.get(i));
            list.add(map);
        }

        // 初始化
        System.out.println("原数据:" + list);

        List<Map<String, String>> newList = new ArrayList<>();

        // 去重
        Set set = new HashSet(codeList);

        for (Object code : set) {
            for (Map map : list) {
                if (map.getOrDefault("serial", "").equals(code)) {
                    newList.add(map);
                    break;
                }
            }
        }

        System.out.println("去重后:" + newList);
    }
}
