package com.xupt.controller;

import com.xupt.pojo.User;
import com.xupt.service.UserService;
import com.xupt.untils.MD5Utils;
import com.xupt.vo.JSONResult;
import com.xupt.vo.UserLogin;
import com.xupt.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation("login and regist")
    public JSONResult registOrLogin(@RequestBody @Valid UserLogin userLogin,@ApiIgnore BindingResult result)  {
        if (result.hasErrors()) {
            return JSONResult.errorMsg(result.getFieldErrors().get(0).getDefaultMessage());
        }
        boolean isExist = userService.queryUsernameIsExist(userLogin.getUsername());
        User user = null;
        if (isExist) {
            user = userService.queryUserForLogin(userLogin.getUsername(), userLogin.getPassword());
            if (user == null) {
                return JSONResult.errorMsg("用户名或密码不正确");
            }
        } else {
            user = new User();
            user.setUsername(userLogin.getUsername());
            user.setNickname(userLogin.getUsername());
            user.setPassword(MD5Utils.getMD5Str(userLogin.getPassword()));
            user = userService.saveUser(user);
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return JSONResult.ok(userVO);
    }
}