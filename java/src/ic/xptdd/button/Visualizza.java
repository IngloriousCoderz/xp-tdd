package ic.xptdd.button;

public class Visualizza {
    public static void visualizza(int x,int y,String ciao)
    {
  for (int i=0;i<x;i++){
    System.out.print("* ");
  }
  System.out.println();
  for (int j=0;j<(y-2)/2;j++){
  System.out.print("* ");
  for (int k=0;k<(x-2)*2;k++){
    System.out.print(" ");
  }
  System.out.print("* ");
  System.out.println();
  }
  System.out.print("* ");
  for (int l=0;l<(x-2)-2;l++){
      System.out.print(" ");
  }
  System.out.print(ciao);
  for (int l=0;l<(x-2)-2;l++){
      System.out.print(" ");
  }
  System.out.print("* ");
  System.out.println();
  for (int j=0;j<(y-2)/2;j++){
  System.out.print("* ");
  for (int k=0;k<(x-2)*2;k++){
    System.out.print(" ");
  }
  System.out.print("* ");
  System.out.println();
  }
  for (int i=0;i<x;i++){
    System.out.print("* ");
  }
  System.out.println();
}
    public static void main(String[] args)
    {
        visualizza(10,10, "ciao");
    }
}
