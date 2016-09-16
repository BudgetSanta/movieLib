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

public class Playlist_18347500 {

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

  // Playlist duration Getter
  public float getPlaylistDuration() {
    return duration;
  }

  // Playlist movie array Getter
  public int[] getPlaylistMovies() {
    return movies;
  }
}
