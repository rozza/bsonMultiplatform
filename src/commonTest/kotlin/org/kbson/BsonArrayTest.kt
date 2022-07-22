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

    val listOfBsonValues = listOf(BsonBoolean.TRUE, BsonBoolean.FALSE)

    @Test
    fun shouldHaveTheExpectedBsonType() {
        assertEquals(BsonType.ARRAY, BsonArray().getBsonType())
    }

    @Test
    fun shouldConstructAnEmptyArray() {
        val bsonValue = BsonArray()

        assertTrue(bsonValue.isEmpty())
        assertEquals(0, bsonValue.size)
        assertTrue(bsonValue.values.isEmpty())
    }

    @Test
    fun shouldConstructFromAList() {
        val bsonValue = BsonArray(listOfBsonValues)

        assertFalse(bsonValue.isEmpty())
        assertEquals(2, bsonValue.size)
        assertContentEquals(listOfBsonValues, bsonValue.values)
    }

    @Test
    fun shouldOverrideEquals() {
        assertEquals(BsonArray(), BsonArray())
        assertEquals(BsonArray(listOfBsonValues), BsonArray(listOfBsonValues))
        assertNotEquals(BsonArray(), BsonArray(listOfBsonValues))
        assertNotEquals(
            BsonArray(listOfBsonValues), BsonArray(listOf(BsonBoolean.TRUE, BsonBoolean.TRUE)))
    }
}
