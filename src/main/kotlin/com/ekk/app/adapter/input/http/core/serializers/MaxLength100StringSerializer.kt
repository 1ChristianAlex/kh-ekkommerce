package com.ekk.app.adapter.input.http.core.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

open class MaxLengthStringSerializer(private val maxLength: Int) : KSerializer<String> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("MaxLengthStringSerializer($maxLength)", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: String) {
        require(value.length <= maxLength) { "String excede $maxLength" }
        encoder.encodeString(value)
    }

    override fun deserialize(decoder: Decoder): String {
        val value = decoder.decodeString()
        if (value.length > maxLength) throw IllegalArgumentException("String excede $maxLength")
        return value
    }
}

