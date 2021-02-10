package MovieDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to construct the database of movies from the dataset
 * 
 * @author rites
 *
 */
public class MoviesArray {

	private ArrayList<Movie> movies;

	public MoviesArray() {

		this.movies = new ArrayList<>();

		/**
		 * Access the dataset and read in the results from a scanner
		 */
		File f = new File("2XB3_MoviesDataBase.txt");
		Scanner s;
		try {
			s = new Scanner(f);
			s.nextLine();

			while (s.hasNextLine()) {
				String[] info;
				ArrayList<String> genreInfo = new ArrayList<>();
				String line = s.nextLine();
				info = line.split("\\s*,");

				for (String b : info[1].split("\\.")) {

					genreInfo.add(b);
				}

				/**
				 * Add movie objects into an ArrayList that will contain all the movies from the
				 * dataset
				 */
				movies.add(new Movie(info[2].replaceAll("(^\\h*)|(\\h*$)", "").toLowerCase(), genreInfo,
						Double.parseDouble(info[3])));
			}
			s.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Return the movies list
	 * 
	 * @return
	 */
	public ArrayList<Movie> getMovies() {
		return movies;

	}

}
