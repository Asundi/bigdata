

package com.cloudxlab.Training1;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FixedLengthInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.cloudxlab.customreader.NLinesInputFormat;

public class rajwordcount
{

public static void main(String[] args) throws Exception
{
  
  JobConf conf = new JobConf();
  Job job = new Job(conf,"RajWordCount")
  
  job.setJarByClass(rajwordcount.class);
  job.setMapperClass(rajwordmapper.class);
  job.setReducerClass(rajwordreducer.class);

  job.setOutputKeyClass(Text.class);
  job.setOutputValueClass(LongWritable.class);

  FileInputFormat.addInputPath(job,new Path(args[1]));
  FileOutputFormat.setOutputPath(job,new Path(args[2]));
  
  boolean result = job.waitForCompletion(true);
  System.exit(result ? 0 : 1);
}


}
