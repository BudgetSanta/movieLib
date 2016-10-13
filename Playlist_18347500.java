/**
 * Student ID: 18347500
 *       Name: Jared Steiner
 *     Campus: Parramatta
 * Tutor Name: Jordan Collier
 *  Class Day: Tuesday
 * Class Time: 9am
 */

/*
TO DO SYNTAX:
(Using '0' instead of 'O' so they don't appear in To Do list)
Current Tasks (List of To Do)
  //T0D0: [[OrderNum][SubOrderNum]] Task Details
In Progress Tasks (Currently working on)
  //N0TE: [[OrderNum][SubOrderNum]] Task Details
Completed Tasks
  //D0NE: [[OrderNum][SubOrderNum]] Task Details [Completion Notes]
*/

import java.util.Arrays;

public class Playlist_18347500 {

  //CONSTANTS
  public static final int INIT_LENGTH = 50;
  public static final int EXPAND_SIZE = 10;

  int playlistID;               // Unique ID for playlist
  String name;                  // Playlist name
  int length;                   // Number of movies in playlist
  float duration;               // Total duration of all movies in playlist
  int[] movies;                 // Array of movie IDs (No movies is one movieID '0')

  public Playlist_18347500 (int idNum, String playlistName, int playlistLength, float playlistDuration, int[] movieArray) {

    playlistID = idNum;
    name = playlistName;
    length = playlistLength;
    duration = playlistDuration;
    movies = movieArray;

  }

  public Playlist_18347500 () {
    playlistID = -1;
    movies = new int[INIT_LENGTH];
    for (int a = 0; a < INIT_LENGTH; a++) {
      movies[a] = -1;
    }
  }

  public Playlist_18347500 (int idNum, String playlistName) {

    playlistID = idNum;
    name = playlistName;
    length = 0;
    duration = 0;
    movies = new int[INIT_LENGTH];
    for (int a = 0; a < INIT_LENGTH; a++) {
      movies[a] = -1;
    }
  }

  // DONE: [11] Playlist Getters

  // ## GETTERS ##
  // TIP: Returns values from object. Check constructors for variable specifics

  // Playlist ID Getter
  public int getPlaylistID() {
    return playlistID;
  }

  // Playlist Name Getter
  public String getPlaylistName() {
    return name;
  }

  // Playlist length Getter
  public int getPlaylistLength() {
    return length;
  }

  // Playlist total available length getter
  public int getPlaylistTotalLength() {
    int count = 0;
    for (int mov : movies) {
      count ++;
    }
    return count;
  }

  // Playlist duration Getter
  public float getPlaylistDuration() {
    return duration;
  }

  // Playlist movie array Getter
  public int[] getPlaylistMovies() {
    return movies;
  }

  // ## MUTATORS ##

  // Add MovieID to a Playlist
  public void addToPlaylist(int movieIndex) {
    int nextFreeIndex = this.getPlaylistLength();  // Length will account for index off by one error
    this.movies[nextFreeIndex] = movieIndex;       // Add Movie
    this.length++;                                 // Update Length
  }

  // Playlist movices Array Expander
  public void expandPlaylist() {
    int originalSize = getPlaylistLength();                             // To reference where to start filling in blank movies later
    movies = Arrays.copyOf(movies, originalSize + EXPAND_SIZE);    // Copy movieLibrary to itself but larger
    for (int i = originalSize; i < originalSize + EXPAND_SIZE; i++) {          // Fill in blanks
      movies[i] = -1;
    }
  }

  // ## SETTERS ##

  // Playlist Duration Setter
  public void setDuration(Float inputDuration) {
    this.duration = inputDuration;
  }
}
