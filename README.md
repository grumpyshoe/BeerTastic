
# Introduction

The app BeerTastic is a showcase app, designed to demonstrate how I create scalable and maintainable projects.

# App content

The app uses the Punk API (https://punkapi.com/) to list different beers. If a beer is selected, a detailed view opens which contains further information.
You can also add a beer to your favorites via the heart symbol in the detailed view. These favorites are highlighted in the previously mentioned overview and displayed in a separate area above the actual list for quick access.

# Architecture

The project is built according to the Clean Architecture Pattern, so that it enables the highest degree of testability. At the top level are the modules `app`, `common`, `data`, `domain` and `features`. Within these modules there are sub-modules to differentiate between different areas. 
This encapsulation reduces the build time as unchanged modules can be loaded from the cache.


# More about me

Name	 : Thomas Cirksena
Email    : thomas.cirksena@gmail.com
Github   : https://github.com/grumpyshoe
LinkedIn : www.linkedin.com/in/thomas-cirksena