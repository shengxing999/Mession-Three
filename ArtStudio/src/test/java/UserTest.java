import com.artstudio.dao.pojo.User;
import com.artstudio.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/13/6:47 下午
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    UserService us;
    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUsername("www");
        user.setPwd("1111");
        user.setRoleId(1);
        user.setCreateBy(111);
        user.setCreateAt(1111111111);
        us.addUserService(user);
        System.out.println("id:" + user.getId());
    }

}
