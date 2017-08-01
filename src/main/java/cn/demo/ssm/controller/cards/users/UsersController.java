package cn.demo.ssm.controller.cards.users;

import cn.demo.ssm.po.users.Users;
import cn.demo.ssm.service.users.UsersService;
import cn.demo.ssm.tool.Md5;
import cn.demo.ssm.tool.token.AuthUtil;
import cn.demo.ssm.tool.token.JavaWebToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 跳转到登陆
     *
     * @return
     */

    @RequestMapping("/jumpLogin")
    public String jumpToWelcome(HttpServletRequest request) {

        return "Login/000";
    }

    //注册用户
    @RequestMapping("/register")
    @ResponseBody
    public Map<String, Object> register(HttpServletRequest request, Users users) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if (users != null) {
            users.setPassword(Md5.md5(users.getPassword()));
            boolean statues = usersService.addUsers(users);
            if (statues) {
                map.put("username", users.getUser());
                map.put("code", 200);
                map.put("result", true);
            } else {
                map.put("code", 401);
                map.put("result", false);
            }
        }
        return map;
    }


    //用户登陆
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request,HttpServletResponse response, Users users) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if (users != null) {
            //加密视图参数用户密码
            String passWord = Md5.md5(users.getPassword());
            //加密后与数据库比较
            Users userJudge = usersService.selectByUsersName(users.getUser());
            if (userJudge==null||!(passWord.equals(userJudge.getPassword()))) {
                map.put("result", false);
            } else {
                    System.out.print("当前用户："+userJudge.getUser());
                    //把用户信息存入token
                    Map<String, Object> loginInfo = new HashMap<>();
                    loginInfo.put("userID", userJudge.getId());
                    loginInfo.put("userName", userJudge.getName());
                    //获取token码
                    String tokenNo = JavaWebToken.createJavaWebToken(loginInfo);
                    System.out.print("token码为："+tokenNo);
                    //将token存入本地
                    addCookie(response, "tokenNo", tokenNo, 3600);
                    addCookie(response, "userName", String.valueOf(userJudge.getName()), 3600);
                    map.put("result", true);
            }
        }
        return map;
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value="/getLoginInfo",produces="application/json;charset=UTF-8")
    @ResponseBody
    public  Map<String, Object> getLoginInfo(HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();
        try {
            Long userID = AuthUtil.getUserId(request);
            Users usersInfo = usersService.selectByUsersId(userID);
            map.put("user",usersInfo.getUser());
            map.put("name",usersInfo.getName());
            return map;
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("result","error");
            return  map;
        }

    }

    @RequestMapping(value="logout",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        boolean IsSuccess = false;
        try {
            //从session拿到token，再解密得到userid
            Map<String, Object> loginInfo = AuthUtil.getClientLoginInfo(request);
            if(loginInfo!=null){
                String tokenNo = JavaWebToken.createJavaWebToken(loginInfo);
                deleteCookie(response, "tokenNo", tokenNo);
            }
            IsSuccess = true;
        }catch(Exception e) {
            e.printStackTrace();
        }
        map.put("IsSuccess", IsSuccess);
        return map;
    }

    /**
     * 删除cookie
     * @param response
     * @param name  cookie名字
     * @param value cookie值
     */
    public static void deleteCookie(HttpServletResponse response,String name,String value){
        Cookie cookie = new Cookie(name,value);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    /**
     * 设置cookie
     *
     * @param response
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期  以秒为单位
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) throws UnsupportedEncodingException {
        Cookie cookie = new Cookie(name, URLEncoder.encode(value,"UTF-8"));
        cookie.setPath("/");
        /*if(maxAge>0)
            cookie.setMaxAge(maxAge);*/

        response.addCookie(cookie);
    }



}
