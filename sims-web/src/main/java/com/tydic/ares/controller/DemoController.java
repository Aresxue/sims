package com.tydic.ares.controller;


import com.asiainfo.ares.function.AuthorizationFuncService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tydic.ares.entity.ResponseBase;
import com.tydic.ares.entity.Student;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 测试所用
 *
 * @author Ares
 * @date 2018/1/24 10:57
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    //配合RestTemplate第二种方式
    //    @Autowired
    //    private LoadBalancerClient loadBalancerClient;

    //配合第三种方法
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthorizationFuncService authorizationFuncService;

    @HystrixCommand(fallbackMethod = "sayError")
    @RequestMapping(value = "/findStudentByName")
    public Student findStudentByName(HttpServletRequest request, @RequestBody(required = false) String parameters)
    {
        try
        {
            JSONObject jsonObject = JSONObject.fromObject(parameters);
            String studentName = jsonObject.getString("studentName");
            LOGGER.info("studentName:" + studentName);
            Student student = new Student();
            student.setStudentName(studentName);

/*
            //1.第一种写法，硬编码，有两个问题：
            //当注册中心有很多服务时，我们可能不知道我们需要的服务由谁提供、api是多少，因此就可能无法调用到服务。
            //当某个服务部署了多个，例如 api 是： “localhost:9080/getMsg，localhost:9081/getMsg “，那么此时就需要负载均衡，这种硬编码显然不符合场景。
            //且此形式只能以ip+端口调用，无法使用服务名调用，这也是无法实现负载均衡的原因（ip+端口只有一个实例）
            RestTemplate restTemplate = new RestTemplate();
            //这里根据需要选取请求类型，也可以统一用get，然后将信息用ObjectMaper读取为参数实体，还可以用***forEntity获取消息头等更详尽的信息，由于是内部交互，为了节省开销一般使用***forObject
            student = restTemplate.postForObject("http://localhost:8082/com/tydic/ares/serviceImpl/findStudentByName", student, Student.class);
*/
/*

            //2.第二种调用方式，相比第一种url使用拼接方式而非硬编码，且最终使用实例名调用
            RestTemplate restTemplate = new RestTemplate();
            //这里的实例名为指定,包括第三种都可以做成配置项
            ServiceInstance serviceInstance = loadBalancerClient.choose("SIMS-IMPL");
            String url = String.format("http://%s:%s%s", serviceInstance.getHost(), serviceInstance.getPort(), "/com/tydic/ares/serviceImpl/findStudentByName");
            student = restTemplate.postForObject(url, student, Student.class);
*/
            //第三种，目前来看最好的方法
            student = restTemplate.postForObject("http://SIMS-IMPL/com/tydic/ares/serviceImpl/findStudentByName", student, Student.class);

            return student;
        } catch (JSONException e)
        {
            throw new RuntimeException("字符串转json出错");
        } catch (Exception e)
        {
            LOGGER.error("我有种不好的预感", e);
            throw new RuntimeException("阿哦,出错了");
        }
    }

    @RequestMapping(value = "/findStudentById")
    public Student findStudentById(HttpServletRequest request, @RequestBody(required = false) String parameters)
    {
        try
        {
            JSONObject jsonObject = JSONObject.fromObject(parameters);
            Long studentId = jsonObject.getLong("studentId");
            LOGGER.info("studentId:" + studentId);
            Student student = null;
            return student;
        } catch (JSONException e)
        {
            throw new RuntimeException("字符串转json出错");
        } catch (Exception e)
        {
            LOGGER.error("我有种不好的预感", e);
            throw new RuntimeException("阿哦,出错了");
        }
    }


    @RequestMapping(value = "/addStudent")
    public ResponseBase addStudent(HttpServletRequest request, @RequestBody(required = false) String parameters)
    {
        try
        {
            JSONObject jsonObject = JSONObject.fromObject(parameters);
            String studentName = jsonObject.getString("studentName");
            String studentId = jsonObject.getString("studentId");
            String classId = jsonObject.getString("classId");
            String studentSex = jsonObject.getString("studentSex");
            String studentAge = jsonObject.getString("studentAge");
            Student student = new Student();
            student.setStudentName(studentName);
            student.setStudentId(Long.valueOf(studentId));
            student.setClassId(Integer.valueOf(classId));
            student.setStudentSex(studentSex);
            student.setStudentAge(Integer.valueOf(studentAge));
            ResponseBase responseBase = null;
            return responseBase;
        } catch (JSONException e)
        {
            throw new RuntimeException("字符串转json出错");
        } catch (Exception e)
        {
            LOGGER.error("我有种不好的预感", e);
            throw new RuntimeException("阿哦,出错了");
        }
    }

    //这个方法的请求和相应入参类型和个数要与原方法
    public Student sayError(HttpServletRequest request, String parameters)
    {
        Student student = new Student();
        student.setStudentName("我有问题啊");
        student.setStudentAge(10000);
        LOGGER.error("我好像出错了兄弟");
        return student;
    }

    @RequestMapping(value = "/authorization")
    public void authorization(HttpServletRequest request)
    {
        authorizationFuncService.authorization();
    }

    @RequestMapping(value = "/testRequest")
    public void testRequest(@RequestBody Student student)
    {
        LOGGER.info("testRequest: " + student.getStudentName());
    }

    /**
     * @Author: Ares
     * @Description: body的参数是以流的形式(也可能是二进制)
     * RequestBody注解的作用就是把该流的数据绑定到参数
     * @Date: 2019/6/8 15:52
     * @Param: [request, student] 请求参数
     * @return: void 响应参数
     **/
    @RequestMapping(value = "/testRequest1")
    public void testRequest1(HttpServletRequest request, Student student) throws IOException
    {
        LOGGER.info(request.getQueryString());
        request.getParameterMap().forEach((k, v) -> LOGGER.info(Arrays.toString(v)));
        LOGGER.info("testRequest1: " + student.getStudentName());

        // 这种方式中文会变为unicode
        request.setCharacterEncoding("utf8");
        BufferedReader br = request.getReader();
        String str = null;
        StringBuilder wholeStr = new StringBuilder();
        while((str = br.readLine()) != null)
        {
            wholeStr.append(str);
        }
        LOGGER.info(wholeStr.toString());
    }


    /**
     * @author: Ares
     * @description: 测试使用Long和long接收浮点型参数是报错还是丢失精度
     * 结论是long和Long都不会报错，但是会丢失精度
     * @date: 2019/9/7 19:35
     * @param: [request, param] 请求参数
     * @return: void 响应参数
     */
    @RequestMapping(value = "/testLong")
    public void testLong(HttpServletRequest request, @RequestBody Student student)
    {
        LOGGER.info("参数为: {}", student);
    }
}