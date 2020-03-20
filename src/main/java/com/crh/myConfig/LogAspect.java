package com.crh.myConfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author crh
 * @date 2020-03-19 10:17
 *  该类为面向切面编程的实际应用：主要用来记录日志信息 储存到对应的数据库中 S_LOG
 */
@Aspect
@Component
public class LogAspect {
//    @Around(value = "execution(* *.*(..))")
    @Around(value = "execution(* *.*(..))")
    public Object aroudFunction(ProceedingJoinPoint point){
        Object proceed = null;
        Logger logger = LoggerFactory.getLogger(LogAspect.class);
        //获取方法名称 方法参数
        String name = point.getSignature().getName();
        logger.info("@before 方法："+name+"前，被调用了");
        System.out.println("@before 方法："+name+"前，被调用了");
        try {
            proceed = point.proceed();
            logger.info("@afterreturning 方法【"+name+"】后，被调用了，返回值【"+proceed+"】");
        } catch (Throwable throwable) {
            logger.info("@afterthrowing 方法【"+name+"】后，被调用了");
            throwable.printStackTrace();
        } finally {
            logger.info("@after 方法【"+name+"】后，被调用了");
        }
        return proceed;
    }
}
