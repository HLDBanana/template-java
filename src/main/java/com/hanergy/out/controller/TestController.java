package com.hanergy.out.controller;

import com.hanergy.out.common.HttpResult;
import com.hanergy.out.entity.AccountInfo;
import com.hanergy.out.service.AccountInfoService;
import com.hanergy.out.service.RedisService;
import com.hanergy.out.vo.PostSwaggerTestReq;
import com.hanergy.out.vo.PostSwaggerTestVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName TestController
 * @Description
 * @Auto HANLIDONG
 * @Date 2019-7-12 9:51)
 */
@RestController
@RequestMapping("/v1/test")
public class TestController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private AccountInfoService accountInfoService;

    Logger log = LoggerFactory.getLogger(TestController.class);

    @ApiOperation(value="get请求",notes="swagger get请求")
    @GetMapping("/get")
    public HttpResult<String> test(@RequestParam("name") @ApiParam(name="name",value="名称",required=true,allowableValues = "张三,李四") @Valid @NotNull String name){
        return HttpResult.successResult(name);
    }

    @ApiOperation(value="post",notes="swagger post请求")
    @PostMapping("/post")
    public HttpResult<PostSwaggerTestVo> test(@RequestBody @Valid PostSwaggerTestReq req){
        PostSwaggerTestVo result = new PostSwaggerTestVo();
        result.setName(req.getName());
        return HttpResult.successResult(result);
    }

    @ApiOperation(value="redis测试",notes="redis测试")
    @GetMapping("/redis")
    public HttpResult<String> redis(){
        redisService.stringSet("test","hello world !!!");
        return HttpResult.successResult("请求成功",redisService.stringGet("test"));
    }


    @ApiOperation(value="mysql测试",notes="mysql测试")
    @GetMapping("/mysql")
    public HttpResult<List<AccountInfo>> post(){
        return HttpResult.successResult(accountInfoService.findAll());
    }

}
