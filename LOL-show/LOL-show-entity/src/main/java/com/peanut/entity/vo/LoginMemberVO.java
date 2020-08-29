package com.peanut.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用于传递登陆的数据
 * @author Peanut
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginMemberVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String userName;
    private String roleName;
    private Integer age;
    private String password;
    private String userText;
}
