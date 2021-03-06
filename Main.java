// --== CS400 File Header Information ==--
// Name: Zhiyuang Han
// Email: zhan98@wisc.edu
// Team: CF red
// Role: Front-End Developer
// TA: Xi Chen
// Lecturer: Florian Heimerl
// Notes to Grader:

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public class Main {
    public static final Dimension SCREEN = new Dimension(900, 800);

    public static void main(String[] args) throws IOException, DataFormatException {
        //csv data loading
        //String filePath = args[0];
        String filePath = "movies.csv";
        MovieDataReader m = new MovieDataReader();
        FileReader f = new FileReader(filePath);
        List<MovieInterface> movieObjects = m.readDataSet(f);
        Map<String ,Movie> map = new HashMap<>();

        for (int i = 0; i < movieObjects.size(); i++) {
            Movie toAdd = (Movie) movieObjects.get(i);
            map.put(toAdd.getTitle(), toAdd);
        }
        //Generate new Map

        new MovieMapper(map);
    }
}
