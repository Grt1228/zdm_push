# zdm_push
什么值得买爆料优惠推送

实现监控什么值得买博主爆料自动推送手机服务

#### 配置参数
参考：application.yml文件配置即可
```
key:
  #支持两种配置：【pushPlus】或者【serverJ】，二选一
  #pushPlus参考：http://pushplus.hxtrip.com/，不限制次数，不用github账号
  #serverJ参考：http://sc.ftqq.com/3.version ，需要github账号，限制次数
  type: pushPlus
  # 对应平台的key
  value: SCU68113********
#爆料人id：https://zhiyou.smzdm.com/member/9687682701/baoliao/ 参考这个链接
blr:
#支持多个爆料人id，用英文都好隔开即可
  uids: 9687682701,2031093162,3050600933
# 频率十秒一次  ，
#corn: 0/10 * * * * ?
# 三十秒一次
#corn: 0/30 * * * * ?
# 一分钟一次
corn: 0/59 * * * * ?
```

#### serverJ酱参数
文档之间看官网即可（需要github账号，限制次数）

文档：http://sc.ftqq.com/3.version

https://s3.ax1x.com/2020/12/29/rHchjg.png

![serverJ酱参数](https://s3.ax1x.com/2020/12/29/rHchjg.png)

#### pushPlus参数

文档之间看官网即可（不限制次数，不用github账号），比较推荐这个更简单点。

文档：http://pushplus.hxtrip.com/

https://s3.ax1x.com/2020/12/29/rHguVA.png
![serverJ酱参数](https://s3.ax1x.com/2020/12/29/rHguVA.png)

#### 启动
ZdmPushApplication.class

#### 实现效果

https://p.ananas.chaoxing.com/star3/origin/a0fb9f24fdb7594e4579fc5ff08b3e41.png

![微信推送](https://p.ananas.chaoxing.com/star3/origin/a0fb9f24fdb7594e4579fc5ff08b3e41.png)

