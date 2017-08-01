package cn.demo.ssm.controller.cards.Recycle;

import cn.demo.ssm.po.cards.Cards;
import cn.demo.ssm.po.recycle.Recycle;
import cn.demo.ssm.po.recycle.Recyclelogo;
import cn.demo.ssm.service.recycle.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/Recycle")
public class RecycleController {
    @Autowired
    private RecycleService recycleService;

    @RequestMapping("/queryRecycle")
    @ResponseBody
    public Map<String,Object> queryRecycle(HttpServletRequest request, String user) {
        Map<String,Object> map = new HashMap<>();

        try{
            if(user!=null){
                List<Recyclelogo> recyclelogos  =  recycleService.loadRecycleLogo(user);
                List<Recycle> recycles  =  recycleService.queryRecycleByUser(user);
                String path=null;

                for (int i=0;i<recycles.size();i++) {
                    for (int j=0;j<recyclelogos.size();j++) {
                        if(recycles.get(i).getId()==recyclelogos.get(j).getCardsid()) {
                            path = recyclelogos.get(j).getPath().substring(recyclelogos.get(j).getPath().lastIndexOf("\\")) +"\\"+ recyclelogos.get(j).getName();
                            map.put("recycle" + recycles.get(i).getId(), path);
                            path =null;
                        }

                    }

                }
                map.put("recycles",recycles);
                map.put("result","success");
            }
        }catch (Exception e){
            map.put("result","error");
        }
        return map;

    }

    @RequestMapping("/updateRecycle")
    @ResponseBody
    public Map<String,Object> updateRecycle(HttpServletRequest request, Recycle recycle) {
        Map<String, Object> map = new HashMap<>();


        try {
            if (recycle != null) {
                recycleService.updateRecycleById(recycle);
                map.put("result", "success");
            }

        }catch(Exception e){
            map.put("result", "error");
        }
        return map;
    }






}
