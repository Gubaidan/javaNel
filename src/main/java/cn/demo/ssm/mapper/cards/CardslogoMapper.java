package cn.demo.ssm.mapper.cards;

import java.util.List;

import cn.demo.ssm.po.cards.Cardslogo;
import cn.demo.ssm.po.cards.CardslogoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardslogoMapper {
    int countByExample(CardslogoExample example);

    int deleteByExample(CardslogoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cardslogo record);

    int insertSelective(Cardslogo record);

    List<Cardslogo> selectByExample(CardslogoExample example);

    Cardslogo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cardslogo record, @Param("example") CardslogoExample example);

    int updateByExample(@Param("record") Cardslogo record, @Param("example") CardslogoExample example);

    int updateByPrimaryKeySelective(Cardslogo record);

    int updateByPrimaryKey(Cardslogo record);
}