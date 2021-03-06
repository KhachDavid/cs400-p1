// --== CS400 File Header Information ==--
// Name: Adilnur Istekov
// Email: Istekov@wisc.edu
// Team: CF red
// Role: Data Wrangler
// TA: Xi Chen
// Lecturer: Florian Heimerl
// Notes to Grader:

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;
/**
 * class that implements movie data reader and creates movie objects
 * @author Adilnur
 *
 */
public class MovieDataReader implements MovieDataReaderInterface {
  /**
   * method that reads data set from filereader
   * @return List of movie objects
   */
  @Override
  public List<MovieInterface> readDataSet(Reader inputFileReader) throws IOException, DataFormatException {
    //reading file with buffered reader
    BufferedReader csvReader = new BufferedReader(inputFileReader);
    if(csvReader == null) {
      throw new IOException("the file cannot be opened for reading "
              + "or there is some error while reading the file");
    }
		/*Scanner sc = new Scanner(inputFileReader);
		int count = 0;
		while(sc.hasNextLine()) {
	        sc.nextLine();
	        count++;
	      }
		csvReader.skip(0);*/
    //initializing movie atributes
    String row;
    String title = null;
    int year = 0;
    String director = null;
    String description = null;
    float avgvote = 0;
    String[][] d = new String[232][13];

    int i = 0;
    //List of movies
    List<MovieInterface> ms = new ArrayList<MovieInterface>();
    while ((row = csvReader.readLine()) != null) {
      List<String> genres = new ArrayList<String>();
      //skip the first line
      if(i == 0) {
        i++;
        continue;
      }
      //split the row using regex string into array data unless in quotes
      String[] data = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
      d[i] = data;
      if(data.length != 13) {
        throw new DataFormatException("there is an error because the file does not have the correct format");
      }

      //System.out.println(data[0]);
      title = d[i][0];
      year = Integer.parseInt(d[i][2]);
      director = d[i][7];
      String[] g = d[i][3].replaceAll("\"", "").replaceAll(" ", "").split(",");

      //add every genre from g to list of genres
      for(int u = 0; u<g.length;u++) {
        genres.add(g[u]);
      }
      description = d[i][11];
      avgvote = Float.parseFloat(d[i][12]);
      //creating movie object
      Movie m = new Movie(title, year, genres, director, description, avgvote);
      //adding it to the list
      ms.add(m);
      i++;
    }
    csvReader.close();
    return ms;
  }

}
