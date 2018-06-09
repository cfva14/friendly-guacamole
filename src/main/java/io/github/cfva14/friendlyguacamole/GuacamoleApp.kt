package io.github.cfva14.friendlyguacamole

import android.app.Application

/**
 * Created by Carlos Valencia on 6/8/18
 */

open class GuacamoleApp : Application() {

    /**
     * Sets a custom name for your logs
     */
    open val guacamoleName: String get() = getString(R.string.friendly_guacamole)

    /**
     * Sets the length of your logs
     */
    open val guacamoleNameLength: Int get() = 25

    init {
        INSTANCE = this
    }

    companion object {
        private var INSTANCE: GuacamoleApp? = null

        @JvmStatic fun getInstance(): GuacamoleApp {
            return INSTANCE ?: getInstance().apply {
                INSTANCE = this
            }
        }

    }

}