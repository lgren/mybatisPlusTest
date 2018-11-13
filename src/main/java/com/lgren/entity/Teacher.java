package com.lgren.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @author Lgren
 * @since 2018-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Teacher对象", description = "")
public class Teacher extends Model<Teacher> {

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

    @TableField("subject")
    private Integer subject;

    @TableField("job_title")
    private Integer jobTitle;

    @TableField("birthday")
    private LocalDateTime birthday;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
