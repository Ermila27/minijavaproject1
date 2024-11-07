 package com.code;
 import java.util.*;
 abstract class Currency {
     int age;
    private double usdtBuying;//data hiding 
    private double usdtselling;
    private double eurobuying ;
    private double euroselling ; 
    Currency( double usb,double uss,double eurb,double eurs){
       this.usdtBuying=usb;
       this.usdtselling=uss;
       this.eurobuying=eurb;
       this.euroselling=eurs;
    }
    // it is recommended to use non parametrizd constructer if another class extend it 
    Currency(){
   
    }
    // abstract metod they define in child class
   public   abstract void birrTousdt();
   public abstract void usdtTobirrr();
    public abstract void euroTobirr();
    
     // getter and setter method private variable 
      public double getUsdtbuying(){
     return  this.usdtBuying;
      }
      public double getEurobuying(){
       return this.eurobuying;
      }
      public double getUsdtselling(){
      return this.usdtselling;
      }
      public double getEuroselling(){
      return this.euroselling;
      }
      public void setUsdtbuying(double get){
       this.usdtBuying=get;
      }
      public void setEurobuying(double get){
       this.eurobuying=get;
      }
      public void setUsdtselling(double get){
       this.usdtselling=get;
      }
      public void seteEuroselling(double get){
       this.euroselling=get;
      }
   }

  public class App extends Currency{
    
    App(double usb, double uss, double eurb, double eurs) {
        super(usb, uss, eurb, eurs);
        /*TODO Auto-generated constructor stub it is suitable to provide
         * todays buying and selling pirce 
        */
    }
    App(){
        
    }
    double usdt=1;
    double birr=1;
    double euro=1;
    Scanner in=new Scanner(System.in);
    double conversionRateOfBirr[]={0.01,1.0};//to convert usdt 1birr=0.01 dollar
    double conversionRateOfUsdt[]={100,50.3};//to convert birr 1 dollar=100birr
    double conversionRateOfEuro[]={ 150.88,50.4};//TO BIRR

    public static void main(String[] args) throws Exception {
     App.menu();   //calling menu function 
    }
  
   // this the first method birr to usd//

    public void birrTousdt(){
    char choice;//variable for to give chance run again this fun
    double result; // variable it contain final result 
    boolean flag=true; //to exit condition from loop
    int selectedRate=0; //variable to carry userselected rate

    do {
        try {
           
            System.out.println("enter amount in BIRR [ETH] to exit (0)" );
            birr=in.nextDouble(); 
            flag=false; //there is no exception so dont want to continue this loop
         if (birr==0) {
            System.out.println("\" (((BYE BYE BYE*!!!!))) \"  ");
            System.exit(0); 
         } 
        
       // this is do while loop to get rate of currency if use enter invalid input it ask again
     
        boolean flag2=true; //for while loop exit condition to get rate 
        System.out.println("choose current minizare to exit +(0)");
            for(int i=0;i<conversionRateOfBirr.length;i++){
         System.out.print(i+1+", "+"["+conversionRateOfBirr[i]+" ]"+"   ");
     
            }//display all rateof conoversion birr to usdt
            System.out.print(" :");
// while loop to get minzare value
            while (flag2) {
        try {   
            selectedRate=in.nextInt();
            if(selectedRate==0) System.exit(0);//out from the program
           if(selectedRate>conversionRateOfBirr.length|| selectedRate<1){
            System.out.println(" wrong choice !there is only :"+conversionRateOfBirr.length+"  minzaree for today to [exit (0)]");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            continue;
           }else flag2=false;
           
           } catch (InputMismatchException e) {
            in.nextLine();
            System.out.println("please select only (NO) from from the avaliabele minzare to exit (0)");
            System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");
            continue; // if there is any input missmatch exception ask again user to enter expected input
           }   
       }
        } catch (InputMismatchException e) {
            in.nextLine();//clean up 
            System.out.println(" INVALID INPUT ONLY NUMBER AVALIABLE  ");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            continue; //exception in outer loop occur continue ask again 
        }
        result=birr*conversionRateOfBirr[selectedRate-1]; // (logic part if rate and amount are get now convert it )
    
        System.out.println((int)birr +" birr is :" +result+" USDT($) [RATE is "+conversionRateOfBirr[selectedRate-1] );
        System.out.print(" do you have anothe amount(y/n)"); 
        System.out.print("??????????");//for other input  
        choice=in.next().charAt(0);
         if (choice=='y') {
          flag=true; //RUN agin dowhile loop if user have another amount to convert
         }
         else System.out.println("THANKS FOR SERVICE");
         
    } while (flag);
   
in.close();
     }

        // method  usdt to birr;
     public void usdtTobirrr(){
        double result; 
        boolean flag=true;
        char choice;
        int selectedRate=0;
        do {
            try {
               
                System.out.println("enter amount in of USDT to exit (0)" );
                usdt=in.nextDouble();
                flag=false; //for outer looop
             if (usdt==0) {
                System.out.println("(((BYE BYE BYE*!!!!)))");
                System.exit(0); 
             } 
            
           // this is  while loop to get rate of currency if use enter invalid input it ask again
         
            boolean flag2=true; //for while loop exit condition
            System.out.println("choose current minizare to exit +(0)");
                for(int i=0;i<conversionRateOfUsdt.length;i++){
             System.out.print(i+1+", "+"["+conversionRateOfUsdt[i]+"]"+"   ");
         
                }
    
                while (flag2) {
            try {   
                selectedRate=in.nextInt();
                if(selectedRate==0) System.exit(0);
               if(selectedRate>conversionRateOfUsdt.length|| selectedRate<1){
                System.out.println(" wrong choice !there is only :"+conversionRateOfUsdt.length+"  minzaree for today to exit (0)");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
                continue;
               }else flag2=false;
               
               } catch (InputMismatchException e) {
                in.nextLine();
                System.out.println("please select only no from from the avaliabele minzare to exit (0)");
                continue;
               }   
           }
            } catch (Exception e) {
                in.nextLine();//clean up
                System.out.println(" INVALID INPUT ONLY NUMBER AVALIABLE  ");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                continue;
            }
            setUsdtbuying(conversionRateOfUsdt[selectedRate-1]-1);//setting buying price for usdt
            setUsdtselling(conversionRateOfUsdt[selectedRate-1]);//detting of selling price of usdt
            result=usdt*conversionRateOfUsdt[selectedRate-1];
        
        
            System.out.println((int)usdt +" usdt is :" +result+" [RATE is :"+conversionRateOfUsdt[selectedRate-1] +"]");
            System.out.println(" do you have anothe amount(y/n)");
            System.out.print("??????????");
            choice=in.next().charAt(0);
             if (choice=='y') {
               flag=true; 
             }
             else System.out.println("THANKS BLA BLA");
        } while (flag);
       
    
         }  
       static   public void menu(){
            /*
             * we crete app object and possible to pass buying and selling price to super class 
             * explicitly currencyfor all ;
             * usb=usdt buuying price 
             * uss =usdt selling price
             * eurb=euro buying price 
             * eurs=euro selling price 
             * we also chnge it by setter method
             * they are pivate 
             */

            App obj=new App();
            Scanner in=new Scanner(System.in);
            int choice;

            System.out.println("::::::::::::::::::::::::::::::::::::::::::::");
        

            do {
                System.out.println("WELCOME TO CURRENCY CONVERTER PLEASE SELECT SERVICES");

                System.out.println(" 1 TO SEE currency PAIR TABLE\n 2:USDT($) TO BIRR(ETH) \n 3:BIRR(ETH) TO USDT($) \n 4:EURO TO BIRR" + //
                                        " \n 5 TO SEE TODAYS BUYING AND SELLING PIRCE \n 0:TO *EXIT*");
                                        
             System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
                try {
                    choice=in.nextInt();
                   
                    switch (choice) {
                        case 0:System.out.println("terminated !!!!");System.exit(0);break;
                        case 1:
        
                           obj.showCurrencyTable();
                           System.out.println(" to exit the program(0)  go to home any character ");
                           try {
                            int h=in.nextInt();
                            if (h==0) {
                             System.out.println("!!!!Terminated\n ~~~~~~~~~~~~~~~~~~~~~");
                             System.exit(0);
                            }

                           } catch (InputMismatchException e) {
                            // TODO: handle exception
                            in.nextLine();
                            continue;
                           }
                         
                            break;
                    case 2:obj.usdtTobirrr();break;
                    case 3:obj.birrTousdt();break;
                    case 4:obj.euroTobirr();
                    case 5:obj.todays();
                    System.out.println(" to exit the program(0)  go to home any character ");
                    try {
                     int h2=in.nextInt();
                     if (h2==0) {
                      System.out.println("!!!!Terminated\n ~~~~~~~~~~~~~~~~~~~~~");
                      System.exit(0);
                     }

                    } catch (InputMismatchException e) {
                     // TODO: handle exception
                     in.nextLine();
                     continue;
                    }
                  
                    break;
                        default:
                             System.out.println("~~~~~~~~~~~~~"); 
                            System.out.println("out of  valid service");
                            System.out.println("~~~~~~~~~~~~~~~");
                    }
        
                } catch (InputMismatchException e) {
                    // TODO: handle exception
                    in.nextLine();
                    System.out.println("invalid input Number EXPECTED  ");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    continue;
                }
            } while (true);
   
        
         }
         // functiion to show pair of currency 
         public void showCurrencyTable(){
            System.out.println("           THIS IS CURRENCY PAIR TABLE");
             System.out.println("  *[ETH/USD PAIR]   -------------------------------------------------------- ");
            for(int i=0;i<conversionRateOfBirr.length;i++){
                System.out.println(i+1+",                   1 ETH=="+conversionRateOfBirr[i]+"USDT");
                
            }
             System.out.println( "  [USD/ETH PAIR]  ----------------------------------------------------------");
             for(int i=0;i<conversionRateOfUsdt.length;i++){
                if(i==0){
                 System.out.println(i+1+",                   1 USDT =="+conversionRateOfUsdt[i]+"ETH {be BLACK}");
                }
                if(i==1){
                 System.out.println(i+1+",                   1 USDT =="+conversionRateOfUsdt[i]+"ETH {be BANK}");
                    }

             }
             System.out.println(" [EUR/BIRR PAIR] -----------------------------------------------------------");
           for(int i=0;i<conversionRateOfEuro.length;i++){
                 System.out.println(i+1+",                   1 EUR== "+conversionRateOfEuro[i] +"ETH "    );
           }
             System.out.println("                 -------------------------------------------------------");

         }

           // this 3rd function euro to birr;
          public strictfp void  euroTobirr(){
          double result;
          char choice;
          boolean flag=true;
          int selectedRate=0;
        
            do {
                try {
                   
                    System.out.println("enter amount in of EURO to exit (0)" );
                   euro =in.nextDouble();
                    flag=false; //for outer looop
                 if (euro==0) {
                    System.out.println(" (((BYE BYE BYE*!!!!))) ");

                    System.exit(0); 
                 } 
                
               // this is  while loop to get rate of currency if use enter invalid input it ask again
             
                boolean flag2=true; //for while loop exit condition
                System.out.println("choose current minizare to exit +(0)");
                    for(int i=0;i<conversionRateOfEuro.length;i++){
                 System.out.print(i+1+", "+"["+conversionRateOfEuro[i]+"]"+"  ");
             
                    }
                System.out.print(":");
                    while (flag2) {
                try {   
                    selectedRate=in.nextInt();
                    if(selectedRate==0) System.exit(0);
                   if(selectedRate>conversionRateOfEuro.length|| selectedRate<1){
                    System.out.println(" wrong choice !there is only :"+conversionRateOfEuro.length+"  minzaree for today to exit (0)");
                    continue;
                   }else flag2=false;// user enter correct choice exit loop 
                   
                   } catch (InputMismatchException e) {
                    in.nextLine();
                    System.out.println("please select only no from from the avaliabele minzare to exit (0)");
                    continue;
                   }   
               }
                } catch (InputMismatchException e) {
                    in.nextLine();//clean up
                    System.out.println(" INVALID INPUT ONLY NUMBER AVALIABLE  ");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    continue;
                }
                setEurobuying(conversionRateOfEuro[selectedRate-1]-1);
                seteEuroselling(conversionRateOfEuro[selectedRate-1]);
                result=euro*conversionRateOfEuro[selectedRate-1];
            
                System.out.println((int)euro +" EURO is :" +result+" BIRR [RATE is :"+conversionRateOfEuro[selectedRate-1] +"]");
                System.out.print(" do you have anothe amount(y/n)?");
                System.out.print("??::");
                choice=in.next().charAt(0);
                 if (choice=='y') {
                   flag=true; 
                 }
            } while (flag);
          }
          /*THIS FUNCTION provide buying and selling informaton about different currencies */
          public void todays(){
            // setEurobuying(148);
            // setUsdtbuying(98);
            // seteEuroselling(150);
            // setUsdtselling(100);
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("              ^THIS IS TODAYS CURRENCY PRICE ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.println("         [* BUYING *]              [*SELLING*]");
            System.out.println(" 1 USDT "+"       "+getUsdtbuying()+"                     "+getUsdtselling()); 
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" 2 EURO"+"        "+getEurobuying()+"                    "+getEuroselling());
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("");
          }
     }

    



 
