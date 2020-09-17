package com.dexin.phenixflowerblooming.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dexin.phenixflowerblooming.dto.LoginDto;
import com.dexin.phenixflowerblooming.entity.User;
import com.dexin.phenixflowerblooming.service.UserService;
import com.dexin.phenixflowerblooming.util.JwtUtils;
import com.dexin.phenixflowerblooming.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    // 注册
    @PostMapping("/logup")
    @ApiOperation("注册用户")
    public Result logup(@Validated @RequestBody LoginDto loginDto) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
        cn.hutool.core.lang.Assert.isNull(user, "用户名已存在");
        user = new User();
        user.setUsername(loginDto.getUsername());
        user.setPassword(SecureUtil.md5(loginDto.getPassword()));
        user.setGmtCreate(DateUtil.toLocalDateTime(DateUtil.date()));
        cn.hutool.core.lang.Assert.isTrue(userService.save(user));
        return Result.success();
    }

    @CrossOrigin
    @PostMapping("/login")
    @ApiOperation("登录")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
        Assert.notNull(user, "用户不存在");
        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return Result.error("密码错误！");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put("name", user.getName());
        claims.put("image", user.getImages());
        claims.put("isAdministrator", user.getIsAdministrator());
        String jwt = jwtUtils.generateToken(user.getId(), claims);

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        // 用户可以另一个接口
        return Result.success(MapUtil.builder()
            .put("id", user.getId())
            .put("username", user.getUsername())
            .put("avatar", user.getImages())
            .map()
        );
    }

    // 退出
    @GetMapping("/logout")
    @RequiresAuthentication
    @ApiOperation("退出")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.success();
    }
}
