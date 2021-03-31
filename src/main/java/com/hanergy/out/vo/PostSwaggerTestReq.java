package com.hanergy.out.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author: Han LiDong
 * @create: 2021/3/22 17:03
 * @update: 2021/3/22 17:03
 */
@Data
@ApiModel("请求bean")
public class PostSwaggerTestReq {

    @NotNull(message = "pageNo不能为空")
    @ApiModelProperty(value ="当前页号" , example = "1" , required = true)
    private Integer pageNo;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value ="每页数量" , example = "15" , required = true)
    private Integer pageSize;

    @ApiModelProperty(value ="名称" , example = "张三" , required = true)
    private String name;

}
