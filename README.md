# Spring rookie

自己搭建一个基于springboot的web运行环境.

---

## 1. 配置说明


### 1.1 About starter

关于 springboot的starter [link](https://segmentfault.com/p/1210000011564985/read)

> starter的理念:starter会把所有用到的依赖都给包含进来,避免了开发者自己去引入依赖所带来的麻烦.需要注意的是不同的starter是为了解决不同的依赖,所以它们内部的实现可能会有很大的差异,例如jpa的starter和Redis的starter可能实现就不一样,这是因为starter的本质在于synthesize,这是一层在逻辑层面的抽象,也许这种理念有点类似于Docker,因为它们都是在做一个"包装"的操作,如果你知道Docker是为了解决什么问题的,也许你可以用Docker和starter做一个类比.


### 1.2 Spring 各个模块说明

[Spring 7大模块简要说明 link](http://www.cnblogs.com/ywlaker/p/6136625.html)


### 1.3 Spring配置参数

[Spring官方参考文档 link](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/)

参数配置请参考章节: `Appendix A. Common application properties`.

---

## 2. 项目资源说明


### 2.1 数据库运行脚本

数据库脚本位于: [sql脚本](docs/spring_rookie.sql)


### 2.2 guide 

帮助文档: [guide](docs/guide.md)


