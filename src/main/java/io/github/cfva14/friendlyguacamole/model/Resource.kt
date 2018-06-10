package io.github.cfva14.friendlyguacamole.model

import io.github.cfva14.friendlyguacamole.model.Status.*

/**
 * Created by Carlos Valencia on 6/9/18
 */

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T?): Resource<T> {
            return Resource(ERROR, data, message)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(LOADING, data, null)
        }
    }

}