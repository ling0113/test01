package com.lock_demo.lock.aspect;

import com.lock_demo.lock.annotation.Retry;
import com.lock_demo.lock.exception.RetryException;
import com.lock_demo.lock.service.AccountService;
import com.lock_demo.lock.service.AccountServiceimpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 重试的切面类
 * tryAgain 方法使用了 @Around 注解（表示环绕通知），可以决定目标方法在何时执行，或者不执行，以及自定义返回结果。
 * 这里首先通过 ProceedingJoinPoint.proceed() 方法执行目标方法，
 * 如果抛出了重试异常，那么重新执行直到满三次，三次都不成功则回滚并返回 FAILED。
 */
@Slf4j
@Aspect
@Component
public class RetryAspect {

    @Pointcut("@annotation(com.lock_demo.lock.annotation.Retry)")
    public void retryPointcut() {

    }

    @Around("retryPointcut() && @annotation(retry)")
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Object tryAgain(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        int count = 0;
        do {
            count++;
            try {
                return joinPoint.proceed();
            } catch (RetryException e) {
                if (count > retry.value()) {
                    log.error("Retry failed!");
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return AccountServiceimpl.Result.FAILED;
                }
            }
        } while (true);
    }
}