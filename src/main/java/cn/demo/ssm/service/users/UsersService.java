package cn.demo.ssm.service.users;

import cn.demo.ssm.po.users.UserDetail;
import cn.demo.ssm.po.users.Userlogo;
import cn.demo.ssm.po.users.Users;
import org.springframework.stereotype.Service;



@Service
public interface UsersService {
    //注册用户
    boolean addUsers(Users users);

    //更新用户
    boolean updateUsers(Users users);

    //根据用户名删除用户
    boolean deleteUsers(String name);

    //根据用户名删除用户
    boolean judgeUsers(Users users);

    //根据名字查询用户信息

    Users selectByUsersName(String name);

    //根据ID查询用户信息

    Users selectByUsersId(Long id);
    //根据user查询用户信息

    Users selectByUser(String user);
    //加载用户信息
    UserDetail loadUserDetail(String user);
    //更新用户详细信息
    boolean updateUserDetail(UserDetail userDetail);

    //新增用户头像
    boolean insertUserLogo(Userlogo userlogo,String user);

    //更新用户头像
    boolean updateUserLogo(Userlogo userlogo,String user);

    //加载用户头像
    Userlogo loadUserLogo(String user);
}
