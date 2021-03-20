package iPublisher;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Author
{
    private final StringProperty authorName;
    private final IntegerProperty idNum;

    public Author(String name, int id)
    {
        this.authorName = new SimpleStringProperty(name);
        this.idNum = new SimpleIntegerProperty(id);
    }

    public void setAuthorName(String name) {authorName.set(name);}
    public void setIdNum(int num) {idNum.set(num);}

    public StringProperty authorNameProperty(){return authorName;}
    public IntegerProperty idNumProperty(){return idNum;}

    public String getAuthorName(){return authorName.get();}
    public int getIdNum(){return idNum.get();}
}
