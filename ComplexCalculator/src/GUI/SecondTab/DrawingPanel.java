package GUI.SecondTab;

import CalcMath.Function;
import ConstsExceptionsEnums.Const;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel
{
    private ArrayList<Function> functions;

    DrawingPanel(ArrayList<Function> functions)
    {
        //Assign
        this.functions = functions;

        //DrawingPanel properties
        this.setBackground(Const.FUNCTION_INVISIBLE_COLOR);
        this.setBorder(BorderFactory.createLineBorder(Const.BUTT_BORDER_COLOR,Const.BUTT_BORDER_THICKNESS));

        Thread repainter = new Thread(
                ()->
                {
                    while(!Thread.currentThread().isInterrupted())
                    {
                        //Sleeps for 500 ms
                        try
                        {
                            Thread.sleep(300);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }

                        this.repaint();
                        this.setVisible(false);
                        this.setVisible(true);
                    }
                }
                );
        repainter.start();
    }

    @Override
    public void paint(Graphics g)
    {
        for(Function func : functions)
        {
            func.draw(g);
        }
        int widthX = this.getWidth();
        int heightY = this.getHeight();

        g.setColor(Color.black);
        g.drawLine(widthX/2, 0, widthX/2, heightY);
        g.drawLine(0, heightY/2, widthX,heightY/2);

    }

    public void updateFunctions(ArrayList<Function> functions)
    {
        this.functions = functions;
    }
}