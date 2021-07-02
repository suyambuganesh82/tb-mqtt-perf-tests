/**
 * Copyright © 2016-2021 The Thingsboard Authors
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
package org.thingsboard.mqtt.broker.client.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.util.concurrent.Promise;

import java.util.function.Consumer;

final class MqttPendingPublish {

    private final int messageId;
    private final Promise<Void> future;
    private final ByteBuf payload;
    private final MqttPublishMessage message;
    private final MqttQoS qos;

    private boolean sent = false;

    MqttPendingPublish(int messageId, Promise<Void> future, ByteBuf payload, MqttPublishMessage message, MqttQoS qos) {
        this.messageId = messageId;
        this.future = future;
        this.payload = payload;
        this.message = message;
        this.qos = qos;
    }

    int getMessageId() {
        return messageId;
    }

    Promise<Void> getFuture() {
        return future;
    }

    ByteBuf getPayload() {
        return payload;
    }

    boolean isSent() {
        return sent;
    }

    void setSent(boolean sent) {
        this.sent = sent;
    }

    MqttPublishMessage getMessage() {
        return message;
    }

    MqttQoS getQos() {
        return qos;
    }

    void startPublishRetransmissionTimer(EventLoop eventLoop, Consumer<Object> sendPacket) {
    }

    void onPubackReceived() {
    }

    void setPubrelMessage(MqttMessage pubrelMessage) {
    }

    void startPubrelRetransmissionTimer(EventLoop eventLoop, Consumer<Object> sendPacket) {
    }

    void onPubcompReceived() {
    }
}