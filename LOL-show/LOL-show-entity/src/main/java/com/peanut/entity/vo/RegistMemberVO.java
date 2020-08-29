package com.peanut.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistMemberVO {
    private String userName;
    private String roleName;
    private Integer areaId;
    private Integer age;
    private String password;
    private String phoneNum;
    private String code;
}
