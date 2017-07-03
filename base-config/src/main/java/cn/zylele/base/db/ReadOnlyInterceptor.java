package cn.zylele.base.db;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadOnlyInterceptor implements Ordered {

    @Around("@annotation(ReadOnly)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            DbContextHolder.setDbType(DbContextHolder.DbType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            DbContextHolder.clearDbType();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}