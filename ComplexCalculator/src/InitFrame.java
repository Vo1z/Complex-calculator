import ConstsExceptionsEnums.Const;
import GUI.FirstTab.FirstTabPanel;
import GUI.SecondTab.SecondTabPanel;

import javax.swing.*;
import java.awt.*;

public class InitFrame extends JFrame
{
    JTabbedPane tabs;
    FirstTabPanel firstTabContent;
    SecondTabPanel secondTabContent;

    public InitFrame()
    {
        //Assigns fields
        this.tabs = new JTabbedPane();
        this.firstTabContent = new FirstTabPanel();
        this.secondTabContent = new SecondTabPanel();

        //Configurations
        this.tabs.addTab("Calculator", null, this.firstTabContent, "");
        this.tabs.addTab("Graphs", null, this.secondTabContent, "");

        //Frame properties
        this.setSize(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
        this.setName("Calculator");
        this.setMinimumSize(new Dimension(Const.WINDOW_MIN_WIDTH, Const.WINDOW_MIN_HEIGHT));
        this.setBackground(Const.BUTT_BORDER_COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        //Frame elements
        this.add(this.tabs);
        this.pack();
    }
}