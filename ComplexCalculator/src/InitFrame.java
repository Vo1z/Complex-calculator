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
        tabs = new JTabbedPane();
        firstTabContent = new FirstTabPanel();
        secondTabContent = new SecondTabPanel();

        //Configurations
        tabs.addTab("Calculator", null, firstTabContent, "");
        tabs.addTab("Graphs", null, secondTabContent, "");

        //Frame properties
        this.setSize(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
        this.setName("Calculator");
        this.setMinimumSize(new Dimension(Const.WINDOW_MIN_WIDTH, Const.WINDOW_MIN_HEIGHT));
        this.setBackground(Const.BUTT_BORDER_COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        //Frame elements
        this.add(tabs);
        this.pack();//TODO read documentation
    }
}