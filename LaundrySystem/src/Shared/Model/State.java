package Shared.Model;

public enum State
{
  avaliable("available"),runing("runing"),broken("broken"),offline("offline");

  private String state;

  State(String state){
    this.state = state;
  }
  public String getState(){
    return state;
  }

}
