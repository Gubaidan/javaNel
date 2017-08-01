package cn.demo.ssm.controller.cards.users;


import cn.demo.ssm.po.users.UserDetail;
import cn.demo.ssm.po.users.Userlogo;
import cn.demo.ssm.po.users.Users;
import cn.demo.ssm.service.users.UsersService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/usersManagement")
public class UsersManagementController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/insertUserInfo")
    @ResponseBody
    public Map<String,Object> insertUserInfo(HttpServletRequest request,String user, UserDetail userDetail) {
        Map<String, Object> map = new HashMap<>();
        boolean statues;
        try{
            Users insertU = usersService.selectByUser(user);
            userDetail.setUserid(insertU.getId());
            statues = usersService.updateUserDetail(userDetail);
            if (statues) map.put("result","success");
                return map;
        }catch (Exception e){
            map.put("result","error");
            return map;
        }

    }


    @RequestMapping("/loadUserInfo")
    @ResponseBody
    public Map<String,Object> loadUserInfo(HttpServletRequest request, String user) {
        Map<String, Object> map = new HashMap<>();
        try{
            UserDetail userDetail = usersService.loadUserDetail(user);
            if (userDetail!=null) {
                map.put("result","success");
                map.put("UserDetail",userDetail);
            }

        }catch (Exception e){
            map.put("result","error");

        }
        return map;
    }

    /**
     * 上传用户头像
     * 括号中的参数名file和表单的input节点的name属性值一致
     * @return
     */
    @RequestMapping(value="/upLoadUserLogo", method= RequestMethod.POST)
    public String upLoadUserLogo(@RequestParam("avatar_file") MultipartFile userLogo,String logoUser){


        //物理存储目录
        String pic_name = "E:\\Java\\demo\\Photo\\User";
        //图片原始名称
        String originalName =  userLogo.getOriginalFilename();
        //图片新名称
        String newName = UUID.randomUUID()+originalName.substring(originalName.lastIndexOf("."));

        Map<String,Object> map = new HashMap<>();

        if(!userLogo.isEmpty()){
            try {
                Userlogo logo = new Userlogo();
                logo.setName(newName);
                logo.setOriginalName(originalName);
                logo.setCreatTime(new Date());
                logo.setPath(pic_name);
                logo.setUserid( usersService.selectByUser(logoUser).getId());
                logo.setSize( userLogo.getSize());
                usersService.insertUserLogo(logo,logoUser);
                //这里将上传得到的文件保存至 d:\\temp\\file 目录
                FileUtils.copyInputStreamToFile(userLogo.getInputStream(), new File(pic_name,
                         newName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

      return "main/user";  //上传成功则跳转
    }


    /**
     * 加载用户头像
     * @return
     */
    @RequestMapping("/loadUserLogo")
    @ResponseBody
    public Map<String,Object> loadUserLogo(HttpServletRequest request, String user) {
        Map<String, Object> map = new HashMap<>();
        try{
           Userlogo userlogo = usersService.loadUserLogo(user);
            if (userlogo!=null) {
                map.put("result","success");
                String path = userlogo.getPath().substring(userlogo.getPath().lastIndexOf("\\"));
                userlogo.setPath(path);
                map.put("userLogo",userlogo);
            }

        }catch (Exception e){
            map.put("result","error");

        }
        return map;
    }






}
