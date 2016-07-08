package javaapplication2;

import java.awt.*;


public class  Jeopardy extends JeopardyApp
{
   public static void main(String[] args)
   {  new Jeopardy(); }
   
   Label lJeopardy = addLabel(" Civil War ",100,30,200,60,this);
   
   Label lScore = addLabel("Score",300,50,50,30,this);
   TextField tScore = addTextField("0",350,50,80,30,this);


   Button bCivilWar = addButton("Civil War ",50,100,100,50,this);
   Button bNorth = addButton("North",150,100,100,50,this);
   Button bSouth = addButton("South",250,100,100,50,this);
  // Button bCW = addButton("CW",350,100,100,50,this);
   Button bNorth2 = addButton("North 200",150,150,100,50,this);
   Button bSouth2 = addButton("South 200",250,150,100,50,this);
   Button bCivilWar2 = addButton("Civil War 200",50,150,100,50,this);
  // Button bCW2 = addButton("CW 200",350,150,100,50,this);
    Button bNorth3 = addButton("North 300",150,200,100,50,this);
   Button bSouth3 = addButton("South 300",250,200,100,50,this);
   Button bCivilWar3 = addButton("Civil War 300",50,200,100,50,this);
  // Button bCW3 = addButton("CW 300",350,200,100,50,this);
   Button bNorth4 = addButton("North 400",150,250,100,50,this);
   Button bSouth4 = addButton("South 400",250,250,100,50,this);
   Button bCivilWar4 = addButton("Civil War 400",50,250,100,50,this);
  // Button bCW4 = addButton("CW 400",350,250,100,50,this);
   Button bCivilWar5 = addButton("Civil War 500 ",50,300,100,50,this);
   Button bNorth5 = addButton("North 500",150,300,100,50,this);
   Button bSouth5 = addButton("South 500",250,300,100,50,this);
  // Button bCW5 = addButton("CW 500",350,300,100,50,this);

   Button bPlayAgain = addButton("Want To Play Again?",50,350,400,50,this);
   
   double score = 0;

   public Jeopardy()  
   {
      setSize(500,500);
      setTitle(" Civil War Jeopardy"); 
   
      lJeopardy.setFont(new Font("Impact",1,36));
       lJeopardy.setBackground(Color.red);
       //255,255,180));
      lJeopardy.setForeground(Color.black);
      lScore.setBackground(Color.white);
      setBackground(Color.red);
   
      bCivilWar.setFont(new Font("Impact",1,16));
       bCivilWar2.setFont(new Font("Impact",1,16));
         bCivilWar3.setFont(new Font("Impact",1,16));
          bCivilWar4.setFont(new Font("Impact",1,16));
          bCivilWar5.setFont(new Font("Impact",1,16));
     // bCW.setFont(new Font("Impact",1,16)); 
     // bCW2.setFont(new Font("Impact",1,16)); 
      // bCW3.setFont(new Font("Impact",1,16));
       // bCW4.setFont(new Font("Impact",1,16)); 
       // bCW5.setFont(new Font("Impact",1,16)); 
      bSouth.setFont(new Font("Impact",1,16));   
       bSouth2.setFont(new Font("Impact",1,16));
        bSouth3.setFont(new Font("Impact",1,16));
         bSouth4.setFont(new Font("Impact",1,16)); 
         bSouth5.setFont(new Font("Impact",1,16)); 
      bNorth.setFont(new Font("Impact",1,16));  
      bNorth2.setFont(new Font("Impact",1,16));
       bNorth3.setFont(new Font("Impact",1,16));
         bNorth4.setFont(new Font("Impact",1,16)); 
         bNorth5.setFont(new Font("Impact",1,16)); 
      bPlayAgain.setFont(new Font("Impact",1,16));      
      
   }
   
   @Override
   public void actions(Object source,String command)
   {
 
  
    if (source == bCivilWar)
      {   civilwar(); }
      if (source == bNorth)
      {  north();   }
      if (source == bSouth)
      {  south();  }
   //   if (source == bCW)
    //  {  cw();  }
    if (source == bNorth2)
      {  north2(); }
       if (source == bCivilWar2)
      {   civilwar2(); }
       if (source == bSouth2)
      {  south2();  }
    //  if (source == bCW2)
    //  {  cw2();  }
      if (source == bCivilWar3)
      {   civilwar3(); }
      if (source == bNorth3)
      {  north3();   }
      if (source == bSouth3)
      {  south3();  }
   //   if (source == bCW3)
    //  {  cw3();  }
    if (source == bCivilWar4)
      {   civilwar4(); }
      if (source == bNorth4)
      {  north4();   }
      if (source == bSouth4)
      {  south4();  }
   //   if (source == bCW4)
    //  {  cw4();  }
    if (source == bCivilWar5)
      {   civilwar5(); }
      if (source == bNorth5)
      {  north5();   }
      if (source == bSouth5)
      {  south5();  }
   //   if (source == bCW5)
    //  {  cw5();  }
      if (source == bPlayAgain)
      {  
         bCivilWar.setEnabled(true);
         bSouth.setEnabled(true);
         bNorth.setEnabled(true);
        // bCW.setEnabled(true);
         score = 0;
      }   
      tScore.setText(score + "");
   }
  
  
    public void civilwar()
   {
      String guess = inputString("What caused the  new ideas of temperance and population growth in politics?");
      if (guess.equals("The major political parties refusal to lead."))
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong..." ); 
      }      

      bCivilWar.setEnabled(false);
   }
  
  
     public void north()
   {
      String guess = inputString("The northerners attempted to gain power as much political power need to control the spread of what?");
      if (
          guess.equalsIgnoreCase("slavery") 
          
         )   
      {
         score = score + 100;
         output("Right!");  
      }


      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bNorth.setEnabled(false);
   }

   
   
  
    public void south()
   {
      String guess = inputString("The confederate�s main goal was to ?");
      if (guess.equalsIgnoreCase("protect there right  to own slaves") )
          
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong... "); 
      }      
      bSouth.setEnabled(false);
   }
   
 /*  
   public void cw()
   {
      int guess = inputInt("The elected President made an empties on stopping,what?");
      if(guess.equalsIgnoreCase("the spreads of slavery.") )
          
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bCW.setEnabled(false);
   }
   */
  
  
   public void north2()
   {
      String guess = inputString("Michigan's ____ used popular sovereignty as a way to stop slavery in the north.?");
      if  ( guess.equalsIgnoreCase(" Lewis Cass") )
          
      {
         score = score + 200;
         output("Right!");  
      }
      else
      {  
         score = score - 200;         
         output("Wrong... " ); 
      }      
      bNorth2.setEnabled(false);
   }
   
  
 public void civilwar2()
   {
      String guess = inputString("When the Kansas-Nebraska act was signed the politicians from the north lost, what?");
      if
       ( guess.equalsIgnoreCase("communication with the  popular concept") )
          
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong..." ); 
      }      

      bCivilWar2.setEnabled(false);
   }
  public void south2()
   {
      String guess = inputString("Southern encouraged the other southerners to leave and join the confederate.?");
      if  ( guess.equalsIgnoreCase("leave and join the confederate.") )//leave and join the confederate.
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong... "); 
      }      
      bSouth2.setEnabled(false);
   }
  /*     public void cw2()
   {
      int guess = inputInt("The nation was political balanced because the north was________ and the south _____.?");
      if  ( guess.equalsIgnoreCase("republican and  democrats") )//leave and join the confederate.
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bCW2.setEnabled(false);
   } 
   */
  
   public void civilwar3()
   {
      String guess = inputString("The Civil War was based on what and was a way Americans expressed themselves.");
      if (guess.equals("politics"))
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong..." ); 
      }      

      bCivilWar3.setEnabled(false);
   }
     public void north3()
   {
      String guess = inputString("_________ were created in parts of the north. ?");
      if (
          guess.equalsIgnoreCase("Anti- Democrats") 
          
         ) 
      {
         score = score + 100;
         output("Right!");  
      }


      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bNorth3.setEnabled(false);
   }
   public void south3()
   {
     String guess = inputString("The south wanted to reach high than the U.S. ?");
      if  ( guess.equalsIgnoreCase("Policy") )//leave and join the confederate.
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong... "); 
      }      
      bSouth3.setEnabled(false);
   }
   /*  
   public void cw3()
   {
      int guess = inputInt("Conservative republicans didn't care about winning more than magnanimous with the  ?");
      if  ( guess.equalsIgnoreCase("rebels") )//
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bCW3.setEnabled(false);
   }
   */
    public void civilwar4()
   {
      String guess = inputString("What was passed a law that the federal tariff in 1832 to void, because he felt it gave the north an advantage. ");
      if (guess.equals("Nullification "))
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong..." ); 
      }      

      bCivilWar4.setEnabled(false);
   }
    public void north4()
   {
      String guess = inputString("___________ thought slavery should end and were passing laws to support this.");
      if (
          guess.equalsIgnoreCase("Radical Republicans") 
         
         )   
      {
         score = score + 100;
         output("Right!");  
      }


      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bNorth4.setEnabled(false);
   }
 public void south4()
   {
      String guess = inputString("Southern councils allowed native-born _______ to became part of the Know Nothing lodges?");
      if (
          guess.equalsIgnoreCase("Catholics") 
          
         )   
      {
         score = score + 100;
         output("Right!");  
      }


      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bSouth4.setEnabled(false);
   }
 /*  
   public void cw4()
   {
      int guess = inputInt("Also _______ used politics as a way to cope with differences. ?");
      if  ( guess.equalsIgnoreCase("Americans") )
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bCW4.setEnabled(false);
   }
   */
   public void civilwar5()
   {
      String guess = inputString("What,was  the basis of the Constitution was written by Thomas Jefferson and James Madison for the doctrine of succession on the disagreement of the states decide.");
      if (guess.equals("state's rights"))
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong..." ); 
      }      

      bCivilWar5.setEnabled(false);
   }
    public void north5()
   {
      String guess = inputString("Most of the northerners KnOw Nothing  about the extra amount  of slaveries to the repeal of the?");
      if (
          guess.equalsIgnoreCase(" Kansas Nebraska Act") 
         
         )   
      {
         score = score + 100;
         output("Right!");  
      }


      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bNorth5.setEnabled(false);
   }
 public void south5()
   {
      String guess = inputString("What two  states used an idea that states had the final decisions best for the people.?");
      if (
          guess.equalsIgnoreCase("Virginia and Kentucky") 
          
         )   
      {
         score = score + 100;
         output("Right!");  
      }


      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bSouth4.setEnabled(false);
   }
 /*  
   public void cw5()
   {
      int guess = inputInt("Peace ________ believe that the U.S shouldn't fight one another and believed slavery should be continued. ?");
      if  ( guess.equalsIgnoreCase("democrats") )
      {
         score = score + 100;
         output("Right!");  
      }
      else
      {  
         score = score - 100;         
         output("Wrong..."); 
      }      
      bCW5.setEnabled(false);
   }
   */
  
}
