package com.lgren.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.github.jsonzou.jmockdata.annotation.MockIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lgren
 * @since 2018-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Student对象", description="")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    @MockIgnore
    @TableId("id")
    private Long id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("real_name")
    private String realName;

    @TableField("birthday")
    private LocalDateTime birthday;

    @MockIgnore
    @TableField(value = "last_update_time", fill = FieldFill.UPDATE)
    private LocalDateTime lastUpdateTime;

    @MockIgnore
    @TableField(value = "last_update_worker", fill = FieldFill.UPDATE)
    private String lastUpdateWorker;

    @MockIgnore
    @TableField(value = "insert_time", fill = FieldFill.INSERT)
    private LocalDateTime insertTime;

    @MockIgnore
    @TableField(value = "insert_worker", fill = FieldFill.INSERT)
    private String insertWorker;

    @MockIgnore
    @TableLogic
    @TableField("del_status")
    private Boolean delStatus;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
