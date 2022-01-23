import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.snnukf.service.UserService;

/**
 * @author simple.jbx
 * @ClassName Starter01
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/07/ 18:54
 */
public class Starter01 {
    public static void main(String[] args) {
        //获取Spring上下文环境
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        UserService userService = (UserService) ac.getBean("userService");
        userService.test();
    }
}
