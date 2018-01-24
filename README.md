#####基于Apache CXF框架，并以“Contract-First”模式进行服务客户端开发，并对请求进行拦截校验Header。“Contract-First”模式指的是基于契约文件（WSDL和XSD）开发对应的Java代码，可以在安装好Apache CXF后，并配置完成相关环境变量，通过wsdl2java生成对应的Java代码，实现方式有很多，这里推荐两种常用方式。
1.  在拥有WSDL和XSD的目录，执行wsdl2java命令以后，将得到的Java代码拷贝至代码工程源代码路径
2.  本例为Maven工程，借助cxf-codegen-plugin插件，将在代码编译期间生成Java代码，开发工具IDE需要设置target\generated\cxf为源代码路径

启动服务端，进入CxfServer目录， 运行端口8484，可在application.properties文件调整
```
mvn clean spring-boot:run
```		
浏览器访问http://localhost:8484/services 查看服务发布的WSDL地址

启动客户端端，进入CxfClient目录， 运行端口8485，可在application.properties文件调整
```
mvn clean spring-boot:run
```	

观察控制台日志输出。