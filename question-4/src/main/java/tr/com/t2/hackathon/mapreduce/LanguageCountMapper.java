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

import org.apache.hadoop.conf.Configuration;
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
public class LanguageCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private static final Logger logger = Logger.getLogger(LanguageCountMapper.class); 

	private final static IntWritable ONE = new IntWritable(1);
	
	String language;
	
    @Override
    public void run(Context context) throws IOException, InterruptedException {
    	init(context);
    	super.run(context);
    }

    protected void init(Context context) {
    	try {
    		Configuration c = context.getConfiguration();
    		language = c.get("Language");
    		logger.info("Mapper has been initialized ...");
    	}
    	catch (Throwable t) {
    		logger.error("Error occured while initializing Mapper", t);
    	}
    }

	@Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        try {
        	// Cast it to integer typed number. Because every line in input file consist of only one number.
        	twitter4j.Status status = twitter4j.json.DataObjectFactory.createStatus(value.toString());
        	
        	if(status.getUser().getLang().equals(language))
        		context.write(new Text((status.getUser().getLang()).toString()), ONE);
        }
        catch (Throwable t) {
        	logger.error("Error occured while executing map function of Mapper", t);
        }
    }

}
