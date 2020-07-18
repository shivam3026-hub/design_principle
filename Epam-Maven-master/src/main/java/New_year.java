
import java.util.*;
import java.util.Vector;

class SWEETS
{
  public String n;

  public int weight;

  public int quantity;
  public SWEETS(String s,int w ,int quan)
  {
    n=s;
    this.weight=w;
    this.quantity=quan;
  }
  public String getName()
  {
    return n;
  }
  public int getW()
  {
    return weight;
  }
  public int getQ()
  {
    return quantity;
  }
}


class Chocolate extends SWEETS
{
  public Chocolate(String name,int w, int quantity) {
    super(name, w, quantity);
  }
}

class Candy extends SWEETS {

  public Candy(String name, int w, int quantity) {
    super(name, w, quantity);

  }
}

class Gifts {
  public Vector<SWEETS> sl;
  int tw;

  public Gifts(Vector<SWEETS> s2) {
    this.sl = s2;
  }

  public int totalWeight()
  {
    int t=0;
    for(SWEETS s1:sl)
    {
      t+=s1.getW()*s1.getQ();
    }
    return t;
  }
}
class Children
{
  String name;
  Vector<Gifts> g=new Vector<Gifts>();

  public Children(String name) {
    this.name = name;
  }
  public void give(Gifts gift,Children child)
  {
    child.take(gift);
  }
  public void take(Gifts gift)
  {
    g.add(gift);
  }
  public void show()
  {
    System.out.print(this.name+": ");
    for(int i=0;i<g.size();i++)
    {
      int ans= g.get(i).totalWeight();
      System.out.println(" Total Weight = "+ans+" grms");
    }
  }
}


public class New_year
{
  public static void main( String[] args )
  {
    Scanner in=new Scanner(System.in);
    System.out.println("enter children name");
    String name=in.nextLine();
    Children c=new Children(name);
    System.out.println("enter choclate name and quantity");
    String ch=in.nextLine();
    int qu=in.nextInt();
    SWEETS c1=new Chocolate(ch,10,qu);

    System.out.println("enter candy  name and quantity");
    String h=in.next();
    int m=in.nextInt();
    SWEETS c2=new Candy(h,1,m);
    Vector<SWEETS> a1=new Vector<SWEETS>();
    a1.add(c1);
    a1.add(c2);
    Gifts gift1=new Gifts(a1);
    c.give(gift1,c);
    c.show();

  }
}

