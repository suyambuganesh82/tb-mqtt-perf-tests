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
package org.thingsboard.mqtt.broker.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.thingsboard.mqtt.broker.service.ServiceHelper;

import javax.annotation.PostConstruct;

@Component
@Data
public class TestRunClusterConfigImpl implements TestRunClusterConfig {

    private final ServiceHelper serviceHelper;

    @Value("${test-run.sequential-number:}")
    private Integer testRunSequentialNumber;
    @Value("${test-run.parallel-tests-count:}")
    private int parallelTestsCount;

    @PostConstruct
    public void init() {
        if (testRunSequentialNumber == null) {
            testRunSequentialNumber = serviceHelper.getId();
        }
    }

    @Override
    public int getSequentialNumber() {
        return testRunSequentialNumber;
    }

    @Override
    public int getParallelTestsCount() {
        return parallelTestsCount;
    }
}
