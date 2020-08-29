package com.peanut.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroPageVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String fullName;
    private String imgSmall;
}
