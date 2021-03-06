// --== CS400 File Header Information ==--
// Name: Abhimanyu Dev Gupta
// Email: adgupta2@wisc.edu
// Team: CF red
// Role: Back-End Developer
// TA: Xi Chen
// Lecturer: Florian Heimerl
// Notes to Grader:

import java.util.List;
import java.util.ArrayList;
import java.util.*;

class MovieObjectTemp<String,Integer,Float> {
  String title;
  Integer year;
  List<String> genres;
  String director;
  String description;
  Float avgVote;

  public MovieObjectTemp (String title, Integer year, List<String> genres, String director, String description, Float avgVote) {
      this.title=title;
      this.year=year;
      this.genres=genres;
      this.director=director;
      this.description=description;
      this.avgVote=avgVote;
  }
}

public class backEndHash {
  public HashTableMap dataBase;
  public HashTableMap dataBase2;

  public backEndHash(List<MovieInterface> movieObjects) {
    dataBase = new HashTableMap();
    dataBase2 = new HashTableMap();

    for (int i=0;i<movieObjects.size();i++) {
      dataBase.put(String.valueOf(movieObjects.get(i).getAvgVote()),movieObjects.get(i));
    }

    for (int i=0;i<movieObjects.size();i++) {
      dataBase2.put(movieObjects.get(i).getGenres().get(0),movieObjects.get(i));
    }
  }
}
