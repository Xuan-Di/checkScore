# checkScore
## 第一步：打通微信端 

![图片描述](http://wzxlq.xyz/iword/sp20200617_160231_404.png)
### 链接改 域名 和 agentid
https://open.weixin.qq.com/connect/oauth2/authorize?appid=ww9b8c761b26841ee0&redirect_uri=http://it.bgcloud.top:8888&response_type=code&scope=snsapi_privateinfo&agentid=1000002#wechat_redirect
#### agentid改为微信企业号对应的。
### 设置可信域名
![图片描述](http://wzxlq.xyz/iword/Snipaste_2020-06-17_16-11-03.png)

## 第二步: 修改源码。两处。带有TODO注释的地方都要修改。
![图片描述](http://wzxlq.xyz/iword/Snipaste_2020-06-17_16-17-54.png)
## 第三步：利用Maven编译并打成jar包，发布到服务器并运行。
## 第四步：打开插入数据库exe工具输入excel文件目录。第一个行是插入成绩到数据库。第二行是插入老师名单到数据库。
### 注意1.两个文件夹目录是独立的，不能一样。2.两个文件夹中不要放入本项目需要的excel之外的其他文件。
![图片描述](http://wzxlq.xyz/iword/Snipaste_2020-06-17_16-23-56.png)
### 注意事项：该项目只能跑在域名为it.bgcloud.top的服务器。端口号8888在项目中已写死，不能改变。
