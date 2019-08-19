package dev.ankang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//告诉Spring当前类是一个切面类
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //本类引用：pointCut()
    //其他的切面类要引用
    @Pointcut("execution(public int dev.ankang.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    //@Before在目标方法之前切入：切入点表达式（指定在哪个方法切入）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName()+"除法运行...参数列表是：{"+ Arrays.asList(joinPoint.getArgs()) +"}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName()+"除法结束...");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result) {
        System.out.println("除法正常返回...运行结果为：{"+result+"}");
    }

    //JoinPoint这个参数一定要出现在参数列表的第一位
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception) {
        System.out.println(joinPoint.getSignature().getName()+"除法异常...异常信息为：{}");
    }
}
