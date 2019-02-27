package plainParser;





import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;



public class plainParser {
    

    
    public static HashMap<String, String> parser_Filename (String path) throws FileNotFoundException, IOException {
        
    /* 
        metadataTable contains a key and value respectfully
        The key will be the name of the metadata we need such as:
            (In this order according the the metadata sheet)
            - Title
            - Keywords
            - DOI
            - Abstract
            - Publication
            - Volume Number
            - Issue Number
            - First Page (if applicable)
            - Last Page (if applicable)
            - Publication Date
        
        The value is the data we're parsing
    */
        HashMap<String, String> metadataTable = new HashMap<>();
        
        BufferedReader br = new BufferedReader(new FileReader(path));
        
        // Used to read the current line in the file
        String line = "NULL";
        String authors = "NULL";
        String title = "NULL";
        String pub = "NULL";
        String vol = "NULL";
        String date = "NULL";
        String pages = "NULL";
        String issNo = "NULL";
        String doi = "NULL";
        String url = "NULL";
        String ab = "NULL";
        String keywords = "NULL";
        int i = 0;       		
        
        
        //Sanchita Mal-Sarkar, Iftikhar U. Sikder, Vijay K. Konangi,
        //Spatio-temporal Pattern discovery in sensor data: A multivalued decision systems approach,
        //Knowledge-Based Systems,
        //Volume 109,
        //2016,
        //Pages 137-146,
        //ISSN 0950-7051,
        //https://doi.org/10.1016/j.knosys.2016.06.032.
        //(http://www.sciencedirect.com/science/article/pii/S0950705116302039)
        //Abstract: Discovering novel and interesting spatio-temporal patterns in sensor data is a major challenge in many scientific domains. Such data are often continuous, unbounded, and associated with high speed, time-variant distribution with local and spatial trends. This paper presents a formalism that includes an extension of classical rough set inference mechanism to reason with space-time variant data streams. The concept of multivalued decision systems has been used to account for multiple patterns in a single time window or snapshot. Such patterns or templates are incorporated in rough set-based rule induction process. A framework for sensor data integration is illustrated by using a space-time clustering mechanism followed by the generation of templates and local rules from such clusters. The multivalued decision system allows mining complex multiple patterns instead of a single value in a given template without requiring complex feature transformation. It also allows us to quantify and estimate potential data compression and associated uncertainty parameters. Finally, the results are validated and compared with other related algorithms. In general, the framework will help us understand the underlying reasoning mechanism about the “part and whole” or spatio-temporal mereological relationship without sacrificing the semantics of the sensor data attributes.
        //Keywords: Spatio-temporal pattern; Multi-valued decision system
        
        // Loops continues until it reaches the end of the file
        // I do not think the while loop is needed
 
        while((line = br.readLine()) != null) {
            /*
             Read each line and place it into each category,
             the integer i is used to identify which line you are on
            */
            // just in case there is an empty line
        	if (line.trim().equals(""))
                continue;            
        	if (i == 1) {
        		title = line;
        		i++;
        	}
        	else if (i == 2) {
        		pub = line;
        		i++;
        	}
          	else if (i == 3) {
        		vol = line;
        		i++;
        	}
        	else if (i == 4) {
        		date = line;
        		i++;
        	}
          	else if (i == 5) {
        		pages = line;
        		i++;
        	}
          	else if (i == 6) {
        		issNo = line;
        		i++;
        	}
          	else if (i == 7) {
        		doi = line;
        		i++;
        	}
          	else if (i == 8) {
        		url = line;
        		i++;
        	}
          	else if (i == 9) {
        		ab = line;
        		i++;
        	}
          	else if (i == 10) {
        		keywords = line;
        		i++;
        	}
          	else {
        		authors = line;
        		i++;
            }
        }
        
    
        
        metadataTable.put("Title", title);
        metadataTable.put("Keywords", keywords);
        metadataTable.put("DOI", doi);
        metadataTable.put("Abstract", ab);
        metadataTable.put("Publication", pub);
        metadataTable.put("Volume Number", vol);
        metadataTable.put("Issue Number", issNo);
        metadataTable.put("Pages", pages);
        metadataTable.put("Publication Date", date);
        
        return metadataTable;
}
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the filename?");
        
        // Reads the file inputed by user
        String input = in.nextLine();
        
        /*      --- Example ---
            "What is the filename?"
            ThermalFluids_Article.ris
        */
        
        // Calls parser function
        parser_Filename(input);
        
        System.out.println(input + " has been parsed.");
    }
}
