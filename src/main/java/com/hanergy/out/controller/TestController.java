package com.hanergy.out.controller;

import com.hanergy.out.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Auto HANLIDONG
 * @Date 2019-7-12 9:51)
 */
@RestController
@RequestMapping("/v1/test")
public class TestController {

    Logger log = LoggerFactory.getLogger(TestController.class);


    @ApiOperation(value="测试",notes="测试信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="test",value="测试",required=true,paramType="query")
    })
    @GetMapping("/test")
    public R test(@RequestParam("test")String test){
        log.info(test);
        return R.ok();
    }
}
