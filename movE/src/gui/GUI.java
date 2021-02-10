package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Algorithms.BinarySearch;
import MovieDatabase.Movie;
import MovieDatabase.MoviesArray;

public class GUI {

	private JFrame frame;
	private JTextField textFieldMovie;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel RecommendationType;
	private JTextPane MovieInfo;
	private JTextArea Recommendations;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1348, 806);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textFieldMovie = new JTextField();
		textFieldMovie.setBounds(384, 111, 394, 43);
		frame.getContentPane().add(textFieldMovie);
		textFieldMovie.setColumns(10);

		/*
		 * Button that recommends movies based off of genre
		 */
		JButton RecommendByGenre = new JButton("Recommend By Genre");
		RecommendByGenre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		RecommendByGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {

				RecommendationType.setText("Recommendation of Movies based on Genre");

				MoviesArray a = new MoviesArray();

				BinarySearch recommendations = new BinarySearch(a.getMovies(), textFieldMovie.getText().toLowerCase());

				recommendations.findUserMovie();

				if (recommendations.getUserMovie() == null) {
					textFieldMovie.setText("Not a valid movie");
				}

				recommendations.buildGenreRecommendations();

				String genres = "";
				for (String type : recommendations.getUserMovie().getGenres()) {
					genres += type + " ";
				}

				MovieInfo.setText("Name of the movie: " + recommendations.getUserMovie().getMovieName() + "\nRating: "
						+ recommendations.getUserMovie().getRating() + "\nGenres: " + genres);

				String recommendation = "";
				for (Movie movie : recommendations.getGenreRecommendations()) {

					String genre = "";
					for (String b : movie.getGenres()) {
						genre += b + " ";
					}
					recommendation += "Name of the movie: " + movie.getMovieName() + " Rating: " + movie.getRating()
							+ " Genres: " + genre + "\n";

				}

				Recommendations.setText(recommendation);

			}
		});

		/*
		 * Button that recommends movies based off of ratings
		 */ RecommendByGenre.setBounds(60, 218, 241, 55);
		frame.getContentPane().add(RecommendByGenre);

		JButton RecommendByRatings = new JButton("Recommend By Ratings");
		RecommendByRatings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RecommendationType.setText("Recommendation of Movies based on Ratings");

				MoviesArray a = new MoviesArray();

				BinarySearch recommendations = new BinarySearch(a.getMovies(), textFieldMovie.getText().toLowerCase());

				recommendations.findUserMovie();

				if (recommendations.getUserMovie() == null) {
					textFieldMovie.setText("Not a valid movie");
				}
				recommendations.buildRatingRecommendation();

				String genres = "";
				for (String type : recommendations.getUserMovie().getGenres()) {
					genres += type + " ";
				}

				MovieInfo.setText("Name of the movie: " + recommendations.getUserMovie().getMovieName() + "\nRating: "
						+ recommendations.getUserMovie().getRating() + "\nGenres: " + genres);

				String recommendation = "";
				for (Movie movie : recommendations.getRatingRecommendations()) {

					String genre = "";
					for (String b : movie.getGenres()) {
						genre += b + " ";
					}
					recommendation += "Name of the movie: " + movie.getMovieName() + " Rating: " + movie.getRating()
							+ " Genres: " + genre + "\n";

				}

				Recommendations.setText(recommendation);

			}
		});

		RecommendByRatings.setFont(new Font("Tahoma", Font.PLAIN, 17));
		RecommendByRatings.setBounds(808, 218, 247, 55);
		frame.getContentPane().add(RecommendByRatings);

		/*
		 * Button that recommends movies based off of ratings and genre
		 */
		btnNewButton = new JButton("Recommend By Genre and Ratings");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RecommendationType.setText("Recommendation of Movies based on Genre and Ratings");

				MoviesArray a = new MoviesArray();

				BinarySearch recommendations = new BinarySearch(a.getMovies(), textFieldMovie.getText().toLowerCase());

				recommendations.findUserMovie();

				if (recommendations.getUserMovie() == null) {
					textFieldMovie.setText("Not a valid movie");
				}

				recommendations.buildGenreRecommendations();
				recommendations.buildRatingRecommendation();
				recommendations.buildBothRecommendations();

				String genres = "";
				for (String type : recommendations.getUserMovie().getGenres()) {
					genres += type + " ";
				}

				MovieInfo.setText("Name of the movie: " + recommendations.getUserMovie().getMovieName() + "\nRating: "
						+ recommendations.getUserMovie().getRating() + "\nGenres: " + genres);

				String recommendation = "";
				for (Movie movie : recommendations.getBothRecommendations()) {

					String genre = "";
					for (String b : movie.getGenres()) {
						genre += b + " ";
					}
					recommendation += "Name of the movie: " + movie.getMovieName() + " Rating: " + movie.getRating()
							+ " Genres: " + genre + "\n";

				}

				Recommendations.setText(recommendation);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(398, 218, 323, 55);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Please Enter a Valid Movie Below");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(410, 10, 370, 73);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel = new JLabel("Info About Movie Entered");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(104, 313, 241, 48);
		frame.getContentPane().add(lblNewLabel);

		RecommendationType = new JLabel("");
		RecommendationType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		RecommendationType.setBounds(662, 313, 619, 43);
		frame.getContentPane().add(RecommendationType);

		Recommendations = new JTextArea();
		Recommendations.setBounds(477, 375, 847, 384);
		frame.getContentPane().add(Recommendations);

		MovieInfo = new JTextPane();
		MovieInfo.setBounds(45, 386, 360, 102);
		frame.getContentPane().add(MovieInfo);

		JLabel lblNewLabel_2 = new JLabel("Make sure the spelling is correct");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(39, 114, 323, 32);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Some example movies are Toy Story, Home Alone etc.");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 145, 374, 32);
		frame.getContentPane().add(lblNewLabel_2_1);
	}
}
