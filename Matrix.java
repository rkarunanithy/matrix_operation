public class Matrix{

	static String output = "";
     
     public static void main(String s[]){
     
          Integer[][] intMatrix = {
                    {
                       0,1,2,3,4,5
                    },
                    {
                       6,7,8,9,0,1
                    },
                    {
                       3,4,5,6,7,8
                    },
                    {
                       9,0,1,2,3,4
                    }
               };
               
           int totalElements = 0;
           int noOfRows = 0;
           for(Integer[] intMatrixEle : intMatrix){
        	   
           
                totalElements += intMatrixEle.length;
                noOfRows++;
           
           }
           
            int printedElements = 0;
            int noOfLayers = 0;
            
            while(printedElements < totalElements){

                 
   				 int processedElement = printLayerInClockWise(noOfRows,noOfLayers,intMatrix);
   				 
    			 printedElements = printedElements + processedElement;
    			 noOfLayers++;
    		}

            System.out.println(output);


      }

        
     
     
     
     
     private static int printLayerInClockWise(int rows,int layer, Integer[][] intMatrix){
    	   System.out.println("Inside printLayerInClockWise ");
           int cnt = 0;
           try{
           
        

        			String bottomStr = "",topStr = "",upwardStr = "",downwardStr = "";
        			String uLog = "",dLog="",tLog="",bLog="";
        			
        			
        			//Going ===> direction
        			//Going <=== direction 

        			int start = layer;
        			int end = intMatrix[layer].length - layer;
        				
        		    int rev_end = end-1;
        			
        			
        			
        		    
        		    String logStr = "Start is ["+start+"] End is ["+end+"] RevEnd["+rev_end+"]\n";
        		    log(logStr);

        			for(int ind=start; ind < end; ind++){

        				 int val = intMatrix[layer][ind];	
        				 tLog += "Top: Val "+val+" <= matrix["+layer+"]["+ind+"]\n";
        				 
        				 topStr += val+" "; 	
        				 
        				 cnt++;

        		         
        		         int bot_m_ind = rows - (layer + 1);
        		         
        				
        				 val = intMatrix[bot_m_ind][rev_end];
        				 bottomStr += val+" ";
        				 bLog += "Bottom : matrix["+bot_m_ind+"]["+rev_end+"]\n";
        				 cnt++;
        				 rev_end--;
        			}
        			
        			log(tLog);
        			log("\n");
        			log("\n");
        			log(bLog);
        			
        		    
        		 
        		    start =  layer + 1 ;
        		    end   =  rows - start;
        		    
        		    
        		    rev_end = end - 1;
        		    
        		    
        		    
        		    for(int ind = start; ind < end; ind++){
        		         
        		         
        		         int val = intMatrix[rev_end][layer];
        		         
        		         uLog += "Upward : End "+end+" Ind "+ind+" Value is "+val+" = matrix["+rev_end+"]["+layer+"]; \n";
        		         rev_end--;
        		         upwardStr += val+" ";
        		         cnt++;
        		         
        		         
        		         
        		         
        		         int last_ind = ( intMatrix[ind].length - 1 ) - layer;
        		         
        		         val = intMatrix[ind][last_ind];
        		         
        		         dLog += "Downward :  Value is "+val+" = matrix["+ind+"]["+last_ind+"]\n";
        		         downwardStr += val+" ";
        		         cnt++;
        		         
        		         
        		         
        		          
        		    }	    
        		    
        		    log(dLog);
        			log("\n");
        			log("\n");
        			log(uLog);
        		    
        			output += topStr+ downwardStr + bottomStr + upwardStr;
        		   
           
           }catch(Exception e){
           
              log(e.getMessage());
           }
           return cnt;
     
     }
     
     
     private static void log(String msg){
        // System.out.println(msg);
     }
     
     
    
    
    
    

}
