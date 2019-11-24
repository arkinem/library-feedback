import javax.swing.*;
import java.util.List;

public class LibraryClient {
    /**
     * Creates an Example SwingWorker
     */
    public SwingWorker<Boolean, Integer> createWorker() {
        return new SwingWorker<Boolean, Integer>() {    		
            @Override
            protected Boolean doInBackground() throws Exception {
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
                return true;
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
                boolean bStatus = false;
                try {
                    bStatus = get();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("Finished with status " + bStatus);
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

    public static void main(String[] args) {
      	JFrame fr =new JFrame();//creating instance of JFrame  
    	JButton b =new JButton("click");//creating instance of JButton  
    	b.setBounds(130,100,300, 40);
    	
    	fr.add(b);//adding button in JFrame  
    	fr.setSize(400,500);//400 width and 500 height  
		fr.setLayout(null);//using no layout managers  
		fr.setVisible(true);//making the frame visible  
    	
    	
        // Create the worker
        LibraryClient l = new LibraryClient();
        SwingWorker<Boolean, Integer> work = l.createWorker();
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
    } // End of: main()
 
    
    
} // End of Class definition


