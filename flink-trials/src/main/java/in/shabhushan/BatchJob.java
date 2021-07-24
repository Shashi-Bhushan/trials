/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package in.shabhushan;

import in.shabhushan.function.FilterGenreFromMovieRatingFunction;
import in.shabhushan.function.MovieRatingJoiner;
import in.shabhushan.function.AverageRatingPerGenreFunction;
import in.shabhushan.model.Movie;
import in.shabhushan.model.MovieRating;
import in.shabhushan.model.Rating;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;

import java.util.*;

/**
 * Skeleton for a Flink Batch Job.
 *
 * <p>For a tutorial how to write a Flink batch application, check the
 * tutorials and examples on the <a href="https://flink.apache.org/docs/stable/">Flink Website</a>.
 *
 * <p>To package your application into a JAR file for execution,
 * change the main class in the POM.xml file to this class (simply search for 'mainClass')
 * and run 'mvn clean package' on the command line.
 */
public class BatchJob {

	private static final String DIR = "/media/shashi/5c0257d4-ee3d-4ed3-8072-ea5aca6e7f1d/dataset/ml-latest/";
	private static final String MOVIES_FILE = DIR + "movies.csv";
	private static final String RATINGS_FILE = DIR + "ratings.csv";

	public static void main(String[] args) throws Exception {
		// set up the batch execution environment
		final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

		/*
		 * Here, you can start creating your execution plan for Flink.
		 *
		 * Start with getting some data from the environment, like
		 * 	env.readTextFile(textPath);
		 *
		 * then, transform the resulting DataSet<String> using operations
		 * like
		 * 	.filter()
		 * 	.flatMap()
		 * 	.join()
		 * 	.coGroup()
		 *
		 * and many more.
		 * Have a look at the programming guide for the Java API:
		 *
		 * https://flink.apache.org/docs/latest/apis/batch/index.html
		 *
		 * and the examples
		 *
		 * https://flink.apache.org/docs/latest/apis/batch/examples.html
		 *
		 */

		DataSource<Movie> movies = env.readCsvFile(MOVIES_FILE)
				.ignoreFirstLine()
				.parseQuotedStrings('"')
				.ignoreInvalidLines()
				.tupleType(Movie.class);

		DataSource<Rating> ratings = env.readCsvFile(RATINGS_FILE)
				.ignoreFirstLine()
				.parseQuotedStrings('"')
				.ignoreInvalidLines()
				.tupleType(Rating.class);

		List<Tuple2<String, Double>> result = movies.join(ratings)
				.where(0) // Join first Column on movies
				.equalTo(0) // Join with first Column on ratings
				// Join Movie and Rating together
				.with(new MovieRatingJoiner())
				// Extract each genre from Genres
				.flatMap(new FilterGenreFromMovieRatingFunction())
				// group by genre
				.groupBy(MovieRating::getGenre)
				// Get average rating per Genre
				.reduceGroup(new AverageRatingPerGenreFunction())
				.collect();

		System.out.println("Result :: ");
		result.sort(Comparator.comparing(a -> a.f1, Collections.reverseOrder()));
		result.forEach(System.out::println);

		// execute program
		// env.execute("Flink Batch Java API Skeleton");
	}
}
