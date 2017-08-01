package cn.demo.ssm.service.impl.Users;

import cn.demo.ssm.mapper.users.UsersMapper;
import cn.demo.ssm.po.users.Users;
import cn.demo.ssm.po.users.UsersExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:/config/spring/applicationContext-*.xml")
public class UsersServiceImplTest {
    @Autowired
    private UsersMapper usersMapper;
    @Test
    public void addUsers() throws Exception {
        Users users = new Users();
        users.setUser("fyk");
        users.setPassword("fangyoukai");
        int ins = usersMapper.insert(users);
        System.out.print("这是ins="+ins);

    }

    @Test
    public void updateUsers() throws Exception {
    }

    @Test
    public void deleteUsers() throws Exception {
    }

    @Test
    public void selectByUsersName() throws Exception {
       Users users =  usersMapper.selectByUserName("hjt");
        System.out.print(users);
    }

}