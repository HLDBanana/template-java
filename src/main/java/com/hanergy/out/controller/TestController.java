package com.hanergy.out.controller;

import com.hanergy.out.entity.AccountInfo;
import com.hanergy.out.service.AccountInfoService;
import com.hanergy.out.service.RedisService;
import com.hanergy.out.utils.R;
import com.hanergy.out.common.RetResponse;
import com.hanergy.out.common.RetResult;
import com.hanergy.out.vo.PostSwaggerTestReq;
import com.hanergy.out.vo.PostSwaggerTestVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @ApiOperation(value="springmvc测试",notes="测试信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="test",value="测试",required=true,paramType="query")
    })
    @GetMapping("/test")
    public R test(@RequestParam("test")String test){
        log.info(test);
        return R.ok();
    }

    @ApiOperation(value="redis测试",notes="redis测试")
    @GetMapping("/redis")
    public RetResult<String> redis(){
        redisService.stringSet("test","hello world !!!");
        return RetResponse.makeOKRsp(redisService.stringGet("test"));
    }


    @ApiOperation(value="post测试",notes="swagger文档格式测试")
    @PostMapping("/post")
    public RetResult<PostSwaggerTestVo> post(@Valid PostSwaggerTestReq req){
        PostSwaggerTestVo result = new PostSwaggerTestVo();
        result.setName(req.getName());
        return RetResponse.makeOKRsp(result);
    }

    @ApiOperation(value="mysql测试",notes="mysql测试")
    @GetMapping("/mysql")
    public RetResult<List<AccountInfo>> post(){
        return RetResponse.makeOKRsp(accountInfoService.findAll());
    }

}
