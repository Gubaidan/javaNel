package cn.demo.ssm.intercepter;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ExceptionHandler extends SimpleMappingExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("code", "501");
        attributes.put("data", new Object[0]);
        attributes.put("result", false);
        attributes.put("error", ex.getMessage());
        view.setAttributesMap(attributes);
        mv.setView(view);
        logger.debug("异常:" + ex.getMessage(), ex);
        return mv;
    }
}
