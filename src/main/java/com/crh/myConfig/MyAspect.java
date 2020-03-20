package com.crh.myConfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author crh
 * @date 2020-03-13 23:24
 */
@Aspect
@Component
public class MyAspect {
    private  Logger loger =  LoggerFactory.getLogger(MyAspect.class);
    @Pointcut(value = "execution(* *.*(..))")
    public void myPointCut(){
    }
//    @Before(value = "execution(* *.*(..))")
//    public void berforeLogRecord(JoinPoint joinPoint){
//        Signature signature = joinPoint.getSignature();
//        for (Object arg : joinPoint.getArgs()) {
//            System.out.println("getArgs="+arg);
//        }
//        System.out.println("getDeclaringType:"+signature.getDeclaringType());
//        System.out.println("getDeclaringTypeName:"+signature.getDeclaringTypeName());
//        System.out.println("getName:"+signature.getName());
//        System.out.println("getModifiers:"+signature.getModifiers());
//        loger.info("loger  @Before -----berforeLogRecord");
//    }
//
//    @AfterReturning(value = "execution(* *.*(..))",returning="result")
//    public void afterReturningLogRecord(JoinPoint joinPoint,Object result){
//        System.out.println("result:"+result);
//        loger.info("loger  @AfterReturning -----afterReturningLogRecord");
//    }
//
//    @AfterThrowing(value = "execution(* *.*(..))",throwing = "myThrowing")
//    public void afterThrowingLogRecord(JoinPoint joinPoint,Throwable myThrowing){
//        loger.info("loger  @AfterThrowing -----afterThrowingLogRecord");
//    }
//
//    @After(value = "execution(* *.*(..))")
//    public void afterLogRecord(JoinPoint joinPoint){
//        System.out.println("joinPoint.getSignature().getName():"+joinPoint.getSignature().getName());
//        loger.info("loger  @After -----afterLogRecord");
//    }

    @Around(value = "myPointCut()")
//    @Around(value = "execution(* *.*(..))")
    public Object aroundLogRecord(ProceedingJoinPoint joinPoint) {
        String name = null;
        Object result = null;
        try {
            name = joinPoint.getSignature().getName();
            System.out.println("before，方法名："+name);
            result = joinPoint.proceed();
            System.out.println("afterreturning，"+name);
        } catch (Throwable throwable) {
            System.out.println("afterthrowing，"+name);
            throwable.printStackTrace();
        } finally {
            System.out.println("after，"+name);
        }
        return result;
    }

}
