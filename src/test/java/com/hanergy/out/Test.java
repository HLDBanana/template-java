package com.hanergy.out;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hanergy.out.service.SysUserService;
import com.hanergy.out.vo.EsourcingQueryVo;
import com.hanergy.out.vo.SearchVo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import javax.management.Query;
import java.sql.SQLOutput;

/**
 * @author DURONGHONG
 * @version 1.0
 * @className Test
 * @description TODO
 * @date 2019-5-20 10:59
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = HanergyOutApplication.class)
public class Test {

    @Autowired
    private SysUserService sysUserService;

    @org.junit.Test
    public void test(){

        EsourcingQueryVo queryVo =new EsourcingQueryVo();
        SearchVo searchVo =new SearchVo();
        searchVo.setUserKey("ydks");
        searchVo.setEqOrLike("T5");
        searchVo.setUserValue("20190626");
//
        queryVo.setSearchParams(searchVo);
//        queryVo.setPageNo(1);
//        queryVo.setPageSize(10);


        JSONObject userListByCondition = sysUserService.getUserListByCondition(queryVo);
        System.out.println(userListByCondition.size());
    }

    public static void main(String[] args) {
    }
}
