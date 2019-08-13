package com.tydic.ares.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;

/**
 * @author Ares
 * @date 2018/3/2 16:48
 */
@FeignClient("SIMS-IMPL")
@Repository
public interface DemoRemote extends DemoService
{
}
