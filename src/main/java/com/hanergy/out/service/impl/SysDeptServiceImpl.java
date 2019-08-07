package com.hanergy.out.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanergy.out.entity.SysDept;
import com.hanergy.out.dao.SysDeptMapper;
import com.hanergy.out.entity.SysUserEntity;
import com.hanergy.out.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanergy.out.utils.PageUtils;
import com.hanergy.out.vo.EsourcingQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author Du Ronghong
 * @since 2019-07-23
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {


    @Override
    public JSONObject getDeptListByCondition(EsourcingQueryVo queryVo) {
        JSONObject result = new JSONObject();
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id,name,upid,full_path_name,full_path_id");
        Integer pageNo = null;
        Integer pageSize = null;
        if (queryVo != null) {
            pageNo = queryVo.getPageNo();
            pageSize = queryVo.getPageSize();
        }
        String deptKey = "", deptValue = "", eqOrLike = "";
        if (queryVo != null && queryVo.getSearchParams() != null) {
            deptKey = queryVo.getSearchParams().getUserKey();
            deptValue = queryVo.getSearchParams().getUserValue();
            eqOrLike = queryVo.getSearchParams().getEqOrLike();
        }
        buildQueryWrapper(eqOrLike, deptKey, deptValue, queryWrapper, result);

        if (pageNo == null || pageSize == null) {
            List<SysDept> userEntity = this.list(queryWrapper);
            JSONObject userJson = new JSONObject();
            userJson.put("totalCount", userEntity.size());
            userJson.put("list", trimEmptyAttr(userEntity));
            result.put("userList", userJson);
            result.put("totalCount", userEntity.size());
        } else {
            Page<SysDept> queryPage = new Page<>(pageNo, pageSize);
            IPage<SysDept> deptPage = this.page(queryPage, queryWrapper);
//            for (SysDept userEN : userPage.getRecords()) {
//                if (userEN.getFlag() == 1) {
//                    userEN.setStatus(0);
//                } else {
//                    userEN.setStatus(1);
//                }
//                userEN.setFlag(null);
//            }
            result.put("userList", new PageUtils(deptPage));
            result.put("totalCount", deptPage.getTotal());
        }

        System.out.println();
        return result;
    }

    private void buildQueryWrapper(String eqOrLike, String userKey, String userValue, QueryWrapper<SysDept> queryWrapper, JSONObject result) {
        if (!StringUtils.isEmpty(userKey) && !StringUtils.isEmpty(eqOrLike)) {
            switch (eqOrLike) {
                case "T1":
                    queryWrapper.eq(userKey.trim(), userValue.trim());
                    break;
                case "T2":
                    queryWrapper.gt(userKey.trim(), userValue.trim());
                    break;
                case "T3":
                    queryWrapper.ge(userKey.trim(), userValue.trim());
                    break;
                case "T4":
                    queryWrapper.lt(userKey.trim(), userValue.trim());
                    break;
                case "T5":
                    queryWrapper.le(userKey.trim(), userValue.trim());
                    break;
                case "T6":
                    queryWrapper.likeLeft(userKey.trim(), userValue.trim());
                    break;
                case "T7":
                    queryWrapper.likeRight(userKey.trim(), userValue.trim());
                    break;
                case "T8":
                    queryWrapper.like(userKey.trim(), userValue.trim());
                    break;
                default:
                    result.put("status", 1);
                    result.put("msg", "参数有误!");
                    break;
            }
        }
    }
    private JSONArray trimEmptyAttr(List<SysDept> list) {
        if (!CollectionUtils.isEmpty(list)) {
            return JSONArray.parseArray(JSONObject.toJSONString(list));
        }
        return new JSONArray();
    }
}
