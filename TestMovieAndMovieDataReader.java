// --== CS400 File Header Information ==--
// Name: Adilnur Istekov
// Email: Istekov@wisc.edu
// Team: CF red
// Role: Data Wrangler
// TA: Xi Chen
// Lecturer: Florian Heimerl
// Notes to Grader:

import java.io.StringReader;
import java.util.Collections;
import java.util.List;
/**
 * This class contains a set of tests for the MovieInterface and MovieDataReaderInterface
 * implementation of the Movie Mapper project.
 */
public class TestMovieAndMovieDataReader {
        MovieDataReaderInterface readerToTest;
        public static void main(String[] args) {
                (new TestMovieAndMovieDataReader()).runTests();
        }
        /**
         * This method calls all of the test methods in the class and ouputs pass / fail
         * for each test.
         */
        public void runTests() {
                // instantiate reader to test once it is implemented
                readerToTest = new MovieDataReader();
                // add all tests to this method
                if (this.testReaderNumberOfMovies()) {
                        System.out.println("Test number of movies: PASSED");
                } else {
                        System.out.println("Test number of movies: FAILED");
                }
                if (this.testReaderMovieTitles()) {
                        System.out.println("Test movie titles: PASSED");
                } else {
                        System.out.println("Test movie titles: FAILED");
                }
                if (this.testMovieOrder()) {
                        System.out.println("Test movie order: PASSED");
                } else {
                        System.out.println("Test movie order: FAILED");
                }
                if (this.testGetGenres()) {
                	System.out.println("Test get genres: PASSED");
                } else{
                        System.out.println("Test get genres: FAILED");
                }
                if (this.testGetDirector()) {
                        System.out.println("Test get director: PASSED");
                } else{
                        System.out.println("Test get director: FAILED");
                }
        }
        /**
         * This test reads in 3 movies and tests whether the list of movies
         * returned is of size 3. It fails if the size is not 3 or if an
         * exception occurs while reading in the movies.
         * @return true if the test passed, false if it failed
         */
        public boolean testReaderNumberOfMovies() {
                List<MovieInterface> movieList;
                try {
                        movieList = readerToTest.readDataSet(new StringReader(
                                        "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"+
                                        "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior,"+ 
"Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley,"+ 
"Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our mo"+
"st primal fears, the fear of the unknown.\",3.5\n"
                                        + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph C"+
"amilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael"+
 "Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"+
                                         "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew "+"Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel,"+
                                        "Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgr"+
                                        "ounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                        		));
                } catch (Exception e) {
                        e.printStackTrace();
                        // test failed
                        return false;
                }
                String director1 = "Ryan Bury, Jennifer Bonior";
                String director2 = "Rene Perez";
                String director3 = "Rachel Lee Goldenberg";
                boolean equalOne = true;
                // check if first movie is has of the above directors
                equalOne = equalOne && (director1.equals(movieList.get(0).getDirector()) ||
                                                                director2.equals(movieList.get(0).getDirector()) ||
                                                                director3.equals(movieList.get(0).getDirector()));
                //System.out.println(movieList.get(0).getDirector());
                
                // check if second movie is has of the above directors
                equalOne = equalOne && (director1.equals(movieList.get(1).getDirector()) ||
                                                                director2.equals(movieList.get(1).getDirector()) ||
                                                                director3.equals(movieList.get(1).getDirector()));
                // check if third movie is has of the above directors
                equalOne = equalOne && (director1.equals(movieList.get(2).getDirector()) ||
                                                                director2.equals(movieList.get(2).getDirector()) ||
                                                                director3.equals(movieList.get(2).getDirector()));
                // true if the three movies have the right directors
                //System.out.println(movieList.get(2).getDirector());
                return equalOne;
        }
        /**
         * This test reads in 3 movies and tests whether the list of movies
         * contains all 3 titles of the source data in any order. It fails
         * if the list returned is missing one or more titles or if an
         * exception occurs while reading in the data.
         * @return true if the test passed, false if it failed
         */
        public boolean testReaderMovieTitles() {
                List<MovieInterface> movieList;
                try {
                        movieList = readerToTest.readDataSet(new StringReader(
                                        "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"+
                                         "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, "+
"Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, "+
"Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our mo"+
"st primal fears, the fear of the unknown.\",3.5\n"+
                                         "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph C"+
"amilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael"+
 "Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"+
                                        "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew "+
"Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel,"+
 "Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgr"+
"ounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                        ));
                } catch (Exception e) {
                    e.printStackTrace();
                    // test failed
                    return false;
            }
            String title1 = "The Source of Shadows";
            String title2 = "The Insurrection";
            String title3 = "Valley Girl";
            boolean equalOne = true;
            // check if first movie is has of the above titles
            equalOne = equalOne && (title1.equals(movieList.get(0).getTitle()) ||
                                                            title2.equals(movieList.get(0).getTitle()) ||
                                                            title3.equals(movieList.get(0).getTitle()));
            // check if second movie is has of the above titles
            equalOne = equalOne && (title1.equals(movieList.get(1).getTitle()) ||
                                                            title2.equals(movieList.get(1).getTitle()) ||
                                                            title3.equals(movieList.get(1).getTitle()));
            // check if third movie is has of the above titles
            equalOne = equalOne && (title1.equals(movieList.get(2).getTitle()) ||
                                                            title2.equals(movieList.get(2).getTitle()) ||
                                                            title3.equals(movieList.get(2).getTitle()));
            // true if the three movies have the right titles
            return equalOne;
    }

        /**
         * This test reads in 3 movies, then sorts them. It then checks whether
         * the default sorting order is descending based on the average ratings.
         * @return true if the test passed, false if it failed
         */
        public boolean testMovieOrder() {
                List<MovieInterface> movieList;
                try {
                        movieList = readerToTest.readDataSet(new StringReader(
                                        "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"+
                                         "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, "+
"Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, "+
"Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our mo"+
"st primal fears, the fear of the unknown.\",3.5\n"+
                                         "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph C"+
"amilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael"+
 "Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"+
                                         "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew "+
"Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel,"+
 "Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgr"+
"ounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                        ));
                } catch (Exception e) {
                        e.printStackTrace();
                        // test failed
                        return false;
                }
                Collections.sort(movieList);
                double lastRating = 11.0;
                for (MovieInterface movie : movieList) {
                        if (movie.getAvgVote() > lastRating) {
                                // test fails
                                return false;
                        }
                        lastRating = movie.getAvgVote();
                }
                // test passes
                return true;
        }
     // TODO: Data Wrangler, add at least 2 more tests
        /**
         * This test checks if getGenres returns correct genres of the movie.
         * @return true if the test passed, false if it failed
         */
        public boolean testGetGenres(){
                List<MovieInterface> movieList;
                try {
                        movieList = readerToTest.readDataSet(new StringReader(
                                        "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"+
                                        "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, "+
"Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, "+
"Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our mo"+
"st primal fears, the fear of the unknown.\",3.5\n"+
                                        "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph C"+
"amilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael"+
 "Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"+
                                         "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew"+ 
"Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel,"+
 "Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgr"+
"ounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                        ));
                } catch (Exception e) {
                        e.printStackTrace();
                        // test failed
                        return false;
                }
                //List<String> list1 = new ArrayList<String>();
                String genre1 = "Horror";
                //list1.add(genre1);
                //List<String> list2 = new ArrayList<String>();
                String genre2 = "Action";
                //list2.add(genre2);
                //List<String> list3 = new ArrayList<String>();
                String genre31 = "Comedy";
                String genre32 = "Musical";
                String genre33 = "Romance";
                //list3.add(genre31);
                //list3.add(genre32);
                //list3.add(genre33);    
                boolean equalOne = true;
                // check if first movie is has of the above genres
                equalOne = equalOne && (genre1.equals(movieList.get(0).getGenres().get(0)) ||
                                                                genre2.equals(movieList.get(0).getGenres().get(0)) ||
                                                                genre31.equals(movieList.get(0).getGenres().get(0)));
                // check if second movie is has of the above titles
                equalOne = equalOne && (genre1.equals(movieList.get(1).getGenres().get(0)) ||
                                                                genre2.equals(movieList.get(1).getGenres().get(0)) ||
                                                                genre31.equals(movieList.get(1).getGenres().get(0)));
                // check if third movie is has of the above titles
                equalOne = equalOne && (genre1.equals(movieList.get(2).getGenres().get(0)) ||
                                                                genre2.equals(movieList.get(2).getGenres().get(0)) ||
                                                                (genre31.equals(movieList.get(2).getGenres().get(0)) &&
                                                                genre32.equals(movieList.get(2).getGenres().get(1)) &&
                                                                genre33.equals(movieList.get(2).getGenres().get(2))));
                //System.out.println(movieList.get(2).getGenres().get(0));
                //System.out.println(movieList.get(2).getGenres().get(1));
                //System.out.println(movieList.get(2).getGenres().get(2));
                // true if the three movies have the right titles
                return equalOne;
        }
        /**
         * This test checks if getDirector method returns the correct director for the movies.
         * @return true if the test passed, false if it failed
         */
        public boolean testGetDirector(){
                List<MovieInterface> movieList;
                try {
                        movieList = readerToTest.readDataSet(new StringReader(
                                        "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"+
                                        "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, "+
"Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, "+
"Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our mo"+
"st primal fears, the fear of the unknown.\",3.5\n"
		+ "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph C"+
		"amilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael"+
		 "Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"+
		                                        "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew "+
		"Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel,"+
		 "Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgr"+
		"ounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
		                        ));
		                } catch (Exception e) {
		                        e.printStackTrace();
		                        // test failed
		                        return false;
		                }
		                String director1 = "Ryan Bury, Jennifer Bonior";
		                String director2 = "Rene Perez";
		                String director3 = "Rachel Lee Goldenberg";
		                boolean equalOne = true;
		                // check if first movie is has of the above directors
		                equalOne = equalOne && (director1.equals(movieList.get(0).getDirector()) ||
		                                                                director2.equals(movieList.get(0).getDirector()) ||
		                                                                director3.equals(movieList.get(0).getDirector()));
		                // check if second movie is has of the above directors
		                equalOne = equalOne && (director1.equals(movieList.get(1).getDirector()) ||
		                                                                director2.equals(movieList.get(1).getDirector()) ||
		                                                                director3.equals(movieList.get(1).getDirector()));
		                // check if third movie is has of the above directors
		                equalOne = equalOne && (director1.equals(movieList.get(2).getDirector()) ||
		                                                                director2.equals(movieList.get(2).getDirector()) ||
		                                                                director3.equals(movieList.get(2).getDirector()));
		                // true if the three movies have the right directors
		                return equalOne;
		        }
                }