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
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

public class LibraryManager_18347500 {

  // Global Keyboard Instance
  public static Scanner kb = new Scanner(System.in);
  public static Boolean globalDebug = true;

  public static void main(String[] args) throws IOException{

    System.out.println("\n ---- IMPORTING PROGRAM FILES ---- ");
    List<Movie_18347500> movieLibrary = initialiseMovieList();                    // Initialises Movie Library to List
    List<Playlist_18347500> playlists = initialisePlaylistList(movieLibrary);     // Initialises Playlists to List
    //DONE: [42] Get ArrayList for Playlists working because playlists.txt doesn't have to exist

    rootMenu(movieLibrary, playlists);

    kb.close();
  }

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
            inMoviesMenu = moviesMenu(inMoviesMenu, inSortSubMenu, movieLibrary);
          } while (inMoviesMenu);
          break;

        // PLAYLISTS MENU
        case 2:
          // Loop through playlists menu till false flag
          inPlaylistsMenu = true;
          do {
            inPlaylistsMenu = playlistsMenu(inPlaylistsMenu, playlists, movieLibrary);
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

  // moviesMenu is the sub menu of ROOT
  static Boolean moviesMenu(Boolean inMoviesMenu, Boolean inSortSubMenu, List<Movie_18347500> movieLibrary) throws IOException{

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
          inSortSubMenu = sortSubMenu(inSortSubMenu, movieLibrary);
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

  // playlistsMenu is a sub menu of ROOT
  static Boolean playlistsMenu(Boolean inPlaylistsMenu, List<Playlist_18347500> playlists, List<Movie_18347500> movieLibrary) throws IOException{

    // Print out menu options and takes input
    printPlaylistsMenuOptions();
    int inputChoice = getIntIn("Enter Menu Choice: ");

    switch (inputChoice) {

      // DISPLAY
      case 1:
        // Display Playlists
        displayAllPlaylists(playlists, movieLibrary);
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

  // sortSubMenu is a sub menu of Movies
  static Boolean sortSubMenu(Boolean inSortSubMenu, List<Movie_18347500> movieLibrary) throws IOException{

    // print menu options and take input
    printSortMenuOptions();
    int inputChoice = getIntIn("Enter Sort by choice: ");

    switch (inputChoice) {

      // TITLE
      case 1:
        // Display movies by title
        displayAllMovies(sortByTitle(movieLibrary));                            // Displays the Movies based in order of title sort
        break;

      // GENRE
      case 2:
        // Display movies by genre
        displayAllMovies(sortByGenre(movieLibrary));
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

  // SHORT DESC
  static void ratingSubMenu() {
    System.out.println("IN RATING SUB MENU");
    // SEARCH THEN SET RATING
  }

  // SHORT DESC
  static void genreSubMenu() {
    System.out.println("IN GENRE SUB MENU");
    // SEARCH THEN SET GENRE
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
    String output = kb.next();
    return output;
  }

  // Combined prompt and VALIDATED Int input return
  static Integer getIntIn(String prompt) throws IOException{
    //DONE: [30] Get Validated Intger in method

    // Takes string input to validate as Int
    String outStr = "";
    // Keeps asking for input while not a valid Integer
    while (!IntegerValidation.isInt(outStr)) {
      outStr = getStrIn(prompt);
      // Only if the loop is going to repeat again does it show an error
      if (!IntegerValidation.isInt(outStr)) {
        System.out.println("ERROR: Not a Number. Please enter another choice.");
      }
    }
    return Integer.parseInt(outStr);
  }

  // Used for normal Display and Sorted display
  static void displayAllMovies(List<Movie_18347500> movieLibrary) {
    //DONE: [50] Display input array list of Movie objects
    for (Movie_18347500 movie : movieLibrary) {
      System.out.println(movie.getMovieID() + ". " + movie.getMovieName() + " {" + movie.getMovieRating() + "/5} [Released: " + movie.getMovieRelease() + "]");
      System.out.println("\tDURATION: " + movie.getMovieDuration() + " hours\t\tWRITER: " + movie.getMovieWriter());
      System.out.println("\tCLASSIFICATION: " + movie.getMovieClassification() + "\t\tDIRECTOR: " + movie.getMovieDirector());
      System.out.println("\tGENRE: " + movie.getMovieGenre());
      System.out.println("");
    }
  }

  static void displayAllPlaylists(List<Playlist_18347500> playlists, List<Movie_18347500> movieLibrary) {

    for (Playlist_18347500 playlist : playlists) {
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
  static List<Movie_18347500> sortByTitle(List<Movie_18347500> movieLibrary) {

    //DONE: [60] Move in Sort codes
    // Display movies by title
    List<Movie_18347500> alphaSorted = movieLibrary;                  // Creates a List to manipulate
    Collections.sort(alphaSorted, Movie_18347500.COMPARE_BY_NAME);    // Sorts based on name.
    return alphaSorted;                                               // returns the Movies in order of sort

  }

  // Sorts the movie library alphabetically within an alphabetical genre sort
  static List<Movie_18347500> sortByGenre(List<Movie_18347500> movieLibrary) {

    //DONE: [61] Move in sort code
    List<Movie_18347500> genreSorted = movieLibrary;
    Collections.sort(genreSorted, Movie_18347500.COMPARE_BY_NAME);          // Sort sort by name first
    Collections.sort(genreSorted, Movie_18347500.COMPARE_BY_GENRE);         // Sorts by genre second so that in a genre movies are alphabetical
    return genreSorted;
  }

  //
  static void searchFor() {

    //TODO: [70] Plan out Searching method

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
    System.out.println("- 3. Add/Change Movie Rating");
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

  // READ IN LINE ALL PURPOSE
  /*
  * Expected, File created outside of method
  *           Scanner created outside when file read in needed
  *           readInLine used in a loop to retrieve lines
  *           # This way it can be used for both playlist and movie files
  */
  static String[] readInLine(Scanner inScanner) {
    //DONE: [40] Read in line from any file
    // All input is seperated by a ',' in files
    String iterLineText = inScanner.nextLine();
    String[] parts = iterLineText.split(",");
    return parts;
  }

  // Creates a file object based of default name
  static File createFileInst(String fileName, Boolean doValidate) {
    //DONE: [41] Create File Method
    File inFile = new File(fileName);           // Existing filename e.g. Book.txt or directory e.g. Texts/Book.txt
    // Requests new file name if not already
    if (doValidate) {                           // Whether it will repeat until pre-existing file found
      while (!inFile.exists()) {
        System.out.println("ERROR: '" + fileName + "' not found!");
        System.out.print("Enter file location: ./");
        inFile = new File(kb.next());
      }
      System.out.println(fileName + " successfully found and imported !");
    }
    else {                                      // Do not persist in finding file. create blank
      if (!inFile.exists()) {
        System.out.println("ERROR: '" + fileName + "' not found!");
        System.out.println("Blank file created. If you have a pre-existing Playlists file please restart the program after renaming it 'playlists.txt'.");
      }
      else {
        System.out.println(fileName + " successfully found and imported !");
      }
    }

    return inFile;
  }

  // Method cread to output a list of lines from movieLibrary. Unique method because Movie and Playlist are different classes
  static List<Movie_18347500> initialiseMovieList() throws IOException{
    List<Movie_18347500> outputList = new ArrayList<Movie_18347500>();

    File userInputFile = createFileInst("movieLibrary.txt", true);              // Create File Instance based off user input
    Scanner fileScanner = new Scanner(userInputFile);                           // Creates scanner instance ased off file instance

    while (fileScanner.hasNext()) {
      String[] lineSplit = readInLine(fileScanner);                                 // Get Line split
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

  static List<Playlist_18347500> initialisePlaylistList(List<Movie_18347500> movieLibrary) throws IOException{
    List<Playlist_18347500> outputList = new ArrayList<Playlist_18347500>();        // OUTPUT list created
    File userInputFile = createFileInst("playlists.txt", false);                    // File created. Dp not persist in finding pre-existing file
    Scanner fileScanner = new Scanner(userInputFile);                               // File scanner created

    while (fileScanner.hasNext()) {
      String[] lineSplit = readInLine(fileScanner);                                             // Splits the line up by commas
      int playlistID = Integer.parseInt(lineSplit[0]);                                          // Playlist ID
      String playlistName = lineSplit[1];                                                       // Playlist Name
      int playlistLength = Integer.parseInt(lineSplit[2]);                                      // How many movies
      List<Integer> moviesInPlaylist = getPlaylistMovIDs(lineSplit, playlistLength);  // Takes all movie int in a sublist
      float totalDuration = sumMovieDurations(movieLibrary, moviesInPlaylist);                  // Created after moviesInPlaylist for obvious reason

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

  static float sumMovieDurations(List<Movie_18347500> movieLibrary, List<Integer> moviesInPlaylist) {
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

  // Takes in Stringp[] and playlistLength to avoid .subList errors. loops through parsing to output List<Integer>
  static List<Integer> getPlaylistMovIDs (String[] inStringArray, int playlistLength) {
    List<Integer> outIntList = new ArrayList<Integer>();
    int maxMovieIndex = 3 + playlistLength;
    for (int i = 3; i < maxMovieIndex; i++) {
      outIntList.add(Integer.parseInt(inStringArray[i]));
    }
    return outIntList;
  }

  static void printlnDebug(String message) {
    if (globalDebug) {System.out.println(message);}
  }

}
