package com.unfbx.zdm_push.pipeline;

import com.unfbx.zdm_push.pojo.ZdmInfo;
import com.unfbx.zdm_push.service.ServerPush;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @Description
 * @Author Grt
 * @Date 2020-12-11
 */
@Service
@Log
public class ZdmPipeline implements Pipeline {

    @Autowired
    private ServerPush serverPush = new ServerPush();

    @Override
    public void process(ResultItems resultItems, Task task) {
        ZdmInfo zdmInfo = new ZdmInfo();
        zdmInfo.setName(resultItems.get("name"));
        zdmInfo.setUrl(resultItems.get("url"));
        if (resultItems.get("flag")){
            serverPush.pushMsgToWechat(zdmInfo);
        }else {
            log.info("~~~~~~~~~~~~~~~~暂无更新数据~~~~~~~~~~~~~~~~");
        }
    }
}
