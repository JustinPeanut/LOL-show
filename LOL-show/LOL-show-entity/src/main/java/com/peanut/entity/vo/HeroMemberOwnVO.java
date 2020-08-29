package com.peanut.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroMemberOwnVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String imgStick;
    private String fullName;
    private String nickName;

}
