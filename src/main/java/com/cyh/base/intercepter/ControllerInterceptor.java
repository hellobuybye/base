// package com.cyh.base.intercepter;


// import lombok.extern.slf4j.Slf4j;
// import org.springframework.web.method.HandlerMethod;
// import org.springframework.web.servlet.HandlerInterceptor;


// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;



// @Slf4j
// public class ControllerInterceptor implements HandlerInterceptor {
	

// 	@Override
// 	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
// 		String path = request.getServletPath();

// 		// logging
// 		log.info("\n");
// 		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ controller interceptor preHandle START");
// 		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ path : {}", path);
// //		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ request : {}", request.getParameterMap().toString());
// //		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ response : {}", response.toString());
// 		if (handler instanceof HandlerMethod) {
// 			log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ handler : {}", (HandlerMethod) handler);
// 		}
// 		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ controller interceptor preHandle END");
// 		log.info("\n");

// 		return true;
// 	}

    
// }
