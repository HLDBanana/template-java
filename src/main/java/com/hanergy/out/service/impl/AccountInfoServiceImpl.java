package com.hanergy.out.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hanergy.out.entity.AccountInfo;
import com.hanergy.out.dao.AccountInfoMapper;
import com.hanergy.out.service.AccountInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Han LiDong
 * @since 2021-03-22
 */
@Service
public class AccountInfoServiceImpl extends ServiceImpl<AccountInfoMapper, AccountInfo> implements AccountInfoService {

    @Override
    public List<AccountInfo> findAll() {
        QueryWrapper<AccountInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("id");
        return this.baseMapper.selectList(queryWrapper);
    }
}
