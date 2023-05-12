/**
 * Copyright © 2016-2023 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.mqtt.broker.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@Data
public class ServiceHelper {

    private int id;
    private TestType testType;

    @PostConstruct
    public void init() {
        String serviceId = System.getenv("TB_SERVICE_ID");
        if (StringUtils.isEmpty(serviceId)) {
            return;
        }
        id = Integer.parseInt(serviceId.replaceAll("[^0-9]", ""));
        testType = serviceId.contains("publishers") ? TestType.PUBLISHERS : TestType.SUBSCRIBERS;
    }

    public enum TestType {
        PUBLISHERS("publishers"),
        SUBSCRIBERS("subscribers"),
        ;

        private final String printName;

        TestType(String printName) {
            this.printName = printName;
        }

        public String getPrintName() {
            return printName;
        }
    }
}
