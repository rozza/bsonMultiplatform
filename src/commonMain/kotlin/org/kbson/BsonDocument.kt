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

class BsonDocument(map: Map<String, BsonValue> = LinkedHashMap()) :
    BsonValue(), Map<String, BsonValue>, Comparable<BsonDocument> {
    private val wrapped: LinkedHashMap<String, BsonValue>

    init {
        wrapped = if (map is LinkedHashMap) map else LinkedHashMap(map)
    }

    override val entries: Set<Map.Entry<String, BsonValue>>
        get() = wrapped.entries
    override val keys: Set<String>
        get() = wrapped.keys
    override val size: Int
        get() = wrapped.size
    override val values: Collection<BsonValue>
        get() = wrapped.values

    override fun containsKey(key: String): Boolean = wrapped.containsKey(key)

    override fun containsValue(value: BsonValue): Boolean = wrapped.containsValue(value)

    override fun get(key: String): BsonValue? = wrapped[key]

    override fun isEmpty(): Boolean = wrapped.isEmpty()

    override fun compareTo(other: BsonDocument): Int {
        TODO("Not yet implemented")
    }

    override fun getBsonType(): BsonType = BsonType.DOCUMENT

    /**
     * Returns true if the value of the key is a BsonNull, returns false if the document does not
     * contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonNull, returns false if the document does not
     * contain the key.
     */
    fun isNull(key: String): Boolean {
        return get(key)?.isNull() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonDocument, returns false if the document does
     * not contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonDocument, returns false if the document does
     * not contain the key.
     */
    fun isDocument(key: String): Boolean {
        return get(key)?.isDocument() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonArray, returns false if the document does not
     * contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonArray, returns false if the document does not
     * contain the key.
     */
    fun isArray(key: String): Boolean {
        return get(key)?.isArray() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonNumber, returns false if the document does not
     * contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonNumber, returns false if the document does not
     * contain the key.
     */
    fun isNumber(key: String): Boolean {
        return get(key)?.isNumber() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonInt32, returns false if the document does not
     * contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonInt32, returns false if the document does not
     * contain the key.
     */
    fun isInt32(key: String): Boolean {
        return get(key)?.isInt32() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonInt64, returns false if the document does not
     * contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonInt64, returns false if the document does not
     * contain the key.
     */
    fun isInt64(key: String): Boolean {
        return get(key)?.isInt64() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonDecimal128, returns false if the document does
     * not contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonDecimal128, returns false if the document does
     * not contain the key.
     * @since 3.4
     */
    fun isDecimal128(key: String): Boolean {
        return get(key)?.isDecimal128() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonDouble, returns false if the document does not
     * contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonDouble, returns false if the document does not
     * contain the key.
     */
    fun isDouble(key: String): Boolean {
        return get(key)?.isDouble() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonBoolean, returns false if the document does not
     * contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonBoolean, returns false if the document does not
     * contain the key.
     */
    fun isBoolean(key: String): Boolean {
        return get(key)?.isBoolean() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonString, returns false if the document does not
     * contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonString, returns false if the document does not
     * contain the key.
     */
    fun isString(key: String): Boolean {
        return get(key)?.isString() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonDateTime, returns false if the document does
     * not contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonDateTime, returns false if the document does
     * not contain the key.
     */
    fun isDateTime(key: String): Boolean {
        return get(key)?.isDateTime() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonTimestamp, returns false if the document does
     * not contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonTimestamp, returns false if the document does
     * not contain the key.
     */
    fun isTimestamp(key: String): Boolean {
        return get(key)?.isTimestamp() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonObjectId, returns false if the document does
     * not contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonObjectId, returns false if the document does
     * not contain the key.
     */
    fun isObjectId(key: String): Boolean {
        return get(key)?.isObjectId() ?: false
    }

    /**
     * Returns true if the value of the key is a BsonBinary, returns false if the document does not
     * contain the key.
     *
     * @param key the key
     * @return true if the value of the key is a BsonBinary, returns false if the document does not
     * contain the key.
     */
    fun isBinary(key: String): Boolean {
        return get(key)?.isBinary() ?: false
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonValue
     */
    operator fun get(key: String, defaultValue: BsonValue): BsonValue {
        val value = get(key)
        return value ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonDocument.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonDocument
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getDocument(key: String, defaultValue: BsonDocument): BsonDocument {
        return get(key)?.asDocument() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonArray.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonArray
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getArray(key: String, defaultValue: BsonArray): BsonArray {
        return get(key)?.asArray() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonNumber.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonNumber
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getNumber(key: String, defaultValue: BsonNumber): BsonNumber {
        return get(key)?.asNumber() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonInt32.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonInt32
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getInt32(key: String, defaultValue: BsonInt32): BsonInt32 {
        return get(key)?.asInt32() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonInt64.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonInt64
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getInt64(key: String, defaultValue: BsonInt64): BsonInt64 {
        return get(key)?.asInt64() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonDecimal128.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonDecimal128
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     * @since 3.4
     */
    fun getDecimal128(key: String, defaultValue: BsonDecimal128): BsonDecimal128 {
        return get(key)?.asDecimal128() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonDouble.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonDouble
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getDouble(key: String, defaultValue: BsonDouble): BsonDouble {
        return get(key)?.asDouble() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonBoolean.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonBoolean
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getBoolean(key: String, defaultValue: BsonBoolean): BsonBoolean {
        return get(key)?.asBoolean() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonString.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonString
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getString(key: String, defaultValue: BsonString): BsonString {
        return get(key)?.asString() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonDateTime.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonDateTime
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getDateTime(key: String, defaultValue: BsonDateTime): BsonDateTime {
        return get(key)?.asDateTime() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonTimestamp.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonTimestamp
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getTimestamp(key: String, defaultValue: BsonTimestamp): BsonTimestamp {
        return get(key)?.asTimestamp() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonObjectId.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonObjectId
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getObjectId(key: String, defaultValue: BsonObjectId): BsonObjectId {
        return get(key)?.asObjectId() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonBinary.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonBinary
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getBinary(key: String, defaultValue: BsonBinary): BsonBinary {
        return get(key)?.asBinary() ?: defaultValue
    }

    /**
     * If the document does not contain the given key, return the given default value. Otherwise,
     * gets the value of the key as a BsonRegularExpression.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value of the key as a BsonRegularExpression
     * @throws org.kbson.BsonInvalidOperationException if the document contains the key but the
     * value is not of the expected type
     */
    fun getRegularExpression(
        key: String,
        defaultValue: BsonRegularExpression
    ): BsonRegularExpression {
        return get(key)?.asRegularExpression() ?: defaultValue
    }

    /**
     * Gets the value of the key if it is a BsonDocument, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonDocument
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not a BsonDocument
     */
    fun getDocument(key: String): BsonDocument {
        throwIfKeyAbsent(key)
        return get(key)!!.asDocument()!!
    }

    /**
     * Gets the value of the key if it is a BsonArray, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonArray
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getArray(key: String): BsonArray {
        throwIfKeyAbsent(key)
        return get(key)!!.asArray()!!
    }

    /**
     * Gets the value of the key if it is a BsonNumber, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonNumber
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getNumber(key: String): BsonNumber {
        throwIfKeyAbsent(key)
        return get(key)!!.asNumber()!!
    }

    /**
     * Gets the value of the key if it is a BsonInt32, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonInt32
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getInt32(key: String): BsonInt32 {
        throwIfKeyAbsent(key)
        return get(key)!!.asInt32()!!
    }

    /**
     * Gets the value of the key if it is a BsonInt64, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonInt64
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getInt64(key: String): BsonInt64 {
        throwIfKeyAbsent(key)
        return get(key)!!.asInt64()!!
    }

    /**
     * Gets the value of the key if it is a BsonDecimal128, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonDecimal128
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     * @since 3.4
     */
    fun getDecimal128(key: String): BsonDecimal128 {
        throwIfKeyAbsent(key)
        return get(key)!!.asDecimal128()!!
    }

    /**
     * Gets the value of the key if it is a BsonDouble, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonDouble
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getDouble(key: String): BsonDouble {
        throwIfKeyAbsent(key)
        return get(key)!!.asDouble()!!
    }

    /**
     * Gets the value of the key if it is a BsonBoolean, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonBoolean
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getBoolean(key: String): BsonBoolean {
        throwIfKeyAbsent(key)
        return get(key)!!.asBoolean()!!
    }

    /**
     * Gets the value of the key if it is a BsonString, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonString
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getString(key: String): BsonString {
        throwIfKeyAbsent(key)
        return get(key)!!.asString()!!
    }

    /**
     * Gets the value of the key if it is a BsonDateTime, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonDateTime
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getDateTime(key: String): BsonDateTime {
        throwIfKeyAbsent(key)
        return get(key)!!.asDateTime()!!
    }

    /**
     * Gets the value of the key if it is a BsonTimestamp, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonTimestamp
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getTimestamp(key: String): BsonTimestamp {
        throwIfKeyAbsent(key)
        return get(key)!!.asTimestamp()!!
    }

    /**
     * Gets the value of the key if it is a BsonObjectId, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonObjectId
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getObjectId(key: String): BsonObjectId {
        throwIfKeyAbsent(key)
        return get(key)!!.asObjectId()!!
    }

    /**
     * Gets the value of the key if it is a BsonRegularExpression, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonRegularExpression
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getRegularExpression(key: String): BsonRegularExpression {
        throwIfKeyAbsent(key)
        return get(key)!!.asRegularExpression()!!
    }

    /**
     * Gets the value of the key if it is a BsonBinary, or throws if not.
     *
     * @param key the key
     * @return the value of the key as a BsonBinary
     * @throws org.kbson.BsonInvalidOperationException if the document does not contain the key or
     * the value is not of the expected type
     */
    fun getBinary(key: String): BsonBinary {
        throwIfKeyAbsent(key)
        return get(key)!!.asBinary()!!
    }

    companion object {

        operator fun invoke(key: String, value: BsonValue): BsonDocument {
            return BsonDocument(linkedMapOf(key to value))
        }
        operator fun invoke(vararg pairs: Pair<String, BsonValue>): BsonDocument {
            return BsonDocument(linkedMapOf(*pairs))
        }
    }

    private fun throwIfKeyAbsent(key: Any) {
        if (!containsKey(key)) {
            throw BsonInvalidOperationException("Document does not contain key: '$key'")
        }
    }
}
