package Client.Model;

import java.util.Calendar;
import java.util.Objects;

public class Customer implements User
{

  private String name;
  private String Id;
  private String password;
  private boolean ban;
  private Calendar endTimeOfBan;
  private int balance;

  public Customer(){}

  public Customer(String name, String id, String password, boolean ban, Calendar endTimeOfBan, int balance){
    this.name = name;
    this.Id = id;
    this.password = password;
    this.ban = ban;
    this.endTimeOfBan = endTimeOfBan;
    this.balance = balance;
  }



  public void setName(String name)
  {
    this.name = name;
  }

  public void setId(String id)
  {
    this.Id = id;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public void setBan(boolean ban)
  {
    this.ban = ban;
  }

  public void setEndTimeOfBan(Calendar endTimeOfBan) { this.endTimeOfBan = endTimeOfBan; }

  public void setBalance(int balance)
  {
    this.balance = balance;
  }




  public String getName()
  {
    return name;
  }

  public String getId()
  {
    return Id;
  }

  public String getPassword()
  {
    return password;
  }

  public boolean isBan()
  {
    return ban;
  }

  public Calendar getEndTimeOfBan() { return endTimeOfBan; }

  public int getBalance()
  {
    return balance;
  }


  public boolean equals(User user)
  {
    return Objects.equals(name, user.getName())
        && Objects.equals(Id, user.getId()) && Objects
        .equals(password, user.getPassword());
  }


}
