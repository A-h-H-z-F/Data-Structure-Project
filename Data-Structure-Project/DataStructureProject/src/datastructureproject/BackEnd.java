package datastructureproject;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class BackEnd {

   public String Unique_Charecter = "!@$&_=|'{}[]%;.,`~\":?<>#٪،»؟«" ;

    public String Exam_is_Infix_Post_Pre = " - + * ^ / ";
    public String Phrase_Recognise_for_Stack = " - + * ^ /  ( ) ";
    public String Redy_Infix_for_Write = "";
    public String Redy_Prefix_for_Write = "";
    public String Redy_Infix_for_Draw = "";
    public String Redy_Prefix_for_Draw = "";
    public String Last_Postfix= "";

    public BackEnd(String Phrase_Logged) throws InterruptedException {
        

        HashMap<String, Integer> Like_Dectionery_Python = new HashMap<>();
        HashMap<String, String> for_Use_Unique_Charecter = new HashMap<>();


        HashMap_Java(Like_Dectionery_Python);

    //    sleep(5000);

        Phrase_is_Infix_Post_Pre( Phrase_Logged, Like_Dectionery_Python ,for_Use_Unique_Charecter  );
        
    //    sleep(5000);
        
        new  Tree(Redy_Infix_for_Draw  , Redy_Prefix_for_Draw,Last_Postfix ,Redy_Infix_for_Write  , Redy_Prefix_for_Write,for_Use_Unique_Charecter );  

    }
    
    
    
    

    public void Phrase_is_Infix_Post_Pre(String Phrase_Logged, HashMap<String, Integer> Like_Dectionery_Python,HashMap<String, String> for_Use_Unique_Charecter) throws InterruptedException {

        if (Exam_is_Infix_Post_Pre.contains(Character.toString(Phrase_Logged.charAt(0)))) {
            System.out.println("prefix");
            
            sleep(1000);

            Convert_Prefix_To_Infix(Phrase_Logged, Like_Dectionery_Python);
            
            Convert_Infix_To_Postfix(Redy_Infix_for_Write, Like_Dectionery_Python);
            Convert_Infix_To_Prefix(Phrase_Logged, Like_Dectionery_Python,for_Use_Unique_Charecter);

            Redy_Prefix_for_Draw = Phrase_Logged;
           

        } else if (Exam_is_Infix_Post_Pre.contains(Character.toString(Phrase_Logged.charAt(Phrase_Logged.length() - 1)))) {
            System.out.println("postfix");
            
            sleep(1000);

            Convert_Postfix_To_Infix(Phrase_Logged, Like_Dectionery_Python);
              
            Convert_Infix_To_Prefix(Redy_Infix_for_Write, Like_Dectionery_Python,for_Use_Unique_Charecter);
                                
            System.out.println(Redy_Infix_for_Write);
                        System.out.println(654);
            
            Last_Postfix = Phrase_Logged;


        } else {

            System.out.println("infix");
            
            sleep(1000);

            Convert_Infix_To_Prefix(Phrase_Logged, Like_Dectionery_Python,for_Use_Unique_Charecter);
            Convert_Infix_To_Postfix(Phrase_Logged, Like_Dectionery_Python);
            Redy_Infix_for_Write = Phrase_Logged;
            
        }

    }
    
    
    
    

    public void Convert_Infix_To_Postfix(String Redy_to_Convert, HashMap<String, Integer> Like_Dectionery_Python) {

        
        
        
        String Converted_Phrase = "";

        Stack<String> Stack = new Stack<String>();

        for (int i = 0; i < Redy_to_Convert.length(); i++) {

            
                        System.out.println("-----------------------------------");
                        System.out.println(Stack);
                        System.out.println("Converted_Phrase = "+Converted_Phrase);
                        System.out.println(Character.toString(Redy_to_Convert.charAt(i)));
                        

                        
//            1:
            if (!Phrase_Recognise_for_Stack.contains(Character.toString(Redy_to_Convert.charAt(i))) ) {
                Converted_Phrase += Character.toString(Redy_to_Convert.charAt(i));} 
            
//            2:
            else if (   "(".equals(Character.toString(Redy_to_Convert.charAt(i)))) {
                Stack.push(Character.toString(Redy_to_Convert.charAt(i)));} 
            
//            3:
            else if (   ")".equals(Character.toString(Redy_to_Convert.charAt(i)))) {

                while (Stack.empty() || !"(".equals(Stack.peek())) {
                    Converted_Phrase += Stack.pop(); 
}

                if( "(".equals(Stack.peek())){
                         Stack.pop();
                }
            } 
            

//            4.:
            else if (Phrase_Recognise_for_Stack.contains(Character.toString(Redy_to_Convert.charAt(i))) ) {

//                    4.1:
                if (Stack.isEmpty() ) {

                    Stack.push(Character.toString(Redy_to_Convert.charAt(i)));} 
                
//                    4.2:
                else if (!Stack.isEmpty() ) {
                    
//                            4.2.1:
                    if (Like_Dectionery_Python.get(Character.toString(Redy_to_Convert.charAt(i))) > Like_Dectionery_Python.get(Stack.peek())) {
                        Stack.push(Character.toString(Redy_to_Convert.charAt(i)));} 
                    
//                            4.2.2:
                    else if ((Objects.equals(Like_Dectionery_Python.get(Character.toString(Redy_to_Convert.charAt(i))), Like_Dectionery_Python.get(Stack.peek()))) && ("^".equals(Character.toString(Redy_to_Convert.charAt(i)) ))) {
                        Stack.push(Character.toString(Redy_to_Convert.charAt(i)));} 
                    
//                             4.2.3:
                    else {

//                                          4.2.3.1:
                        while (!Stack.isEmpty()  && Like_Dectionery_Python.get(Character.toString(Redy_to_Convert.charAt(i))) <= Like_Dectionery_Python.get(Stack.peek())) {
                            Converted_Phrase += Stack.pop();}
                            
//                                          4.2.3.2:
                            Stack.push(Character.toString(Redy_to_Convert.charAt(i)));
                        
                    }

                }

            }
        }
        
        while (!Stack.isEmpty()){
        Converted_Phrase += Stack.pop(); }

 
        Last_Postfix=Converted_Phrase;
        
    }
    
    
    
    public void Convert_Infix_To_Prefix(String Redy_to_Convert, HashMap<String, Integer> Like_Dectionery_Python ,HashMap<String, String> for_Use_Unique_Charecter) {

        String Redy_to_Convert_Reversed = "" ;

        for (int i = Redy_to_Convert.length()-1 ; -1 < i; i--) {
            switch (Character.toString(Redy_to_Convert.charAt(i))) {
                case ")":
                    Redy_to_Convert_Reversed +="(";
                    break;
                case "(":
                    Redy_to_Convert_Reversed +=")";
                    break;
                default:
                    Redy_to_Convert_Reversed +=Character.toString(Redy_to_Convert.charAt(i));
                    break;
            }
        }

        Redy_Infix_for_Draw = Redy_to_Convert_Reversed;
        
        String Converted_Phrase = "";
        Stack<String> Stack = new Stack<String>();

        for (int i = 0; i < Redy_to_Convert.length(); i++) {
            
            System.out.println("-----------------------------------");
            System.out.println(Stack);
            System.out.println("Converted_Phrase = "+Converted_Phrase);
            System.out.println(Character.toString(Redy_to_Convert_Reversed.charAt(i)));
            System.out.println(Redy_to_Convert_Reversed);

            if (!Phrase_Recognise_for_Stack.contains(Character.toString(Redy_to_Convert_Reversed.charAt(i))) ) {
                Converted_Phrase += Character.toString(Redy_to_Convert_Reversed.charAt(i)); } 
            
            else if ("(".equals(Character.toString(Redy_to_Convert_Reversed.charAt(i)))) {
                Stack.push(Character.toString(Redy_to_Convert_Reversed.charAt(i)));}
            
            
            else if (")".equals(Character.toString(Redy_to_Convert_Reversed.charAt(i)))) {
                
                while (Stack.empty() || !"(".equals(Stack.peek())) {
                    
                    Converted_Phrase += Stack.pop(); }
                
                if( "(".equals(Stack.peek())){
                         Stack.pop();
                }
            } 
            
            else if (Phrase_Recognise_for_Stack.contains(Character.toString(Redy_to_Convert_Reversed.charAt(i))) == true) {
                
                if (Stack.isEmpty() ) {
                    Stack.push(Character.toString(Redy_to_Convert_Reversed.charAt(i)));} 
                
                else if (!Stack.isEmpty() ) {
                    
                    if (Like_Dectionery_Python.get(Character.toString(Redy_to_Convert_Reversed.charAt(i))) > Like_Dectionery_Python.get(Stack.peek())) {
                        Stack.push(Character.toString(Redy_to_Convert_Reversed.charAt(i))); } 
                    
                    else if ((Objects.equals(Like_Dectionery_Python.get(Character.toString(Redy_to_Convert_Reversed.charAt(i))), Like_Dectionery_Python.get(Stack.peek()))) && ("^".equals(Character.toString(Redy_to_Convert_Reversed.charAt(i))))) {
                        while ((Objects.equals(Like_Dectionery_Python.get(Character.toString(Redy_to_Convert_Reversed.charAt(i))), Like_Dectionery_Python.get(Stack.peek()))) && ("^".equals(Character.toString(Redy_to_Convert_Reversed.charAt(i))))) {
                            Converted_Phrase += Stack.pop(); }

                        Stack.push(Character.toString(Redy_to_Convert_Reversed.charAt(i))); } 
                    
                    
                    else if (Objects.equals(Like_Dectionery_Python.get(Character.toString(Redy_to_Convert_Reversed.charAt(i))), Like_Dectionery_Python.get(Stack.peek()))) {
                        Stack.push(Character.toString(Redy_to_Convert_Reversed.charAt(i)));} 
                    
                    else {

                        while (!Stack.isEmpty()  && Like_Dectionery_Python.get(Character.toString(Redy_to_Convert_Reversed.charAt(i))) <= Like_Dectionery_Python.get(Stack.peek())) {
                            Converted_Phrase += Stack.pop();}

                         Stack.push(Character.toString(Redy_to_Convert_Reversed.charAt(i)));
                        
                    }
                    
                }
            }
        }
        
        while (!Stack.isEmpty()){
                    System.out.println(123);

        Converted_Phrase += Stack.pop(); }
        
        Redy_Prefix_for_Draw = Converted_Phrase;
        
        // c-b-a
        //  --abc
        String Final_Convert_Reversed = new StringBuilder(Converted_Phrase).reverse().toString();
        
        Redy_Prefix_for_Write=Final_Convert_Reversed;
                
        
List<Integer> Save_Random_Number = new ArrayList<Integer>();
        
        for (int j = 0; j < Redy_to_Convert.length(); j++) {
            
              char Char = Converted_Phrase.charAt(j);
              int counts = 0;
              if("(".equals(Character.toString(Converted_Phrase.charAt(j))) || ")".equals(Character.toString(Converted_Phrase.charAt(j)))){continue;}
            for (int i = 0; i < Redy_to_Convert.length(); i++) {
                if (Converted_Phrase.charAt(i) == Char) {
                    counts++;}
                //فکر کنم این طوری یونیک میشن  
                if (1 < counts) {
                    
                    int Random_Number = (int)(Math.random()*(Unique_Charecter.length())+1);  
                    Save_Random_Number.add(Random_Number);
                    //
                    
                    for_Use_Unique_Charecter.put(Character.toString(Unique_Charecter.charAt(Random_Number)),Character.toString(Redy_Infix_for_Draw.charAt(j)) );
                   Redy_Infix_for_Draw= Redy_Infix_for_Draw.replace(Character.toString(Redy_Infix_for_Draw.charAt(j)), Character.toString(Unique_Charecter.charAt(Random_Number)))   ;
                   Unique_Charecter=  Unique_Charecter.replace(Character.toString(Unique_Charecter.charAt(Random_Number)), "");
                    
                }
            }
            
        }
        
        Unique_Charecter = "!@$&_=|'{}[]%;.,`~\":?<>#٪،»؟«" ;
        
        for (int j = 0; j < Redy_to_Convert.length(); j++) {
            
              char Char = Converted_Phrase.charAt(j);
              int counts = 0;
               if("(".equals(Character.toString(Converted_Phrase.charAt(j))) || ")".equals(Character.toString(Converted_Phrase.charAt(j)))){continue;}

            for (int i = 0; i < Redy_to_Convert.length(); i++) {
                if (Converted_Phrase.charAt(i) == Char) {
                    counts++;}
                //فکر کنم این طوری یونیک میشن  
                if (1 < counts) {
                                        
                   Redy_Prefix_for_Draw= Redy_Prefix_for_Draw.replace(Character.toString(Redy_Prefix_for_Draw.charAt(j)), Character.toString(Unique_Charecter.charAt(  Save_Random_Number.get(0))))   ;
                   Unique_Charecter=  Unique_Charecter.replace(Character.toString(Unique_Charecter.charAt(Save_Random_Number.get(0))), "");
                   Save_Random_Number.remove(0);
                    
                }
            }
            
            
        }
        
                 Redy_Prefix_for_Draw = new StringBuilder(Redy_Prefix_for_Draw).reverse().toString();
                 Redy_Infix_for_Draw = new StringBuilder(Redy_Infix_for_Draw).reverse().toString();

        

    }
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void Convert_Postfix_To_Infix(String Redy_to_Convert, HashMap<String, Integer> Like_Dectionery_Python) {

        String Converted_Phrase = "";

//              1:
        Stack<String> Stack = new Stack<String>();

//              2:
        for (int i = 0; i < Redy_to_Convert.length(); i++) {

//              2.1:
            if (Phrase_Recognise_for_Stack.contains(Character.toString(Redy_to_Convert.charAt(i))) == false) //                    2.1.1:       
                 {Stack.push(Character.toString(Redy_to_Convert.charAt(i)));}
            
//                    2.2:
            else if (Phrase_Recognise_for_Stack.contains(Character.toString(Redy_to_Convert.charAt(i))) == true) {

//                       2.2.1:   &   2.2.2:
                String First_Pop = Stack.pop();

//                      2.2.3:   &   2.2.4:
                String Second_Pop = Stack.pop();

//                      2.2.5:
                String Push_to_Stack = "(" + Second_Pop + Character.toString(Redy_to_Convert.charAt(i)) + First_Pop + ")";

//                      2.2.6:
                Stack.push(Push_to_Stack);

            }

        }
        Converted_Phrase = Stack.peek();
        Redy_Infix_for_Write = Converted_Phrase;

    }
    
    
    
    
    
    

    public void Convert_Prefix_To_Infix(String Redy_to_Convert, HashMap<String, Integer> Like_Dectionery_Python) {

        String Converted_Phrase = "";

//              1:
        Stack<String> Stack = new Stack<String>();

//              2:
        for (int i = Redy_to_Convert.length()-1 ; -1 < i; i--) {

//              2.1:
            if (!Phrase_Recognise_for_Stack.contains(Character.toString(Redy_to_Convert.charAt(i))) ) 

//                    2.1.1:       
              {Stack.push(Character.toString(Redy_to_Convert.charAt(i)));} 
            
//                    2.2:
            else if (Phrase_Recognise_for_Stack.contains(Character.toString(Redy_to_Convert.charAt(i)))) {

//                       2.2.1:   &   2.2.2:
                String First_Pop = Stack.pop();

//                      2.2.3:   &   2.2.4:
                String Second_Pop = Stack.pop();

//                      2.2.5:
                String Push_to_Stack = "(" + First_Pop + Character.toString(Redy_to_Convert.charAt(i)) + Second_Pop + ")";

//                      2.2.6:
                Stack.push(Push_to_Stack);

            }

        }
        Converted_Phrase = Stack.peek();
        Redy_Infix_for_Write =Converted_Phrase;
        
    }

    
    
    
    public void HashMap_Java(HashMap<String, Integer> Like_Dectionery_Python) {
        Like_Dectionery_Python.put("(", 0);
        Like_Dectionery_Python.put("+", 1);
        Like_Dectionery_Python.put("-", 1);
        Like_Dectionery_Python.put("*", 2);
        Like_Dectionery_Python.put("/", 2);
        Like_Dectionery_Python.put("^", 3);        
    }

}
