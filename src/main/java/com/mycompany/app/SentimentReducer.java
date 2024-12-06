// package com.mycompany.app;

// import org.apache.hadoop.io.IntWritable;
// import org.apache.hadoop.io.Text;
// import org.apache.hadoop.mapreduce.Reducer;

// import java.io.IOException;

// public class SentimentReducer extends Reducer<Text, IntWritable, Text, Text> {

//     private final Text result = new Text();

//     @Override
//     public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
//         int sum = 0;
//         int count = 0;

//         // Sum up all the ratings for a product and count the number of ratings
//         for (IntWritable value : values) {
//             sum += value.get();
//             count++;
//         }

//         if (count > 0) {
//             double average = (double) sum / count;  // Calculate average rating
//             String sentimentCategory = getSentimentCategory(average);  // Categorize the sentiment
//             result.set(String.format("Average Rating: %.2f, Sentiment: %s", average, sentimentCategory));
//             context.write(key, result);  // Emit product and sentiment info
//         } else {
//             System.out.println("No ratings for product: " + key.toString());  // Log if no ratings exist
//         }
//     }

//     // Categorize sentiment based on the average rating
//     private String getSentimentCategory(double average) {
//         if (average >= 4.0) return "Positive";  // Ratings 4.0 - 5.0
//         else if (average >= 3.0) return "Neutral";  // Ratings 3.0 - 3.9
//         else return "Negative";  // Ratings 1.0 - 2.9
//     }
// }

package com.mycompany.app;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SentimentReducer extends Reducer<Text, IntWritable, Text, Text> {

    private final Text result = new Text();

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        Map<Integer, Integer> ratingCount = new HashMap<>();

        // Initialize the rating counts (e.g., 1-5 stars)
        for (int i = 1; i <= 5; i++) {
            ratingCount.put(i, 0);
        }

        // Count ratings for each product
        for (IntWritable value : values) {
            int rating = value.get();
            ratingCount.put(rating, ratingCount.getOrDefault(rating, 0) + 1);
        }

        // Convert rating distribution to a string
        StringBuilder distribution = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            distribution.append(i).append("-Star: ").append(ratingCount.get(i)).append(", ");
        }

        // Remove trailing comma and space
        if (distribution.length() > 0) {
            distribution.setLength(distribution.length() - 2);
        }

        // Set and write the result
        result.set(distribution.toString());
        context.write(key, result);
    }
}
