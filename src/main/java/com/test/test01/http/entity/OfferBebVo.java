package com.test.test01.http.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: com.sycexe.cms.vo.OfferAsdVo
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/4/28 10:27
 * @Version: 1.0
 */
@Data
public class OfferBebVo {

    @ApiModelProperty( value="预约类型 ")
    private String appointmentType;

    @ApiModelProperty(value="便签名字")
    private String labelName;

    @ApiModelProperty(value="手机号")
    private String phone;

    @ApiModelProperty(value="面积")
    private String size;

    @ApiModelProperty(value="姓名")
    private String username;


}
