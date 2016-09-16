

public class Playlist_18347500 {

  int playlistId;               // Unique ID for playlist
  String name;                  // Playlist name
  int length;                   // Number of movies in playlist
  float duration;               // Total duration of all movies in playlist
  int[] movies;                 // Array of movie IDs (No movies is one movieID '0')

  public Playlist_18347500 (int idNum, String playlistName, int playlistLength, float playlistDuration, int[] movieArray) {

    playlistId = idNum;
    name = playlistName;
    length = playlistLength;
    duration = playlistDuration;
    movies = movieArray;

  }

  // TODO1: Playlist Getters
}
