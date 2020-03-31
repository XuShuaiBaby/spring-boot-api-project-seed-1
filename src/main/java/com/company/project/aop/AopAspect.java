package com.company.project.aop;

import com.company.project.core.ResultCode;
import com.company.project.core.ServiceException;
import org.apache.ibatis.annotations.Delete;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * aop
 * @description
 * @author shuai.xu
 * @time 2019/3/7 10:01
*/

@Aspect
@Order(1)
@Component
public class AopAspect {
/**
     * 必须为final String类型的,注解里要使用的变量只能是静态常量类型的
     */

    public static final String EDP="execution(* (com.company.project.service.impl.*).*(..)))";

/**
     * 切面的前置方法 即方法执行前拦截到的方法
     * 在目标方法执行之前的通知
     * @param jp
     */

    @Before(value = "execution(* (com.company.project.*.impl.*).*(..)))")
    public void doBefore(JoinPoint jp){
        System.out.println("=========执行前置通知==========");
        // 获取方法
        MethodInvocationProceedingJoinPoint mjp = (MethodInvocationProceedingJoinPoint) jp;
        MethodSignature signature = (MethodSignature) mjp.getSignature();
        Method method = signature.getMethod();
        Delete delteAnnotation = method.getAnnotation(Delete.class);
        if(null == delteAnnotation){
            //return ResultGenerator.genFailResult("获取注解失败");
            throw new ServiceException(ResultCode.FAIL,"1111");
        }
    }


/**
     * 在方法正常执行通过之后执行的通知叫做返回通知
     * 可以返回到方法的返回值 在注解后加入returning
     * @param jp
     * @param result
     */

    @AfterReturning(value=EDP,returning="result")
    public void doAfterReturning(JoinPoint jp,String result){
        System.out.println("===========执行后置通知============");
    }

/**
     * 最终通知：目标方法调用之后执行的通知（无论目标方法是否出现异常均执行）
     * @param jp
     */

    @After(value=EDP)
    public void doAfter(JoinPoint jp){
        System.out.println("===========执行最终通知============");
    }

/**
     * 环绕通知：目标方法调用前后执行的通知，可以在方法调用前后完成自定义的行为。
     * @param pjp
     * @return
     * @throws Throwable
     */

   /* @Around(EDP)
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        Map<String,Object> map = new HashMap<>();
        System.out.println("======执行环绕通知开始=========");
        // 获取方法
        MethodInvocationProceedingJoinPoint mjp = (MethodInvocationProceedingJoinPoint) pjp;
        MethodSignature signature = (MethodSignature) mjp.getSignature();
        Method method = signature.getMethod();
        // 获取方法上的注解
        Delete delteAnnotation = method.getAnnotation(Delete.class);
        Insert delteAnnotation1 = method.getAnnotation(Insert.class);
        Update delteAnnotation2= method.getAnnotation(Update.class);

        String[] strings = delteAnnotation.value();
        for (String f:strings) {
            System.out.println("SQL:"+f);
        }
        // 调用方法的参数
        Object[] args = pjp.getArgs();
        for (int i = 0; i <args.length ; i++) {
            System.out.println(args[i]);
            map.put("param:",args[i]);
        }
        // 调用的方法名
        //String method = pjp.getSignature().getName();
        // 获取目标对象
        Object target = pjp.getTarget();
        // 执行完方法的返回值
        // 调用proceed()方法，就会触发切入点方法执行
        Object result=pjp.proceed();
        System.out.println("输出,方法名：" + method + ";目标对象：" + target + ";返回值：" + result);
        System.out.println("======执行环绕通知结束=========");
        return result;
    }*/

/**
     * 在目标方法非正常执行完成, 抛出异常的时候会走此方法
     * @param jp
     * @param ex
     */

    @AfterThrowing(value=EDP,throwing="ex")
    public void doAfterThrowing(JoinPoint jp,Exception ex) {
        System.out.println("===========执行异常通知============");
    }
}
