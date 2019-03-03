package json;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;



/**
 * @Author：史泽颖
 * @Date： Create in  2019-03-03  20:31
 * @Description：对下面的 json 字符串 serial 相同的进行去重。
 */
public class DelRepeat {
    public static JSONArray delRepeatIndexid(JSONArray array) {

        //合并相同serial的name值
        JSONArray arrayTemp = new JSONArray();

        int num = 0;
        for (int i = 0; i < array.size(); i++) {
            if (num == 0) {
                arrayTemp.add(array.get(i));
            } else {
                int numJ = 0;
                for (int j = 0; j < arrayTemp.size(); j++) {
                    JSONObject newJsonObjectI = (JSONObject) array.get(i);
                    JSONObject newJsonObjectJ = (JSONObject) arrayTemp.get(j);
                    String serialI = newJsonObjectI.get("serial").toString();
                    String nameI = newJsonObjectI.get("name").toString();

                    String serialJ = newJsonObjectJ.get("serial").toString();
                    String nameJ = newJsonObjectJ.get("name").toString();

                    if (serialI.equals(serialJ)) {
                        String newValue = nameI + "," + nameJ;
                        arrayTemp.remove(j);
                        JSONObject newObject = new JSONObject();
                        newObject.put("serial", serialI);
                        newObject.put("name", newValue);
                        arrayTemp.add(newObject);
                        break;
                    }
                    numJ++;
                }
                if (numJ - 1 == arrayTemp.size() - 1) {
                    arrayTemp.add(array.get(i));
                }
            }
            num++;
        }
        return arrayTemp;
    }

    public static void main(String[] args) {
        String string = " [{\n" +
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
        JSONArray objects = JSONArray.parseArray(string);
        System.out.println(delRepeatIndexid(objects));
    }
}
