
# Introduction

The app `BeerTastic` is a showcase app that illustrates my approach on how I accomplish tasks and create scalable and maintainable projects.

# Content of the app

The content of the app and the range of functions are kept small. The app uses the Punk API (https://punkapi.com/) to list different beers. Selecting a beer opens a detailed view containing further information. You can add a beer to your favorites using the heart symbol at the top right of the detailed view. These favorites are then highlighted in the aforementioned overview list and displayed in a separate area above the actual list for quick access.

# Architecture

The project is structured according to the `clean architecture` pattern, so that it enables maximum testability. At the top level are the modules `app`, `common`, `data`, `domain` and `features`. Within these modules there are sub-modules to differentiate between different areas. This concept reduces the build time significantly, as unchanged modules can be loaded from the cache.

For the communication between UI & data the MVVM pattern was used to achieve a clear differentiation of responsibilities. The UI elements themselves were implemented in compose.

More about me

Name	 : Thomas Cirksena  
Email    : thomas.cirksena@gmail.com  
Github   : https://github.com/grumpyshoe  
LinkedIn : www.linkedin.com/in/thomas-cirksena  


Name	 : Thomas Cirksena  
Email    : thomas.cirksena@gmail.com  
Github   : https://github.com/grumpyshoe  
LinkedIn : www.linkedin.com/in/thomas-cirksena  
