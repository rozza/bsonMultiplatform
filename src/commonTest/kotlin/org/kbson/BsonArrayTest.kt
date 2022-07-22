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

import kotlin.test.*

class BsonArrayTest {

    @Test
    fun shouldBeArrayType() {
        assertEquals(BsonType.ARRAY, BsonArray().getBsonType())
    }

    @Test
    fun shouldConstructAnEmptyArray() {
        val bsonArray = BsonArray()

        assertTrue(bsonArray.isEmpty())
        assertEquals(0, bsonArray.size)
        assertTrue(bsonArray.getValues().isEmpty())
    }

    @Test
    fun shouldConstructFromAList() {
        val bsonValues = listOf(BsonBoolean.TRUE, BsonBoolean.FALSE)
        val bsonArray = BsonArray(bsonValues)

        assertFalse(bsonArray.isEmpty())
        assertEquals(2, bsonArray.size)
        assertContentEquals(bsonValues, bsonArray.getValues())
    }
}
