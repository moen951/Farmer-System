package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PlaySchoolClock 
{
	public JLabel clock;

    public static void main(String[] args) 
    {
    
        new PlaySchoolClock();
    }

    public PlaySchoolClock() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

               JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
               frame.add(new ClockPane());
                frame.pack();
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
            }
        });
    }

    public class ClockPane extends JPanel 
    {

        

        public ClockPane() {
            setLayout(new BorderLayout());
            clock = new JLabel();
            clock.setHorizontalAlignment(JLabel.CENTER);
            clock.setFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 26f));
            tickTock();
            add(clock);

            Timer timer = new Timer(500, new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {
                    tickTock();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.setInitialDelay(0);
            timer.start();
            
           
        }

        public void tickTock() 
        {
        	//DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);

            //clock.setText(df.format(new Date()));
            clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
        }
        
      
    }
}