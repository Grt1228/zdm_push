package com.unfbx.zdm_push;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@RetrofitScan("com.unfbx.zdm_push.api")
@ComponentScan(basePackages = {"com.unfbx.zdm_push.pipeline","com.unfbx.zdm_push.service","com.unfbx.zdm_push.task"})
public class ZdmPushApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZdmPushApplication.class, args);
    }

}
