package Shared.Model;

import java.io.Serializable;

public class Message implements Serializable
{
  private String text;
  private String date;
  private String senderID;
  private String receiverID;
  private boolean read;

  public Message(String text, String date, String senderID, String receiverID, boolean read)
  {
    this.text = text;
    this.date = date;
    this.senderID = senderID;
    this.receiverID = receiverID;
    this.read = read;
  }

  public String getText()
  {
    return text;
  }

  public String getDate()
  {
    return date;
  }

  public String getSenderID()
  {
    return senderID;
  }

  public String getReceiverID()
  {
    return receiverID;
  }

  public boolean isRead() { return read; }



  public void setRead(boolean read) { this.read = read; }

  public void setDate(String date)
  {
    this.date = date;
  }

  public void setSenderID(String senderID)
  {
    this.senderID = senderID;
  }

  public void setReceiverID(String receiverID) { this.receiverID = receiverID; }

  public void setText(String text) { this.text = text; }


}

