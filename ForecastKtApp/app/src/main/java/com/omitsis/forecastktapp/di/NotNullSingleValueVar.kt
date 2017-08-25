package com.omitsis.forecastktapp.di

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class NotNullSingleValueVar<T>(): ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T =
            value ?:throw IllegalStateException("Not initialized")

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("already initialized")
    }

    object DelegatesExt{
        fun <T> notNullSingleValue():
                ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
    }
}