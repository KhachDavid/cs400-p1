// --== CS400 File Header Information ==--
// Author: CS400 Course Staff
// Email: heimerl@cs.wisc.edu / dahl@cs.wisc.edu
// Notes: This dummy class is part of the starter archive for Project One
//        in spring 2021. You can extend it to work on your Project One Final
//        App.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

public class MovieDataReaderDummy implements MovieDataReaderInterface {
    /**
     * Method that reades movie data in CSV format from the Redaer provided. The
     * dummy implementations will always return the same 3 sets of movies.
     */
    @Override
    public List<MovieInterface> readDataSet(Reader inputFileReader) throws FileNotFoundException, IOException {
        ArrayList<MovieInterface> movies = new ArrayList<MovieInterface>();
        movies.add(new MovieInterface() {
            @Override
            public String getTitle() {
                return "Plan 9 from Outer Spacce";
            }

            @Override
            public Integer getYear() {
                return 1959;
            }

            @Override
            public List<String> getGenres() {
                return Arrays.asList(new String[] { "Action", "Comedy" });
            }

            @Override
            public String getDirector() {
                return "Ed Wood";
            }

            @Override
            public String getDescription() {
                return "Residents of California's San Fernando Valley are under attack by flying saucers from outer space.";
            }

            @Override
            public Float getAvgVote() {
                return 5.3f;
            }

            @Override
            public int compareTo(MovieInterface otherMovie) {
                if (this.getTitle().equals(otherMovie.getTitle())) {
                    return 0;
                    // sort by rating
                } else if (this.getAvgVote() < otherMovie.getAvgVote()) {
                    return +1;
                } else {
                    return -1;
                }
            }
        });
        // TODO: Fixme! Add two more example movies to the list before returning it
        // (could be
        // ficticious ones)
        // .
        movies.add(new MovieInterface() {

            @Override
            public String getTitle() {
                return "Faster than light";
            }

            @Override
            public Integer getYear() {
                return 2015;
            }

            @Override
            public List<String> getGenres() {
                return Arrays.asList(new String[] { "Action", "Comedy" });
            }

            @Override
            public String getDirector() {
                return "Naruto Uzumaki";
            }

            @Override
            public String getDescription() {
                return "The story about person who was able to move faster than light";
            }

            @Override
            public Float getAvgVote() {
                return 8.1f;
            }

            @Override
            public int compareTo(MovieInterface otherMovie) {
                if (this.getTitle().equals(otherMovie.getTitle())) {
                    return 0;
                    // sort by rating
                } else if (this.getAvgVote() < otherMovie.getAvgVote()) {
                    return +1;
                } else {
                    return -1;
                }
            }
        });
        movies.add(new MovieInterface() {
            @Override
            public String getTitle() {
                return "We like animals";
            }

            @Override
            public Integer getYear() {
                return 2013;
            }

            @Override
            public List<String> getGenres() {
                return Arrays.asList(new String[] { "Romance", "Comedy" });
            }

            @Override
            public String getDirector() {
                return "Light Yagami";
            }

            @Override
            public String getDescription() {
                return "People from different countries gathered to discuss how they like animals";
            }

            @Override
            public Float getAvgVote() {
                return 1.9f;
            }

            @Override
            public int compareTo(MovieInterface otherMovie) {
                if (this.getTitle().equals(otherMovie.getTitle())) {
                    return 0;
                    // sort by rating
                } else if (this.getAvgVote() < otherMovie.getAvgVote()) {
                    return +1;
                } else {
                    return -1;
                }
            }
        });
        return movies;
    }
}

