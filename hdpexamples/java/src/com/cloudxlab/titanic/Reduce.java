public static class Reduce extends Reducer<Key_value, IntWritable, Key_value, IntWritable> {
 
public void reduce(Key_value key, Iterable<IntWritable> values, Context context)
 
throws IOException, InterruptedException {
 
int sum = 0;
 
for (IntWritable val : values) {
 
sum += val.get();
 
}
 
context.write(key, new IntWritable(sum));
 
}
 
}
