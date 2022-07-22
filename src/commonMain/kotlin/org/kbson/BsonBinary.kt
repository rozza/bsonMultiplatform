/*
 * Copyright 2008-present MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kbson

/**
 * A representation of the BSON Binary type. Note that for performance reasons instances of this
 * class are not immutable, so care should be taken to only modify the underlying byte array if you
 * know what you're doing, or else make a defensive copy.
 */
class BsonBinary(val type: Byte, val data: ByteArray) : BsonValue() {

    /**
     * Construct a new instance with the given data and the default sub-type
     *
     * @param data the data
     *
     * @see org.kbson.multi.BsonBinarySubType.BINARY
     */
    constructor(data: ByteArray) : this(BsonBinarySubType.BINARY.value, data)

    /**
     * Construct a new instance with the given data and binary sub type.
     *
     * @param data the data
     * @param type the binary sub type
     *
     * @see org.kbson.multi.BsonBinarySubType.BINARY
     */
    constructor(type: BsonBinarySubType, data: ByteArray) : this(type.value, data)

    override fun getBsonType(): BsonType {
        return BsonType.BINARY
    }

    override fun toString(): String {
        return ("BsonBinary{" + "type=" + type + ", data=" + data.toString() + '}')
    }

    companion object {
        fun clone(from: BsonBinary): BsonBinary {
            return BsonBinary(from.type, from.data.copyOf())
        }
    }
}
