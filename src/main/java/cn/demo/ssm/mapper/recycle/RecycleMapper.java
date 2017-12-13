package cn.demo.ssm.mapper.recycle;

import cn.demo.ssm.po.recycle.Recycle;
import cn.demo.ssm.po.recycle.RecycleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecycleMapper {
    int countByExample(RecycleExample example);

    int deleteByExample(RecycleExample example);

    int deleteByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);
    int deleteByPrimaryKey(Integer id);

    int insert(Recycle record);

    int insertSelective(Recycle record);

    List<Recycle> selectByExample(RecycleExample example);

    Recycle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recycle record, @Param("example") RecycleExample example);

    int updateByExample(@Param("record") Recycle record, @Param("example") RecycleExample example);

    int updateByPrimaryKeySelective(Recycle record);

    int updateByPrimaryKey(Recycle record);
}