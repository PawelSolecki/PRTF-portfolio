package com.example.portfolioservice.portfolios.infrastructure.utils

import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

class UtilsImpl : Utils {
    override fun <T : Any, P : Any> patch(target: T, patchDto: P): T {
        patchDto::class.memberProperties.forEach { patchProp ->
            val safePatchProp = patchProp as? KProperty1<P, *> ?: return@forEach

            val patchValue = safePatchProp.get(patchDto)
            if (patchValue == null) return@forEach

            target::class.memberProperties
                .filterIsInstance<KMutableProperty<T>>()
                .find { it.name == patchProp.name }
                ?.let { targetProp ->
                    try {
                        @Suppress("UNCHECKED_CAST")
                        targetProp.setter.call(target, patchValue as Any)
                    } catch (e: TypeCastException) {
                        System.err.println("Błąd typu dla właściwości ${patchProp.name}: ${e.message}")
                    }
                }
        }
        return target
    }
}