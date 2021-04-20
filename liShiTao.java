package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class liShiTao {
    public static void main(String[] args) {
        //1 实现
        System.out.println(reverse("123dsa"));
        //2
        System.out.println(export(new String[]{"2", "1", "+", "3", "*"}));
        //3 未实现
        for (Integer i :
                getSort(getSort(new Integer[]{3,1,4,1,5,9,2,6}))) {
            System.out.println(i);
        }

        //4 实现
        String s="[{\n" +
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
        System.out.println(getJson(s));
        //5:未实现
    }
    //反转
    public static String reverse(String s){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=s.length()-1;i>=0;i--){
            stringBuilder.append(s.charAt(i));
        }
        return  stringBuilder.toString();
    }
    //逆波兰表达式
    public static Double export(String[] strings){
        Stack<Double> stack=new Stack<>();
        for (String c :
                strings) {
                if (getSymbol(c)==0){
                    stack.push(Double.parseDouble(c));
                }else{
                    Double count;
                    if (getSymbol(c)==1){
                        count=0.0;
                        while (!stack.empty()){
                            count-=stack.pop();
                        }
                    }else if (getSymbol(c)==2){
                        count=0.0;
                        while (!stack.empty()){
                            count+=stack.pop();
                        }
                    }else if (getSymbol(c)==3){
                        count=1.0;
                        while (!stack.empty()){
                            count*=stack.pop();
                        }
                    }else{
                        count=stack.pop();
                        while (!stack.empty()){
                            count/=stack.pop();
                        }
                    }
                    stack.push(count);
                }
        }
        return stack.pop();
    }
    //判断符号
    public static Integer getSymbol(String s){
        if (s.equals("-")){
            return 1;
        }
        if (s.equals("+")){
            return 2;
        }
        if (s.equals("*")){
            return 3;
        }
        if (s.equals("/")){
            return 4;
        }
        return 0;
    }



    //归并排序 sort (网上参考)
    public static Integer[] getSort(Integer[] integers){
        int len=integers.length;
        Integer[] result = new Integer[len];
        int block, start;

        for(block = 1; block < len*2; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = Math.min((start + block), len);
                int high = Math.min((start + 2 * block), len);

                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;

                while (start1 < end1 && start2 < end2) {
                    result[low++] = integers[start1] < integers[start2] ? integers[start1++] : integers[start2++];
                }
                while(start1 < end1) {
                    result[low++] = integers[start1++];
                }
                while(start2 < end2) {
                    result[low++] = integers[start2++];
                }
            }
            Integer[] temp = integers;
            integers = result;
            result = temp;
        }
        result = integers;
        return result;
    }



    //json 字符串去重
    public  static String getJson(String s){
        List<JsonEntity> list=new ArrayList<>();
        //去除[]
        String s1=s.substring(1,s.length()-1);
        //得到数组
        String[] strings=s1.split("},");
        for (String temps :
                strings) {
            //去除 {}
            temps=temps.substring(1);
            String[] strings1=temps.split(",");
            String[] keys=strings1[0].split(":");
            JsonEntity jsonEntity=new JsonEntity();
            jsonEntity.setName(keys[1]);

            String[] keys2=strings1[1].split(":");
            jsonEntity.setSerial(keys2[1]);
            list.add(jsonEntity);
        }
        //去重
        list=list.stream().filter(distinctByKey(JsonEntity::getSerial)).collect(Collectors.toList());
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("[");
        for (int i=0 ;i<list.size();i++) {
            JsonEntity j=list.get(i);
            String s2;
            if (i==list.size()-1){
               s2="{"+"\"name\":"+j.getName()+",\"serial\":"+j.getSerial()+"}";
            }else {
                s2 = "{" + "\"name\":" + j.getName()  + ",\"serial\":" + j.getSerial() + "},";
            }
            stringBuilder.append(s2);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    //实体去重
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
class JsonEntity{
    private String name;
    private String serial;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
