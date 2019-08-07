package com.hanergy.out.controller;

import ch.qos.logback.core.util.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.hanergy.out.service.SysUserService;
import com.hanergy.out.utils.RSAUtils;
import com.hanergy.out.vo.ConditionKey;
import com.hanergy.out.vo.EsourcingQueryVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserRestController
 * @Description TODO
 * @Author DURONGHONG
 * @DATE 2018/10/23 9:09
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/api/v1/user")
public class UserRestController {

    @Autowired
    private SysUserService userService;

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
    @RequestMapping(value = "/getEncrpyUserListByCondition", method = RequestMethod.POST)
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
        JSONObject jsonObject = userService.getUserListByCondition(queryVo);

        //result.put("data", encrptyDouble(jsonObject));

        result.put("data", jsonObject);

        result.put("status", 0);
        result.put("msg", "请求成功!");
        return result;
    }

    /**
     * 双重加密返回数据
     *
     * @param jsonObject
     * @return
     */
    private String encrptyDouble(JSONObject jsonObject) throws Exception {
        if (jsonObject != null && jsonObject.size() > 0) {
            String encryptByPublicKey = RSAUtils.encryptByPublicKey(jsonObject.toJSONString(), RSAUtils.ESOURCING_PUBLIC_KEY);
//          return AESUtil.encrypt(encryptByPublicKey, AESUtil.ECRYPT_PASSWORD);

            //String decryString = RSAUtils.decryptByPrivateKey(encryptByPublicKey,RSAUtils.ESOURCING_PRIVATE_KEY);
            return encryptByPublicKey;
        }
        return "";
    }
}

