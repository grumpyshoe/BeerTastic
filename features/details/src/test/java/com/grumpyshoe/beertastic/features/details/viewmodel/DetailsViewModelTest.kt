package com.grumpyshoe.beertastic.features.details.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.grumpyshoe.beertastic.domain.beer.models.fakeBeer
import com.grumpyshoe.beertastic.domain.beer.usecase.FakeGetBeerById
import com.grumpyshoe.beertastic.domain.beer.usecase.FakeIsBeerFavorite
import com.grumpyshoe.beertastic.domain.beer.usecase.FakeSetIsBeerFavorite
import com.grumpyshoe.beertastic.domain.beer.usecase.SetIsBeerFavorite
import com.grumpyshoe.beertastic.features.details.navigation.DetailsDestination.BEER_ID
import com.grumpyshoe.beertastic.features.details.ui.uimodel.BeerDetailsDataState
import com.grumpyshoe.beertastic.result.ApiError
import com.grumpyshoe.beertastic.result.ApiSuccess
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DetailsViewModelTest {

    private lateinit var getBeerById: FakeGetBeerById
    private lateinit var isBeerFavorite: FakeIsBeerFavorite
    private lateinit var setIsBeerFavorite: SetIsBeerFavorite
    private val testDispatcher = UnconfinedTestDispatcher()

    private lateinit var sut: DetailsViewModel

    @Before
    fun setup() {
        getBeerById = FakeGetBeerById()
        isBeerFavorite = FakeIsBeerFavorite()
        setIsBeerFavorite = FakeSetIsBeerFavorite()
    }

    private fun initViewModel(beerId: Int = 1) {
        sut = DetailsViewModel(
            savedStateHandle = SavedStateHandle().also {
                it[BEER_ID] = "$beerId"
            },
            getBeerById = getBeerById,
            ioDispatcher = testDispatcher,
            isBeerFavorite = isBeerFavorite,
            setIsBeerFavorite = setIsBeerFavorite
        )
    }

    @Test
    fun `on init - with beer id - correct id is requested`() {

        // define test data
        getBeerById.result = ApiSuccess(fakeBeer)

        // init viewModel
        initViewModel(beerId = 99)

        // check assertions
        assertEquals(99, getBeerById.requestedBeerId)
    }

    @Test
    fun `beerDetailsDataState - on data available - is mapped correctly`() {

        // define test data
        getBeerById.result = ApiSuccess(fakeBeer)

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.beerDetailsDataState.take(1).lastOrNull() }
        assertTrue(actual is BeerDetailsDataState.DataLoaded)
    }

    @Test
    fun `beerDetailsDataState - on error - is mapped correctly`() {

        // define test data
        getBeerById.result = ApiError("DummyError")

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.beerDetailsDataState.take(1).lastOrNull() }
        assertTrue(actual is BeerDetailsDataState.Error)
    }

    @Test
    fun `isFavorite - on not favorite beer - is false`() {

        // define test data
        isBeerFavorite.result = false

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.beerDetailsDataState.take(1).lastOrNull() }
        val isFavorite = (actual as BeerDetailsDataState.DataLoaded).isFavorite
        assertFalse(isFavorite)
    }

    @Test
    fun `isFavorite - on favorite - is true`() {

        // define test data
        isBeerFavorite.result = true

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.beerDetailsDataState.take(1).lastOrNull() }
        val isFavorite = (actual as BeerDetailsDataState.DataLoaded).isFavorite
        assertTrue(isFavorite)
    }
}
