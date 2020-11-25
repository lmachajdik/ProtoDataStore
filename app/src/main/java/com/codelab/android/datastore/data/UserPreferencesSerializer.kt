package com.codelab.android.datastore.data

import android.content.Context
import androidx.datastore.CorruptionException
import androidx.datastore.DataStore
import androidx.datastore.Serializer
import com.codelab.android.datastore.UserPreferences
import com.google.protobuf.InvalidProtocolBufferException
import kotlinx.coroutines.flow.Flow
import java.io.InputStream
import java.io.OutputStream

object UserPreferencesSerializer : Serializer<UserPreferences> {
    override fun readFrom(input: InputStream): UserPreferences {
        try {
            return UserPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: UserPreferences, output: OutputStream) = t.writeTo(output)
}