package com.tydic.ares.entity;

/**
 * @author: Ares
 * @date: 2019/11/2 11:04
 * @description: 测试teledb事务
 * @version: JDK 1.8
 */
public class AcctBalanceEntity
{
    /**
     * 余额帐本标识
     */
    private Long acctBalanceId;
    /**
     * 余额帐本类型标识
     */
    private Long balanceTypeId;
    /**
     * 帐户标识
     */
    private Long acctId;
    /**
     * 用户标识
     */
    private Long prodInstId;
    /**
     * 帐本余额
     */
    private Long balance;
    /**
     * 修改之前帐本余额，修改余额数据做稽核
     */
    private Long oldBalance;
    /**
     * 状态
     */
    private Short statusCd;
    /**
     * 生效时间
     */
    private String effDate;
    /**
     * 失效时间
     */
    private String expDate;
    /**
     * 当前时间
     */
    private String sysDate;
    /**
     * 对象类型
     */
    private Short objectTypeId;
    /**
     * 专款标识
     */
    private Long spePaymentId;
    /**
     * 帐目组标识
     */
    private Long acctItemGroupId;
    /**
     * 状态时间
     */
    private String statusDate;
    /**
     * 生成时间
     */
    private String createDate;
    /**
     * 路由标识
     */
    private Long routeId;
    /**
     * 余额共享标识
     */
    private Short shareRuleFlag = 0;
    /**
     * 保留金额
     */
    private Long reserveBalance = 0L;
    /**
     * 余额上限
     */
    private Long cycleUpper;
    /**
     * 余额下限
     */
    private Long cycleLower;
    /**
     * 类型
     */
    private Short cycleType;
    /**
     * 帐本操作动作: 0(insert操作)、1(update操作)、(2delete操作)
     */
    private Short action;
    /**
     * 余额UPDATE操作时候具体动作0(根据字段ACCT_BALANBCE_ID更新字段BALANCE)、1()
     */
    private Short actionUpdate;
    /**
     * 余额分表名
     */
    private String acctBalanceTableName;
    /**
     * 余额类型名称
     */
    private String balanceTypeName;
    /**
     * 余额对象优先级
     */
    private Short balanceObjectTypePriority;
    /**
     * 余额类型优先级
     */
    private Long balanceTypePriority;
    /**
     * 支出余额
     */
    private Long payAmount;
    /**
     * 允许提取标志
     */
    private Integer allowDraw;
    private Short ifEarning;
    /**
     * 是否允许转入转出
     */
    private Short transFlag;
    private Short ifPrincipal;
    private Short ifPayold;

    public Long getAcctBalanceId()
    {
        return acctBalanceId;
    }

    public void setAcctBalanceId(Long acctBalanceId)
    {
        this.acctBalanceId = acctBalanceId;
    }

    public Long getBalanceTypeId()
    {
        return balanceTypeId;
    }

    public void setBalanceTypeId(Long balanceTypeId)
    {
        this.balanceTypeId = balanceTypeId;
    }

    public Long getAcctId()
    {
        return acctId;
    }

    public void setAcctId(Long acctId)
    {
        this.acctId = acctId;
    }

    public Long getProdInstId()
    {
        return prodInstId;
    }

    public void setProdInstId(Long prodInstId)
    {
        this.prodInstId = prodInstId;
    }

    public Long getBalance()
    {
        return balance;
    }

    public void setBalance(Long balance)
    {
        this.balance = balance;
    }

    public Long getOldBalance()
    {
        return oldBalance;
    }

    public void setOldBalance(Long oldBalance)
    {
        this.oldBalance = oldBalance;
    }

    public Short getStatusCd()
    {
        return statusCd;
    }

    public void setStatusCd(Short statusCd)
    {
        this.statusCd = statusCd;
    }

    public String getEffDate()
    {
        return effDate;
    }

    public void setEffDate(String effDate)
    {
        this.effDate = effDate;
    }

    public String getExpDate()
    {
        return expDate;
    }

    public void setExpDate(String expDate)
    {
        this.expDate = expDate;
    }

    public String getSysDate()
    {
        return sysDate;
    }

    public void setSysDate(String sysDate)
    {
        this.sysDate = sysDate;
    }

    public Short getObjectTypeId()
    {
        return objectTypeId;
    }

    public void setObjectTypeId(Short objectTypeId)
    {
        this.objectTypeId = objectTypeId;
    }

    public Long getSpePaymentId()
    {
        return spePaymentId;
    }

    public void setSpePaymentId(Long spePaymentId)
    {
        this.spePaymentId = spePaymentId;
    }

    public Long getAcctItemGroupId()
    {
        return acctItemGroupId;
    }

    public void setAcctItemGroupId(Long acctItemGroupId)
    {
        this.acctItemGroupId = acctItemGroupId;
    }

    public String getStatusDate()
    {
        return statusDate;
    }

    public void setStatusDate(String statusDate)
    {
        this.statusDate = statusDate;
    }

    public String getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }

    public Long getRouteId()
    {
        return routeId;
    }

    public void setRouteId(Long routeId)
    {
        this.routeId = routeId;
    }

    public Short getShareRuleFlag()
    {
        return shareRuleFlag;
    }

    public void setShareRuleFlag(Short shareRuleFlag)
    {
        this.shareRuleFlag = shareRuleFlag;
    }

    public Long getReserveBalance()
    {
        return reserveBalance;
    }

    public void setReserveBalance(Long reserveBalance)
    {
        this.reserveBalance = reserveBalance;
    }

    public Long getCycleUpper()
    {
        return cycleUpper;
    }

    public void setCycleUpper(Long cycleUpper)
    {
        this.cycleUpper = cycleUpper;
    }

    public Long getCycleLower()
    {
        return cycleLower;
    }

    public void setCycleLower(Long cycleLower)
    {
        this.cycleLower = cycleLower;
    }

    public Short getCycleType()
    {
        return cycleType;
    }

    public void setCycleType(Short cycleType)
    {
        this.cycleType = cycleType;
    }

    public Short getAction()
    {
        return action;
    }

    public void setAction(Short action)
    {
        this.action = action;
    }

    public Short getActionUpdate()
    {
        return actionUpdate;
    }

    public void setActionUpdate(Short actionUpdate)
    {
        this.actionUpdate = actionUpdate;
    }

    public String getAcctBalanceTableName()
    {
        return acctBalanceTableName;
    }

    public void setAcctBalanceTableName(String acctBalanceTableName)
    {
        this.acctBalanceTableName = acctBalanceTableName;
    }

    public String getBalanceTypeName()
    {
        return balanceTypeName;
    }

    public void setBalanceTypeName(String balanceTypeName)
    {
        this.balanceTypeName = balanceTypeName;
    }

    public Short getBalanceObjectTypePriority()
    {
        return balanceObjectTypePriority;
    }

    public void setBalanceObjectTypePriority(Short balanceObjectTypePriority)
    {
        this.balanceObjectTypePriority = balanceObjectTypePriority;
    }

    public Long getBalanceTypePriority()
    {
        return balanceTypePriority;
    }

    public void setBalanceTypePriority(Long balanceTypePriority)
    {
        this.balanceTypePriority = balanceTypePriority;
    }

    public Long getPayAmount()
    {
        return payAmount;
    }

    public void setPayAmount(Long payAmount)
    {
        this.payAmount = payAmount;
    }

    public Integer getAllowDraw()
    {
        return allowDraw;
    }

    public void setAllowDraw(Integer allowDraw)
    {
        this.allowDraw = allowDraw;
    }

    public Short getIfEarning()
    {
        return ifEarning;
    }

    public void setIfEarning(Short ifEarning)
    {
        this.ifEarning = ifEarning;
    }

    public Short getTransFlag()
    {
        return transFlag;
    }

    public void setTransFlag(Short transFlag)
    {
        this.transFlag = transFlag;
    }

    public Short getIfPrincipal()
    {
        return ifPrincipal;
    }

    public void setIfPrincipal(Short ifPrincipal)
    {
        this.ifPrincipal = ifPrincipal;
    }

    public Short getIfPayold()
    {
        return ifPayold;
    }

    public void setIfPayold(Short ifPayold)
    {
        this.ifPayold = ifPayold;
    }
}
