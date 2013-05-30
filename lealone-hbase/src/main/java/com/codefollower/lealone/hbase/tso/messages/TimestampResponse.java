/*
 * Copyright 2011 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codefollower.lealone.hbase.tso.messages;

import java.io.DataOutputStream;
import java.io.IOException;

import org.jboss.netty.buffer.ChannelBuffer;

/**
 * The message object for sending a commit request to TSO
 * 
 * @author maysam
 * 
 */
public class TimestampResponse implements TSOMessage {

    /**
     * the timestamp
     */
    public long timestamp;

    /**
     * Constructor from timestamp
     * 
     * @param t
     */
    public TimestampResponse(long t) {
        timestamp = t;
    }

    public TimestampResponse() {
    }

    @Override
    public String toString() {
        return "TimestampResponse: T_s:" + timestamp;
    }

    @Override
    public void readObject(ChannelBuffer aInputStream) {
        timestamp = aInputStream.readLong();
    }

    @Override
    public void writeObject(DataOutputStream aOutputStream) throws IOException {
        aOutputStream.writeLong(timestamp);
    }
}
