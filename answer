> 递归逆序

```java
String f(String s){
        if(s.length()<2) return s;
        char l = s.charAt(0);
        char r = s.charAt(s.length()-1);
        return r+f(s.substring(1,s.length()-1))+l;
}
```

> 逆波兰

这里的Integer只是便于书写，真实应该使用Double，因为除的时候会产生小数

```java
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Calculate {
    public static void main(String[] args) {
        //input 2 3 4 + *
        //prepare two stacks
        Stack<Integer> num = new Stack<Integer>();
        Stack<String> ops = new Stack<String>();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String n = in.next();
            if(isOp(n)){
                ops.push(n);
            } else {
                num.push(Integer.parseInt(n));
            }
        }
        //start calculate
        while(!ops.isEmpty()){
            Integer i1 = num.pop();
            Integer i2 = num.pop();
            String op = ops.pop();
            Integer r = calculate(i1,i2,op.charAt(0));
            num.push(r);
        }
        //result
        System.out.println(num.pop());
        
    }

    private static Integer calculate(Integer i1, Integer i2, char op) {
        Integer result = -1;
        switch (op){
            case '+':
                result = i2+i1;
                break;
            case '-':
                result = i2-i1;
                break;
            case '*':
                result = i2*i1;
                break;
            case '/':
                result = i2/i1;
                break;
            case '%':
                result = i2%i1;
                break;
        }
        return result;
    }

    private static boolean isOp(String op){
        return Arrays.asList("+", "-", "*", "/", "%").contains(op);
    }

}
```

> 归并排序

```java
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,1,4,1,5,9,2,6};
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
```

> JSON去重与JSON树生成

```java
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;


public class JsonParse {
    public static void main(String[] args) throws JsonProcessingException {
        String json = " [{\n" +
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
                "  }];";
        //这里Java没有提供JSON的原生解析类，个人想到的办法有两种
        //1.使用第三方Json解析技术，如Jackson、Gson、fastJson等
        //2.使用正则表达式进行模式匹配，解析出字段和对应的值，然后再通过Java反射映射为对象再进行后续操作（模式匹配未完成）
        //故就使用方法一
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = mapper.readValue(json, List.class);
        //去重
        TreeSet<String> set = new TreeSet<>();
        ArrayList<User> result = new ArrayList<>();
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(set.contains(user.serial)) continue;
            result.add(user);
            set.add(user.serial);
        }
        System.out.println(users);
    }
}

class User implements Serializable {
    String name;
    String serial;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
```

树生成

```java
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;


public class JsonParse {
    public static void main(String[] args) throws JsonProcessingException {
        String json = " [\n" +
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
                "  ];";
        //同上
        ObjectMapper mapper = new ObjectMapper();
        List<Location> users = mapper.readValue(json, List.class);
        //节点处理
        Location root = null;
        Iterator<Location> iterator = users.iterator();
        ArrayList<Location> finish = new ArrayList<>();
        while(iterator.hasNext()){
            Location location = iterator.next();
            if("".equals(location)){
                root = location;
            } else {
                //遍历
                for(int i=0;i<finish.size();i++){
                    if(finish.get(i).id.equals(location.parent)){
                        location.p = finish.get(i);
                        break;
                    }
                }
            }
            finish.add(location);
            
        }
        System.out.println(finish);
    }
}

class Location implements Serializable {
    String id;
    String name;
    String code;
    String parent;
    Location p;
}
```

