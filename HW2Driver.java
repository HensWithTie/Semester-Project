import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class HW2Driver {
    public static void main(String[] args) throws Exception{

        JobClient jobClient = new JobClient();
        JobConf jobConf = new JobConf(HW2Driver.class);
        jobConf.setJobName("Estimated Deaths in 100K");
        jobConf.setOutputKeyClass(Text.class);
        jobConf.setOutputValueClass(Text.class);
        jobConf.setMapperClass(HW2Mapper.class);
        jobConf.setReducerClass(HW2Reducer.class);
        jobConf.setInputFormat(TextInputFormat.class);
        jobConf.setOutputFormat(TextOutputFormat.class);
        FileInputFormat.setInputPaths(jobConf, new Path(args[0]));
        FileOutputFormat.setOutputPath(jobConf, new Path(args[1]));
        jobClient.setConf(jobConf);
        try {
            JobClient.runJob(jobConf);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

