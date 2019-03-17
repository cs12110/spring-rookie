# guide book

主要用于记录发现的各种问题.

---

## 1. 整合shrio问题

在整合shrio的时候出现异常,异常如下:

```java
Description:

The bean 'rookieServiceImpl' could not be injected as a 'com.pkgs.service.RookieServiceImpl' because it is a JDK dynamic proxy that implements:
	com.pkgs.service.RookieService


Action:

Consider injecting the bean as one of its interfaces or forcing the use of CGLib-based proxies by setting proxyTargetClass=true on @EnableAsync and/or @EnableCaching.
```

解决方法

```java
/**
* 解决springboot注入问题
*
* @return DefaultAdvisorAutoProxyCreator
*/
@Bean
public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
	DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
	defaultAdvisorAutoProxyCreator.setUsePrefix(true);
	return defaultAdvisorAutoProxyCreator;
}
```