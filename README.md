# zdm_push
什么值得买爆料优惠推送

实现监控什么值得买博主爆料自动推送手机服务

#### 配置参数
参考：src/main/resources/application.yml文件配置即可
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

github图片会挂点链接看吧：https://s3.ax1x.com/2020/12/29/rHchjg.png

![serverJ酱参数](https://s3.ax1x.com/2020/12/29/rHchjg.png)

#### pushPlus参数

文档之间看官网即可（不限制次数，不用github账号），比较推荐这个更简单点。

文档：http://pushplus.hxtrip.com/

github图片会挂点链接看吧：https://s3.ax1x.com/2020/12/29/rHguVA.png

![serverJ酱参数](https://s3.ax1x.com/2020/12/29/rHguVA.png)

#### 有java+mvn环境启动

- 本地有mvn环境的直接导入源代码运行ZdmPushApplication.java就可以了

#### 没有java+mvn环境启动

- 首先需要安装一个jdk1.8以上版本**（这个是必须的，百度一下安装教程很简单的我提供一个安装包：https://pan.jgsu.wiki/file/5fbf1553f71c88ca591df237/4a1061305251ea36e6fd2eda23b75a74/jdk-8u251-windows-x64.exe）**
- 下载jar包
- 新建txt文件，复制项目src/main/resources/application.yml文件的内容，粘贴进去，并且修改对应自己的key和需要监控的爆料人id，保存后，把文件txt后缀改成yml后缀
- 新建txt文件，复制项目run.bat文件的内容，粘贴进去，保存后，把文件txt后缀改成bat后缀
- 运行run.bat文件接口**（run.bat，application.yml,jar包必须在同一目录）**
- 上面需要的三个文件，application.yml，run.bat，jar包。直接下载地址：
**github：https://github.com/Grt1228/zdm_push/releases/download/v0.1/zdm_push.zip**

**蓝奏：https://266km.lanzous.com/i4napjtt9ta**


#### 实现效果

github图片会挂点链接看吧：https://p.ananas.chaoxing.com/star3/origin/a0fb9f24fdb7594e4579fc5ff08b3e41.png

![微信推送](https://p.ananas.chaoxing.com/star3/origin/a0fb9f24fdb7594e4579fc5ff08b3e41.png)

