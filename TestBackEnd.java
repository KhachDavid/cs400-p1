// --== CS400 File Header Information ==--
// Name: Abhimanyu Dev Gupta
// Email: adgupta2@wisc.edu
// Team: CF red
// Role: Back-End Developer
// TA: Xi Chen
// Lecturer: Florian Heimerl
// Notes to Grader:

public class TestBackEnd {

    public static void main(String[] args) {
        (new TestBackEnd()).runTests();
    }

    public void runTests() {
        // add all tests to this method
        if (this.testInitialNumberOfMovies()) {
            System.out.println("Test initial number of movies: PASSED");
        } else {
            System.out.println("Test initial number of movies: FAILED");
        }
        if (this.testGetAllGenres()) {
            System.out.println("Test get all genres: PASSED");
        } else {
            System.out.println("Test get all genres: FAILED");
        }
        if (this.testGetThreeMoviesInitial()) {
            System.out.println("Test get three movies sorted by rating: PASSED");
        } else {
            System.out.println("Test get three movies sorted by rating: FAILED");
        }
        if (this.testGetAvgRatingsInitial()) {
            System.out.println("Test get average ratings: PASSED");
        } else {
            System.out.println("Test get average ratings: FAILED");
        }
        if (this.testGetGenresInitial()) {
            System.out.println("Test get genres: PASSED");
        } else {
            System.out.println("Test get genres: FAILED");
        }
    }

    public boolean testInitialNumberOfMovies() {
        try {
            // instantiate once BackendInterface is implemented
            BackendInterface backendToTest = null; /* new Backend(new StringReader(
                                        "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,\
avg_vote\n"
                                        + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennif\
er Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hum\
mel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of storie\
s woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
                                        + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Par??, Wilma Elle\
s, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey,\
 Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to c\
ontrol populations.,2.9\n"
                                        + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkingt\
on, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario\
 Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of y\
oung lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                        )); */
            if (backendToTest.getNumberOfMovies() == 0) {
                // test passed
                return true;
            } else {
                // test failed
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // test failed
            return false;
        }
    }


    /**
     * This test instantiates the back end with three movies and tests whether
     * the getAllGenres method return the correct set of genres for those three
     * movies.
     *
     * @return true if the test passed, false if it failed
     */
    public boolean testGetAllGenres() {
        try {
            // instantiate once BackendInterface is implemented
            BackendInterface backendToTest = null; /* new Backend(new StringReader(
                                                      "title,original_title,year,genre,duration,country,language,director,writer,production_com\
pany,actors,description,avg_vote\n"
                                                      + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Je\
nnifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grine\
staff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Gr\
  ace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
    + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"\
  Michael Par??, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clen\
  denen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants \
  to expose how left-wing powers use film to control populations.,2.9\n"
    + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee G\
  oldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Benn\
  et, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Se\
  t to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical a\
  daptation of the 1983 film.\",5.4\n"
    )); */
            if (backendToTest.getAllGenres().size() == 5 && backendToTest.getAllGenres().contains("Horror")
                    && backendToTest.getAllGenres().contains("Action") && backendToTest.getAllGenres().contains("Comedy")
                    && backendToTest.getAllGenres().contains("Musical") && backendToTest.getAllGenres().contains("Romance")) {
                // test passed
                return true;
            } else {
                // test failed
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // test failed
            return false;
        }
    }


    /**
     * This test instantiates the back end with three movies and tests whether the
     * initial list returned by getThreeMovies starting with the first movie (0)
     * is empty. It passes when 0 is returned and fails in all other cases, including
     * when an exception is thrown.
     *
     * @return true if the test passed, false if its failed
     */
    public boolean testGetThreeMoviesInitial() {
        try {
            // instantiate once BackendInterface is implemented
            BackendInterface backendToTest = null; /* new Backend(new StringReader(
                                                      "title,original_title,year,genre,duration,country,language,director,writer,production_com\
pany,actors,description,avg_vote\n"
                                                      + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Je\
nnifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grine\
staff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Gr\
ace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
                                                      + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"\
Michael Par??, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clen\
denen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants \
to expose how left-wing powers use film to control populations.,2.9\n"
                                                      + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee G\
oldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Benn\
et, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Se\
t to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical a\
daptation of the 1983 film.\",5.4\n"
                                                      )); */
            if (backendToTest.getThreeMovies(0).size() == 0) {
                // test passed
                return true;
            } else {
                // test failed
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // test failed
            return false;
        }
    }

    public boolean testGetAvgRatingsInitial() {
        try {
            BackendInterface backendToTest = null;
            if (backendToTest.getAvgRatings().size() == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean testGetGenresInitial() {
        try {
            BackendInterface backendToTest = null;
            if (backendToTest.getGenres().size() == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}