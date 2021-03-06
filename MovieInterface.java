// --== CS400 File Header Information ==--
// Name: Adilnur Istekov
// Email: Istekov@wisc.edu
// Team: CF red
// Role: Data Wrangler
// TA: Xi Chen
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.List;

public interface MovieInterface extends Comparable<MovieInterface>{
  public String getTitle();
  public Integer getYear();
  public List<String> getGenres();
  public String getDirector();
  public String getDescription();
  public Float getAvgVote();
  // from super interface Comparable
  public int compareTo(MovieInterface otherMovie);
}
