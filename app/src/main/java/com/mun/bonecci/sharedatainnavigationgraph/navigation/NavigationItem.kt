package com.mun.bonecci.sharedatainnavigationgraph.navigation

/**
 * Sealed class representing different screens in the navigation graph.
 *
 * @property route The unique route associated with each screen.
 */
sealed class NavigationItem(var route: String) {
    /**
     * Object representing ScreenA in the navigation graph.
     */
    data object ScreenA : NavigationItem(route = SCREEN_A)

    /**
     * Object representing ScreenB in the navigation graph.
     */
    data object ScreenB : NavigationItem(route = SCREEN_b)

    companion object {
        const val SCREEN_A = "screen_a"
        const val SCREEN_b = "screen_b"
    }
}