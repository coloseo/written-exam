package pers.xqs.algorithm;

import java.util.List;

public class Addr {
    private String id;
    private String name;
    private String code;
    private String parent;
    private List<Addr> children;

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

    public List<Addr> getChildren() {
        return children;
    }

    public void setChildren(List<Addr> children) {
        this.children = children;
    }
}
