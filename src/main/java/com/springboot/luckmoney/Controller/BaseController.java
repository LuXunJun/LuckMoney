package com.springboot.luckmoney.Controller;

import com.springboot.luckmoney.aspect.HttpAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {

    private final static Logger logger = (Logger) LoggerFactory.getLogger(BaseController.class);

    public void PrintLogInfo(String format, Object obj) {
        logger.info(format, obj);
    }

    public void PrintLogError(String format, Object obj) {
        logger.error(format, obj);
    }

}
