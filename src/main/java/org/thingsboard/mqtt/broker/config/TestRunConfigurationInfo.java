/**
 * Copyright © ${project.inceptionYear}-2018 The Thingsboard Authors
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thingsboard.mqtt.broker.data.PublisherGroup;
import org.thingsboard.mqtt.broker.data.SubscriberGroup;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestRunConfigurationInfo {
    private List<PublisherGroup> publisherGroups;
    private List<SubscriberGroup> subscriberGroups;
    private int dummyClients;
    private int secondsToRun;
    private int additionalSecondsToWait;
    private int maxMsgsPerPublisherPerSecond;
    private int publisherQosValue;
    private int subscriberQosValue;
}