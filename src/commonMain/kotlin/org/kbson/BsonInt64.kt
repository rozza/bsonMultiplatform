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

/** A representation of the BSON Int64 type. */
class BsonInt64(val value: Long) : BsonNumber(), Comparable<BsonInt64> {

    override fun intValue(): Int {
        return value.toInt()
    }

    override fun longValue(): Long {
        return value
    }

    override fun doubleValue(): Double {
        return value.toDouble()
    }

    override fun getBsonType(): BsonType {
        return BsonType.INT32
    }

    override fun compareTo(other: BsonInt64): Int {
        return value.compareTo(other.value)
    }
}
