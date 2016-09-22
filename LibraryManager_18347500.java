/*
TO DO SYNTAX:
(Using '0' instead of 'O' so they don't appear in To Do list)
Current Tasks (List of To Do)
  //T0D0: [[OrderNum][SubOrderNum]] Task Details
In Progress Tasks (Currently working on)
  //N0TE: [[OrderNum][SubOrderNum]] Task Details
Completed Taks
  //D0NE: [[OrderNum][SubOrderNum]] Task Details [Completion Notes]
*/
import java.io.*;
import java.util.Scanner;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

public class LibraryManager_18347500 {

  // Global Keyboard Instance
  public static Scanner kb = new Scanner(System.in);
  public static List<Movie_18347500> movieLibrary = initialiseMovieList();                    // Initialises Movie Library to List
  public static List<Playlist_18347500> playlists = initialisePlaylistList();                 // Initialises Playlists to List

  public static void main(String[] args) throws IOException{

    //TODO: [80] Move methods to seperate files
    //TODO: [81] Sort methods into categories
    //TODO: [82] Reference web showing Class.Method() references

    System.out.println("\n ---- IMPORTED PROGRAM FILES ---- ");


    //DONE: [42] Get ArrayList for Playlists working because playlists.txt doesn't have to exist

    rootMenu(movieLibrary, playlists);

    kb.close();
  }

  // This is the menu that calls all sub menus and repeats with menuLoopFlags
  static void rootMenu(List<Movie_18347500> movieLibrary, List<Playlist_18347500> playlists) throws IOException{

    // DONE: [20] Get basic Menu navigation working
    // Menu Loop Flags
    Boolean inRootMenu = true;              // Root Menu Loop Flag
    Boolean inMoviesMenu = false;           // Movie Menu Loop Flag
    Boolean inSortSubMenu = false;          // Sort Sub Menu Loop Flag
    Boolean inPlaylistsMenu = false;        // Playlists Menu Loop Flag

    // Root Menu Loop, when false, end program
    while (inRootMenu) {
      //DONE: [21] Print out Menu options
      //DONE: [22] Take input

      // Print Menu options and then take input
      printRootMenuOptions();
      int inputChoice = getIntIn("Enter Menu Choice: ");

      // Deciding on Menu options
      switch (inputChoice) {

        // MOVIES MENU
        case 1:
          // Loop through movies menu till false flag
          inMoviesMenu = true;
          do {
            inMoviesMenu = moviesMenu(inMoviesMenu, inSortSubMenu);
          } while (inMoviesMenu);
          break;

        // PLAYLISTS MENU
        case 2:
          // Loop through playlists menu till false flag
          inPlaylistsMenu = true;
          do {
            inPlaylistsMenu = playlistsMenu(inPlaylistsMenu);
          } while (inPlaylistsMenu);
          break;

        // SAVE MENU
        case 3:
          saveMenu();
          break;

        // EXIT MENU
        case 4:
          // Sets loop flag to false
          inRootMenu = false;
          break;

        // Bad input catch
        default:
          System.out.println("ERROR: Invalid Input. Please enter a menu choice");
          break;

      }

    }

  }

  // moviesMenu is a sub menu of ROOT for individual movies
  static Boolean moviesMenu(Boolean inMoviesMenu, Boolean inSortSubMenu) throws IOException{

    // Print menu options and take input
    printMoviesMenuOptions();
    int inputChoice = getIntIn("Enter Menu Choice: ");

    switch (inputChoice) {

      // DISPLAY
      case 1:
        // Display Movies in ID order
        displayAllMovies(movieLibrary);
        break;

      // SORT BY MENU
      case 2:
        // Loop through Sort by menu till false flag
        inSortSubMenu = true;
        do {
          inSortSubMenu = sortSubMenu(inSortSubMenu);
        } while (inSortSubMenu);
        break;

      // RATING MENU
      case 3:
        ratingSubMenu();
        break;

      // GENRE MENU
      case 4:
        genreSubMenu();
        break;

      // ADD MOVIE
      case 5:
        addMovieSubMenu();
        break;

      // EXIT
      case 6:
        // Sets loop flag to false
        inMoviesMenu = false;
        break;

      default:
        // Bad input catch
        System.out.println("ERROR: Invalid Input. Please enter a menu choice");
        break;

    }
    return inMoviesMenu;

  }

  // playlistsMenu is a sub menu of ROOT for playlists of movies
  static Boolean playlistsMenu(Boolean inPlaylistsMenu) throws IOException{

    // Print out menu options and takes input
    printPlaylistsMenuOptions();
    int inputChoice = getIntIn("Enter Menu Choice: ");

    switch (inputChoice) {

      // DISPLAY
      case 1:
        // Display Playlists
        displayAllPlaylists(playlists);
        break;

      // CREATE
      case 2:
        // Create a playlist
        System.out.println("IN CREATE PLAYLIST OPTION");
        break;

      // ADD TO PLAYLIST
      case 3:
        // Add a movie to a playlist
        System.out.println("ADD TO PLAYLIST OPTION");
        break;

      // EXIT
      case 4:
        // Sets loop flag to false
        inPlaylistsMenu = false;
        break;

      default:
        // Bad input catch
        System.out.println("ERROR: Invalid Input. Please enter a menu choice");
        break;
    }

    return inPlaylistsMenu;
  }

  // sortSubMenu is a sub menu of Movies for sorting movieLibrary
  static Boolean sortSubMenu(Boolean inSortSubMenu) throws IOException{

    // print menu options and take input
    printSortMenuOptions();
    int inputChoice = getIntIn("Enter Sort by choice: ");

    switch (inputChoice) {

      // TITLE
      case 1:
        // Display movies by title
        displayAllMovies(sortByTitle());                            // Displays the Movies based in order of title sort
        break;

      // GENRE
      case 2:
        // Display movies by genre
        displayAllMovies(sortByGenre());
        break;

      // EXIT
      case 3:
        // sets loops flag to false
        inSortSubMenu = false;
        break;

      default:
        // catch bad input
        System.out.println("ERROR: Invalid Input. Please enter a menu choice");
        break;
    }

    return inSortSubMenu;
  }

  // ratingSubMenu is a sub menu of Movies for changing the rating of a movie
  static void ratingSubMenu() throws IOException{
    //comment
    int movieIndex;
    do {
      movieIndex = findMovieIndex();
    } while (movieIndex == -1);

    System.out.println("\n\t!! This movies rating is " + movieLibrary.get(movieIndex).getMovieRating());

    float rating;
    do {
      rating = getFloatIn("Please enter the new rating: ");
    } while (!isValidRating(rating));

    movieLibrary.get(movieIndex).setMovieRating(rating);
    System.out.println("Movie {" + movieLibrary.get(movieIndex).getMovieName() + "} rating changed to " + movieLibrary.get(movieIndex).getMovieRating());

    //DONE [90] RATING EDIT - take rating input and validate
    //DONE [91] RATING EDIT - confirm (TITLE, prev Rating, new Rating)
    //TODO [92] GENRE EDIT - copy and adjust for genre
    //TODO [93] Comment your shit man. c'mon seriously its a mess
  }

  // isValidRating used in ratingSubMenu, contains the specifics of rating specifictions
  static Boolean isValidRating(float rating) {
    if ( (0.0 <= rating && rating <= 5.0) && rating % 0.5 == 0) {    // Whole and half numbers can be divided by 0.5 with no remainder
      return true;                                                   // Only whole and half number can be ratings
    }
    else {
      System.out.println("\n # " + rating + " is not a valid rating.");
      System.out.println("\tRATING MUST BE\n\t - Between 0 and 5\n\t - A whole or half number\n\t - e.g. 0,1.5 or 4.0");
      return false;
    }
  }

  // Returns the movie's index in movieLibrary list
  static int findMovieIndex() {
    // SEARCH THEN SET RATING
    int movieIndex;
    do {
      movieIndex = searchFor(getStrIn("Please enter a movie title to edit: "));   // Returns movie index if exits
    } while (movieIndex == -1);

    return movieIndex;
  }

  // genreSubMenu is a sub menu of Movies for changing the rating of a movie
  static void genreSubMenu() {
    // SEARCH THEN SET GENRE
    int movieIndex;
    do {
      movieIndex = findMovieIndex();
    } while (movieIndex == -1);

    System.out.println("\n\t!! This movies genre is " + movieLibrary.get(movieIndex).getMovieGenre());

    String newGenre;
    do {
      printGenres();
      newGenre = getStrIn("Please enter a genre from above: ");
    } while (!isValidGenre(newGenre));

    movieLibrary.get(movieIndex).setMovieGenre(newGenre);
    System.out.println("\n\t!! Movie {" + movieLibrary.get(movieIndex).getMovieName() + "} genre changed to " + movieLibrary.get(movieIndex).getMovieGenre());
  }

  // isValidGenre used in genreSubMenu, contains the specifics of rating specifictions
  static Boolean isValidGenre(String newGenre) {
    String[] genres = {"Action", "Adventure", "Comedy", "Crime", "Fantasy", "Family", "Romance", "Horror", "Drama", "Sci-fi", "Thriller"};
    for (String validGenre : genres) {
      if (Objects.equals(newGenre.toLowerCase(), validGenre.toLowerCase())) {
        return true;
      }
    }
    System.out.println(newGenre + " is not a valid genre. Please make another selection.");
    return false;
  }

  // SHORT DESC
  static void addMovieSubMenu() {
    // change return to Movie_18347500
    System.out.println("IN ADD MOVIE SUB MENU");
    // CREATE AND RETURN MOVIE OBJECT
  }

  // SHORT DESC
  static void saveMenu() {
    System.out.println("IN SAVE MENU");
    // OVERWRITE FLIES WITH DATA IN MEMORY
  }

  // Combined prompt and String input return
  static String getStrIn(String prompt) {
    System.out.print(prompt);
    String output = kb.nextLine();
    return output;
  }

  // Combined prompt and VALIDATED Int input return
  static Integer getIntIn(String prompt) throws IOException{
    //DONE: [30] Get Validated Intger in method

    // Takes string input to validate as Int
    String outStr = "";
    // Keeps asking for input while not a valid Integer
    while (!NumberValidation.isInt(outStr)) {
      outStr = getStrIn(prompt);
      // Only if the loop is going to repeat again does it show an error
      if (!NumberValidation.isInt(outStr)) {
        System.out.println("ERROR: Not a valid integer. Please enter another choice.");
      }
    }
    return Integer.parseInt(outStr);
  }

  // Combined prompt and VALIDATED Float input return
  static Float getFloatIn(String prompt) throws IOException {

    // Takes string input to validate as float
    String outStr = "";
    // keeps asking for input while not a valid float
    while (!NumberValidation.isFloat(outStr)) {
      outStr = getStrIn(prompt);
      // only if the loop is going to repeat again does it show an error
      if (!NumberValidation.isFloat(outStr)) {
        System.out.println("ERROR: Not a valid float number. Please enter another choice.");
      }
    }
    return Float.parseFloat(outStr);
  }

  // displayAllMovies takes any sort of movieLibrary and displays it
  static void displayAllMovies(List<Movie_18347500> inputList) {
    //DONE: [50] Display input array list of Movie objects
    for (Movie_18347500 movie : inputList) {
      System.out.println(movie.getMovieID() + ". " + movie.getMovieName() + " {" + movie.getMovieRating() + "/5} [Released: " + movie.getMovieRelease() + "]");
      System.out.println("\tDURATION: " + movie.getMovieDuration() + " hours\t\tWRITER: " + movie.getMovieWriter());
      System.out.println("\tCLASSIFICATION: " + movie.getMovieClassification() + "\t\tDIRECTOR: " + movie.getMovieDirector());
      System.out.println("\tGENRE: " + movie.getMovieGenre());
      System.out.println("");
    }
  }

  // displayAllPlaylists takes the playlist list and displays it
  static void displayAllPlaylists(List<Playlist_18347500> inputList) {

    for (Playlist_18347500 playlist : inputList) {
      System.out.println("\n" + playlist.getPlaylistID() + ". " + playlist.getPlaylistName() + " ["+ playlist.getPlaylistLength() + " movies] {Total Runtime: " + playlist.getPlaylistDuration() + " hours}");
      for (int playlistMovieID : playlist.getPlaylistMovies()) {          // Loops though playlistMovie IDs
        for (Movie_18347500 libMovie : movieLibrary) {                    // Loops through movieLibrary movies
          if (playlistMovieID == libMovie.getMovieID()) {                 // checks playlistMovieID against movieLibraryID
            System.out.println("\t" + libMovie.getMovieName());                  // prints out movie name
          }
        }
      }
    }
  }

  // Sorts the movie library alphabetically
  static List<Movie_18347500> sortByTitle() {

    //DONE: [60] Move in Sort codes
    // Display movies by title
    List<Movie_18347500> alphaSorted = movieLibrary;                  // Creates a List to manipulate
    Collections.sort(alphaSorted, Movie_18347500.COMPARE_BY_NAME);    // Sorts based on name.
    return alphaSorted;                                               // returns the Movies in order of sort

  }

  // Sorts the movie library alphabetically within an alphabetical genre sort
  static List<Movie_18347500> sortByGenre() {

    //DONE: [61] Move in sort code
    List<Movie_18347500> genreSorted = movieLibrary;
    Collections.sort(genreSorted, Movie_18347500.COMPARE_BY_NAME);          // Sort sort by name first
    Collections.sort(genreSorted, Movie_18347500.COMPARE_BY_GENRE);         // Sorts by genre second so that in a genre movies are alphabetical
    return genreSorted;
  }

  // ROOT MENU OPTIONS PRINT OUT
  static void printRootMenuOptions() {
    System.out.println("");
    System.out.println("## ROOT MENU ##");
    System.out.println("- 1. Movies");
    System.out.println("- 2. Playlists");
    System.out.println("- 3. Save");
    System.out.println("- 4. Exit");
  }

  // MOVIES MENU OPTIONS PRINT OUT
  static void printMoviesMenuOptions() {
    System.out.println("");
    System.out.println("## MOVIES MENU ##");
    System.out.println("- 1. Display Movies");
    System.out.println("- 2. Sort Movies");
    System.out.println("- 3. Change Movie Rating");
    System.out.println("- 4. Change Movie Genre");
    System.out.println("- 5. Add Movie");
    System.out.println("- 6. Go Back");
  }

  // PLAYLISTS MENU OPTIONS PRINT OUT
  static void printPlaylistsMenuOptions() {
    System.out.println("");
    System.out.println("## PLAYLISTS MENU ##");
    System.out.println("- 1. Display Playlists");
    System.out.println("- 2. Create a Playlist");
    System.out.println("- 3. Add Movie to a Playlist");
    System.out.println("- 4. Go Back");
  }

  // SORT MENU OPTIONS PRINT OUT
  static void printSortMenuOptions() {
    System.out.println("");
    System.out.println("## SORT MENU ##");
    System.out.println("- 1. Sort Movies by Title");
    System.out.println("- 2. Sort Movies by Genre");
    System.out.println("- 3. Go Back");
  }

  // AVAILABLE GENRES PRINT OUT
  static void printGenres() {
    System.out.println("");
    System.out.println("Available Genres:");
    System.out.println("\t- Action\t- Adventure\t- Comedy");
    System.out.println("\t- Crime\t\t- Fantasy\t- Family");
    System.out.println("\t- Romance\t- Horror\t- Drama");
    System.out.println("\t- Sci-fi\t- Thriller");
  }

  // All purpose read in next line and split by commas
  static String[] readInLineSplit(Scanner inScanner) {
    //DONE: [40] Read in line from any file
    // All input is seperated by a ',' in files
    String iterLineText = inScanner.nextLine();
    String[] parts = iterLineText.split(",");
    return parts;
  }

  // Creates a file object based of given filename
  static File createFileInst(String fileName, Boolean doValidate) {
    //DONE: [41] Create File Method
    File inFile = new File(fileName);           // Existing filename e.g. Book.txt or directory e.g. Texts/Book.txt
    // Requests new file name if not already
    if (doValidate) {                           // Whether it will repeat until pre-existing file found
      while (!inFile.exists()) {                // FILENAME SEARCH PERSIST
        System.out.println("ERROR: '" + fileName + "' not found!");
        System.out.print("Enter file location: ./");
        inFile = new File(kb.next());
      }
      System.out.println(fileName + " successfully found and imported !");
    }
    else {
      if (!inFile.exists()) {                   // FILENAME SEARCH NO-PERSIST. CREATE BLANK FILE FOR USE
        System.out.println("ERROR: '" + fileName + "' not found!");
        System.out.println("Blank file created. If you have a pre-existing Playlists file please restart the program after renaming it 'playlists.txt'.");
      }
      else {                                    // FILE FOUND ON FIRST TRY WITH NO PERSISTANCE. WELL DONE
        System.out.println(fileName + " successfully found and imported !");
      }
    }

    return inFile;
  }

  // Method created to output a list of lines from movieLibrary.txt. Unique method because Movie and Playlist are different classes
  static List<Movie_18347500> initialiseMovieList() {
    List<Movie_18347500> outputList = new ArrayList<Movie_18347500>();

    File userInputFile = createFileInst("movieLibrary.txt", true);                // Create File Instance based off user input
    Scanner fileScanner = new Scanner(System.in);            //FIXME              // Creating keyboard input first allows try catch for FNF and also 'may not be initialised issue'
    try {
      fileScanner = new Scanner(userInputFile);                                   // Creates scanner instance based off file instance
    } catch (Exception e) {
      System.out.println("FileNotFoundException thrown.");
    }

    while (fileScanner.hasNext()) {
      String[] lineSplit = readInLineSplit(fileScanner);                                 // Get Line split
      Boolean hasRating = true;                                                     // hasRating uses length of array to decide if movie has rating
      if (lineSplit.length != 9) {
        hasRating = false;                                                          // If false, constructor leaves rating as empty
      }
      Movie_18347500 tempMovieObj = new Movie_18347500(lineSplit, hasRating);       // Doesn't have a rating

      outputList.add(tempMovieObj);                                                 // Add object to list
    }

    fileScanner.close();
    return outputList;

  }

  // Fills playlist List with contents of playlist.txt. Unique method because Movie and Playlsit are different classes
  static List<Playlist_18347500> initialisePlaylistList() {
    List<Playlist_18347500> outputList = new ArrayList<Playlist_18347500>();        // OUTPUT list created
    File userInputFile = createFileInst("playlists.txt", false);                    // File created. Dp not persist in finding pre-existing file

    Scanner fileScanner = new Scanner(System.in);                                   // Creating keyboard input first allows try catch for FNF and also 'may not be initialised issue'
    try {
      fileScanner = new Scanner(userInputFile);                                     // Creates a scanner instance based off file instance
    } catch (Exception e) {
      System.out.println("FileNotFoundException thrown.");
    }

    while (fileScanner.hasNext()) {
      String[] lineSplit = readInLineSplit(fileScanner);                                             // Splits the line up by commas
      int playlistID = Integer.parseInt(lineSplit[0]);                                          // Playlist ID
      String playlistName = lineSplit[1];                                                       // Playlist Name
      int playlistLength = Integer.parseInt(lineSplit[2]);                                      // How many movies
      List<Integer> moviesInPlaylist = getPlaylistMovIDs(lineSplit, playlistLength);            // Takes all movie int in a sublist
      float totalDuration = sumMovieDurations(moviesInPlaylist);                  // Created after moviesInPlaylist for obvious reason

      Playlist_18347500 tempPlaylistObj = new Playlist_18347500(
        playlistID,                                                // int playlistID
        playlistName,                                              // String playlistName
        playlistLength,                                            // int length (how many movies)
        totalDuration,                                             // float sum of duration
        moviesInPlaylist                                           // int[] movies in playlist
      );

      outputList.add(tempPlaylistObj);

    }

    return outputList;
  }

  // Searches through movies to add up their durations
  static float sumMovieDurations(List<Integer> moviesInPlaylist) {
    float totalDuration = 0;                        // Running count of movie durations
    for (int playlistMov : moviesInPlaylist) {
      for (Movie_18347500 mov : movieLibrary) {
        if (playlistMov == mov.getMovieID()) {      // Comparing playlistMovieID with IDs form Library
          totalDuration += mov.getMovieDuration();
        }
      }
    }
    return totalDuration;
  }

  // getsPlaylistsMovieIDs from file input after making them ints in a List
  static List<Integer> getPlaylistMovIDs (String[] inStringArray, int playlistLength) {
    List<Integer> outIntList = new ArrayList<Integer>();
    int maxMovieIndex = 3 + playlistLength;
    for (int i = 3; i < maxMovieIndex; i++) {
      outIntList.add(Integer.parseInt(inStringArray[i]));
    }
    return outIntList;
  }

  // Returns movie index in library if search matches name. returns -1 if no match
  static int searchFor(String searchKey) {

    //TODO: [70] Plan out Searching method
    // Objects.equals(A,B); will give value equality boolean
    int outputIndex = -1;
    for (int i = 0; i < movieLibrary.size()-1; i++) {
      if (Objects.equals(searchKey, movieLibrary.get(i).getMovieName())) {
        return i;
      }
    }

    System.out.println("No movies named " + searchKey + " were found. Please change your search term.");
    return outputIndex;
  }

}
