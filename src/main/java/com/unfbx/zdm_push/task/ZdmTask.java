package com.unfbx.zdm_push.task;

import com.unfbx.zdm_push.pipeline.ZdmPipeline;
import com.unfbx.zdm_push.processor.ZdmPageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.extern.java.Log;
import us.codecraft.webmagic.Spider;

/**
 * @Description 定时拉取：十分钟一次
 * @Author Grt
 * @Date 2020-12-11
 */
@Component
@Log
public class ZdmTask {

    private int i;
    @Autowired
    private ZdmPipeline zdmPipeline;
    @Value("${blr.uids}")
    private String[] uids;

    ZdmPageProcessor zdmPageProcessor = new ZdmPageProcessor();

    /**
     * 十分钟执行一次
     */
    @Scheduled(cron = "${corn}")
    public void execute() {
        if(uids == null || uids.length <= 0){
            log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~没有配置需要监控的博主~~~~~~~~~~~~~~~~~~~~~~~~~~");
            return;
        }
        for (String uid : uids){
            Spider.create(zdmPageProcessor)
                    .addUrl("https://zhiyou.smzdm.com/member/"+uid+"/baoliao/")
                    .addPipeline(zdmPipeline)
                    .thread(1)
                    .run();
        }
    }
}
