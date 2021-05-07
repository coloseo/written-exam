```java
/**
 * 编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
 */
public class ReverseString {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverse(str));
    }

    public static String reverse(String str) {
        if (str == null || str.length() == 1) {
            return str;
        }
        String s = str.substring(1);
        return reverse(s) + str.charAt(0);
    }
}
```

```java
/**
 * 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
 */
public class CalcNum {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        String express = sin.nextLine();
        System.out.println(calcRevPolishNotation(express));
    }

    public static int calcRevPolishNotation(String express){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <express.length() ;i++) {
            // 普通数值的处理
            if ((express.charAt(i) + "").matches("\\d")){
                stack.push(express.charAt(i) + "");
                // + - * / 运算符的处理
            }else if ((express.charAt(i) + "").matches("[\\+\\-\\*\\/]")){
                String k1 = stack.pop();
                String k2 = stack.pop();
                // 计算结果
                int res = calcValue(k1, k2, (express.charAt(i) + ""));
                stack.push(res+"");
            }

        }
        return Integer.valueOf(stack.pop());
    }
    //根据运算符计算结果
    private static int calcValue(String k1, String k2, String c) {
        switch(c){
            case "+":
                return Integer.valueOf(k1)+Integer.valueOf(k2);
            case "-":
                return Integer.valueOf(k2)-Integer.valueOf(k1);
            case "*":
                return Integer.valueOf(k1)*Integer.valueOf(k2);
            case "/":
                return Integer.valueOf(k2)/Integer.valueOf(k1);
            default:
                throw new RuntimeException("没有该类型的运算符！");
        }
    }
}
```

```java
/**
 * 用归并排序将3，1，4，1，5，9，2，6 排序。
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] tmpArray = new int[data.length];
        mergeSort(data, 0, data.length - 1, tmpArray);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
    public static void mergeSort(int[] data, int left, int right, int[] tmpArray) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(data, left, center, tmpArray);
            mergeSort(data, center + 1, right, tmpArray);
            merge(data, left, center, right, tmpArray);
        }
    }
    public static void merge(int[] data, int left, int center, int right, int[] tmpArray) {
        int i = left;
        int j = center + 1;
        int k = 0;

        while (i <= center && j <= right) {
            if (data[i] > data[j]) {
                tmpArray[k++] = data[j++];
            } else {
                tmpArray[k++] = data[i++];
            }
        }
        while (i <= center) {
            tmpArray[k++] = data[i++];
        }
        while (j <= right) {
            tmpArray[k++] = data[j++];
        }
        for (int t = 0; t < k; t++) {
            data[left + t] = tmpArray[t];
        }
    }
}
```

```java
/**
 * 对下面的 json 字符串 serial 相同的进行去重。
 */
public class JsonDistinct {
    public static void main(String[] args) {
        String data = "[{\"name\": \"张三\",\"serial\": \"0001\"}, {\"name\": \"李四\",\"serial\": \"0002\"}, {\"name\": \"王五\",\"serial\": \"0003\"}, {\"name\": \"王五2\",\"serial\": \"0003\"}, {\"name\": \"赵四\",\"serial\": \"0004\"}, {\"name\": \"小明\",\"serial\": \"005\"}, {\"name\": \"小张\",\"serial\": \"006\"}, {\"name\": \"小李\",\"serial\": \"006\"}, {\"name\": \"小李2\",\"serial\": \"006\"}, {\"name\": \"赵四2\",\"serial\": \"0004\"}]";
        JSONArray arr = JSONObject.parseArray(data);
        List<JSONObject> objList = arr.toJavaList(JSONObject.class);
        Map<String, String> map = objList.stream().filter(Objects::nonNull).collect(Collectors.toMap(item -> item.getString("name"), item -> item.getString("serial")));
        Map<String,String> map2 = new HashMap<>();
        for(String key : map.keySet()){
            if(!map2.containsValue(map.get(key))){
                map2.put(key, map.get(key));
            }
        }
        System.out.println(map2.toString());
    }
}
```

```java
/**
 * 把下面给出的扁平化json数据用递归的方式改写成组织树的形式
 */
public class JsonToTree {
    public static void main(String[] args) {
        String data = "[{\"id\": \"1\",\"name\": \"中国\",\"code\": \"110\",\"parent\": \"\" }," +
        "{\"id\": \"2\",\"name\": \"北京市\",\"code\": \"110000\",\"parent\": \"110\" }," +
        "{\"id\": \"3\",\"name\": \"河北省\",\"code\": \"130000\",\"parent\": \"110\" }," +
        "{\"id\": \"4\",\"name\": \"四川省\",\"code\": \"510000\",\"parent\": \"110\" }," +
        "{\"id\": \"5\",\"name\": \"石家庄市\",\"code\": \"130001\",\"parent\": \"130000\" }," +
        "{\"id\": \"6\",\"name\": \"唐山市\",\"code\": \"130002\",\"parent\": \"130000\" }," +
        "{\"id\": \"7\",\"name\": \"邢台市\",\"code\": \"130003\",\"parent\": \"130000\" }," +
        "{\"id\": \"8\",\"name\": \"成都市\",\"code\": \"510001\",\"parent\": \"510000\" }," +
        "{\"id\": \"9\",\"name\": \"简阳市\",\"code\": \"510002\",\"parent\": \"510000\" }," +
        "{\"id\": \"10\",\"name\": \"武侯区\",\"code\": \"51000101\",\"parent\": \"510001\" }," +
        "{\"id\": \"11\",\"name\": \"金牛区\",\"code\": \"51000102\",\"parent\": \"510001\" }]";
        JSONArray arr = JSONObject.parseArray(data);
        List<JSONObject> objList = arr.toJavaList(JSONObject.class);
        System.out.println(listToTree(objList.get(0), objList));
    }

    public static JSONObject listToTree(JSONObject obj, List<JSONObject> objList) {
        JSONArray tempJson = new JSONArray();
        for (int i = 0; i < objList.size(); i++) {
            if (objList.get(i).get("parent").equals(obj.get("code"))) {
                tempJson.add(objList.get(i));
            }
        }
        objList.removeAll(tempJson);
        for(int i = 0; i < tempJson.size(); i ++) {
            listToTree((JSONObject) tempJson.get(i), objList);
        }
        if(tempJson.size() != 0) {
            obj.put("children", tempJson);
        }
        return obj;
    }
}
```

