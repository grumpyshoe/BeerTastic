<p>
<h2><i>Update:</i></h2>
Unfortunately, the API used in this project is no longer available. A working project will be available again soon, until then this repo can show how I work and structure projects despite the fact that it currently does not provide any data.

</p>

<hr/>

<h1 align="center">BeerTastic</h1>

<p align="center">
  <a href="https://opensource.org/licenses/MIT"><img alt="License" src="https://img.shields.io/badge/License-MIT-purple.svg"/></a>
  <a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/grumpyshoe/BeerTastic/actions"><img alt="Build Status" src="https://github.com/grumpyshoe/BeerTastic/workflows/Android%20CI/badge.svg"/></a> 
</p>

<div float="left">
<img src="/preview/splashscreen.png"  width="24%"/>
<img src="/preview/beerOverview2.png"  width="24%"/>
<img src="/preview/beerDetails2.png"  width="24%"/>
</div>

# Introduction

The app `BeerTastic` is a showcase app that illustrates my approach on how I accomplish tasks and create scalable and maintainable projects.

# Content of the app

The content of the app and the range of functions are kept small. The app uses the Punk API (https://punkapi.com/) to list different beers. 

## Features
* The homescreen shows a list of beer which loads more data while scrolling down (like a infinite list).
* The homescreen also shows a option to show a random beer.
* Selecting a beer (taping on the list item) opens a detailed view containing further information.
* You can add a beer to your favorites using the heart symbol at the top right of the detailed view. These favorites are then highlighted in the aforementioned overview list and displayed in a separate area above the actual list for quick access.

# Architecture

The project is structured according to the `clean architecture` pattern, so that it enables maximum testability. At the top level are the modules `app`, `common`, `data`, `domain` and `features`. Within these modules there are sub-modules to differentiate between different areas. This concept reduces the build time significantly, as unchanged modules can be loaded from the cache.

For the communication between UI & data the MVVM pattern was used to achieve a clear differentiation of responsibilities. The UI elements themselves were implemented in compose.

# More about me

Name	 : Thomas Cirksena  
Email    : thomas.cirksena@gmail.com  
Github   : https://github.com/grumpyshoe  
LinkedIn : www.linkedin.com/in/thomas-cirksena  
