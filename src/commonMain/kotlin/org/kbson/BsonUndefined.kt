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
 * Represents the value associated with the BSON Undefined type. All values of this type are
 * identical. Note that this type has been deprecated in the BSON specification.
 *
 * @see [BSON Spec](http://bsonspec.org/spec.html)
 *
 * @see org.kbson.multi.BsonType.UNDEFINED
 */
class BsonUndefined() : BsonValue() {

    override fun getBsonType(): BsonType {
        return BsonType.UNDEFINED
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        return true
    }

    override fun hashCode(): Int {
        return this::class.hashCode()
    }

    override fun toString(): String {
        return "BsonUndefined()"
    }

    companion object {
        val UNDEFINED: BsonUndefined = BsonUndefined()
    }
}
