package com.lgren.entity.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * 职称
 *
 * @author Lgren
 * @create 2018/11/7 14:45
 **/
public enum JobTitleEnum implements IEnum<Integer> {
    JUNIOR(1, "初级"),
    MIDDLE(2, "中级"),
    ADVANCED(3, "高级"),
    SPECIAL(4, "特级");
    private Integer value;
    private String desc;

    JobTitleEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return desc;
    }
}
