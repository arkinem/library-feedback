package com.arkinem.libraryfeedbackclient;
import javax.swing.*;

import com.arkinem.libraryfeedbackclient.model.Question;
import com.arkinem.libraryfeedbackclient.utils.HttpRequest;

import java.util.ArrayList;
import java.util.List;

public class QuestionsWorker {
    /**
     * Creates an SwingWorker
     */
    public SwingWorker<List<Question>, Integer> createWorker() {
        return new SwingWorker<List<Question>, Integer>() {   
        	
        	
            @Override
            protected List<Question> doInBackground() throws Exception {
            	

            	String response = HttpRequest.sendGet("/v1/question");
            	List<Question> questions = Question.parseQuestionsFromJSON(response);
//                System.out.println("afterparse: " + questions.size());
    			
                // Start Progress
                setProgress(0);
                waitFor(500);

                // Example Loop
                for (int iCount = 1; iCount <= 20; iCount++) {
                    // Is an even number?
                    if (iCount % 2 == 0) {
                        publish(iCount);
                    }

                    // Set Progress
                    setProgress((iCount * 100) / 20);
                    waitFor(250);
                }

                // Finished
                return questions;
            }

            @Override
            protected void process(List<Integer> chunks) {
                // Get Info
                for (int number : chunks) {
                    System.out.println("Found even number: " + number);
                }
            }

            @Override
            protected void done() {
            	List<Question> questions = new ArrayList<>();
            	
                try {
                	questions = get();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                System.out.println("Questions fetched" + questions.size());
            }
        };
    } // End of Method: createWorker()


    /**
     * Wait the given time in milliseconds
     * @param iMillis
     */
    private void waitFor (int iMillis) {
        try {
            Thread.sleep(iMillis);
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    } // End of Method: waitFor()

    
    
} // End of Class definition


