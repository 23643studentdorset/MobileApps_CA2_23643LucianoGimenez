# MobileApps_CA2_23643LucianoGimenez

## Requirements:
### 1. Movie recycler view:
  - Create a Movie class with the structure specified in movie.json
  - Obtain and fill data (minimum of 4 movies)
    - Obtain relevant movie data from Vue (https://www.myvue.com/cinema/dublin/whats-on) or your favourite provider and add data credits at the bottom of the app
    - Generate a random number between 0 and 15 for each movie and assign to seats_remaining
    - Start with an initial default seats_selected value of 0 for all movies
    - You shall fill random URLs for images from pixabay or other free image providers to begin with
  - Build a Recycler View using the specified template, refer to recycler_view_template_*.jpg
  - If any seats are selected, show how many seats are selected and hide remaining seats
### 2. Seat selection feature:
  - Clicking any item (anywhere on the item) on the movie recycler view should open a new MovieActivity, refer to movie_activity_*.jpg
  - Add plus and minus icons, show seats_selected in the middle
  - On click plus/minus, update both seats_selected and seats_remaining for that movie
  - Add validation, when 0 seats selected minus is disabled, when 0 seats remaining plus is disabled
  - When back is pressed, the selected seats are retained and reflected in the recycler view. (Hint: If you don’t see any updates, call adapter notifyDatasetChanged as soon as you return to the recycler view activity)
### 3. Bonus:
  - Add "filling fast" badge if less than 3 seats remaining
  - Use "Roboto Condensed" font to replicate same style
  - Use original movie images from myvue.com or your favourite provider (Hint: check get_movie_image_url.gif)

### Note:
Follow submissions guidelines
This assignment carries 10% of your Mobile App 1 course.
Bonus part does not carry any marks individually, but will be used to claim back any marks you lose.
___

## Met Requirements:
### 1. Movie recycler view:
- [x] Create a Movie class with the structure specified in movie.json
- [x] Obtain and fill data (minimum of 4 movies)
- [x] Obtain relevant movie data from Vue (https://www.myvue.com/cinema/dublin/whats-on) or your favourite provider and add data credits at the bottom of the app
- [x] Generate a random number between 0 and 15 for each movie and assign to seats_remaining
- [x] Start with an initial default seats_selected value of 0 for all movies
  - You shall fill random URLs for images from pixabay or other free image providers to begin with
- [x] Build a Recycler View using the specified template, refer to recycler_view_template_*.jpg
  - If any seats are selected, show how many seats are selected and hide remaining seats
### 2. Seat selection feature:
- [x] Clicking any item (anywhere on the item) on the movie recycler view should open a new MovieActivity, refer to movie_activity_*.jpg
- [x] Add plus and minus icons, show seats_selected in the middle
- [x] On click plus/minus, update both seats_selected and seats_remaining for that movie
- [x] Add validation, when 0 seats selected minus is disabled, when 0 seats remaining plus is disabled
  - When back is pressed, the selected seats are retained and reflected in the recycler view. (Hint: If you don’t see any updates, call adapter notifyDatasetChanged as soon as you return to the recycler view activity)
### 3. Bonus:
- Add "filling fast" badge if less than 3 seats remaining
- [x] Use "Roboto Condensed" font to replicate same style
- [x] Use original movie images from myvue.com or your favourite provider (Hint: check get_movie_image_url.gif)

We have tried different approaches to change the text into the recycler view but none of them were working
first we tried with implementing a variable on the adapter and the app was crashing and after that with an Array
to populate the info on the adapter, even if the logs show that the number of seats we are intending is correct
we did not find the mistake to solve it.






