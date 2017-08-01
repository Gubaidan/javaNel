package cn.demo.ssm.service.impl.Users;


import cn.demo.ssm.mapper.users.UserDetailMapper;
import cn.demo.ssm.mapper.users.UserlogoMapper;
import cn.demo.ssm.mapper.users.UsersMapper;
import cn.demo.ssm.po.users.*;
import cn.demo.ssm.service.users.UsersService;
import cn.demo.ssm.tool.OperateFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserDetailMapper userDetailMapper;
    @Autowired
    private UserlogoMapper userlogoMapper;


    @Override
    public boolean addUsers(Users users) {
        int ins = usersMapper.insert(users);
        if(ins>0) return true;
        else
            return false;
    }

    @Override
    public boolean updateUsers(Users users) {
        int ins =  usersMapper.updateByPrimaryKey(users);
        if(ins>0) return true;
        else
            return false;
    }

    @Override
    public boolean deleteUsers(String name) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        int ins =  usersMapper.deleteByExample(usersExample);
        if(ins>0) return true;
        else
            return false;
    }

    @Override
    public boolean judgeUsers(Users users) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(users.getUser());
        criteria.andNameEqualTo(users.getPassword());
        usersMapper.selectByExample(usersExample);
        return false;
    }

    @Override
    public Users selectByUsersName(String name) {
        return  usersMapper.selectByUserName(name);
    }

    @Override
    public Users selectByUsersId(Long id) {

        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public Users selectByUser(String user) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUserEqualTo(user);
       List<Users> users = usersMapper.selectByExample(usersExample);
        return users.get(0);
    }

    @Override
    public UserDetail loadUserDetail(String user) {
        return userDetailMapper.selectUserDetail(user);
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        UserDetailExample userDetailExample = new UserDetailExample();
        UserDetailExample.Criteria criteria = userDetailExample.createCriteria();
        criteria.andUseridEqualTo(userDetail.getUserid());
        List<UserDetail> userDetails = userDetailMapper.selectByExample(userDetailExample);
        userDetail.setId(userDetails.get(0).getId());
        int ins =   userDetailMapper.updateByPrimaryKey(userDetail);
        if(ins>0) return true;
        else
            return false;
    }

    @Override
    public boolean insertUserLogo(Userlogo userlogo,String user) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria1 =usersExample.createCriteria();
        criteria1.andUserEqualTo(user);
        List<Users> users = usersMapper.selectByExample(usersExample);

        UserlogoExample userlogoExample = new UserlogoExample();
        UserlogoExample.Criteria criteria = userlogoExample.createCriteria();
        criteria.andUseridEqualTo(users.get(0).getId());
        List<Userlogo> userlogos = userlogoMapper.selectByExample(userlogoExample);

        Boolean aBoolean = false;
        int ins=0;
        OperateFile operateFile=null;

        if(userlogos.size()>0){
            try {
                String path = "E:\\Java\\demo\\Photo\\User\\"+userlogos.get(0).getName();
                Boolean bBoolean = operateFile.deleteFile(path);
            }catch (Exception e){
                System.out.print(e.getCause());
            }
            aBoolean = updateUserLogo(userlogo,user);
        }
        else
            {
                ins =   userlogoMapper.insert(userlogo);
        }
        if(ins>0||aBoolean) return true;
        else return false;
    }

    @Override
    public boolean updateUserLogo(Userlogo userlogo,String user) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria1 =usersExample.createCriteria();
        criteria1.andUserEqualTo(user);
        List<Users> users = usersMapper.selectByExample(usersExample);

        UserlogoExample userlogoExample = new UserlogoExample();
        UserlogoExample.Criteria criteria = userlogoExample.createCriteria();
        criteria.andUseridEqualTo(users.get(0).getId());
        List<Userlogo> userlogos = userlogoMapper.selectByExample(userlogoExample);
        userlogo.setId(userlogos.get(0).getId());
        int ins = userlogoMapper.updateByPrimaryKey(userlogo);
        if(ins>0) return true;
        else
            return false;
    }

    @Override
    public Userlogo loadUserLogo(String user) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria1 =usersExample.createCriteria();
        criteria1.andUserEqualTo(user);
        List<Users> users = usersMapper.selectByExample(usersExample);

        UserlogoExample userlogoExample = new UserlogoExample();
        UserlogoExample.Criteria criteria = userlogoExample.createCriteria();
        criteria.andUseridEqualTo(users.get(0).getId());

        return  userlogoMapper.selectByExample(userlogoExample).get(0);
    }
}
