// --== CS400 File Header Information ==--
// Name: Adilnur Istekov
// Email: Istekov@wisc.edu
// Team: CF red
// Role: Data Wrangler
// TA: Xi Chen
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
/**
 * this class implements movie object
 * @author Adilnur
 *
 */
public class Movie implements MovieInterface{
  private String title;
  private int year;
  private List<String> genres;
  private String director;
  private String description;
  private float avgvote;
  /**
   * constructor that takes 6 variables and stores them
   * @param title of the movie
   * @param year of the movie
   * @param genres of the movie
   * @param director of the movie
   * @param description of the movie
   * @param avgvote of the movie
   */
  public Movie(String title, int year, List<String> genres, String director, String description, float avgvote) {
    this.title = title;
    this.year = year;
    this.genres = genres;
    this.director = director;
    this.description = description;
    this.avgvote = avgvote;
  }
  /**
   * accessor method for title
   * @return title of the movie
   */
  @Override
  public String getTitle() {
    return this.title;
  }
  /**
   * accessor method for year
   * @return year of the movie
   */
  @Override
  public Integer getYear() {
    // TODO Auto-generated method stub
    return this.year;
  }
  /**
   * accessor method for genres
   * @return genres of the movie
   */
  @Override
  public List<String> getGenres() {

    return this.genres;
  }
  /**
   * accessor method for director
   * @return director of the movie
   */
  @Override
  public String getDirector() {
    this.director = this.director.replaceAll("\"", "");
    return this.director;
  }
  /**
   * accessor method for description
   * @return description of the movie
   */
  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return this.description;
  }
  /**
   * accessor method for average vote
   * @return average vote of the movie
   */
  @Override
  public Float getAvgVote() {
    // TODO Auto-generated method stub
    return this.avgvote;
  }
  /**
   * method that compares movie by comparing their average vote
   * @return -1 if this movie's average vote is higher that otherMovie's
   * 			1 if this movie's average vote is lower that otherMovie's and
   * 			0 if they are equal
   *
   */
  @Override
  public int compareTo(MovieInterface otherMovie) {
    if(this.avgvote>otherMovie.getAvgVote()) {
      return -1;
    }
    else if(this.avgvote<otherMovie.getAvgVote()) {
      return 1;
    }
    else {
      return 0;
    }

  }
  /**
   * method that returns string version of all private fields
   * @return String that contains a structured version of the movie with the attributes
   */
  @Override
  public String toString() {
    String s = "Title: "+this.title+"\n"+"Year: "+this.year+"\n"+"Genres: ";
    for(int i = 0;i<this.genres.size();i++) {
      if(i==this.genres.size()-1) {
        s += this.genres.get(i);
        break;
      }
      s += this.genres.get(i)+", ";
    }
    s+= "\n"+"Director: "+this.director+"\n" + "Description: "+this.description + "\n"+ "Average vote: "+this.avgvote;
    return s;
  }

}
