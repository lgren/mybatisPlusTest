package com.lgren.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.github.jsonzou.jmockdata.annotation.MockIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 * @author Lgren
 * @since 2018-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Student对象", description = "")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    @MockIgnore
    @ApiModelProperty(value = "学生ID")
    @TableId("id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty(value = "生日")
    @TableField("birthday")
    private LocalDateTime birthday;

    @MockIgnore
    @ApiModelProperty(value = "修改时间")
    @TableField(value = "last_update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastUpdateTime;

    @MockIgnore
    @ApiModelProperty(value = "修改人")
    @TableField(value = "last_update_worker", fill = FieldFill.INSERT_UPDATE)
    private String lastUpdateWorker;

    @MockIgnore
    @ApiModelProperty(value = "添加时间")
    @TableField(value = "insert_time", fill = FieldFill.INSERT)
    private LocalDateTime insertTime;

    @MockIgnore
    @ApiModelProperty(value = "添加人")
    @TableField(value = "insert_worker", fill = FieldFill.INSERT)
    private String insertWorker;

    @MockIgnore
    @ApiModelProperty(value = "状态0.未删除 1.已删除")
    @TableLogic
    @TableField("del_status")
    private Boolean delStatus;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
