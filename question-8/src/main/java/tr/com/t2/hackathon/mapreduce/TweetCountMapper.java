/*
 * Copyright (c) 2014, "SkyKeeper Team". All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 */

package tr.com.t2.hackathon.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

/**

 * 
 * Map implementation of Map/Reduce job.
 * Reads input and generates partial intermediate results.
 */
public class TweetCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private static final Logger logger = Logger.getLogger(TweetCountMapper.class); 

	private final static IntWritable ONE = new IntWritable(1);
	
    @Override
    public void run(Context context) throws IOException, InterruptedException {
    	init(context);
    	super.run(context);
    }

    protected void init(Context context) {
    	try {
    		logger.info("Mapper has been initialized ...");
    	}
    	catch (Throwable t) {
    		logger.error("Error occured while initializing Mapper", t);
    	}
    }

	@Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        try {
        	context.write(new Text("satir"), ONE);
        }
        catch (Throwable t) {
        	logger.error("Error occured while executing map function of Mapper", t);
        }
    }
}
