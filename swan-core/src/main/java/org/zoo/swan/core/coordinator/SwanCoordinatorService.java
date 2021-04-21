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

package org.zoo.swan.core.coordinator;
 
import org.zoo.swan.common.config.SwanConfig;

/**
 * this is save transaction log service.
 * @author dzc
 */
public interface SwanCoordinatorService {

    /**
     * init swan config.
     *
     * @param swanConfig {@linkplain SwanConfig}
     * @throws Exception exception
     */
    void start(SwanConfig swanConfig) throws Exception;

    /**
     * 判断tokenId是否存在
     * @param tokenId  tokenId
     */
    boolean isExist(String tokenId);

    /**
     * 保存tokenId
     * @param tokenId  tokenId
     */
    boolean add(String tokenId);
}
