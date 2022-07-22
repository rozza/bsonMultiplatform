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

import kotlin.test.Test
import kotlin.test.assertEquals

class BsonBinaryTest {

    private val data =
        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
            .map { it.toByte() }
            .toByteArray()

    @Test
    fun shouldInitializeWithData() {
        val bsonBinary = BsonBinary(data)

        assertEquals(data, bsonBinary.data)
        assertEquals(BsonBinarySubType.BINARY.value, bsonBinary.type)
    }

    @Test
    fun shouldInitializeWithDataAndSubType() {
        var bsonBinary = BsonBinary(BsonBinarySubType.BINARY, data)

        assertEquals(BsonBinarySubType.BINARY.value, bsonBinary.type)
        assertEquals(data, bsonBinary.data)

        bsonBinary = BsonBinary(BsonBinarySubType.FUNCTION, data)
        assertEquals(BsonBinarySubType.FUNCTION.value, bsonBinary.type)
        assertEquals(data, bsonBinary.data)

        bsonBinary = BsonBinary(BsonBinarySubType.MD5, data)
        assertEquals(BsonBinarySubType.MD5.value, bsonBinary.type)
        assertEquals(data, bsonBinary.data)

        bsonBinary = BsonBinary(BsonBinarySubType.OLD_BINARY, data)
        assertEquals(BsonBinarySubType.OLD_BINARY.value, bsonBinary.type)
        assertEquals(data, bsonBinary.data)

        bsonBinary = BsonBinary(BsonBinarySubType.USER_DEFINED, data)
        assertEquals(BsonBinarySubType.USER_DEFINED.value, bsonBinary.type)
        assertEquals(data, bsonBinary.data)

        bsonBinary = BsonBinary(BsonBinarySubType.UUID_LEGACY, data)
        assertEquals(BsonBinarySubType.UUID_LEGACY.value, bsonBinary.type)
        assertEquals(data, bsonBinary.data)

        bsonBinary = BsonBinary(BsonBinarySubType.UUID_STANDARD, data)
        assertEquals(BsonBinarySubType.UUID_STANDARD.value, bsonBinary.type)
        assertEquals(data, bsonBinary.data)
    }
}
