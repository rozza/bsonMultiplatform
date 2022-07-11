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

/** A value representing the BSON timestamp type. */
class BsonTimestamp(val value: Long = 0) : BsonValue(), Comparable<BsonTimestamp> {

    override fun getBsonType(): BsonType = BsonType.TIMESTAMP

    /**
     * Gets the time in seconds since epoch.
     *
     * @return an int representing time in seconds since epoch
     */
    fun getTime(): Int = (value shr 32).toInt()

    /**
     * Gets the increment value.
     *
     * @return an incrementing ordinal for operations within a given second
     */
    fun getInc(): Int = value.toInt()

    companion object {

        /**
         * Construct a new instance for the given time and increment.
         *
         * @param seconds the number of seconds since the epoch
         * @param increment the increment.
         */
        fun invoke(seconds: Long, increment: Long): BsonTimestamp {
            return BsonTimestamp(seconds shl 32 or (increment and 0xFFFFFFFFL))
        }
    }

    override fun compareTo(other: BsonTimestamp): Int {
        return value.compareTo(other.value)
    }
}
