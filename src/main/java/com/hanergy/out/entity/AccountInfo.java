package com.hanergy.out.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Han LiDong
 * @since 2021-03-22
 */
@TableName("account_info")
@ApiModel(value="AccountInfo对象", description="")
public class AccountInfo extends Model<AccountInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "户主姓名")
    private String accountName;

    @ApiModelProperty(value = "银行卡号")
    private String accountNo;

    @ApiModelProperty(value = "帐户密码")
    private String accountPassword;

    @ApiModelProperty(value = "帐户余额")
    private Double accountBalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
            "id=" + id +
            ", accountName=" + accountName +
            ", accountNo=" + accountNo +
            ", accountPassword=" + accountPassword +
            ", accountBalance=" + accountBalance +
        "}";
    }
}
