
package com.grumpyshoe.beertastic.data.source.network.beer.api

import com.grumpyshoe.beertastic.data.source.network.beer.model.BeerDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PunkAPI {

    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 80,
    ): Response<List<BeerDto>>

    @GET("beers/{beerId}")
    suspend fun getBeerById(
        @Path("beerId") beerId: Int,
    ): Response<BeerDto>

    @GET("beers/random")
    suspend fun getRandomBeer(): Response<BeerDto>
}
