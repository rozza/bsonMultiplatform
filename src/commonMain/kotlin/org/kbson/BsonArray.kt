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

class BsonArray(initial: List<BsonValue> = emptyList()) : BsonValue(), List<BsonValue> {
    override val size: Int = initial.size
    private val values: MutableList<BsonValue> = initial.toMutableList()

    /**
     * Construct an empty BsonArray with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the BsonArray
     * @throws IllegalArgumentException if the specified initial capacity is negative
     * @since 4.3
     */
    constructor(initialCapacity: Int) : this() {
        ArrayList<BsonValue>(initialCapacity)
    }

    /**
     * Gets the values in this array as a list of `BsonValue` objects.
     *
     * @return the values in this array.
     */
    fun getValues(): List<BsonValue> {
        return values.toList()
    }

    override fun getBsonType(): BsonType {
        return BsonType.ARRAY
    }

    override fun contains(element: BsonValue): Boolean {
        return values.contains(element)
    }

    override fun containsAll(elements: Collection<BsonValue>): Boolean {
        return values.containsAll(elements)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o !is BsonArray) {
            return false
        }
        return getValues() == o.getValues()
    }

    override fun get(index: Int): BsonValue {
        return values.get(index)
    }

    override fun hashCode(): Int {
        return values.hashCode()
    }

    override fun isEmpty(): Boolean {
        return values.isEmpty()
    }

    override fun iterator(): Iterator<BsonValue> {
        return values.iterator()
    }

    override fun listIterator(): ListIterator<BsonValue> {
        return values.listIterator()
    }

    override fun listIterator(index: Int): ListIterator<BsonValue> {
        return values.listIterator(index)
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<BsonValue> {
        return values.subList(fromIndex, toIndex)
    }

    override fun lastIndexOf(element: BsonValue): Int {
        return values.lastIndexOf(element)
    }

    override fun indexOf(element: BsonValue): Int {
        return values.indexOf(element)
    }

    override fun toString(): String {
        return ("BsonArray{" + "values=" + values + '}')
    }

    // TODO("CLONE")
    fun clone(): BsonArray {
        TODO("Not yet implemented")
    }
    //
    //    companion object {
    //        /**
    //         * Parses a string in MongoDB Extended JSON format to a `BsonArray`
    //         *
    //         * @param json the JSON string
    //         * @return a corresponding `BsonArray` object
    //         * @see org.bson.multi.json.JsonReader
    //         *
    //         * @mongodb.driver.manual reference/mongodb-extended-json/ MongoDB Extended JSON
    //         *
    //         * @since 3.4
    //         */
    //        fun parse(json: String?): BsonArray {
    //            return BsonArrayCodec().decode(JsonReader(json), DecoderContext.builder().build())
    //        }
    //    }
}
