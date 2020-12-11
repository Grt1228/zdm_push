# zdm_push
什么值得买爆料优惠推送

实现监控什么值得买博主爆料自动推送手机服务

#### 配置参数
参考：application.yml文件配置即可
```
# 配置自己的server酱key
# 参考地址：http://sc.ftqq.com/3.version
key: b082eb2****
# 什么值得买爆料人id：
# 参考：https://zhiyou.smzdm.com/member/9687682701/baoliao/
uid: 9687682701
# server酱有每天次数（重要重要重要）限制建议：60秒钟一次，已经做了重复限制，相同商品不会重复推送
corn: 0/59 * * * * ?
#测试频率：十秒一次
#corn: 0/30 * * * * ?
```

#### server酱参数
文档之间看官网即可

http://sc.ftqq.com/3.version

#### 启动
ZdmPushApplication.class

#### 实现效果
![微信推送](https://p.ananas.chaoxing.com/star3/origin/a0fb9f24fdb7594e4579fc5ff08b3e41.png)

