package cn.demo.ssm.controller.cards.cards;

import cn.demo.ssm.po.cards.Cards;
import cn.demo.ssm.po.cards.Cardslogo;
import cn.demo.ssm.service.cards.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Cards")
public class CardsController {
    @Autowired
    private CardsService cardsService;

    @RequestMapping("/queryCards")
    @ResponseBody
    public Map<String,Object> queryCards(HttpServletRequest request, String user) {
        Map<String,Object> map = new HashMap<>();


        try{
                if(user!=null){
                List<Cardslogo> cardslogos  =  cardsService.loadCardsLogo(user);
                List<Cards> cards  =  cardsService.queryCardInfoByUser(user);
                String path=null;

                    for (int i=0;i<cards.size();i++) {
                        for (int j=0;j<cardslogos.size();j++) {
                            if(cards.get(i).getId()==cardslogos.get(j).getCardsid()) {
                                path = cardslogos.get(j).getPath().substring(cardslogos.get(j).getPath().lastIndexOf("\\")) +"\\"+ cardslogos.get(j).getName();
                                map.put("cards" + cards.get(i).getId(), path);
                                path =null;
                            }

                        }

                    }
                    map.put("cards",cards);
                    map.put("result","success");
                }
        }catch (Exception e){
            map.put("cards","error");
            }
                return map;
    }

    @RequestMapping("/updateCards")
    @ResponseBody
    public Map<String,Object> updateCards(HttpServletRequest request, Cards cards) {
        Map<String, Object> map = new HashMap<>();


        try {
            if (cards != null) {
                cardsService.updateCardInfoById(cards);
                map.put("result", "success");
               }

            }catch(Exception e){
                map.put("result", "error");
            }
            return map;
        }







 }




