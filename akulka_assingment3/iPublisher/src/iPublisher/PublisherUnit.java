package iPublisher;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PublisherUnit
{
    private final StringProperty publisherName;
    private final StringProperty publisherAddress;
    private final IntegerProperty publisherID;


    public PublisherUnit(String name, String address, int id)
    {
        this.publisherName = new SimpleStringProperty(name);
        this.publisherAddress = new SimpleStringProperty(address);
        this.publisherID = new SimpleIntegerProperty(id);

    }

    public void setPublisherName(String name) {publisherName.set(name);}
    public void setPublisherAddress(String address) {publisherAddress.set(address);}
    public void setPublisherID(int id) {publisherID.set(id);}


    public StringProperty publisherNameProperty(){return publisherName;}
    public StringProperty publisherAddressProperty(){return publisherAddress;}
    public IntegerProperty publisherIDProperty(){return publisherID;}


    public String getPublisherName(){return publisherName.get();}
    public String getPublisherAddress(){return publisherAddress.get();}
    public int getPublisherID(){return publisherID.get();}

}
