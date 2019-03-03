package json;

import net.sf.json.JSONObject;

import java.util.ArrayList;

/**
 * @Author：史泽颖
 * @Date： Create in  2019-03-04  3:28
 * @Description：把下面给出的扁平化json数据用递归的方式改写成组织树的形式
 */
public class TreeNode {
    private String id;
    private String parent;
    private String name;
    private String code;
    private ArrayList<TreeNode> children = new ArrayList<TreeNode>();

    public TreeNode(String id, String parent, String name, String code) {
        this.id = id;
        this.parent = parent;
        this.name = name;
        this.code = code;
    }

    public void add(TreeNode node) {//递归添加节点
        if ("1".equals(node.id)) {
            this.children.add(node);
        } else if (node.parent.equals(this.code)) {
            this.children.add(node);
        } else {
            for (TreeNode tmp_node : children) {
                tmp_node.add(node);
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TreeNode> children) {
        this.children = children;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("1", "", "中国", "110");
        TreeNode node = null;
        node = new TreeNode("2", "110", "北京市", "110000");
        root.add(node);
        node = new TreeNode("3", "110", "河北省", "130000");
        root.add(node);
        node = new TreeNode("4", "110", "四川省", "510000");
        root.add(node);
        node = new TreeNode("5", "130000", "石家庄市", "130001");
        root.add(node);
        node = new TreeNode("6", "130000", "唐山市", "130002");
        root.add(node);
        node = new TreeNode("7", "130000", "邢台市", "130003");
        root.add(node);
        node = new TreeNode("8", "510000", "成都市", "510001");
        root.add(node);
        node = new TreeNode("9", "510000", "简阳市", "510002");
        root.add(node);
        node = new TreeNode("10", "510001", "武侯区", "51000101");
        root.add(node);
        node = new TreeNode("11", "510001", "金牛区", "51000102");
        root.add(node);
        JSONObject obj = JSONObject.fromObject(root);
        System.out.println(obj.toString());
    }
}