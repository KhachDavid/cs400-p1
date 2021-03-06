// --== CS400 File Header Information ==--
// Name: Abhimanyu Dev Gupta
// Email: adgupta2@wisc.edu
// Team: CF red
// Role: Back-End Developer
// TA: Xi Chen
// Lecturer: Florian Heimerl
// Notes to Grader:

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.zip.DataFormatException;

public class backInterface implements BackendInterface{
  public List<String> ratingFilters = new ArrayList<String>();
  public List<String> genreFilters = new ArrayList<String>();
  public List<MovieInterface> movieObjects;
  public MovieDataReader m;
  public backEndHash data;

  public backInterface(String path) throws IOException, DataFormatException {
    MovieDataReader m = new MovieDataReader();
    FileReader f = new FileReader(path);
    List<MovieInterface> movieObjects = m.readDataSet(f);
    backEndHash data = new backEndHash(movieObjects);
  }

  @Override public void addGenre(String genre) {
    genreFilters.add(genre);
  }

  @Override public void removeGenre(String genre) {
    genreFilters.remove(genre);
  }

  @Override public List<String> getGenres() {
    return genreFilters;
  }

  @Override public void addAvgRating(String rating) {
    ratingFilters.add(rating);
  }

  @Override public void removeAvgRating(String rating) {
    ratingFilters.remove(rating);
  }

  @Override public List<String> getAvgRatings() {
    return ratingFilters;
  }

  @Override public int getNumberOfMovies() {
    return movieObjects.size();
  }

  @Override public List<String> getAllGenres() {
    Set<String> set = new HashSet<String>();
    for (int i=0;i<movieObjects.size();i++) {
      for (int j=0;j<movieObjects.get(i).getGenres().size();j++) {
        set.add(movieObjects.get(i).getGenres().get(j));
      }
    }
    return (List<String>) set;
  }

  @Override public List<MovieInterface> getThreeMovies(int startingIndex) {
    List<MovieInterface> tempMovies = movieObjects;
    List<MovieInterface> returnThree = new ArrayList<MovieInterface>();
    Collections.sort(tempMovies, (o1, o2) -> (o1.getAvgVote().compareTo(o2.getAvgVote())));
    try {
      for (int i=startingIndex;i<startingIndex+3;i++) {
        returnThree.add(tempMovies.get(i));
      }
    } catch (Exception e) {
    }
    return returnThree;
  }

  public List<Movie> filterRatingsMovies() {
    List<Movie> temp = new ArrayList<Movie>();

    for (int i=0;i<ratingFilters.size();i++) {
      try{
        temp = data.dataBase.get(ratingFilters.get(i));
      }
      catch (Exception e) {

      }
    }
    return temp;
  }

  public List<Movie> filterGenreMovies() {
    List<Movie> temp = new ArrayList<Movie>();

    for (int i=0;i<genreFilters.size();i++) {
        temp = data.dataBase2.get(genreFilters.get(i));
    }
    return temp;
  }
}


