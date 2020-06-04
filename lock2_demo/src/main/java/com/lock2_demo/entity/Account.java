package com.lock2_demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@ApiModel(value="com.lock2_demo.entity.Account")
@Table(name = "`account`")
public class Account implements Serializable {
    @Id
    @Column(name = "`id`")
    @ApiModelProperty(value="id")
    private Integer id;

    @Column(name = "`a`")
    @ApiModelProperty(value="a")
    private String a;

    @Column(name = "`deposit`")
    @ApiModelProperty(value="deposit")
    private BigDecimal deposit;

    @Column(name = "`version`")
    @ApiModelProperty(value="version")
    private Integer version;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return a
     */
    public String getA() {
        return a;
    }

    /**
     * @param a
     */
    public void setA(String a) {
        this.a = a == null ? null : a.trim();
    }

    /**
     * @return deposit
     */
    public BigDecimal getDeposit() {
        return deposit;
    }

    /**
     * @param deposit
     */
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    /**
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}