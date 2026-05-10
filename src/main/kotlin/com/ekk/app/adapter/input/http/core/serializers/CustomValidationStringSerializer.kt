package com.ekk.app.adapter.input.http.core.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

open class CustomValidationStringSerializer(private val validators: List<(String) -> String?>) : KSerializer<String> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("CustomValidationStringSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: String) {
        for (validation in validators) {
            val errorMessage = validation(value)
            require(errorMessage.isNullOrBlank()) { errorMessage!! }
        }

        encoder.encodeString(value)
    }

    private fun getSerialName(): String {
        descriptor.annotations

        return descriptor.getElementName(0)
    }

    override fun deserialize(decoder: Decoder): String {
        val serialName = getSerialName()
        val value = decoder.decodeString()
        for (validation in validators) {
            val errorMessage = validation(value)
            errorMessage?.let {
                throw IllegalArgumentException(buildString {
                    append(serialName)
                    append(" ")
                    append(errorMessage)
                })
            }
        }

        return value
    }
}