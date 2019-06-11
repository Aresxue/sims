package com.asiainfo.ares.exceptions;

/**
 * @Author: Ares
 * @Date: 2019/6/10 19:51
 * @Description:
 * @Version: JDK 1.8
 */
public class RemoteInvokeException extends Exception
{
    private static final long serialVersionUID = -2038262924659942460L;
    /**
     * 响应码
     */
    private String errCode;
    /**
     * 响应描述
     */
    private String errMsg;

    public RemoteInvokeException()
    {
    }

    public RemoteInvokeException(String errCode, String errMsg)
    {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public RemoteInvokeException(String message)
    {
        super(message);
    }

    public RemoteInvokeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public RemoteInvokeException(Throwable cause)
    {
        super(cause);
    }

    public String getErrCode()
    {
        return errCode;
    }

    public void setErrCode(String errCode)
    {
        this.errCode = errCode;
    }

    public String getErrMsg()
    {
        return errMsg;
    }

    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }
}
