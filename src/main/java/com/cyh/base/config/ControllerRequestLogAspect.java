//package com.cyh.base.config;
//
//
//import com.cyh.base.dto.ApiResponse;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.Profiles;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Slf4j
//@Aspect
//@Component
//public class ControllerRequestLogAspect {
//
//    @Autowired(required = false)
//    private HttpServletRequest request;
//
//    @Autowired
//    private Environment environment;
//
//    public ControllerRequestLogAspect() {
//    }
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) ||"
//            + "@annotation(org.springframework.web.bind.annotation.GetMapping) ||"
//            + "@annotation(org.springframework.web.bind.annotation.PostMapping)")
//    public void requestPointcut() {}
//
//    @Before("requestPointcut()")
//    public void apiRequestLog(final JoinPoint joinPoint) {
//        if (log.isDebugEnabled()) {
//            try {
//                MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//                log.debug("[REQUEST]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//                log.debug("API request {}.{}", signature.getDeclaringTypeName(), signature.getMethod().getName());
//                log.debug("URL : {}", request.getRequestURI());
//                Object[] args = joinPoint.getArgs();
//                if (args.length == 0) {
//                    log.debug("no parameter");
//                } else {
//                    for (Object arg : args) {
//                        log.debug("parameter type = {}", arg.getClass().getSimpleName());
//                        log.debug("parameter : {}", arg);
////                        log.debug("parameter : {}", convertLogStr(arg));
//                    }
//                }
//                log.debug("[REQUEST]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//            } catch (Exception e) {
//                log.error("[ControllerRequestLogAspect] apiRequestLog Error", e);
//            } finally {
//                doFinally();
//            }
//        }
//    }
//
//    @AfterReturning(value = "requestPointcut()", returning = "result")
//    public void apiResponseLog(JoinPoint joinPoint, Object result) {
//        if (log.isDebugEnabled()) {
//            try {
//                MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//                log.debug("[RESPONSE]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//                log.debug("API response {}.{}", signature.getDeclaringTypeName(), signature.getMethod().getName());
//                log.debug("URL : {}", request.getRequestURI());
//                //log.debug("return type = {}", returnObj.getClass().getSimpleName());
//                log.debug("result : {}", result);
//                if(environment.acceptsProfiles(Profiles.of("dev"))){
//                    if (result instanceof ApiResponse) {
//                        ApiResponse<?> res = (ApiResponse<?>) result;
//                        log.debug("result body : {}", convertLogStr(res.getBody()));
//                    }
//                }
//                log.debug("[RESPONSE]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//            } catch (Exception e) {
//                log.error("[ControllerRequestLogAspect] apiResponseLog Error", e);
//            } finally {
//                doFinally();
//            }
//        }
//    }
//
//    /**
//     * 컨트롤러 처리 후 반드시 처리되어야 하는 기능를 구현
//     */
//    private void doFinally() {
//        try {
//            //ClientInfoHolder.clear();
//        } catch (Exception e) {
//            log.error("[ControllerRequestLogAspect] Finally Error", e);
//        }
//    }
//
//    /**
//     * json string 으로 변경
//     * @param fromObj
//     * @return
//     * @throws Exception
//     */
//    private String convertLogStr(Object fromObj) {
//        String result = "";
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//            //mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            result = mapper.writeValueAsString(fromObj);
//        } catch (Exception e) {
//            log.error("[ControllerRequestLogAspect] convertLogStr Error", e);
//        }
//        return result;
//    }
//
//}
