// --== CS400 File Header Information ==--
// Name: Adilnur Istekov
// Email: Istekov@wisc.edu
// Team: CF red
// Role: Data Wrangler
// TA: Xi Chen
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public interface MovieDataReaderInterface {
  public List<MovieInterface> readDataSet(Reader inputFileReader) throws IOException, DataFormatException;
}
