package tech.snnukf.spring;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author simple.jbx
 * @ClassName 模拟Spring实现
 * 1. 通过带参构造器得到对应的配置文件
 * 2. 通过dom4j解析配置文件（xml文件），
 * 得到List集合（存放bean标签的id和class属性值）
 * 3. 通过反射得到对应的实例化对象 遍历List集合获取对应class属性，利用
 * Class.forName(class).newInstance()
 * 4. 通过id属性值获取指定的实例化对象
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2021/12/30/ 19:22
 */
public class MyClassPathXmalApplicationContext implements MyFactory{

    /*存放从配置文件中获取到的bean标签信息（MyBean代表的是每一个bean标签）*/
    private List<MyBean> beanList;
    private Map<String, Object> beanMap = new HashMap<>();

    public MyClassPathXmalApplicationContext(String fileName) {

        /*通过dom4j解析配置文件（xml文件），得到List集合*/
        this.parseXml(fileName);

        /*通过反射得到对应的实例化对象，放置在Map对象*/
        this.instanceBean();
    }

    /**
     * @author simple.jbx
     * @description 通过反射得到对应的实例化队形，防止在Map中
     * 1. 判断对象集合是否为空，如果不为空则遍历集合，获取对象id和class属性
     * 2. 通过类的全路径名 反射得到实例化对象， Class.forName(class).newInstance()
     * 3. 将对应的id和实例化好的bean对象设置到Map对象中
     * @date 20:56 2021/12/30
     * @param
     * @return
     **/
    private void instanceBean() {
        //1.  判断对象集合是否为空，如果不为空，则遍历集合，获取对象的id和class属性
        if(beanList != null && beanList.size() > 0) {
            for (MyBean bean : beanList) {
                String id = bean.getId();
                String clazz = bean.getClazz();
                try {
                    // 2.通过类的全路径名 反射得到实例化对象
                    Object object = Class.forName(clazz).newInstance();
                    // 3.将对应的id和实例化好的bean对象设置到map对象中
                    beanMap.put(id, object);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @author simple.jbx
     * @description 通过dom4j解析配置文件，得到List集合
     * 1. 获取解析器
     * 2. 获取配置文件的URL
     * 3. 通过解析器解析配置文件（xml文件）
     * 4. 通过xpath语法解析，获取beans标签下的所有bean标签
     * 5. 通过指定解析语法解析文档对象，返回元素集合
     * 6. 判断元素集合是否为空
     * 7. 集合不为空，遍历集合
     * 8. 获取bean标签元素的属性（id、class属性）
     * 9. 获取MyBean对象，将id和class属性值设置到对象中，再将对象设置到MyBean的集合中
     * @date 20:41 2021/12/30
     * @param	fileName
     * @return
     **/
    private void parseXml(String fileName) {
        //1.获取解析器
        SAXReader saxReader = new SAXReader();
        //2.获取配置文件的URL
        URL url = this.getClass().getClassLoader().getResource(fileName);
        System.out.println(url);
        try {
            //3. 通过解析器配置文件
            Document document = saxReader.read(url);
            //4. 通过xpath语法解析，获取beans标签下的所有bean标签
            XPath xPath = document.createXPath("beans/bean");
            //5. 通过制定的解析语法解析文档对象，返回元素集合
            List<Element> elementList = xPath.selectNodes(document);
            if(elementList != null && elementList.size() > 0) {
                beanList = new ArrayList<>();

                //7. 如果集合不为空，遍历集合
                for (Element el : elementList) {
                    //8. 获取bean标签元素的属性（id、class）
                    String id = el.attributeValue("id");
                    String clazz = el.attributeValue("class");
                    //获取MyBean对象，将id和class属性值设置到对象中，在将对象设置到MyBean中
                    MyBean myBean = new MyBean(id, clazz);
                    beanList.add(myBean);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author simple.jbx
     * @description 通过id获取对应map中的value（实例化的bean对象）
     * @date 20:40 2021/12/30
     * @param	id
     * @return
     **/
    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }
}
