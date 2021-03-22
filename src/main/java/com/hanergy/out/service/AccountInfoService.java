package com.hanergy.out.service;

import com.hanergy.out.entity.AccountInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Han LiDong
 * @since 2021-03-22
 */
public interface AccountInfoService extends IService<AccountInfo> {

    public List<AccountInfo> findAll();
}
