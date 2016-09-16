

public class Movie_18347500 {

    int movieID;             // Unique ID for each movie
    String title;            // Name of movie
    String director;         // Name of director
    String writer;           // Name of writer
    float duration;          // duration in hours e.g. 2.5 hours
    String genre;            // Type of movie
    String classification;   // Classification of movie content
    String releaseDate;      // Date in MONTH YYYY format
    float rating;            // Whole or half numebr for rating, e.g 1,2,4.5,2.5 NOT 1.9, 2.6

    public Movie_18347500 (int idNum, String movieName, String directorName, String writerName, float movieDuration, String movieGenre, String movieClassification, String movieReleaseDate, float movieRating) {
      // Maybe have a check to see if any crucial data is blank?
      movieID = idNum;
      title = movieName;
      director = directorName;
      writer = writerName;
      duration = movieDuration;
      genre = movieGenre;
      classification = movieClassification;
      releaseDate = movieReleaseDate;
      rating = movieRating;
    }

    // TODO1: Movie Getters
    // TODO2: Movie Setters

}
