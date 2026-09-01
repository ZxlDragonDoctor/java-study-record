import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.w3c.dom.Text;
import wordcutMap.WordCutMapper;
import wordcutReduce.WordCutReducer;


import java.io.FileOutputStream;
import java.io.IOException;

public class WordCutDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS","hdfs://192.168.193:9870");
        Job job = Job.getInstance();

        job.setMapperClass(WordCutMapper.class);
        job.setReducerClass(WordCutReducer.class);
        job.setJarByClass(WordCutDriver.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);


        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        System.exit(job.waitForCompletion(true)?0:-1);

    }
}
