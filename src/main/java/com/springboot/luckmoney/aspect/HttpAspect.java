package com.springboot.luckmoney.aspect;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//AOP 请求拦截器
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = (Logger) LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.springboot.luckmoney.Controller.LuckmoneyController.*(..))")
    public void Pointcut() {
    }

    @Before("Pointcut()")
    /*连接点的定义 事前拦截 => 连接点 => 事后拦截 */
    /*连接点（joinpoint） 事件被拦截到的点 AOP拦截的是方法 所有这里的 joinpoint 就是指被拦截到的方法 */
    /*ServletRequestAttributes 是线程隔离的 保存了每次访问的 request对象 */
    public void doBefore(JoinPoint jp) {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={}", request.getRequestURL());
        logger.info("method={}", request.getMethod());
        logger.info("ip={}", request.getRemoteAddr());
        logger.info("class method={}"
                , jp.getSignature().getDeclaringType() + "." + jp.getSignature().getName());
        logger.info("args={}", jp.getArgs());

    }

    @After("Pointcut()")
    public void doAfter() {
        System.out.println("doAfter");
        logger.info("doAfter");
    }

    @AfterReturning(returning = "obj", pointcut = "Pointcut()")
    public void doAfterReturning(Object obj) {
        logger.info("response={}", obj);
    }

}
