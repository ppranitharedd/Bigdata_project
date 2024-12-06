// package com.mycompany.app;

// import org.apache.hadoop.io.IntWritable;
// import org.apache.hadoop.io.Text;
// import org.apache.hadoop.mapreduce.Mapper;

// import java.io.IOException;

// public class SentimentMapper extends Mapper<Object, Text, Text, IntWritable> {

//     private final Text productID = new Text();
//     private final IntWritable sentimentScore = new IntWritable();

//     @Override
//     public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
//         String[] fields = value.toString().split(",");  // Adjust delimiter if needed
//         if (fields.length > 2) {
//             try {
//                 String product = fields[1].trim();  // Assuming product ID is in the 2nd column
//                 int rating = (int) Float.parseFloat(fields[2].trim());  // Convert rating to integer

//                 productID.set(product);
//                 sentimentScore.set(rating);  // Use the rating as the sentiment score
//                 context.write(productID, sentimentScore);
//             } catch (NumberFormatException e) {
//                 // Skip rows with invalid rating value
//                 System.err.println("Skipping row due to invalid number format: " + value);
//             }
//         }
//     }
// }

// Updated Mapper for Visualization
package com.mycompany.app;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SentimentMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final Text productID = new Text();
    private final IntWritable rating = new IntWritable();

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");  // Adjust delimiter if needed
        if (fields.length > 2) {
            try {
                String product = fields[1].trim();  // Assuming product ID is in the 2nd column
                int ratingValue = (int) Float.parseFloat(fields[2].trim());  // Convert rating to integer

                productID.set(product);
                rating.set(ratingValue);

                // Emit product ID and corresponding rating
                context.write(productID, rating);
            } catch (NumberFormatException e) {
                // Skip rows with invalid rating value
                System.err.println("Skipping row due to invalid number format: " + value);
            }
        }
    }
}

