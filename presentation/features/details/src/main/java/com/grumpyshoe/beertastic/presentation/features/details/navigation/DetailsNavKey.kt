
package com.grumpyshoe.beertastic.presentation.features.details.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class DetailsNavKey(val beerId: Int) : NavKey
