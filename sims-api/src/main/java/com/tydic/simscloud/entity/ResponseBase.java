package com.tydic.simscloud.entity;

/**
 * @author Ares
 * @date 2018/1/31 16:38
 */
public class ResponseBase
{
    //返回码
    private String returnCode;
    //返回描述
    private String returnDesc;

    public String getReturnCode()
    {
        return returnCode;
    }

    public void setReturnCode(String returnCode)
    {
        this.returnCode = returnCode;
    }

    public String getReturnDesc()
    {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc)
    {
        this.returnDesc = returnDesc;
    }
}
