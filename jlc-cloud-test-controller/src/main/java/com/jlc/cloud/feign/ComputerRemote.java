package com.jlc.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// name:远程服务名，及spring.application.name配置的名称
@FeignClient(name= "compute-service")
public interface ComputerRemote {
	
	@RequestMapping(value = "/add")
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}