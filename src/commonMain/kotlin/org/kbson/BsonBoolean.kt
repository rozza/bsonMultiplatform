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

import org.bson.multi.BsonType
import org.bson.multi.BsonValue

/** A representation of the BSON Boolean type. */
class BsonBoolean(val value: Boolean) : BsonValue(), Comparable<BsonBoolean> {

    override fun compareTo(o: BsonBoolean): Int {
        return value.compareTo(o.value)
    }

    override fun getBsonType(): BsonType {
        return BsonType.BOOLEAN
    }

    override fun hashCode(): Int {
        return if (value) 1 else 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as BsonBoolean

        if (value != other.value) return false

        return true
    }

    override fun toString(): String {
        return "BsonBoolean(value=$value)"
    }

    companion object {
        /** The true value. */
        val TRUE = BsonBoolean(true)

        /** The false value. */
        val FALSE = BsonBoolean(false)

        /**
         * Returns a `BsonBoolean` instance representing the specified `boolean` value.
         *
         * @param value a boolean value.
         * @return [BsonBoolean.TRUE] if `value` is true, [BsonBoolean.FALSE] if `value` is false
         */
        fun valueOf(value: Boolean): BsonBoolean {
            return if (value) TRUE else FALSE
        }
    }
}
