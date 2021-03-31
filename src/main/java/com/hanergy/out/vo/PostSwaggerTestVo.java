package com.hanergy.out.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author: Han LiDong
 * @create: 2021/3/22 17:03
 * @update: 2021/3/22 17:03
 */
@Data
@ApiModel("返回信息")
public class PostSwaggerTestVo {


    @ApiModelProperty(value ="年龄" , example = "18" )
    private Integer age;


    @ApiModelProperty(value ="数量" , example = "1" )
    private Integer num;

    @ApiModelProperty(value ="名称" , example = "张三" )
    private String name;

}
