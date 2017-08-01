package cn.demo.ssm.service.impl.cards;


import cn.demo.ssm.mapper.cards.CardsMapper;
import cn.demo.ssm.po.cards.Cards;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:/config/spring/applicationContext-*.xml")
public class CardsServiceImplTest {
    @Autowired private CardsMapper cardsMapper;
    @Test
    public void updateCardInfoByUser() throws Exception {
        Cards cards = cardsMapper.selectByPrimaryKey(16);
        System.out.print(cards);

    }

}