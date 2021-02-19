import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import tree.Region;
import tree.RegionChild;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SamKK
 * @version 1.0
 * @date 2021/2/18 23:51
 */
public class Demo5 {

    public static List<RegionChild> findFistParent(List<Region> regions) {
        List<RegionChild> first = new ArrayList<>();
        for (int i = 0; i < regions.size(); i++) {
            //先确定首，然后再递归寻找子
            Region region = regions.get(i);
            if (region.getParent() == null || region.getParent().equals("")) {
                RegionChild regionChild = new RegionChild();
                regionChild.setCode(region.getCode());
                regionChild.setId(region.getId());
                regionChild.setName(region.getName());
                regionChild.setParent(region.getParent());
                first.add(regionChild);
            }
        }

        // 已经确定好了父级,现在递归寻找子集
        for (RegionChild regionChild : first) {
            regionChild = findChild(regionChild, regions);
        }
        return first;
    }

    private static RegionChild findChild(RegionChild first, List<Region> regions) {
        String parentCode = first.getCode();
        List<RegionChild> regionChildren = new ArrayList<>();
        for (Region region : regions) {
            String parent = region.getParent();
            if (parent.equals(parentCode)) {
                RegionChild regionChild = new RegionChild();
                regionChild.setCode(region.getCode());
                regionChild.setId(region.getId());
                regionChild.setName(region.getName());
                regionChild.setParent(region.getParent());
                regionChildren.add(regionChild);
            }
        }

        if (regionChildren != null && regionChildren.size() != 0) {
            for (RegionChild regionChild : regionChildren) {
                findChild(regionChild, regions);
            }
        }
        first.setChild(regionChildren);
        return first;
    }

    public static void main(String[] args) {
        String inner = "[\n" +
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
        List<Region> parses = JSON.parseArray(inner, Region.class);
        List<RegionChild> child = findFistParent(parses);
        System.out.println(JSONArray.toJSON(child));
    }
}
