package Shared.Model;

public class Feedback
{
  private String advice;
  private boolean broken;
  private String problem;

  private Feedback(String advice,boolean broken,String problem){
    this.advice = advice;
    this.broken = broken;
    this.problem = problem;
  }

  public void setAdvice(String advice)
  {
    this.advice = advice;
  }

  public void setBroken(boolean broken)
  {
    this.broken = broken;
  }

  public void setProblem(String problem)
  {
    this.problem = problem;
  }

  public String getAdvice()
  {
    return advice;
  }

  public boolean isBroken()
  {
    return broken;
  }

  public String getProblem()
  {
    return problem;
  }
}
