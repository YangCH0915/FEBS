package cn.xry;

import cn.xry.common.domain.Tree;
import cn.xry.system.domain.Menu;
import cn.xry.system.domain.User;
import cn.xry.system.service.MenuService;
import cn.xry.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Test
    public void test() {
        User user = this.userService.findByName("mrbird");
        System.out.println(user.getUsername());
    }

    @Test
    public void getMenuTree() {
    }

    @Test
    public void getUserMenu() {
        List<Menu> tree =  this.menuService.findUserMenus("MrBird");
        System.out.println(tree.toString());
    }
}
