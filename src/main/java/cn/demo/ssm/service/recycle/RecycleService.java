package cn.demo.ssm.service.recycle;

import cn.demo.ssm.po.recycle.Recycle;
import cn.demo.ssm.po.recycle.Recyclelogo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecycleService {
    //查询某个用户的回收站名片信息
    List<Recycle> queryRecycleByUser(String user);

    //从回收站彻底删除一或多个名片信息
    boolean deleteRecycleCardInfoByUser(List<String> users);

    //名片信息从回收站恢复
    boolean recoverRecycleCardInfoByUser(List<String> users);

    //上传名片头像信息
    boolean insertRecycleLogo(Recyclelogo recyclelogo, String user);

    //加载名片头像信息
    List<Recyclelogo> loadRecycleLogo(String user);

    //更新名片头像
    boolean updateRecycleLogo(Recyclelogo recyclelogo,String user);

    //更新某个名片信息
    boolean updateRecycleById(Recycle recycle);

}
