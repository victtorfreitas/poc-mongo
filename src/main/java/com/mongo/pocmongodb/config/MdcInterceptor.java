package com.mongo.pocmongodb.config;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
public class MdcInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    String correlation_id = getCorrelationId(request);
    MDC.put("CORRELATION_ID", correlation_id);
    return true;
  }

  private static String getCorrelationId(HttpServletRequest request) {
    String correlationIdHeader = request.getHeader("CORRELATION_ID");
    return correlationIdHeader != null ? correlationIdHeader : UUID.randomUUID().toString();
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) {
    MDC.remove("CORRELATION_ID");
  }
}
