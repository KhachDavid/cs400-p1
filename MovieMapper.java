// --== CS400 File Header Information ==--
// Name: Zhiyuang Han
// Email: zhan98@wisc.edu
// Team: CF red
// Role: Front-End Developer
// TA: Xi Chen
// Lecturer: Florian Heimerl
// Notes to Grader:

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public class MovieMapper extends JFrame {
  public static final Font BASEFONT = new Font("Tahoma", Font.PLAIN, 20);
  public static final int bfWIDTH = Main.SCREEN.width / 3;
  public static final int CPNHEIGHT = 100;
  public static final int CPNMARGIN = 20;
  public static final int CPNPLACING= Main.SCREEN.width/7;
  public static final int POPUPWIN = Main.SCREEN.width / 2;
  private static int vertMs = 0;

  public int selectedMode = 0;

  private Map<String ,Movie> movies;
  private ModeButton modeButton[] = new ModeButton[3];
  private SearchBox sBox = new SearchBox();
  private MovieList movieList = new MovieList();
  private Tile columt;


  public MovieMapper(Map<String ,Movie> movies) {

    super("MovieMapper");
    this.movies = movies;
    setSize(Main.SCREEN);

    setUndecorated(true);
    setVisible(true);
    setLocationRelativeTo(null);
    setLayout(null);

    getContentPane().setBackground(Color.white);
    setVisible(true);

    //Base Mode
    modeButton[0] = new ModeButton("Base Mode");
    getContentPane().add(modeButton[0]);
    modeButton[0].setVisible(true);

    modeButton[0].addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) { super.mouseClicked(e);
        switchMode(0); }
    });

    //Genre Selection Mode
    modeButton[1] = new ModeButton("Genre Selection Mode");
    getContentPane().add(modeButton[1]);
    modeButton[1].setVisible(true);
    modeButton[1].setLocation(bfWIDTH, 0);
    modeButton[1].addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

      }
    });

    modeButton[1].addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) { super.mouseClicked(e);
        switchMode(1); }
    });

    //Rating Selection Mode
    modeButton[2] = new ModeButton("Rating Selection Mode");
    getContentPane().add(modeButton[2]);
    modeButton[2].setVisible(true);
    modeButton[2].setLocation(bfWIDTH * 2, 0);
    modeButton[2].addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) { super.mouseClicked(e);
        switchMode(2); }
    });

    switchMode(0);
    //Columns

    columt = new Tile(
      new String[]
        {"Index", "Title", "Year", "Genre", "Director", "Description", "Rating"});
    getContentPane().add(columt);
    columt.setLocation(0, 100);
    columt.setVisible(true);
    columt.setBackground(Color.BLUE);
    System.out.println(columt.getX());


    //SearchBox CommandLine
    getContentPane().add(sBox);
    sBox.setVisible(true);
    sBox.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
          searchDatabase();
        }
      }
    });

    //Search Button
    JButton sbtn = new JButton("Search");
    sbtn.setBackground(Color.white);
    getContentPane().add(sbtn);
    sbtn.setLocation(sBox.getX() + sBox.getWidth(), sBox.getY());
    sbtn.setSize(CPNPLACING, sBox.getHeight());
    sbtn.setFont(BASEFONT);
    sbtn.setVisible(true);
    sbtn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        searchDatabase();
      }
    });

    //Movie List
    getContentPane().add(movieList);
    movieList.setVisible(true);
    List<Movie> list = new LinkedList<>();
    for (Movie m : movies.values()) {
      list.add(m);
      System.out.println(m.getTitle());
    }
    MovieTile tile = new MovieTile(list.get(0), 0);
    getContentPane().add(tile);
    tile.setVisible(true);
    tile.setLocation(0, 300);

    movieList.displayList(list);

    addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_SLASH) {

        }
      }
    });
  }

  private void switchMode(int mode) {
    selectedMode = mode;
    for (ModeButton mb : modeButton) {
      mb.setBackground(Color.white);
    }
    modeButton[selectedMode].setBackground(Color.gray);
  }

  public void searchDatabase() {
    //Search Content is sBox.getText() -- String
    //invoke movieList.displayList(Your List); to display
    //Below is example
    System.out.println(
            "Searched for " + sBox.getText() +
                    " with " + selectedMode);
    String[] searchKeys = sBox.getText().split(",");

    ///GenreFilter
    //movieList.displayList(movies);
    switch(selectedMode) {
      case 0 : {
        List<Movie> mv = new ArrayList<Movie>();

        backInterface b = null;
        try {
          b = new backInterface("movies.csv");
        } catch (IOException | DataFormatException ioException) {
          ioException.printStackTrace();
        }
        MovieDataReader m = new MovieDataReader();
        try {
          assert b != null;
          b.movieObjects = m.readDataSet(new FileReader("movies.csv"));
        } catch (IOException | DataFormatException ioException) {
          ioException.printStackTrace();
        }

        for (String s : searchKeys) {
          for (MovieInterface mvs : b.movieObjects) {
            if (mvs.getTitle().contains(s)) {
              mv.add((Movie) mvs);
            }
          }
        }
        //For BaseMode
        //May Search For Movie Name

        movieList.clear();
        movieList.displayList(mv);

        break;
      }
      case 1 : {
        //For GenreFilter
        //String[] genre = sBox.getText().split(";");
        backInterface b = null;
        try {
          b = new backInterface("movies.csv");
        } catch (IOException | DataFormatException ioException) {
          ioException.printStackTrace();
        }
        MovieDataReader m = new MovieDataReader();
        try {
          assert b != null;
          b.movieObjects = m.readDataSet(new FileReader("movies.csv"));
        } catch (IOException | DataFormatException ioException) {
          ioException.printStackTrace();
        }
        for (String s : searchKeys) {
          b.addGenre(s);
        }
        b.data = new backEndHash(b.movieObjects);

        movieList.clear();
        movieList.displayList(b.filterGenreMovies());
        break;
      }
      case 2 : {
        backInterface b = null;
        try {
          b = new backInterface("movies.csv");
        } catch (IOException | DataFormatException ioException) {
          ioException.printStackTrace();
        }
        MovieDataReader m = new MovieDataReader();
        try {
          assert b != null;
          b.movieObjects = m.readDataSet(new FileReader("movies.csv"));
        } catch (IOException | DataFormatException ioException) {
          ioException.printStackTrace();
        }
        for (String s : searchKeys) {
          b.addAvgRating(s);
        }
        b.data = new backEndHash(b.movieObjects);

        movieList.clear();
        movieList.displayList(b.filterRatingsMovies());

      }

    }
  }

  private class ModeButton extends JLabel {

    public ModeButton(String title) {
      super(title);
      setHorizontalAlignment(SwingConstants.CENTER);
      setSize(Main.SCREEN.width/3, CPNHEIGHT);
      setOpaque(true);
      setBackground(Color.white);
      setBorder(BorderFactory.createLineBorder(Color.black, 5));
      setFont(new Font("Tahoma", Font.PLAIN, 20));
      setForeground(Color.black);
    }
  }
  private class MovieList extends JPanel {
    private List<MovieTile> curList = new LinkedList<>();
    public MovieList() {
      setBackground(Color.black);
      setLocation(0, CPNMARGIN * 2 + CPNHEIGHT * 3 / 2 );
      setSize(Main.SCREEN.width,
        Main.SCREEN.height - getY());

      setBorder(BorderFactory.createLineBorder(Color.black, 2));
      addMouseListener(new MouseAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
          super.mouseMoved(e);
          System.out.println(0);
        }
      });
    }
    public void displayList(List<Movie> movies) {
      int index = 0;
      for (Movie m : movies) {
        if (m != null) {
          MovieTile toAdd = new MovieTile(m, index + 1);
          add(toAdd);
          curList.add(toAdd);
          toAdd.setLocation(0, index * CPNHEIGHT);
          toAdd.setVisible(true);
          index++;
        }
      }
    }
    public void clear() {
      for (MovieTile m : curList) {
        remove(m);
      }
      curList = new LinkedList<>();
    }
    public void scroll(int offset) {
      for (MovieTile m : curList) {
        m.setLocation(0, m.getY() + offset);
      }
      repaint();
    }

  }
  private class SearchBox extends JTextField {
    public SearchBox() {
      setBackground(Color.white);
      setSize(Main.SCREEN.width - CPNMARGIN * 2, CPNHEIGHT / 2);
      setBorder(null);
      setLocation(CPNMARGIN, CPNHEIGHT + CPNMARGIN);
      setFont(new Font("Tahoma", Font.PLAIN, 20));
    }

  }
  private class Tile extends JPanel {
    TileBlock[] blocks = new TileBlock[7];

    public Tile() {
      setSize(Main.SCREEN.width, CPNHEIGHT);
      setBackground(Color.white);
    }
    public Tile(String[] strings) {
      super();
      build(strings);
    }

    public void build(String[] strings) {
      for (int i = 0; i < 7; i++) {
        blocks[i] = new TileBlock(strings[i]);
        add(blocks[i]);
        blocks[i].setLocation(CPNPLACING * i , 0);
      }
    }
  }

  private class MovieTile extends Tile {
    public MovieTile(Movie movie, int index) {
      super();
      String[] blocktxt = {
        String.valueOf(index),
        movie.getTitle(),
        String.valueOf(movie.getYear()), String.valueOf(movie.getGenres()),
        movie.getDirector(),
        movie.getDescription(),
        String.valueOf(movie.getAvgVote())};
      build(blocktxt);
    }
  }
  private class TileBlock extends JButton {

    public TileBlock(String Caption) {

      super(Caption);
      TileBlock that = this;
      setOpaque(true);
      setBackground(Color.white);
      setSize(CPNPLACING, CPNHEIGHT);
      setHorizontalAlignment(SwingConstants.CENTER);
      setVerticalAlignment(SwingConstants.CENTER);
      setFont(BASEFONT);
      setBorder(BorderFactory.createLineBorder(Color.black, 3));
      setVisible(true);
      addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
          vertMs = e.getYOnScreen();
        }
        @Override
        public void mouseClicked(MouseEvent e) {
          new PopupInfo(that.getText());
        }
      });

      addMouseMotionListener(new MouseAdapter() {

        @Override
        public void mouseDragged(MouseEvent e) {
          movieList.scroll(e.getYOnScreen() - vertMs);
          vertMs = e.getYOnScreen();
        }
      });

    }
  }

  private class PopupInfo extends JFrame{

    public PopupInfo(String info) {
      setSize(POPUPWIN * 2, POPUPWIN);
      setVisible(true);
      JTextArea text = new JTextArea(info);
      text.setSize(POPUPWIN ,200);
      text.setFont(new Font("Tahoma", Font.PLAIN, 30));
      text.setLocation(0,0);
      text.setLineWrap(true);

      add(text);
      text.setVisible(true);
    }
  }
}
