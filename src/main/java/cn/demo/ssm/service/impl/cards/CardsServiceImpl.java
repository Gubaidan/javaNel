package cn.demo.ssm.service.impl.cards;

import cn.demo.ssm.mapper.cards.CardsMapper;
import cn.demo.ssm.mapper.cards.CardslogoMapper;
import cn.demo.ssm.po.cards.Cards;
import cn.demo.ssm.po.cards.CardsExample;
import cn.demo.ssm.po.cards.Cardslogo;
import cn.demo.ssm.po.cards.CardslogoExample;
import cn.demo.ssm.service.cards.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardsServiceImpl implements CardsService {
public class CardsServiceImpl implements CardsService {
public class CardsServiceImpl implements CardsService {
public class CardsServiceImpl implements CardsService {
public class CardsServiceImpl implements CardsService {
public class CardsServiceImpl implements CardsService {

    @Autowired
    private CardsMapper cardsMapper;
    @Autowired
    private CardslogoMapper cardslogoMapper;
    @Override
    public boolean judgeUser(String user) {
        return false;
    }

    @Override
    public List<Cards> queryCardInfo() {
        return null;
    }

    @Override
    public List<Cards> queryRecycle() {
        return null;
    }

    @Override
    public List<Cards> queryCardInfoByUser(String user) {
        if(user.equals("admin")){
            CardsExample Example = new CardsExample();
            CardsExample.Criteria criteriaAdmin = Example.createCriteria();
            criteriaAdmin.andUserNotEqualTo("@@@@@@@@@@@");
            return cardsMapper.selectByExample(Example);
        }
        else{
        CardsExample cardsExample = new CardsExample();
        CardsExample.Criteria criteria = cardsExample.createCriteria();
        criteria.andUserEqualTo(user);
        return cardsMapper.selectByExample(cardsExample);
        }
    }


    @Override
    public boolean updateCardInfoById(Cards cards) {
       int ins = cardsMapper.updateByPrimaryKey(cards);
       if(ins>0) return true;
       else
        return false;
    }

    @Override
    public boolean deleteCardInfoByUser(List<String> users) {
        return false;
    }

    @Override
    public boolean recycleCardInfoByUser(List<String> users) {
        return false;
    }

    @Override
    public boolean insertCardInfoByUser(List<Cards> cards) {
        return false;
    }

    @Override
    public boolean insertCardsLogo(Cardslogo cardslogo, String user) {
        return false;
    }

    @Override
    public List<Cardslogo> loadCardsLogo(String user) {
        List<Cardslogo> cardslogos;
        CardslogoExample cardslogoExample1 = new CardslogoExample();
        CardslogoExample.Criteria criteria1 = cardslogoExample1.createCriteria();
        criteria1.andUserEqualTo(user);
        CardslogoExample cardslogoExample2 = new CardslogoExample();
        CardslogoExample.Criteria criteria2 = cardslogoExample2.createCriteria();
        criteria2.andUserNotEqualTo("$%^&*");
        if(user.equals("admin")){
        return cardslogoMapper.selectByExample(cardslogoExample2);
        }
        else
        return cardslogoMapper.selectByExample(cardslogoExample1);
    }


    @Override
    public boolean updateCardsLogo(Cardslogo cardslogo, String user) {
        return false;
    }
}
