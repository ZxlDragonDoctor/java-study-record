package wordcutReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class WordCutReducer extends Reducer<Text, IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
            int item = 0;
            for(IntWritable intWritable:values){
                item +=intWritable.get();
            }
            context.write(key,new IntWritable(item));
    }
}
