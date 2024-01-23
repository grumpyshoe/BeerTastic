package com.grumpyshoe.beertastic.features.home.viewmodel

import com.grumpyshoe.beertastic.domain.beer.models.fakeBeer
import com.grumpyshoe.beertastic.domain.beer.models.getFakeBeer
import com.grumpyshoe.beertastic.domain.beer.usecase.FakeGetBeerById
import com.grumpyshoe.beertastic.domain.beer.usecase.FakeGetBeers
import com.grumpyshoe.beertastic.domain.beer.usecase.FakeGetFavorites
import com.grumpyshoe.beertastic.domain.beer.usecase.FakeGetRandomBeer
import com.grumpyshoe.beertastic.features.home.ui.uimodel.BeerDataState
import com.grumpyshoe.beertastic.result.ApiError
import com.grumpyshoe.beertastic.result.ApiSuccess
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private lateinit var getBeers: FakeGetBeers
    private lateinit var getBeerById: FakeGetBeerById
    private lateinit var getFavorites: FakeGetFavorites
    private lateinit var getRandomBeer: FakeGetRandomBeer
    private val testDispatcher = UnconfinedTestDispatcher()

    private lateinit var sut: HomeViewModel

    @Before
    fun setup() {
        getBeers = FakeGetBeers()
        getBeerById = FakeGetBeerById()
        getFavorites = FakeGetFavorites()
        getRandomBeer = FakeGetRandomBeer()
    }

    private fun initViewModel() {
        sut = HomeViewModel(
            getBeers = getBeers,
            getBeerById = getBeerById,
            getFavorites = getFavorites,
            getRandomBeer = getRandomBeer,
            ioDispatcher = testDispatcher
        )
    }

    @Test
    fun `viewState - on data available - has correct state`() {

        // define test data
        getBeers.result = ApiSuccess((0..3).map { getFakeBeer(it) })

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.viewState.take(1).lastOrNull() }
        assertTrue(actual is BeerDataState.DataLoaded)
    }

    @Test
    fun `beerList - on data available - has correct data length`() {

        // define test data
        getBeers.result = ApiSuccess((0..2).map { getFakeBeer(it) })

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.beerList.take(1).lastOrNull() }
        assertEquals(3, actual?.size)
    }

    @Test
    fun `beerList - on data available - mapped data correctly`() {

        // define test data
        getBeers.result = ApiSuccess(
            listOf(
                fakeBeer.copy(
                    id = 99,
                    name = "beer_123",
                    tagline = "tag 1",
                    firstBrewed = "2012-05-14",
                    description = "dummy description",
                    imageUrl = "dummy image url"
                )
            )
        )

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.beerList.take(1).lastOrNull()?.firstOrNull() }
        assertEquals(99, actual?.id)
        assertEquals("beer_123", actual?.name)
        assertEquals("tag 1", actual?.tagline)
        assertEquals("dummy description", actual?.shortDescription)
        assertEquals("dummy image url", actual?.imageUrl)
    }

    @Test
    fun `beerList - on data available - shorten description to 50 chars + ellipsis`() {

        // define test data
        getBeers.result = ApiSuccess(
            listOf(
                fakeBeer.copy(
                    description = (0..100).joinToString(separator = "") { "a" }
                )
            )
        )

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.beerList.take(1).lastOrNull()?.firstOrNull() }
        assertEquals(53, actual?.shortDescription?.length)
    }

    @Test
    fun `viewState - on error - is set correctly`() {

        // define test data
        getBeers.result = ApiError("DummyError")

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.viewState.take(1).lastOrNull() }
        assertTrue(actual is BeerDataState.Error)
    }

    @Test
    fun `request page - on init - is 1`() {

        // define test data
        getBeers.result = ApiSuccess(listOf(fakeBeer))

        // init viewModel
        initViewModel()

        // check assertions
        assertEquals(1, getBeers.requestedPage)
    }

    @Test
    fun `requested page - on loadMoreData - is increased by 1`() {

        // define test data
        getBeers.result = ApiSuccess(listOf(fakeBeer))

        // init viewModel
        initViewModel()

        // trigger action
        sut.loadMoreData()

        // check assertions
        assertEquals(2, getBeers.requestedPage)
    }

    @Test
    fun `beerList - on favorites available - doesn't contain duplicates`() {

        // define test data
        getBeers.result = ApiSuccess((0..2).map { getFakeBeer(it) })
        getFavorites.result = listOf(fakeBeer.id)

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.beerList.take(1).lastOrNull() }
        assertEquals(2, actual?.size)
        assertTrue(actual?.map { it.id }?.contains(fakeBeer.id) == false)
    }

    @Test
    fun `favorites - on favorites available - contains correct data`() {

        // define test data
        getFavorites.result = listOf(fakeBeer.id)

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.favorites.take(1).lastOrNull() }
        assertEquals(1, actual?.size)
        assertTrue(actual?.map { it.id }?.contains(fakeBeer.id) == true)
    }

    @Test
    fun `randomBeer - on init - is null`() {

        // init viewModel
        initViewModel()

        // check assertions
        val actual = runBlocking { sut.randomBeer.take(1).lastOrNull() }
        assertNull(actual)
    }

    @Test
    fun `randomBeer - on request beer - contains correct data`() {

        // define test data
        getRandomBeer.result = ApiSuccess(fakeBeer)

        // init viewModel
        initViewModel()

        // trigger action
        sut.showRandomBeer()

        // check assertions
        val actual = runBlocking { sut.randomBeer.take(1).lastOrNull() }
        assertEquals(fakeBeer.id, actual!!.id)
    }
}