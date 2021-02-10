package MovieDatabase;

import java.util.ArrayList;

public class Movie implements Comparable<Movie> {

	private String movieName;
	private ArrayList<String> genres;
	private double rating;

	public Movie(String movieName, ArrayList<String> genres, double rating) {

		this.movieName = movieName;
		this.genres = genres;
		this.rating = rating;
	}

	/**
	 * Returns the name of the movie
	 * 
	 * @return
	 */
	public String getMovieName() {
		return this.movieName;
	}

	/**
	 * Returns the list of genres related to the rating
	 * 
	 * @return
	 */
	public ArrayList<String> getGenres() {
		return this.genres;
	}

	/**
	 * Returns the movies rating
	 * 
	 * @return
	 */
	public double getRating() {
		return this.rating;
	}

	/**
	 * Compare method to compare two movies based on their name in lexicographical
	 * order
	 */
	public int compareTo(Movie movie) {

		if (this.getMovieName().compareTo(movie.getMovieName()) > 0)
			return 1;
		else if (this.getMovieName().compareTo(movie.getMovieName()) < 0)
			return -1;
		else
			return 0;

	}

}
