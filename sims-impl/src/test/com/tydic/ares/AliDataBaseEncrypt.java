package com.tydic.ares;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @Author Ares
 * @Date 2018/9/25 10:04
 * @Description:阿里数据库加解密算法
 * @Version JDK 1.8
 */
public class AliDataBaseEncrypt
{
    //加密
    public String encrypt()
    {
        return null;
    }


    public static void main(String[] args) throws Exception
    {
        //解密
        //        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIKsyFH0Y1H5HAQ/N7oDR1yjZQU16CmkgSYjMjSoUedDV4r9OBYXxKk9x65cjkaxBj0eeffDmLbb3yYcBR8aXeECAwEAAQ==";
        //        String password = "hJbcmYZ38F3PfkWu+pVMm8/CNfD5SWVVfXIpXJue94r42I7uQwy2cdMt856xA8DvhJOXBm9f8jTrSZgdu3Pv2g==";
        //
        //        try
        //        {
        //            System.out.println(ConfigTools.decrypt(publicKey, password));
        //        } catch (Exception e)
        //        {
        //            e.printStackTrace();
        //        }

        //加密
        ConfigTools.main(new String[]{"123456"});
    }
}
