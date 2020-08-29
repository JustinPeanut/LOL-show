package com.peanut.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Peanut
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AreaVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String areaName;
}
