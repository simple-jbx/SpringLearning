package tech.snnukf.service;

import org.springframework.stereotype.Service;

/**
 * @author simple.jbx
 * @ClassName UserService
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/21/ 14:24
 */
@Service
public class UserService {
    public void test() {
        System.out.println(UserService.this.getClass().getName());
        // int i = 1 / 0;
    }
}
