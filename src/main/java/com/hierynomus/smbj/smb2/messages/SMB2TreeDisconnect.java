/*
 * Copyright (C)2016 - Jeroen van Erp <jeroen@hierynomus.com>
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
package com.hierynomus.smbj.smb2.messages;

import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smbj.common.SMBBuffer;
import com.hierynomus.smbj.smb2.SMB2Dialect;
import com.hierynomus.smbj.smb2.SMB2MessageCommandCode;
import com.hierynomus.smbj.smb2.SMB2Packet;

/**
 * [MS-SMB2].pdf 2.2.11 SMB2 TREE_DISCONNECT Request / 2.2.12 SMB2 TREE_DISCONNECT Response
 */
public class SMB2TreeDisconnect extends SMB2Packet {

    public SMB2TreeDisconnect() {
        super();
    }

    public SMB2TreeDisconnect(SMB2Dialect smbDialect) {
        super(smbDialect, SMB2MessageCommandCode.SMB2_TREE_DISCONNECT);
    }

    @Override
    protected void writeTo(SMBBuffer buffer) {
        buffer.putUInt16(4); // StructureSize (2 bytes)
        buffer.putReserved(2); // Reserved (2 bytes)
    }

    @Override
    protected void readMessage(SMBBuffer buffer) throws Buffer.BufferException {
        buffer.readUInt16(); // StructureSize (2 bytes)
        buffer.skip(2); // Reserved (2 bytes)
    }
}