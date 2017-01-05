package com.qaworks.utils;

import org.apache.log4j.Logger;
import org.testng.IExecutionListener;

public class TestNGExecutionListener implements IExecutionListener {


   protected static Logger LOGGER = Logger.getLogger(TestNGExecutionListener.class);


    public void onExecutionStart() {
        LOGGER.debug("Starting execution");
    }


    public void onExecutionFinish() {
        LOGGER.debug("Generating report");
        try {
            MasterThoughtsReporter.generateReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
