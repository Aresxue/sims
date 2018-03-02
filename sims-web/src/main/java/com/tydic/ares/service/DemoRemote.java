package com.tydic.ares.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Ares
 * @date 2018/3/2 16:48
 */
@FeignClient("SIMS-IMPL")
public interface DemoRemote extends DemoService
{
}
