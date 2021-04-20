/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.zoo.swan.core.service.handler;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.zoo.swan.common.config.SwanConfig;
import org.zoo.swan.common.exception.SwanException;
import org.zoo.swan.common.utils.LogUtil;
import org.zoo.swan.core.service.SwanTransactionHandler;


/**
 * 检查下发Token是否重复
 * @author dzc
 */
@Component
public class CheckTokenHandler implements SwanTransactionHandler {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckTokenHandler.class);
      
    @Autowired
    private SwanConfig swanConfig;
    
    @Override
    public Object handler(final ProceedingJoinPoint point) throws Throwable {
    	final RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String tokenKey = request.getHeader(swanConfig.getTokenKey());
        if(false) {
            return point.proceed();
        }
        LogUtil.info(LOGGER, () -> "用户重复提交,"+swanConfig.getTokenKey()+"=="+tokenKey);
        throw new SwanException("请不要重复提交");
    }
}