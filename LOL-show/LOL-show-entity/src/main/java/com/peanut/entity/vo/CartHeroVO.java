package com.peanut.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartHeroVO implements Serializable {
    private Integer id;
    private String fullName;
    private String nickName;
    private Double price;
    private String imgCart;
}
