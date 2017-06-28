package com.cloudxlab.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public rajwordmapper extends Mapper<Object,Text,Text,LongWritable>
{
public void mapper(LongWritable key, Text value, Context context)
{

  String[] words = value.toString().split("[ /t]+")
  
  for(String word:words)
  {
  
   word = word.replaceAll("[^a-zA-Z0-9]","")
   word = word.toLowercase()
   
   Text outkey = new Text(word)
   LongWritable one = new LongWritable(1)
   context.write(outkey,one)
   
  }

}
}
