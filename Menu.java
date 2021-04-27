import lombok.Builder;
import lombok.Data;
import org.junit.Test;
import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Builder
public class Menu {
    public Integer id;
    public String name;
    public Integer code;
    public Integer parent;
    public List<Menu> childlist;

    public Menu(Integer id, String name, Integer code, Integer parent) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parent = parent;
    }

    public Menu(Integer id, String name, Integer code, Integer parent, List<Menu> childlist) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parent = parent;
        this.childlist = childlist;
    }
    @Test
    public void test(){
        List<Menu> menus = Arrays.asList(
                new Menu(1,"中国",110,0),
                new Menu(2,"北京市",110000,110),
                new Menu(3,"河北省",130000,110),
                new Menu(4,"四川省",510000,110),
                new Menu(5,"石家庄市",130001,130000),
                new Menu(6,"唐山市",130002,130000),
                new Menu(7,"邢台市",130003,130000),
                new Menu(1,"成都市",510001,510000),
                new Menu(9,"简阳市",510002,510000),
                new Menu(10,"武侯区",51000101,510001),
                new Menu(11,"金牛区",51000102,510001));
        List<Menu> collect = menus.stream()
                .filter(m -> m.getParent() == 0)
                .map((m) -> {
                            m.setChildlist(getChildrens(m, menus));
                            return m;
                        }
                ).collect(Collectors.toList());
        System.out.println("----转json输出结果----");
        System.out.println(JSON.toJSON(collect));
    }
    private static List<Menu> getChildrens(Menu root,List<Menu> all){
        List<Menu> children = all.stream().filter(m -> {
            return Objects.equals(m.getParent(),root.getId());
        }).map(
                (m) -> {
                    m.setChildlist(getChildrens(m,all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }
}
