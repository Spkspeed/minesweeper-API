# minesweeper-API

## The Game
Develop the classic game of [Minesweeper](https://en.wikipedia.org/wiki/Minesweeper_(video_game))

## What to build
The following is a list of items (prioritized from most important to least important) we wish to see:
* Design and implement  a documented RESTful API for the game (think of a mobile app for your API) - DONE - CREATE API DOCUMENTATION WITH SWAGGER
* Implement an API client library for the API designed above. Ideally, in a different language, of your preference, to the one used for the API - PENDING - I THINK I DONT UNDERSTAND THIS ITEM YET, IS THE API CLIENT THE MAIN LOGIC CODE?
* When a cell with no adjacent mines is revealed, all adjacent squares will be revealed (and repeat) - DONE - NEED MORE TESTING
* Ability to 'flag' a cell with a question mark or red flag - DONE
* Detect when game is over - DONE
* Persistence - PENDING
* Time tracking - DONE
* Ability to start a new game and preserve/resume the old ones - PENDING
* Ability to select the game parameters: number of rows, columns, and mines - DONE
* Ability to support multiple users/accounts - DONE
 
## The initial Design

The development was focused using Java language with Swagger framework for Document the API which can be located in
heroku url

* In the beginning of creating the API Documentation I decided to use Swagger framework for document the API Controller but later I figured out that there was needed to use a different approach with another language and a separate project according to specifications.
* The initial development was started using TDD methodology to keep a set of tests to verify the correct functionality of the basic actions.
* The tests only verifies basic functionality
* There is needed to start a full tests of the functionality which I will start once I finish the most important items.
