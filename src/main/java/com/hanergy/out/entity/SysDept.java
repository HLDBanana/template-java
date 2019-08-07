package com.hanergy.out.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author Du Ronghong
 * @since 2019-07-23
 */
@TableName("sys_dept")
@ApiModel(value="SysDept对象", description="部门")
public class SysDept extends Model<SysDept> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键：部门ID")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "上级（根的上级是-1）")
    private String upid;

    @ApiModelProperty(value = "部门类型")
    private String type;

    @ApiModelProperty(value = "部门级别：杨国栋2019年6月10日新增")
    private Integer level;

    @ApiModelProperty(value = "合计人数：从末级部门层层递归   杨国栋2019年7月9日新增")
    private Integer 

totalNumber;

    @ApiModelProperty(value = "部门状态：1使用中；2作废")
    private String state;

    @ApiModelProperty(value = "全路径id")
    private String fullPathId;

    @ApiModelProperty(value = "全路径名称")
    private String fullPathName;

    @ApiModelProperty(value = "部门负责人工号")
    private String manage;

    @ApiModelProperty(value = "部门负责人姓名")
    private String manageName;

    @ApiModelProperty(value = "部门负责人主键")
    private String manageId;

    @ApiModelProperty(value = "创建时间；是否为同步时间？")
    private Date createTime;

    @ApiModelProperty(value = "修改时间；是否为同步时间？")
    private Date updateTime;

    @ApiModelProperty(value = "是否同步OA,02-不同步,01和空同步")
    private String oaSync;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getUpid() {
        return upid;
    }

    public void setUpid(String upid) {
        this.upid = upid;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    public Integer gettotalNumber() {
        return totalNumber;
    }

    public void settotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getFullPathId() {
        return fullPathId;
    }

    public void setFullPathId(String fullPathId) {
        this.fullPathId = fullPathId;
    }
    public String getFullPathName() {
        return fullPathName;
    }

    public void setFullPathName(String fullPathName) {
        this.fullPathName = fullPathName;
    }
    public String getManage() {
        return manage;
    }

    public void setManage(String manage) {
        this.manage = manage;
    }
    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }
    public String getManageId() {
        return manageId;
    }

    public void setManageId(String manageId) {
        this.manageId = manageId;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public String getOaSync() {
        return oaSync;
    }

    public void setOaSync(String oaSync) {
        this.oaSync = oaSync;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysDept{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", upid=" + upid +
        ", type=" + type +
        ", level=" + level +
        ", totalNumber=" + totalNumber +
        ", state=" + state +
        ", fullPathId=" + fullPathId +
        ", fullPathName=" + fullPathName +
        ", manage=" + manage +
        ", manageName=" + manageName +
        ", manageId=" + manageId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", oaSync=" + oaSync +
        "}";
    }
}
