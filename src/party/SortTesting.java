package party;

/**
* <h1>Sort Test!</h1>
*
*<p>
* @author  Natig Hasanov
* @version 1.4
* @since   2014-10-05 

*/









import java.io.*;
import org.apache.log4j.Logger;
import java.util.Properties;
import java.io.IOException;
import java.util.Enumeration;



/**
 *  The SortTest Class  implements an application that
* simply sorts given arguments to the standard output.
 * @author Natig Hasanov
 *
 */
public class SortTesting {
	
    
	
	private static  Logger logger = Logger.getLogger(SortTesting.class);
	
	
	
	
	
	
	/**
	 * Sort takes two arguments array and size of array
	 * @param a : array
	 * @param size : array size
	 * @return nothing
	 */
    public static void sort(int a[], int size) {
   	logger.debug("Array is ready to be sorted");
        for (int i = 1; i < size; i++) {
          
            int x = a[i];
            int j;
            
            for (j = i-1; j >=0; --j) {
                if (a[j] <= x)
                    break;
                a[j+1] = a[j];
            }
           
            a[j+1] = x;
        }
    }

    /** 
     * Test program to test sort 
     * Reading from .properties file.Sorting it and output sorted result
     * @param argv : takes path(location) of .properties file as an argument/(changed)
    
     */
    public static void main(String argv[]) {
    	
	
    	
    	try {
    		logger.info("Reading arguments from .properties file");
			File file = new File("config/inputs.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			
	
			
			
			Enumeration enuKeys = properties.keys();
			logger.warn("Attention : Enumeration is raw type");
		    int elem_size = properties.size();
		    int test[] = new int[elem_size];
		    int iter = 0;
		    logger.info("Key-value pairs in .properties file are converted to an integer type array");
			while (enuKeys.hasMoreElements()) {
				
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				test[iter]= Integer.parseInt(value);
				iter++;
			}
			
			
		        logger.info("Sorting is starting");
		        sort(test, elem_size);
		        logger.info("Sorting is finished");
		        
		        
		        System.out.println("Sort result :");
		        for (int i = 0; i < elem_size; i++)
		            System.out.print(" " + test[i]);
		        System.out.println();
		        
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error("File Not Found", e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("IO exception occured", e);
			
		}
	
    	 logger.info("FINISHED!");
    	 System.exit(0);
    	 }
    	  
    }
