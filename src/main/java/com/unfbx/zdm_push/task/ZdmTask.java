package com.unfbx.zdm_push.task;

import com.unfbx.zdm_push.pipeline.ZdmPipeline;
import com.unfbx.zdm_push.processor.ZdmPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * @Description 定时拉取：十分钟一次
 * @Author Grt
 * @Date 2020-12-11
 */
@Component
public class ZdmTask {

    private int i;
    @Autowired
    private ZdmPipeline zdmPipeline;
    @Value("${uid}")
    private String uid;

    ZdmPageProcessor zdmPageProcessor = new ZdmPageProcessor();

    /**
     * 十分钟执行一次
     */
    @Scheduled(cron = "${corn}")
    public void execute() {
        Spider.create(zdmPageProcessor)
                .addUrl("https://zhiyou.smzdm.com/member/"+uid+"/baoliao/")
                .addPipeline(zdmPipeline)
                .thread(1)
                .run();
    }
}
