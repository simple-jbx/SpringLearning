package tech.snnukf.spring;

/**
 * @author simple.jbx
 * @ClassName MyBean
 * @description Bean 属性对象
 * 用来存储配置文件中bean标签对应的id和class属性值
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2021/12/30/ 19:07
 */
public class MyBean {
    private String id;
    private String clazz;

    public MyBean(String id, String clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
