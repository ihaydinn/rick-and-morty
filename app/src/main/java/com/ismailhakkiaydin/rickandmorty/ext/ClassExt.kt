package com.ismailhakkiaydin.rickandmorty.ext

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


fun <C> Class<*>.findGenericWithType(genericIndex: Int): Class<C> {
    @Suppress("UNCHECKED_CAST")
    return (genericSuperclass as ParameterizedType).actualTypeArguments.getOrNull(genericIndex) as Class<C>
}
