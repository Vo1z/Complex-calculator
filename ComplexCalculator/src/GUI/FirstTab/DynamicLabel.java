package GUI.FirstTab;

import javax.swing.*;

public class DynamicLabel extends JLabel
{
    private String content;

    DynamicLabel(String content)
    {
        super(content);
        this.content = content;
    }

    public void replaceContent(String contentToReplace)
    {
        content = contentToReplace;
        this.setText(content);
    }

    public void appendContent(String contentToAppend)
    {
        content += contentToAppend;
        this.setText(content);
    }

    public void replaceBack(String contentToReplace)
    {
        if (content.length() > 0)
        {
            content = content.substring(0, content.length() - 1);
            content += contentToReplace;
            this.setText(content);
        }
    }

    //Getters
    public String getContent()
    {
        return content;
    }
}
