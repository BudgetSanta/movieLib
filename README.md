# Movie Library Project

## Planning

*CLASS: Movie*
* MovieID [Getter]
* Title [Getter]
* Director [Getter]
* Writer [Getter]
* Duration [Getter]
* Genre [Getter, Setter]
* Classification [Getter]
* Release Date [Getter]
* Rating  [Getter, Setter]

*CLASS: Playlist*
* PlaylistID [Getter]
* Name [Getter]
* Length [Getter]
* Duration [Getter]
* Movies [Getter]


## IDEAS:
* *Booleans for menus* (used to loop menus. Will allow to ake input from user inside do while loop then on exit choice change flag)
  * Main menu : TRUE till program Exit
    * Movies sub menu : TRUE while in movies sub menu
      * Sort sub menu : TRU wile in Sort sub sub menu
      * Some menus will 'go up a directory' after their function automatically, e.g. rating (rate a movie then it moves user back to movies sub menu)
    * Playlists sub menu : TRU while in playlists sub menu
* When reading in movies keep track of *longest name for formatting the display*?
  * e.g.
  * ----------------------------------------------
  * #. MOVIE TITLE WITH MORE TEXT FOR LONG MOVIES
  *      DURATION:  %%% hours GENRE: %%%%%%%%%%
  *      CLASSIFICATION: %%%%% RATING: %%%
  * ----------------------------------------------
* When reading in movies, keep track of *largest ID num* for when adding
  * Also can have a check when adding to ensure no duplicate IDs


## Taks to Complete:
* [ ] *Movies*
    * [X] Display ALL [Title, Duration, Genre, Classification, Rating]
      * Refer to IDEAS for possible format.
    * [X] Sort by
      * [X] Title
      * [X] Genre
    * [ ] Add Rating
      * [ ] Search Feature [Simple]
      * [ ] Rating setter
    * [ ] Change Genre
      * [ ] Search Feature [Simple]
      * [ ] Genre setter
    * [ ] Add Movie
      * [ ] Add new object
      * [ ] Add object to library array
    * [ ] Exit
* [ ] *Playlists*
    * [X] Display Playlists
* [ ] *Save*
    * [ ] Write to output
* [ ] *Exit*
    * [ ] Warn of discarding unsaved changes


## METHODS:
---------
### LibraryManager_18347500.java
  ```java
  public static void main(String[] args)
  ```
    DESC: This method does blah blah blah
