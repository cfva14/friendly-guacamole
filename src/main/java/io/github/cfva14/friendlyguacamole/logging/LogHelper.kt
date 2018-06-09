package io.github.cfva14.friendlyguacamole.logging

import android.util.Log
import io.github.cfva14.friendlyguacamole.BuildConfig
import io.github.cfva14.friendlyguacamole.GuacamoleApp

/**
 * Created by Carlos Valencia on 6/8/18
 */

/**
 * Use this to log the different levels and to create the TAG's
 * */

object LogHelper {

    /**
     * If name and length are not provided, default values will be used.
     * */

    private val LOG_PREFIX = "${GuacamoleApp.getInstance().guacamoleName}__"
    private val LOG_PREFIX_LENGTH = LOG_PREFIX.length
    private val MAX_LOG_TAG_LENGTH = GuacamoleApp.getInstance().guacamoleNameLength

    private fun makeLogTag(str: String) : String {
        if (str.length > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1)
        }
        return LOG_PREFIX + str
    }

    fun makeLogTag(cls: Class<*>): String {
        return makeLogTag(cls.simpleName)
    }

    fun v(tag: String, vararg messages: Any) {
        log(tag, Log.VERBOSE, null, messages)
    }

    fun d(tag: String, vararg messages: Any) {
        log(tag, Log.DEBUG, null, messages)
    }

    fun i(tag: String, vararg messages: Any) {
        log(tag, Log.INFO, null, messages)
    }

    fun w(tag: String, vararg messages: Any) {
        log(tag, Log.WARN, null, messages)
    }

    fun w(tag: String, t: Throwable, vararg messages: Any) {
        log(tag, Log.WARN, t, messages)
    }

    fun e(tag: String, vararg messages: Any) {
        log(tag, Log.ERROR, null, messages)
    }

    fun e(tag: String, t: Throwable, vararg messages: Any) {
        log(tag, Log.ERROR, t, messages)
    }

    private fun log(tag: String, level: Int, t: Throwable?, messages: Array<out Any>) {
        val message: String
        message = if (t == null && messages.size == 1) {
            messages[0].toString()
        } else {
            val sb = StringBuilder()
            for (m in messages) {
                sb.append("$m ")
            }
            if (t != null) {
                sb.append("\n").append(Log.getStackTraceString(t))
            }
            sb.toString()
        }

        if (BuildConfig.DEBUG) {
            Log.println(level, tag, message)
        }
    }

}