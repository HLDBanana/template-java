package com.hanergy.out.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanergy.out.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

}
