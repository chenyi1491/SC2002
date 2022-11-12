package view;

import java.util.ArrayList;
import java.util.Arrays;

import operator.FileInputOutputOperator;
import operator.ViewOperator;
import model.Movies;

/**
 * This View class presents the details of a particular Movie object
 */

public class MovieDetailView extends StartView {

	/**
	 * This is the View options
	 */
	private ArrayList<String> options = new ArrayList<>(Arrays.asList(
			"Back to Previous Page"
	));

	/**
	 * This is the View title
	 */
	private String title;

	/**
	 * This is the View content
	 */
	private String viewContent;

	/**
	 * This constructor initialise this class with a specified Movie object
	 * @param movie The selected movie for detail viewing
	 */
	public MovieDetailView(Movies movie) {
		this.title = movie.getTitle();
		this.viewContent = movie.toString();
	}

	/**
	 * This method transforms the View into active state
	 */
	public void activate() {
		super.setOptions(this.options);
		super.setTitle(this.title);
		super.setViewContent(this.viewContent);
		super.activate();
		
		int userInput = FileInputOutputOperator.getUserInputInt("Please input your choice",1,options.size());
		processUserInput(userInput);
	}

	/**
	 * This method helps to manage execution of code based on the user put choice on the View options.
	 * @param input the index of the options
	 */
	@Override
	protected void processUserInput(int input) {
		if (input == options.size()) {
			ViewOperator.popView();
		}
	}

}