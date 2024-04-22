import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

public class HW2Mapper extends MapReduceBase implements Mapper<LongWritable,
        Text, Text, Text>{
    @Override
    public void map(LongWritable key, Text text, OutputCollector<Text, Text>
            outputCollector, Reporter reporter) throws IOException {

        String line = text.toString();
        String[] storage = line.split(",");//data[0] is key, data[1] is the value
        String stub = storage[3];
        String year = storage[5];
        String estimateIn100K = storage[9];

        String combo = stub +" in "+year;


        outputCollector.collect(new Text(combo), new Text(estimateIn100K));

    }
}
