package cn.demo.ssm.service.cards;

import cn.demo.ssm.po.cards.Cards;
import cn.demo.ssm.po.cards.Cardslogo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CardsService {
    //验证是否管理员
    boolean judgeUser(String user);

    //admin账户下展示所有名片信息
    List<Cards> queryCardInfo();

    //admin账户下展示回收站名片信息
    List<Cards> queryRecycle();

    //查询某个用户的所有名片信息
    List<Cards> queryCardInfoByUser(String user);

    //更新某个名片信息
    boolean updateCardInfoById(Cards cards);

    //从数据库彻底删除一或多个名片信息
    boolean deleteCardInfoByUser(List<String> users);

    //把名片信息放入回收站
    boolean recycleCardInfoByUser(List<String> users);

    //添加名片信息
    boolean insertCardInfoByUser(List<Cards> cards);

    //上传名片头像信息
    boolean insertCardsLogo(Cardslogo cardslogo,String user);

    //加载名片头像信息
    List<Cardslogo> loadCardsLogo(String user);

    //更新名片头像
    boolean updateCardsLogo(Cardslogo cardslogo,String user);
}
