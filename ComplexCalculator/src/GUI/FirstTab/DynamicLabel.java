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
        this.content = contentToReplace;
        this.setText(this.content);
    }

    public void appendContent(String contentToAppend)
    {
        this.content += contentToAppend;
        this.setText(this.content);
    }

    public void replaceBack(String contentToReplace)
    {
        if (this.content.length() > 0)
        {
            this.content = this.content.substring(0, this.content.length() - 1);
            this.content += contentToReplace;
            this.setText(this.content);
        }
    }

    //Getters
    public String getContent()
    {
        return this.content;
    }
}
