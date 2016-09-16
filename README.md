# Movie Library Project

## Planning

   CLASS/Attribute | GETTER | SETTER | MUTATOR(s) |
-----------------------------------------------------
*CLASS: Movie*
* MovieID             [x]      [ ]       [ ]
* Title               [x]      [ ]       [ ]
* Director            [x]      [ ]       [ ]
* Writer              [x]      [ ]       [ ]
* Duration            [x]      [ ]       [ ]
* Genre               [x]      [x]       [ ]
* Classification      [x]      [ ]       [ ]
* Release Date        [x]      [ ]       [ ]

*CLASS: Playlist*
* PlaylistID          [x]      [ ]       [ ]
* Name                [x]      [ ]       [ ]
* Length              [x]      [?]       [ ]
* Duration            [x]      [?]       [ ]
* Movies              [x]      [?]       [ ]


## IDEAS:
* # Booleans for menus (used to loop menus. Will allow to ake input from user inside do while loop then on exit choice change flag)
..* Main menu : TRUE till program Exit
....* Movies sub menu : TRUE while in movies sub menu
      * Sort sub menu : TRU wile in Sort sub sub menu
      * Some menus will 'go up a directory' after their function automatically, e.g. rating (rate a movie then it moves user back to movies sub menu)
    * Playlists sub menu : TRU while in playlists sub menu
* # When reading in movies keep track of longest name for formatting the display?
    - e.g.
    - ----------------------------------------------
    - #. MOVIE TITLE WITH MORE TEXT FOR LONG MOVIES
    -      DURATION:  %%% mins GENRE: %%%%%%%%%%
    -      CLASSIFICATION: %%%%% RATING: %%%
    - ----------------------------------------------
  - # When reading in movies, keep track of largest ID num for when adding
      - Also can have a check when adding to ensure no duplicate IDs


 ## Taks to Complete:
  - Movies
     - [ ] Display ALL [Title, Duration, Genre, Classification, Rating]
        - Refer to IDEAS for possible format.
     - [ ] Sort by
        - [ ] Title
        - [ ] Genre
     - [ ] Add Rating
        - [ ] Search Feature [Simple]
        - [ ] Rating setter
     - [ ] Change Genre
        - [ ] Search Feature [Simple]
        - [ ] Genre setter
     - [ ] Add Movie
        - [ ] Add new object
        - [ ] Add object to library array
     - [ ] Exit
  - Playlists
     - [ ] Display Playlists
  - Save
     - [ ] Write to output
     - [ ] Close files
  - Exit


METHODS:
---------
Movies_18347500.java
  ```java
  public static void main(String[] args)
  ```
    DESC:
  blah blah blah()
    DESC:
  foo foo foo()
    DESC:
  bar bar bar()
    DESC:
