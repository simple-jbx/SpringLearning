package tech.snnukf.spring;

/**
 * @author simple.jbx
 * @className MyFactory
 * @description 工厂接口
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2021/12/30/ 19:21
 */
public interface MyFactory {
    
    /**
     * @author simple.jbx
     * @description 通过id属性值获取对象
     * @date 19:22 2021/12/30
     * @param	id
     * @return 
     **/
    public Object getBean(String id);
}
