package cn.demo.ssm.mapper.recycle;

import cn.demo.ssm.po.recycle.Recyclelogo;
import cn.demo.ssm.po.recycle.RecyclelogoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclelogoMapper {
    int countByExample(RecyclelogoExample example);

    int deleteByExample(RecyclelogoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recyclelogo record);

    int insertSelective(Recyclelogo record);

    List<Recyclelogo> selectByExample(RecyclelogoExample example);

    Recyclelogo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recyclelogo record, @Param("example") RecyclelogoExample example);

    int updateByExample(@Param("record") Recyclelogo record, @Param("example") RecyclelogoExample example);

    int updateByPrimaryKeySelective(Recyclelogo record);

    int updateByPrimaryKey(Recyclelogo record);
}