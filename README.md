# template-cloud

springcloud模板项目，整合了feign服务调用、hystrix熔断器、sleuth日志埋点、zipkin链路追踪、zuul网关、config配置中心。
后续需要使用docker部署。

## 部署在118的/data/projcets/joint文件夹下面

#### 部署方式: 
    #### 首先将hanergy-out.jar上传到204的/home/root/upload下面,
    然后进入堡垒机,进入118服务器,使用以下命令传输jar包
    
    sudo scp root@192.168.18.204:/root/uplaod/hanergy-out.jar .
    
    输入密码: 12345@bdbi