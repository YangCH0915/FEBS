package cn.xry;

import cn.xry.pay.domain.Passageway;
import cn.xry.pay.service.PassagewayService;
import cn.xry.system.domain.AdminUser;
import cn.xry.system.domain.AdminUserWithRole;
import cn.xry.system.service.MenuService;
import cn.xry.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private PassagewayService passagewayService;

    @Test
    public void test() {
        AdminUserWithRole user = userService.findAdminUserWithRole(1L);
        System.out.println(user);
    }

    @Test
    public void add(){
        Passageway passageway = new Passageway();
        passageway.setAppId("10025636523");
        passageway.setCreateTime(new Date());
        passageway.setPassagewayId("12345612");
        passageway.setPassagewayName("测试1");
        passageway.setPayId("123456L");
        passageway.setPayKey("safjhkasdfasdf");
        passageway.setPublicKey("");
        passageway.setSignType("MD5");
        passageway.setStatus(true);
        passageway.setPayType("winxin_wap");
        int save = passagewayService.save(passageway);
        System.out.println("保存结果："+save);
    }

    @Test
    public void update(){
        Passageway passageway = new Passageway();
        passageway.setId(39L);
        passageway.setAppId("10025636524");
        passageway.setCreateTime(new Date());
        passageway.setPassagewayId("123456134");
        passageway.setPassagewayName("测试1");
        passageway.setPayId("654321");
        passageway.setPayKey("safjhkasdfasdf");
        passageway.setPublicKey("");
        passageway.setSignType("MD5");
        passageway.setStatus(true);
        passageway.setPayType("ali_wap");
        int save = passagewayService.updateNotNull(passageway);
        System.out.println("更新结果："+save);
    }

    @Test
    public void delete(){
        int delete = passagewayService.delete(40L);
        System.out.println("删除结果："+delete);
    }

    @Test
    public void select(){
//        List<Passageway> passageways = passagewayService.selectAll();
        List<AdminUser> userByPassagewayId = userService.findUserByPassagewayId("15338987");
        System.out.println("查询结果："+userByPassagewayId.toString());
    }

}
