package com.arkinem.libraryfeedbackclient;
import java.util.List;

import javax.swing.*;

import com.arkinem.libraryfeedbackclient.model.Question;

public class MainWindow {
	
	private final JFrame frame;

	public  MainWindow() {
	 	frame = new JFrame(); //creating instance of JFrame  
    	JButton b =new JButton("click");//creating instance of JButton  
    	b.setBounds(130,100,300, 40);
    	
    	frame.add(b);//adding button in JFrame  
    	frame.setSize(700,500);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible  
		
		 // Create the worker
        QuestionsWorker q = new QuestionsWorker();
        SwingWorker<List<Question>, Integer> work = q.createWorker();
        work.execute();

        // Wait for it to finish
        while (!work.isDone()) {
            // Show Progress
            try {
                int iProgress = work.getProgress();
                System.out.println("Progress %" + iProgress);
                b.setText("Progress %" + iProgress);
                Thread.sleep(500);
            }
            catch (Exception ex) {
                System.err.println(ex);
            }
        } // End of Loop: while (!work.isDone())
	} 
} 


