package com.grumpyshoe.beertastic.common.navigation.transision

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

object TransitionDuration {
    const val NORMAL = 1000
    const val FAST = 300
}

interface Transition {
    fun enter(
        initialOffsetX: Int = TransitionDuration.FAST,
        durationMillis: Int = TransitionDuration.FAST,
    ): EnterTransition

    fun exit(
        initialOffsetX: Int = TransitionDuration.FAST,
        durationMillis: Int = TransitionDuration.FAST,
    ): ExitTransition

    fun popEnter(
        initialOffsetX: Int = TransitionDuration.FAST,
        durationMillis: Int = TransitionDuration.FAST,
    ): EnterTransition

    fun popExit(
        initialOffsetX: Int = TransitionDuration.FAST,
        durationMillis: Int = TransitionDuration.FAST,
    ): ExitTransition
}

object SlideFromRight : Transition {

    override fun enter(initialOffsetX: Int, durationMillis: Int): EnterTransition {
        return slideInHorizontally(
            initialOffsetX = { initialOffsetX },
        )
    }

    override fun exit(initialOffsetX: Int, durationMillis: Int): ExitTransition {
        return slideOutHorizontally(
            targetOffsetX = { -initialOffsetX },
        )
    }

    override fun popEnter(initialOffsetX: Int, durationMillis: Int): EnterTransition {
        return slideInHorizontally(
            initialOffsetX = { -initialOffsetX },
        )
    }

    override fun popExit(initialOffsetX: Int, durationMillis: Int): ExitTransition {
        return slideOutHorizontally(
            targetOffsetX = { initialOffsetX },
        )
    }
}

object FadeIn : Transition {

    override fun enter(initialOffsetX: Int, durationMillis: Int): EnterTransition {
        return fadeIn()
    }

    override fun exit(initialOffsetX: Int, durationMillis: Int): ExitTransition {
        return fadeOut()
    }

    override fun popEnter(initialOffsetX: Int, durationMillis: Int): EnterTransition {
        return fadeIn()
    }

    override fun popExit(initialOffsetX: Int, durationMillis: Int): ExitTransition {
        return fadeOut()
    }
}
