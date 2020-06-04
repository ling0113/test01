package com.lock_demo.lock.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value="com.test.test01.lock.entity.Account")
@Table(name = "`account`")
public class Account implements Serializable {
    @Id
    @Column(name = "`id`")
    @ApiModelProperty(value="id")
    private Integer id;

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