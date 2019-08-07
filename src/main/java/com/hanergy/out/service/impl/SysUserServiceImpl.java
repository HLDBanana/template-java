package com.hanergy.out.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanergy.out.dao.SysUserDao;
import com.hanergy.out.entity.SysUserEntity;
import com.hanergy.out.service.SysUserService;
import com.hanergy.out.utils.PageUtils;
import com.hanergy.out.vo.EsourcingQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * 系统用户
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public JSONObject getUserListByCondition(EsourcingQueryVo queryVo) {
        JSONObject result = new JSONObject();
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_id,name,email,job_number,department,department_tree_name");
        Integer pageNo = null;
        Integer pageSize = null;
        if (queryVo != null) {
            pageNo = queryVo.getPageNo();
            pageSize = queryVo.getPageSize();
        }

        String userKey = "", userValue = "", eqOrLike = "";
        if (queryVo != null && queryVo.getSearchParams() != null) {
            userKey = queryVo.getSearchParams().getUserKey();
            userValue = queryVo.getSearchParams().getUserValue();
            eqOrLike = queryVo.getSearchParams().getEqOrLike();
        }
        buildQueryWrapper(eqOrLike, userKey, userValue, queryWrapper, result);

        if (pageNo == null || pageSize == null) {
            List<SysUserEntity> userEntity = this.list(queryWrapper);
//            for (SysUserEntity userEN : userEntity) {
////                userEN.setPassword("********");
//                if (userEN.getFlag() == 1) {
//                    userEN.setStatus(0);
//                } else {
//                    userEN.setStatus(1);
//                }
//                userEN.setFlag(null);
//            }
            JSONObject userJson = new JSONObject();
            userJson.put("totalCount", userEntity.size());
            userJson.put("list", trimEmptyAttr(userEntity));
            result.put("userList", userJson);
            result.put("totalCount", userEntity.size());
        } else {
            Page<SysUserEntity> queryPage = new Page<>(pageNo, pageSize);
            IPage<SysUserEntity> userPage = this.page(queryPage, queryWrapper);
            for (SysUserEntity userEN : userPage.getRecords()) {
                if (userEN.getFlag() == 1) {
                    userEN.setStatus(0);
                } else {
                    userEN.setStatus(1);
                }
                userEN.setFlag(null);
            }
            result.put("userList", new PageUtils(userPage));
            result.put("totalCount", userPage.getTotal());
        }

        System.out.println();
        return result;
    }

    private void buildQueryWrapper(String eqOrLike, String userKey, String userValue, QueryWrapper<SysUserEntity> queryWrapper, JSONObject result) {
        if (StringUtils.isEmpty(userKey) || StringUtils.isEmpty(eqOrLike)) {
            queryWrapper.in("flag", 0, 2);
        } else {
            queryWrapper.in("flag", 0, 2);
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


    private JSONArray trimEmptyAttr(List<SysUserEntity> list) {
        if (!CollectionUtils.isEmpty(list)) {
            return JSONArray.parseArray(JSONObject.toJSONString(list));
        }
        return new JSONArray();
    }
}
