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
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.log4j.Logger;

/**

 *  
 * Reduce implementation of Map/Reduce job.
 * Gets partial intermediate results as grouped and generates its result.
 */
public class LanguageCountReducer extends Reducer<Text, IntWritable, NullWritable, IntWritable> {

	private static final Logger logger = Logger.getLogger(LanguageCountReducer.class); 
    
    @Override
    public void run(Context context) throws IOException, InterruptedException {
    	init(context);
    	super.run(context);
    }
    
	protected void init(Context context) {
    	try {
    		logger.info("Reducer has been initialized ...");
    	}
    	catch (Throwable t) {
    		logger.error("Error occured while initializing Reducer", t);
    	}
    }

    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		try {
			int sum = 0;
			Iterator<IntWritable> i = values.iterator();
			// Explore all occurences of this number and calculate sum of them as frequency of number
			while (i.hasNext()) {
				sum += i.next().get();
			}
			// Write occurence of this number 
			context.write(NullWritable.get(), new IntWritable(sum));
		}
        catch (Throwable t) {
        	logger.error("Error occured while executing reduce function of Reducer", t);
        }    
    }

}
