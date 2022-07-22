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
 * Base class for the numeric BSON types. This class mirrors the functionality provided by
 * `java.lang.Number`.
 */
abstract class BsonNumber : BsonValue() {
    /**
     * Returns the value of the specified number as an `int`, which may involve rounding or
     * truncation.
     *
     * @return the numeric value represented by this object after conversion to type `int`.
     */
    abstract fun intValue(): Int

    /**
     * Returns the value of the specified number as an `long`, which may involve rounding or
     * truncation.
     *
     * @return the numeric value represented by this object after conversion to type `long`.
     */
    abstract fun longValue(): Long

    /**
     * Returns the value of the specified number as a `double`, which may involve rounding.
     *
     * @return the numeric value represented by this object after conversion to type `double`.
     */
    abstract fun doubleValue(): Double

    /**
     * Returns the value of the specified number as a `Decimal128`, which may involve rounding.
     *
     * @return the numeric value represented by this object after conversion to type `Decimal128`.
     * @since 3.4
     */
    abstract fun decimal128Value(): Long
}
