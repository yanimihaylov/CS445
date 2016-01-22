import java.util.*;
import java.text.*;
public class dateTest{
	
	public static void main(String[] args){

		Date date = new Date();
 
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		 
        String testDateString = "02/04/2014";
        Date d2 = new Date();

       try
       {
           Date d1 = df.parse(testDateString);

           df.format(d1);
           String t = df.format(d2);
           System.out.println(d1.getYear());


       }

       catch (Exception ex ){
          System.out.println(ex);
       }
    }
}
