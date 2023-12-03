package com.ll.scode.global.aspect;

import com.ll.scode.global.rq.Rq.Rq;
import com.ll.scode.global.rsData.RsData.RsData;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ResponseAspect {
    private final Rq rq;

    @Around("(@annotation(org.springframework.web.bind.annotation.GetMapping) || @annotation(org.springframework.web.bind.annotation.PostMapping) || @annotation(org.springframework.web.bind.annotation.PutMapping) || @annotation(org.springframework.web.bind.annotation.DeleteMapping)))")
    public Object handleResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();

        if (proceed instanceof RsData) {
            RsData<?> rsData = (RsData<?>) proceed;
            rq.getResp().setStatus(rsData.getStatusCode());
            return rsData;
        }

        return proceed;
    }
}
