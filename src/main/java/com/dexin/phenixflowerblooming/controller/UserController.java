package com.dexin.phenixflowerblooming.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dexin.phenixflowerblooming.entity.User;
import com.dexin.phenixflowerblooming.service.UserService;
import com.dexin.phenixflowerblooming.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 2017101044 林浚颖
 * @since 2020-09-13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //进行加密操作的对象
    @Autowired
    private BCryptPasswordEncoder encoder;

    //登陆
    @RequestMapping(value = "/userLogin/submit",method = RequestMethod.POST)
    public String userLogin(@Validated @RequestBody LoginDto loginDto,HttpServletRequest servletRequest){
        User user = userService.getOne(new QueryWrapper<User>().eq("username",loginDto.getUsername()));
        Assert.notNull(user,"用户不存在");
        /**
         * encoder.matches(password, userLogin.getPassword()，实现输入的密码与数据库中的密码进
         * 行匹配,如果匹配成功则返回匹配的数据给controller层，如果失败则抛异常。
         * 为什么没盐，没有解密了?因为这个已经被CryptPasswordEncoder封装好了，
         * 在encoder.matches()方进行解密匹配完全帮你封装好了，所以不必考虑，
         * 只需要将前端传入的密码与数据库中加密后的密码进行匹配就行。
         *
         * boolean matches(CharSequence rawPassword, String encodedPassword)
         *
         * **/
        if(encoder.matches(loginDto.getPassword(),user.getPassword())){
//            return Result.error("密码错误").toString();
            return "{" +
                    "\"error_code\":" + 0 +
                    ", \"status\":\"" + 0 + "\"" +
                    '}';
        }
//        return Result.success("登陆成功").toString();
        return "{" +
                "\"error_code\":" + 0 +
                ", \"status\":\"" + 1 + "\"" +
                '}';
    }


    //注册
    @RequestMapping(value = "/userRegister/submit",method = RequestMethod.POST)
    public String userRegister(@Validated @RequestBody LoginDto loginDto){
        User user = userService.getOne(new QueryWrapper<User>().eq("username",loginDto.getUsername()));
        Assert.isNull(user,"用户已存在");
        user = new User();
        user.setUsername(loginDto.getUsername());
        //对密码进行encode加密(BCrypt)
        user.setPassword(encoder.encode(loginDto.getPassword()));
        //设置创建时间
//      user.setGmtCreate()
        Assert.isTrue(userService.save(user),"ErrorMassage:保存失败");
//        return Result.success("注册成功").toString();
        return "{" +
                "\"error_code\":" + 0 +
                ", \"status\":\"" + 1 + "\"" +
                '}';
    }

    //LogOut
//    @GetMapping("/logout")
//    @RequiresAuthentication
//    public Result logout() {
//        SecurityUtils.getSubject().logout();
//        return Result.success();
//    }
}
