package Client.Model;

public interface User
{
  void setName(String name);

  void setId(String id);

  void setPassword(String password);

  String getName();

  String getId();

  String getPassword();

  boolean equals(User user);
}