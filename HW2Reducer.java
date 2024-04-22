import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

public class HW2Reducer extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
    @Override
    public void reduce(Text text, Iterator<Text> iterator, OutputCollector<Text, Text>
            outputCollector, Reporter reporter) throws IOException {
        HashSet<Text> hashbrown = new HashSet<>();
        while(iterator.hasNext()){
            hashbrown.add(iterator.next());
        }
        outputCollector.collect(text, new Text (hashbrown.size() + ""));
    }
}