package iPublisher;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Title
{
    private final StringProperty titleName;
    private final IntegerProperty titleID;

    public Title(String name, int id)
    {
        this.titleName= new SimpleStringProperty(name);
        this.titleID = new SimpleIntegerProperty(id);
    }

    public void setTitleName(String name) {titleName.set(name);}
    public void setTitleID(int num) {titleID.set(num);}

    public StringProperty titleNameProperty(){return titleName;}
    public IntegerProperty titleIDProperty(){return titleID;}

    public String getTitleName(){return titleName.get();}
    public int getTitleID(){return titleID.get();}
}
