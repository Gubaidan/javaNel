package cn.demo.ssm.service.impl.Recycle;

import cn.demo.ssm.mapper.recycle.RecycleMapper;
import cn.demo.ssm.mapper.recycle.RecyclelogoMapper;
import cn.demo.ssm.po.recycle.Recycle;
import cn.demo.ssm.po.recycle.RecycleExample;
import cn.demo.ssm.po.recycle.Recyclelogo;
import cn.demo.ssm.po.recycle.RecyclelogoExample;
import cn.demo.ssm.service.recycle.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecycleServiceImpl implements RecycleService {
    @Autowired
    private RecycleMapper recycleMapper;
    @Autowired
    private RecyclelogoMapper recyclelogoMapper;
    @Override
    public List<Recycle> queryRecycleByUser(String user) {
        if(user.equals("admin")){
            RecycleExample Example = new RecycleExample();
            RecycleExample.Criteria criteriaAdmin =Example.createCriteria();
            criteriaAdmin.andUserNotEqualTo("@@@@@@@@@@@");
            return recycleMapper.selectByExample(Example);
        }
        else{
            RecycleExample recycleExample = new RecycleExample();
            RecycleExample.Criteria criteria = recycleExample.createCriteria();
            criteria.andUserEqualTo(user);
            return recycleMapper.selectByExample(recycleExample);
        }
    }

    @Override
    public boolean deleteRecycleCardInfoByUser(List<String> users) {
        return false;
    }

    @Override
    public boolean recoverRecycleCardInfoByUser(List<String> users) {
        return false;
    }

    @Override
    public boolean insertRecycleLogo(Recyclelogo recyclelogo, String user) {
        return false;
    }

    @Override
    public List<Recyclelogo> loadRecycleLogo(String user) {
        List<Recyclelogo> recyclelogos;
        RecyclelogoExample recyclelogoExample1 = new RecyclelogoExample();
        RecyclelogoExample.Criteria criteria1 = recyclelogoExample1.createCriteria();
        criteria1.andUserEqualTo(user);
        RecyclelogoExample recyclelogoExample2 = new RecyclelogoExample();
        RecyclelogoExample.Criteria criteria2 = recyclelogoExample2.createCriteria();
        criteria2.andUserNotEqualTo("$%^&*");
        if(user.equals("admin")){
            return recyclelogoMapper.selectByExample(recyclelogoExample2);
        }
        else
            return recyclelogoMapper.selectByExample(recyclelogoExample1);
    }

    @Override
    public boolean updateRecycleLogo(Recyclelogo recyclelogo, String user) {
        return false;
    }

    @Override
    public boolean updateRecycleById(Recycle recycle) {
        int ins = recycleMapper.updateByPrimaryKey(recycle);
        if(ins>0) return true;
        else
            return false;
    }
}
