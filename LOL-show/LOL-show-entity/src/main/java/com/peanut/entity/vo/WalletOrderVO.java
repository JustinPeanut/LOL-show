package com.peanut.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String orderName;

    private Double price;

    private String orderNum;

    private String aipayNum;

    private String orderMark;

    private Integer memberId;
}
