package com.peanut.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Peanut
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String planDate;

    private String planEvent;

    private Integer lastTime;

}
