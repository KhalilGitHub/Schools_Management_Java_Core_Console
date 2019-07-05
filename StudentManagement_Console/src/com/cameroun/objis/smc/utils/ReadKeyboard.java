package com.cameroun.objis.smc.utils;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;




public class ReadKeyboard{

	
	static String myLine;
    static InputStreamReader is;
    static BufferedReader br;
    static StringTokenizer st;
 
   
     public ReadKeyboard(){}
 
     
 
     static {
         is = new InputStreamReader(System.in);
         br = new BufferedReader(is);
      }
     
     
  
     public static byte readByte(){
       byte byte0 = 0;
       try{
          myLine = br.readLine();
          st = new StringTokenizer(myLine);
          byte0 = Byte.parseByte(st.nextToken());
       }
       
           catch(IOException ioexception){
             System.out.println("Error reading keyboard byte type.\nHere is the error message from the system: " + ioexception + "\nPlease start again.");
             byte0 = readByte();
             
          }
          
           catch(NumberFormatException numberformatexception){
             System.out.println("Error reading keyboard integer.\nThe format of the number read does not seem to match \340 a type integer (byte).\nAllowed values: -128\340 127.\nSystem error message :" + numberformatexception + "\nPlease start again.");
             byte0 = readByte();
          }
          
           catch(NoSuchElementException nosuchelementexception){
             System.out.println("Error reading keyboard integer. You have only to tap on 'enter'.\nPlease start again.");
             byte0 = readByte();
          }
          
           catch(Exception exception){
             System.out.println("Error reading keyboard integer.\\nHere is the error message from the system :" + exception + "\nPlease start again.");
             byte0 = readByte();
          }
       return byte0;
    }
 
     public static short readShort(){
       short word0 = 0;
       try{
          myLine = br.readLine();
          st = new StringTokenizer(myLine);
          word0 = Short.parseShort(st.nextToken());
       }
       
           catch(IOException ioexception){
             System.out.println("Error reading keyboard short type.\\nHere is the error message from the system: " + ioexception + "\nPlease start again.");
             word0 = readShort();
          }
          
           catch(NumberFormatException numberformatexception){
               System.out.println("Error reading keyboard integer.\nThe format of the number read does not seem to match \340 a type integer (byte).\nAllowed values: -128\340 127.\nSystem error message :" + numberformatexception + "\nPlease start again.");
             word0 = readShort();
          }
          
           catch(NoSuchElementException nosuchelementexception){
               System.out.println("Error reading keyboard integer. You have only to tap on 'enter'.\nPlease start again.");
             word0 = readShort();
          }
          
           catch(Exception exception){
               System.out.println("Error reading keyboard integer.\\nHere is the error message from the system :" + exception + "\nPlease start again.");
             word0 = readShort();
          }
       return word0;
    }
 
     public static int readInt(){
       int i = 0;
       try{
          myLine = br.readLine();
          st = new StringTokenizer(myLine);
          i = Integer.parseInt(st.nextToken());
       }
       
           catch(IOException ioexception){
               System.out.println("Error reading keyboard integer type.\\nHere is the error message from the system: " + ioexception + "\nPlease start again.");
             i = readInt();
          }
          
           catch(NumberFormatException numberformatexception){
               System.out.println("Error reading keyboard integer.\nThe format of the number read does not seem to match \340 a type integer (byte).\nAllowed values: -128\340 127.\nSystem error message :" + numberformatexception + "\nPlease start again.");
             i = readInt();
          }
          
           catch(NoSuchElementException nosuchelementexception){
               System.out.println("Error reading keyboard integer. You have only to tap on 'enter'.\nPlease start again.");
             i = readInt();
          }
          
           catch(Exception exception){
               System.out.println("Error reading keyboard integer.\\nHere is the error message from the system :" + exception + "\nPlease start again.");
             i = readInt();
          }
       return i;
    }
 
     public static long readLong()
    {
       long l = 0L;
       try{
          myLine = br.readLine();
          st = new StringTokenizer(myLine);
          l = Long.parseLong(st.nextToken());
       }
       
           catch(IOException ioexception){
               System.out.println("Error reading keyboard long type.\\nHere is the error message from the system: " + ioexception + "\nPlease start again.");
             l = readLong();
          }
          
           catch(NumberFormatException numberformatexception){
               System.out.println("Error reading keyboard integer.\nThe format of the number read does not seem to match \340 a type integer (byte).\nAllowed values: -128\340 127.\nSystem error message :" + numberformatexception + "\nPlease start again.");
             l = readLong();
          }
          
           catch(NoSuchElementException nosuchelementexception)
          {
               System.out.println("Error reading keyboard integer. You have only to tap on 'enter'.\nPlease start again.");
             l = readLong();
          }
           catch(Exception exception){
               System.out.println("Error reading keyboard integer.\\nHere is the error message from the system :" + exception + "\nPlease start again.");
             l = readLong();
          }
       return l;
    }
 
     public static float readFloat(){
       float f = 0.0F;
       try{
          myLine = br.readLine();
          st = new StringTokenizer(myLine);
          f = Float.parseFloat(st.nextToken());
       }
       
           catch(IOException ioexception){
               System.out.println("Error reading keyboard float type.\\nHere is the error message from the system: " + ioexception + "\nPlease start again.");
             f = readFloat();
          }
          
           catch(NumberFormatException numberformatexception){
               System.out.println("Error reading keyboard integer.\nThe format of the number read does not seem to match \340 a type integer (byte).\nAllowed values: -128\340 127.\nSystem error message :" + numberformatexception + "\nPlease start again.");
             f = readFloat();
          }
          
           catch(NoSuchElementException nosuchelementexception){
               System.out.println("Error reading keyboard integer. You have only to tap on 'enter'.\nPlease start again.");
             f = readFloat();
          }
          
           catch(Exception exception){
               System.out.println("Error reading keyboard integer.\\nHere is the error message from the system :" + exception + "\nPlease start again.");
             f = readFloat();
          }
       return f;
    }
 
     public static double readDouble()
    {
       double d = 0.0D;
       try{
          myLine = br.readLine();
          st = new StringTokenizer(myLine);
          d = Double.parseDouble(st.nextToken());
       }
       
           catch(IOException ioexception){
               System.out.println("Error reading keyboard double type.\\nHere is the error message from the system: " + ioexception + "\nPlease start again.");
             d = readDouble();
          }
          
           catch(NumberFormatException numberformatexception){
               System.out.println("Error reading keyboard integer.\nThe format of the number read does not seem to match \340 a type integer (byte).\nAllowed values: -128\340 127.\nSystem error message :" + numberformatexception + "\nPlease start again.");
             d = readDouble();
          }
          
           catch(NoSuchElementException nosuchelementexception){
               System.out.println("Error reading keyboard double. You have only to tap on 'enter'.\nPlease start again.");
             d = readDouble();
          }
          
           catch(Exception exception){
               System.out.println("Error reading keyboard double.\\nHere is the error message from the system :" + exception + "\nPlease start again.");
             d = readDouble();
          }
       return d;
    }
 
     public static char readChar(){
       char c = ' ';
       try{
          myLine = br.readLine();
          if(myLine.length() == 0){
              System.out.println("Error reading keyboard double. You have only to tap on 'enter'.\nPlease start again.");
             c = readChar();
          }
          c = myLine.charAt(0);
       }
       
           catch(IOException ioexception){
               System.out.println("Error reading keyboard char type.\\nHere is the error message from the system: " + ioexception + "\nPlease start again.");
             c = readChar();
          }
          
           catch(StringIndexOutOfBoundsException stringindexoutofboundsexception){
             System.out.println("Erreur lors de la lecture du caract\350re au clavier.\nMessage d'erreur du syst\350me :" + stringindexoutofboundsexception + "\nVeuillez recommencer.");
             c = readChar();
          }
          
           catch(Exception exception){
               System.out.println("Error reading keyboard integer.\\nHere is the error message from the system :" + exception + "\nPlease start again.");
             c = readChar();
          }
       return c;
    }
 
     public static String readString(){
       try{
          myLine = br.readLine();
       }
       
           catch(IOException ioexception){
               System.out.println("Error reading keyboard String type.\\nHere is the error message from the system: " + ioexception + "\nPlease start again.");
             myLine = readString();
          }
          
           catch(Exception exception){
               System.out.println("Error reading keyboard integer.\\nHere is the error message from the system :" + exception + "\nPlease start again.");
             myLine = readString();
          }
       return myLine;
    }
     
     
     public static BigDecimal readBigDecimal(){
    	 
    	 int i = 0;
         try{
            myLine = br.readLine();
            st = new StringTokenizer(myLine);
            i = Integer.parseInt(st.nextToken());
         }
         
             catch(IOException ioexception){
                 System.out.println("Error reading keyboard integer type.\\nHere is the error message from the system: " + ioexception + "\nPlease start again.");
               i = readInt();
            }
            
             catch(NumberFormatException numberformatexception){
                 System.out.println("Error reading keyboard integer.\nThe format of the number read does not seem to match \340 a type integer (byte).\nAllowed values: -128\340 127.\nSystem error message :" + numberformatexception + "\nPlease start again.");
               i = readInt();
            }
            
             catch(NoSuchElementException nosuchelementexception){
                 System.out.println("Error reading keyboard integer. You have only to tap on 'enter'.\nPlease start again.");
               i = readInt();
            }
            
             catch(Exception exception){
                 System.out.println("Error reading keyboard integer.\\nHere is the error message from the system :" + exception + "\nPlease start again.");
               i = readInt();
            }
         BigDecimal j = new BigDecimal(i);
         return j;
      }
}