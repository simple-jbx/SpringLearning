package tech.snnukf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * TODO...
 *
 * @className: Account
 * @author: simple.jbx
 * @date: 2022/12/20
 **/
@Data
@AllArgsConstructor
@SuperBuilder
public class Account {

    private Integer id;

    private String name;

    private String type;

    private Double money;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private Integer userId;
}
