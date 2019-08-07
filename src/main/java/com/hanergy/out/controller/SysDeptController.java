package com.hanergy.out.controller;


import com.alibaba.fastjson.JSONObject;
import com.hanergy.out.service.ISysDeptService;
import com.hanergy.out.vo.ConditionKey;
import com.hanergy.out.vo.EsourcingQueryVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 部门 前端控制器
 * </p>
 *
 * @author Du Ronghong
 * @since 2019-07-23
 */
@Controller
@RequestMapping("/api/v1/dept")
public class SysDeptController {

    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 加密返回数据
     *
     * @return
     */
    @ApiOperation(value="查人",notes="根据条件查人")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo",value="页码",required=true,paramType="query"),
            @ApiImplicitParam(name="pageSize",value="条数",required=true,paramType="query"),
            @ApiImplicitParam(name="userKey",value="字段名",required=true,paramType="query"),
            @ApiImplicitParam(name="userValue",value="值",required=true,paramType="query"),
            @ApiImplicitParam(name="eqOrLike",value="查询条件（T1~T8）",required=true,paramType="query")
    })
    @RequestMapping(value = "/getEncrpyDeptListByCondition", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getEncryptUserListByCondition(
            @RequestBody(required = false) EsourcingQueryVo queryVo
    ) throws Exception {
        JSONObject result = new JSONObject();
        if (queryVo != null && queryVo.getSearchParams()!=null) {
            String eqOrLike = queryVo.getSearchParams().getEqOrLike();
            if (!ConditionKey.CONDITION_KEY_LIST.contains(eqOrLike)) {
                result.put("status", 1);
                result.put("msg", "参数有误!");
                return result;
            }
        }
        JSONObject jsonObject = sysDeptService.getDeptListByCondition(queryVo);

        //result.put("data", encrptyDouble(jsonObject));

        result.put("data", jsonObject);

        result.put("status", 0);
        result.put("msg", "请求成功!");
        return result;
    }

}
