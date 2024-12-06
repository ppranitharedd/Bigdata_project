// package com.mycompany.app;

// import org.apache.hadoop.conf.Configuration;
// import org.apache.hadoop.fs.Path;
// import org.apache.hadoop.io.IntWritable;
// import org.apache.hadoop.io.Text;
// import org.apache.hadoop.mapreduce.Job;
// import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
// import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// public class SentimentDriver {

//     public static void main(String[] args) throws Exception {
//         if (args.length != 2) {
//             System.err.println("Usage: SentimentDriver <input path> <output path>");
//             System.exit(-1);
//         }

//         Configuration conf = new Configuration();
//         Job job = Job.getInstance(conf, "Sentiment Analysis");

//         job.setJarByClass(SentimentDriver.class);
//         job.setMapperClass(SentimentMapper.class);
//         job.setReducerClass(SentimentReducer.class);

//         job.setOutputKeyClass(Text.class);
//         job.setOutputValueClass(IntWritable.class);

//         FileInputFormat.addInputPath(job, new Path(args[0]));
//         FileOutputFormat.setOutputPath(job, new Path(args[1]));

//         // Check if job completed successfully
//         System.exit(job.waitForCompletion(true) ? 0 : 1);
//     }
// }
package com.mycompany.app;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SentimentDriver {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Sentiment Analysis");

        job.setJarByClass(SentimentDriver.class);
        job.setMapperClass(SentimentMapper.class);
        job.setReducerClass(SentimentReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
