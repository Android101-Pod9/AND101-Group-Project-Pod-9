# **# Milestone 1 : Activity 2**
# **ScreenSync**

## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview

### Description 

**Description of your app**

### App Evaluation

<!-- Evaluation of your app across the following attributes -->

**Movie App**
### Mobile: 
It can give release dates (can add it to a calender)
It's more accesible as an app
Notifications for when tickets open up

### Story:
With a surge of Netflix and on-demand apps, not many people go to the theatre, so maybe tickets wouldn't be as useful, because there are other ways to watch movies.
friends : While lots of people mostly use streaming apps, some are still interested in going to movies as a way to hang out with others.

### Market:
Target audience would be movie enthusiasts and movie theatre enjoyers in general, but that would also mean it's probably a small group of people because going to the movies is less popular now.

### Habit:
It's not used to create anything,it instead would be habit forming for people who go often, also with the notifications, it would lead to people opening the app more often.
The average user would probably use it every couple of months.

### Scope:
if we add dates to calender and notifications it would take much longer to do maybe 2 months, 
the stripped down version would still show movies, movie theatres associated with them and possibly the tickets to those movies and it would still be useful.


## Product Spec

### 1. User Features (Required and Optional)

Required Features:

- being able to add movies from the search into a watchlist 
- filter based on genre(s) (using dropdown button)
    - have the genre filter let you pick more than one genre
- recommend movies  based on the filter (search bar and search button)
- show Release dates of upcoming movies
- having movies already presented in the beginning (base list of movies when the user first goes into the app )
- home page
- watchlist page
- detailed info page



Stretch Features:
- notifications when tickets open up
- showing location of the movie theatre
- search based on actors
- have a drop down filter so you can search based on actors or genres
- give plot summary 
- when you're in the more info page, the movies have tags that you can click on which will take you back to the search page
- 


### 2. Chosen API(s)

- IMDB API - https://imdb-api.com/api
    - release dates of upcoming movies
    - recommend movies to watch in theatres
    - manage a favorite list of movies you have watched so far
    - have a watchlist
    - search for actors
    - search keywords (can help filter based on genre)
- OMDb API - https://www.omdbapi.com/
    - can retrieve year of release
    - give plot summary or full plot synopis(SPOILERS!!)

### 3. User Interaction

Required Feature

- **being able to add movies from the search**
    - => **plus button/toggle button that is part of each movie item, when you click it is added to a list **
    - **seperate button that user clicks to take you to the list of movies they added**
    - **button to go back to the search**
- **filter based on genre(s)**
  - => **textbox or drop down (maybe start with a drop down and then do a textbox later**
  - be able to select more than one genre
  - **search button once the filter is selected or typed**
- **recommend movies  based on the filter**
  - => **see above**
- **show Release dates of upcoming movies**
  - => **click on the movie name and then itll give you more information**
      - when it gives you more info it can you take you to a seperate page with the info
      - you would need a back button to go back to the main page
      - there would be a total of 3 pages (list, main, the more info page)
~~- **show base list of movies before user searches**~~
    - the main user action would be going back to the home screen after you search, aka you search and the screen changes to the search results but you should be able to click back to go to the home
- **watchlist page**
    - have a button at the bottom of the screen that shoes yuo the watchlist
- **home page**
    - have a button on the bottom of the screen that shows you the watchlist
    - when you search in the "home page" the screen will change to show only the search results 
    -  when you show the search results you should have a back button that you can click to go back to the original home suggestions
- **detailed info page**
    - have a back button from the detailed info page or maybe just have it so you can click the home or watch list button
	- display title, movie poster, release date, and movie genere 
 

Stretch Feature
// leave for later if we decide to add these features
- PRIORITY STRETCH: LOGIN/SIGN UP PAGE***~~
- **notifications when tickets open up**
    - => **list result of user action here**
- **showing location of the movie theatre**
  - => **list result of user action here**
- **search based on actors**
  - => **list result of user action here**
- **have a drop down filter so you can search based on actors or genres**
  - => **list result of user action here**
- **give plot summary **
  - => **list result of user action here**
- **have movie search suggestions as the user types in the search bar**


## Wireframes

<!-- Add picture of your hand sketched wireframes in this section -->
<!--esther -->
<img src="https://i.imgur.com/InUCVg0.png" width=600>
<img src="https://i.imgur.com/UW97JJ6.png" width=600>
<!--suharta-->
<img src="https://i.imgur.com/dKr8VjY.jpg" width=600>
<img src="https://i.imgur.com/gJyyxuh.jpg" width=600>
<!--vishva-->
<img src="https://i.imgur.com/Lxay2HC.jpg" width=600> 
<!--zainab-->
<img src="https://i.imgur.com/20tWNCq.png" width=600>
<img src="https://i.imgur.com/sdnOlHX.png" width=600>
<img src="https://i.imgur.com/7A3sRWd.png" width=600>


### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Build Notes

Here's a place for any other notes on the app, it's creation 
process, or what you learned this unit!  

For Milestone 2, include **2+ GIFs** of the build process here!
![](https://i.imgur.com/8X7r2WG.gif)
![](https://i.imgur.com/x3eQQ1w.gif)
![](https://i.imgur.com/4Y9wp5M.gif)



## License

Copyright **2023** **your name**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
weava logo
Drop here!