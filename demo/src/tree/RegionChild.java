package tree;

import java.util.List;

/**
 * @author SamKK
 * @version 1.0
 * @date 2021/2/18 23:52
 */
public class RegionChild {

    private String id;

    private String name;

    private String code;

    private String parent;

    private List<RegionChild> child;

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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public List<RegionChild> getChild() {
        return child;
    }

    public void setChild(List<RegionChild> child) {
        this.child = child;
    }
}
