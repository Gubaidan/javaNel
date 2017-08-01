package cn.demo.ssm.mapper.cards;

import cn.demo.ssm.po.cards.Cards;
import cn.demo.ssm.po.cards.CardsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsMapper {
    int countByExample(CardsExample example);

    int deleteByExample(CardsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cards record);

    int insertSelective(Cards record);

    List<Cards> selectByExample(CardsExample example);

    Cards selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cards record, @Param("example") CardsExample example);

    int updateByExample(@Param("record") Cards record, @Param("example") CardsExample example);

    int updateByPrimaryKeySelective(Cards record);

    int updateByPrimaryKey(Cards record);
}