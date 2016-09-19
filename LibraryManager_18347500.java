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

public class LibraryManager_18347500 {

  // Global Keyboard Instance
  public static Scanner kb = new Scanner(System.in);

  public static void main(String[] args) throws IOException{

    ArrayList<Movie_18347500> movieLibrary = initialiseMovieArrayList("movieLibrary.txt");        // Initialises Movie Library to Array List
    //TODO: [42] Get ArrayList for Playlists working because playlists.txt doesn't have to exist

    rootMenu(movieLibrary);

    kb.close();
  }

  static void rootMenu(ArrayList<Movie_18347500> movieLibrary) throws IOException{

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

  // moviesMenu is the sub menu of ROOT
  static Boolean moviesMenu(Boolean inMoviesMenu, Boolean inSortSubMenu, ArrayList<Movie_18347500> movieLibrary) throws IOException{

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

  // playlistsMenu is a sub menu of ROOT
  static Boolean playlistsMenu(Boolean inPlaylistsMenu) throws IOException{

    // Print out menu options and takes input
    printPlaylistsMenuOptions();
    int inputChoice = getIntIn("Enter Menu Choice: ");

    switch (inputChoice) {

      // DISPLAY
      case 1:
        // Display Playlists
        System.out.println("IN DISPLAY OPTION");
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
  static Boolean sortSubMenu(Boolean inSortSubMenu) throws IOException{

    // print menu options and take input
    printSortMenuOptions();
    int inputChoice = getIntIn("Enter Sort by choice: ");

    switch (inputChoice) {

      // TITLE
      case 1:
        // Display movies by title
        System.out.println("IN SORT BY TITLE OPTION");
        break;

      // GENRE
      case 2:
        // Display movies by genre
        System.out.println("IN SORT BY GENRE OPTION");
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
  static void displayAllMovies(ArrayList<Movie_18347500> movieLibrary) {
    //TODO: [50] Display input array list of Movie objects
    for (Movie_18347500 movie : movieLibrary) {
      System.out.println(movie.getMovieID() + ". " + movie.getMovieName() + " {" + movie.getMovieRating() + "/5} [Released: " + movie.getMovieRelease() + "]");
      System.out.println("\tDURATION: " + movie.getMovieDuration() + " hours\t\tWRITER: " + movie.getMovieWriter());
      System.out.println("\tCLASSIFICATION: " + movie.getMovieClassification() + "\t\tDIRECTOR: " + movie.getMovieDirector());
      System.out.println("\tGENRE: " + movie.getMovieGenre());
      System.out.println("");
    }
  }

  static void sortBy() {

    //TODO: [60] Plan out Sorting method

  }

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
  static File createFileInst(String fileName) {
    //DONE: [41] Create File Method
    File inFile = new File(fileName);           // Existing filename e.g. Book.txt or directory e.g. Texts/Book.txt
    // Requests new file name if not already
    while (!inFile.exists()) {
      System.out.println("ERROR: '" + fileName + "' not found!");
      System.out.print("Enter file location: ./");
      inFile = new File(kb.next());
    }

    return inFile;
  }

  static ArrayList<Movie_18347500> initialiseMovieArrayList(String fileName) throws IOException{
    ArrayList<Movie_18347500> outputList = new ArrayList<Movie_18347500>();

    File userInputFile = createFileInst(fileName);              // Create File Instance based off user input
    Scanner fileScanner = new Scanner(userInputFile);           // Creates scanner instance ased off file instance

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

}
