package wordcutMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class WordCutMapper extends Mapper<LongWritable, Text,Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split("\\s+");
        for(String word:words){
            context.write(new Text(word),new IntWritable(1));
        }
    }
}
