package com.hanergy.out.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 */
@TableName("sys_user")
public class SysUserEntity extends Model<SysUserEntity> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId
    private Long userId;

    /**
     * 登陆名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 角色ID列表
     */
    @TableField(exist = false)
    private List<Long> roleIdList;

    /**
     * 创建者ID
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户类型: 1招聘总监 2 招聘负责人
     */
    private Integer userType;
    /**
     * 工号
     */
    private String jobNumber;
    /**
     * [SF系统]用户id
     */
    private String sfUserId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 职位id
     */
    @TableField("position_id")
    private String positionId;

    /**
     * 职位名称
     */
    private String position;

    /**
     * 部门名称
     */
    private String department;

    /**
     * 部门id
     */
    @TableField("department_id")
    private String departmentId;

    /**
     * 部门树 ，多个部门阶段用“，”逗号隔开
     */
    @TableField("department_tree")
    private String departmentTree;

    /**
     * 部门树名称，多个部门用“，”隔开
     */
    @TableField("department_tree_name")
    private String departmentTreeName;


    /**
     *  工作地点
     */
    @TableField("work_place")
    private String workPlace;

    /**
     * 毕业学校(距离当前最近的学历)
     */
    @TableField("graduate_school")
    private String graduateSchool;


    /**
     *  身份证号码
     */
    @TableField("id_card")
    private String idCard;


    /**
     *  专业
     */
    private String major;

    /**
     * 入职开始时间
     */
    private String bigda;

    /**
     *  离职时间
     */
    private String endda;
    
    /**
     * 异动开始时间
     */
    private String ydks;

    /**
     *  异动结束时间
     */
    private String ydjs;
    
    /**
     * 异动类型：1离职2入职3调动
     */
    @TableField(exist = false)
    private String ydlx;
    
    /**
     * 在职情况：0：在职 ； 1：离职
     */
    private Integer flag;
    
    //上级汇报人工号
    private String manage;
    
    //座机号
    private String phone;
    
    //源更新时间
    private String source_time;

    private String oaSync;

    public String getOaSync() {
        return oaSync;
    }

    public void setOaSync(String oaSync) {
        this.oaSync = oaSync;
    }

    public String getYdks() {
		return ydks;
	}

	public void setYdks(String ydks) {
		this.ydks = ydks;
	}

	public String getYdjs() {
		return ydjs;
	}

	public void setYdjs(String ydjs) {
		this.ydjs = ydjs;
	}

	public String getYdlx() {
		return ydlx;
	}

	public void setYdlx(String ydlx) {
		this.ydlx = ydlx;
	}

	public String getManage() {
		return manage;
	}

	public void setManage(String manage) {
		this.manage = manage;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSource_time() {
		return source_time;
	}

	public void setSource_time(String source_time) {
		this.source_time = source_time;
	}

	/**
     * 设置：
     *
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：
     *
     * @return Long
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置：用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：用户名
     *
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置：密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：密码
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置：邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：邮箱
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：手机号
     *
     * @return String
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置：状态  0：禁用   1：正常
     *
     * @param status 状态  0：禁用   1：正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态  0：禁用   1：正常
     *
     * @return Integer
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    protected Serializable pkVal() {
        // TODO Auto-generated method stub
        return this.userId;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getSfUserId() {
        return sfUserId;
    }

    public void setSfUserId(String sfUserId) {
        this.sfUserId = sfUserId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentTree() {
        return departmentTree;
    }

    public void setDepartmentTree(String departmentTree) {
        this.departmentTree = departmentTree;
    }

    public String getDepartmentTreeName() {
        return departmentTreeName;
    }

    public void setDepartmentTreeName(String departmentTreeName) {
        this.departmentTreeName = departmentTreeName;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getBigda() {
        return bigda;
    }

    public void setBigda(String bigda) {
        this.bigda = bigda;
    }

    public String getEndda() {
        return endda;
    }

    public void setEndda(String endda) {
        this.endda = endda;
    }

    public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
