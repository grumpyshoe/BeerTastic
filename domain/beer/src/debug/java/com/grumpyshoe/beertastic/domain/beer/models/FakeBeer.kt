package com.grumpyshoe.beertastic.domain.beer.models

val fakeBeer = getFakeBeer()

fun getFakeBeer(id: Int = 0): Beer {
    return Beer(
        id = id,
        name = "Beer_$id",
        tagline = "Tag_$id",
        firstBrewed = "2023-05-23",
        description = "Beer description $id",
        imageUrl = "dummyUrl $id",
        abv = 6.0,
        ibu = 60.0,
        targetFG = 1010.0,
        targetOG = 1056.0,
        ebc = 17.0,
        srm = 8.5,
        ph = 4.4,
        attenuationLevel = 82.14,
        volume = Volume(
            value = 20,
            unit = "liters"
        ),
        boilVolume = Volume(
            value = 25,
            unit = "liters"
        ),
        method = Method(
            mashTemp = listOf(
                MethodItem(
                    temp = Value(
                        value = 65.0,
                        unit = "celsius"
                    ),
                    duration = 75
                )
            ),
            fermentation = Fermentation(
                temp = Value(
                    value = 19.0,
                    unit = "celsius"
                )
            ),
            twist = "twist"
        ),
        ingredients = Ingredients(
            malt = listOf(
                IngredientsItem(
                    name = "Extra Pale",
                    amount = Value(
                        value = 5.3,
                        unit = "kilograms"
                    )
                )
            ),
            hops = listOf(
                IngredientsItem(
                    name = "Ahtanum",
                    amount = Value(
                        value = 17.5,
                        unit = "grams"
                    )
                )
            ),
            yeast = "Wyeast 1056 - American Ale™"
        ),
        foodPairing = listOf(
            "Spicy carne asada with a pico de gallo sauce",
            "Shredded chicken tacos with a mango chilli lime salsa",
            "Cheesecake with a passion fruit swirl sauce"
        ),
        brewersTips = "brewer tips",
        contributedBy = "Sam Mason <samjbmason>"
    )
}
