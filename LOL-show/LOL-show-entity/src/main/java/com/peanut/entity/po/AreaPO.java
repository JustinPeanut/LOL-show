package com.peanut.entity.po;

/**
 * @author Peanut
 */
public class AreaPO {
    private Integer id;

    private String areaName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    @Override
    public String toString() {
        return "AreaPO{" +
                "id=" + id +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}