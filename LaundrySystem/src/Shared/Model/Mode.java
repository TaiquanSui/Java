package Shared.Model;

public enum Mode
{
  mode1(40,10),mode2(65,10),mode3(70,10),mode4(85,10);

  private int min;
  private int money;

  Mode(int min,int money){
    this.min = min;
    this.money = money;
  }
  public int getMin(){
    return min;
  }
  public int getMoney(){ return money; }
}
