package com.hanergy.out.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hanergy.out.entity.SysUserEntity;
import com.hanergy.out.vo.EsourcingQueryVo;



/**
 * 系统用户
 */
public interface SysUserService extends IService<SysUserEntity> {
    /**
     * 根据条件查询在职员工
     */
    JSONObject getUserListByCondition(EsourcingQueryVo queryVo);
}
