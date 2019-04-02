package com.xupt.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author maxu
 * @date 2019/4/1
 */
@Data
public class UserLogin {
    @NotBlank(message = "用户名为空")
    private String username;
    @NotBlank(message = "密码为空")
    private String password;
}
