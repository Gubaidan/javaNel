package cn.demo.ssm.mapper.users;

import cn.demo.ssm.po.users.UserDetail;
import cn.demo.ssm.po.users.UserDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailMapper {
    int countByExample(UserDetailExample example);

    int deleteByExample(UserDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    List<UserDetail> selectByExample(UserDetailExample example);

    UserDetail selectByPrimaryKey(Integer id);

    UserDetail selectByPrimaryName(String name);

    UserDetail selectUserDetail(String user);

    int updateByExampleSelective(@Param("record") UserDetail record, @Param("example") UserDetailExample example);

    int updateByExample(@Param("record") UserDetail record, @Param("example") UserDetailExample example);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
}