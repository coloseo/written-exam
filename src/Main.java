import com.google.gson.*;
import com.oracle.javafx.jmx.json.JSONReader;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.*;

public class Main {


    /**
     * 要求：1.编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置
     * @param str 需要反转的字符串
     * @return 反转后的字符串
     */
    public static String reverse(String str){
        if(str.length() <= 1){
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }


    /**
     * 要求：2.编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。例如，命令 expr 2 3 4 + *
     * @param tokens 输入的逆波兰式表达式
     * @return 返回计算后的值，未做逆波兰式有效性验证
     */
    public static int expr(String[] tokens) {
        if(tokens==null||tokens.length==0){
            return 0;
        }
        if(tokens.length==1){
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            String temp=tokens[i];
            if(temp.equals("+")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(a+b);
            }else if(temp.equals("*")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(a*b);
            }else if(temp.equals("-")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b-a);
            }else if(temp.equals("/")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b/a);
            }else{
                stack.add(Integer.parseInt(temp));
            }
        }
        return stack.pop();

    }


    /**
     * 要求：3.用归并排序将3，1，4，1，5，9，2，6 排序。
     * @param arr 需要排序的数组
     * @param left 左边开始下标
     * @param right 右边结束下标
     */

    public static void merSort(int[] arr,int left,int right){

        if(left<right){
            int mid = (left+right)/2;
            merSort(arr,left,mid);//左边归并排序，使得左子序列有序
            merSort(arr,mid+1,right);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right);//合并两个子序列
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid&&j<=right){
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[k++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[k++] = arr[j++];
        }
        //将temp中的元素全部拷贝到原数组中
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + left] = temp[k2];
        }
    }


    /**
     * 要求：4.对下面的 json 字符串 serial 相同的进行去重。
     * @return 去重后的json字符串
     */
    public static String deleteRepeat(){
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
                "  }]";

        JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
        Set set = new HashSet();
        for(int i = 0; i < jsonArray.size(); i++){
            JsonElement jsonElement = jsonArray.get(i);

            if (!set.add(jsonElement.getAsJsonObject().get("serial"))){
                jsonArray.remove(i);
                i--;
            }

        }


        return jsonArray.toString();
    }

    public static JsonArray tree(JsonArray jsonArray, String parentId){

        JsonArray jsonArray1 = new JsonArray();

        for(int i = 0; i < jsonArray.size(); i++){

            JsonObject jsonElement = jsonArray.get(i).getAsJsonObject();
            if (jsonElement.get("parent").getAsString().equals(parentId)){
                JsonObject jsonObject = new JsonObject();

                jsonObject.add("id", jsonElement.get("id"));
                jsonObject.add("name", jsonElement.get("name"));
                jsonObject.add("code", jsonElement.get("code"));
                jsonObject.add("child", tree(jsonArray, jsonElement.get("code").getAsString()));
                jsonArray1.add(jsonObject);

            }

        }


        return jsonArray1;
    }


    /**
     * 要求：5.把下面给出的扁平化json数据用递归的方式改写成组织树的形式
     * @return tree数据json字符串
     */
    public static String treeJson(){

        String json  = "[\n" +
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



        JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
        JsonArray jsonArray1 = new JsonArray();
        for (int i = 0; i < jsonArray.size(); i++){
            JsonObject jsonElement = jsonArray.get(i).getAsJsonObject();
            if (jsonElement.get("parent").getAsString().equals("")){
                JsonObject jsonObject = new JsonObject();
                jsonObject.add("id", jsonElement.get("id"));
                jsonObject.add("name", jsonElement.get("name"));
                jsonObject.add("code", jsonElement.get("code"));
                jsonObject.add("child", tree(jsonArray, jsonElement.get("code").getAsString()));
                jsonArray1.add(jsonObject);
            }

        }






        return jsonArray1.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverse("test"));
        System.out.print("请输逆波兰式,以空格来分割参数：");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(expr(s.split(" ")));

        int[] test = {3,1,4,1,5,9,2,6};
        merSort(test,0,test.length-1);
        for(int i=0; i<test.length;i++){
            System.out.print(test[i] + " ");
        }


        System.out.println(deleteRepeat());

        System.out.println(treeJson());



    }
}
