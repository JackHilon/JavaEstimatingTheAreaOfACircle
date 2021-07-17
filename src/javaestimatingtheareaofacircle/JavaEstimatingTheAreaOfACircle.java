
package javaestimatingtheareaofacircle;

import java.util.ArrayList;
//import java.util.InputMismatchException;
import java.util.Scanner;


public class JavaEstimatingTheAreaOfACircle {

    //==========================================================================
    // https://open.kattis.com/problems/estimatingtheareaofacircle
    // simple caculation program                                     ===========
    // Kattis error (compile error), but I think my program is right ===========
    //==========================================================================
    public static final double PI=Math.PI;
    
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
       
        ArrayList<double[]> outputs =new ArrayList<double[]>();
        Object[] temp=null;
        double[] oneResult=new double[2];
        
        
        while(true){
            
            temp= Get3Numbers(in);
            
            if(!CheckLine(temp))
                break;
            
            oneResult=TwoAreas(temp);
            
            outputs.add(oneResult);
            
        }// end while
        
        PrintArrayList(outputs);
        
    }
    private static boolean CheckLine(Object[] numbers)
    {
        double radius=(double)numbers[0];
        int totalP=(int) numbers[1];
        int circleP=(int) numbers[2];
        
        if(radius==0 &&  totalP==0 && circleP==0  )
            return false;
        else 
            return true;
    }
    
    private static double[] TwoAreas(Object[] numbers)
    {
        double radius=(double)numbers[0];
        int totalP=(int) numbers[1];
        int circleP=(int) numbers[2];
        
        double[] res=new double[2];
        res[0]=CircleTrueArea(radius);
        res[1]=CircleEstimatedArea(radius, totalP, circleP);
        return res;
    }
    
    private static double CircleEstimatedArea(double radius, int totalPoints, int circlePoints)
    {
        double estimated = (double) 4*radius*radius*circlePoints/(double) totalPoints;
        return estimated;
    }
    
    private static double CircleTrueArea(double radius)
    {
        double res =PI*radius*radius;
        return res;
    }
    
    private static Object[] Get3Numbers(Scanner input)
    {
        Object[] result=new Object[3];
        //try{
            
            String str=GetLine(input);
            String[] strArray=String2StringArray(str);
//            if(strArray.length!=3)
//                throw new InputMismatchException();
            
            double number1=GetDouble(strArray[0]);
//            if(number1<0 || number1>1000)    // delete (=) in number1<=0
//                throw new InputMismatchException();
                
            int number2=GetInteger(strArray[1]);
//            if(number2<0 || number2>100000)   // 0 <-- 1
//                throw new InputMismatchException();
            
            int number3=GetInteger(strArray[2]);
//            if(number3<0 || number3>number2)
//                throw new InputMismatchException();
            
            result[0]=number1;
            result[1]=number2;
            result[2]=number3;
            
            return result;
            
//        }catch(Exception e)
//        {
//            return Get3Numbers(input);
//        }
    }
    
    private static int GetInteger(String str) 
    {
        int res = 0;
        res = Integer.parseInt(str);
        return res;
    }
    
    private static double GetDouble(String str)
    {
        double res=Double.parseDouble(str);
        return res;
    }
    
    private static String[] String2StringArray(String str)
    {
        String[] res=str.split(" ", 3);
        return res;
    }
    
    private static String GetLine(Scanner input) 
    {
        String str = input.nextLine();
        return str;
    }
    private static void PrintArrayList(ArrayList<double[]> list)
    {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
        }
    }
}
