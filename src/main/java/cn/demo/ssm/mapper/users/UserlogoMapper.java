package cn.demo.ssm.mapper.users;

import cn.demo.ssm.po.users.Userlogo;
import cn.demo.ssm.po.users.UserlogoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserlogoMapper {
    int countByExample(UserlogoExample example);

    int deleteByExample(UserlogoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userlogo record);

    int insertSelective(Userlogo record);

    List<Userlogo> selectByExample(UserlogoExample example);

    Userlogo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userlogo record, @Param("example") UserlogoExample example);

    int updateByExample(@Param("record") Userlogo record, @Param("example") UserlogoExample example);

    int updateByPrimaryKeySelective(Userlogo record);

    int updateByPrimaryKey(Userlogo record);
}