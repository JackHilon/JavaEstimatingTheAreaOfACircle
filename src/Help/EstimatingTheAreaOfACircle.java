
package help;

import java.util.ArrayList;
import java.util.Scanner;


public class EstimatingTheAreaOfACircle {
    
    
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
        double res =Math.PI*radius*radius;
        return res;
    }
    
    private static Object[] Get3Numbers(Scanner input)
    {
        Object[] result=new Object[3];
       
            String str=input.nextLine();
            String[] strArray=str.split(" ",3);

            double number1=Double.parseDouble(strArray[0]);
            
            int number2=Integer.parseInt(strArray[1]);
            
            int number3=Integer.parseInt(strArray[2]);
            
            result[0]=number1;
            result[1]=number2;
            result[2]=number3;
            
            return result;
    }
    
    private static void PrintArrayList(ArrayList<double[]> list)
    {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
        }
    }
}


