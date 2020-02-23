package Client.Model;

import java.util.Objects;

public class Administrator implements User
{

  private String name;
  private String Id;
  private String password;

  public Administrator(String name, String Id, String password){
    this.name = name;
    this.Id = Id;
    this.password = password;
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

  public boolean equals(User user)
  {
    return Objects.equals(name, user.getName())
        && Objects.equals(Id, user.getId()) && Objects
        .equals(password, user.getPassword());
  }

}

