package com.hanergy.out.service;

import com.alibaba.fastjson.JSONObject;
import com.hanergy.out.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hanergy.out.vo.EsourcingQueryVo;

/**
 * <p>
 * 部门 服务类
 * </p>
 *
 * @author Du Ronghong
 * @since 2019-07-23
 */
public interface ISysDeptService extends IService<SysDept> {
    /**
     * 根据条件查询在职员工
     */
    JSONObject getDeptListByCondition(EsourcingQueryVo queryVo);
}
