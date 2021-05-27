package com.hubject.user.controller;

import com.hubject.api.controller.user.HelloControllerApi;
import com.hubject.grace.result.GraceJSONResult;
import com.hubject.utils.RedisOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloControllerApi {

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RedisOperator redis;

//    Swagger2 文档生成工具
    @Override
    public Object hello() {

        logger.debug("debug: hello~");
        logger.info("info: hello~");
        logger.warn("warn: hello~");
        logger.error("error: hello~");

//        return "hello";
//        return IMOOCJSONResult.ok();
//        return IMOOCJSONResult.ok("hello");
//        return IMOOCJSONResult.errorMsg("您的信息有误~！");
        return GraceJSONResult.ok();
    }

    @GetMapping("/redis")
    public Object redis() {
        redis.set("age", "18");
        GraceJSONResult age = GraceJSONResult.ok(redis.get("age"));
        return age;
    }

}
