package seniorproject;

/*
This template serves as the basis for all our future parsers.
With the use of a hashmap, we can easily organize the parsed metadata
in a clean data structure.
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.swing.*;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ParserTemplate {

/* ### .RIS PARSER ### */
public static HashMap<String, String> risParser (String path) throws FileNotFoundException, IOException {
/* 
    metadataTable contains a key and value respecfully
    The key will be the name of the metadata we need such as:
        (In this order according the the metadata sheet)
        - Title
        - Keywords
        - DOI
        - Absract
        - Publication
        - Volume Number
        - Issue Number
        - First Page
        - Last Page
        - Publication Date
    
    The value is the data we're parsing
*/
    HashMap<String, String> metadataTable = new HashMap<>();
        
        BufferedReader br = new BufferedReader(new FileReader(path));
        
        // Used to read the current line in the file
        String line;
        String Key;
        String Map = "";
        int authors = 1;
        int temp = 0;
        
        // Loops continues until it reaches the end of the file
        while((line = br.readLine()) != null) {
            
            Key = line;
            String[] data = line.split(" ");
            Key = data[0];
            if(data.length > 3){
               Map = data[3];
            }
            for(int i = 4; i < data.length;i++){
               Map = Map + " " + data[i];
            }
            if(Key.equals("TY")){
               Key = "Type";
               if(data[3].equals("ABST")){
                  metadataTable.put(Key, "abstract");
               }
               if(data[3].equals("ADVS")){
                  metadataTable.put(Key, "audiovisual material");
               }
               if(data[3].equals("AGGR")){
                  metadataTable.put(Key, "aggregated database");
               }
               if(data[3].equals("ANCIENT")){
                  metadataTable.put(Key, "ancient text");
               }
               if(data[3].equals("ART")){
                  metadataTable.put(Key, "art work");
               }
               if(data[3].equals("BILL")){
                  metadataTable.put(Key, "bill");
               }
               if(data[3].equals("BLOG")){
                  metadataTable.put(Key, "BLOG");
               }
               if(data[3].equals("BOOK")){
                  metadataTable.put(Key, "whole book");
               }
               if(data[3].equals("CASE")){
                  metadataTable.put(Key, "case");
               }
               if(data[3].equals("CHAP")){
                  metadataTable.put(Key, "book chapter");
               }
               if(data[3].equals("CHART")){
                  metadataTable.put(Key, "chart");
               }
               if(data[3].equals("CLSWK")){
                  metadataTable.put(Key, "classical work");
               }
               if(data[3].equals("COMP")){
                  metadataTable.put(Key, "computer program");
               }
               if(data[3].equals("CONF")){
                  metadataTable.put(Key, "conference proceeding");
               }
               if(data[3].equals("CPAPER")){
                  metadataTable.put(Key, "conference paper");
               }
               if(data[3].equals("CTLG")){
                  metadataTable.put(Key, "catalog");
               }
               if(data[3].equals("DATA")){
                  metadataTable.put(Key, "data file");
               }
               if(data[3].equals("DBASE")){
                  metadataTable.put(Key, "online database");
               }
               if(data[3].equals("DICT")){
                  metadataTable.put(Key, "dictionary");
               }
               if(data[3].equals("EBOOK")){
                  metadataTable.put(Key, "electronic book");
               }
               if(data[3].equals("ECHAP")){
                  metadataTable.put(Key, "electronic book section");
               }
               if(data[3].equals("EDBOOK")){
                  metadataTable.put(Key, "edited book");
               }
               if(data[3].equals("EJOUR")){
                  metadataTable.put(Key, "electronic article");
               }
               if(data[3].equals("ELEC")){
                  metadataTable.put(Key, "web page");
               }
               if(data[3].equals("ENCYC")){
                  metadataTable.put(Key, "encyclopedia");
               }
               if(data[3].equals("EQUA")){
                  metadataTable.put(Key, "equation");
               }
               if(data[3].equals("FIGURE")){
                  metadataTable.put(Key, "figure");
               }
               if(data[3].equals("GEN")){
                  metadataTable.put(Key, "generic");
               }
               if(data[3].equals("GOVDOC")){
                  metadataTable.put(Key, "government document");
               }
               if(data[3].equals("GRANT")){
                  metadataTable.put(Key, "grant");
               }
               if(data[3].equals("HEAR")){
                  metadataTable.put(Key, "hearing");
               }
               if(data[3].equals("ICOMM")){
                  metadataTable.put(Key, "internet communication");
               }
               if(data[3].equals("INPR")){
                  metadataTable.put(Key, "in press");
               }
               if(data[3].equals("INPR")){
                  metadataTable.put(Key, "in press");
               }
               if(data[3].equals("JFULL")){
                  metadataTable.put(Key, "journal (full)");
               }
               if(data[3].equals("JOUR")){
                  metadataTable.put(Key, "journal");
               }
               if(data[3].equals("LEGAL")){
                  metadataTable.put(Key, "legal rule or regulation");
               }
               if(data[3].equals("MANSCPT")){
                  metadataTable.put(Key, "manuscript");
               }
               if(data[3].equals("MAP")){
                  metadataTable.put(Key, "map");
               }
               if(data[3].equals("MGZN")){
                  metadataTable.put(Key, "magazine article");
               }
               if(data[3].equals("MPCT")){
                  metadataTable.put(Key, "motion picture");
               }
               if(data[3].equals("MULTI")){
                  metadataTable.put(Key, "online multimedia");
               }
               if(data[3].equals("MUSIC")){
                  metadataTable.put(Key, "music score");
               }
               if(data[3].equals("NEWS")){
                  metadataTable.put(Key, "newspaperer");
               }
               if(data[3].equals("PAMP")){
                  metadataTable.put(Key, "pamphlet");
               }
               if(data[3].equals("PAT")){
                  metadataTable.put(Key, "patent");
               }
               if(data[3].equals("PCOMM")){
                  metadataTable.put(Key, "personal communication");
               }
               if(data[3].equals("RPRT")){
                  metadataTable.put(Key, "report");
               }
               if(data[3].equals("SER")){
                  metadataTable.put(Key, "serial publication");
               }
               if(data[3].equals("SLIDE")){
                  metadataTable.put(Key, "slide");
               }
               if(data[3].equals("SOUND")){
                  metadataTable.put(Key, "sound recording");
               }
               if(data[3].equals("STAND")){
                  metadataTable.put(Key, "standard");
               }
               if(data[3].equals("STAT")){
                  metadataTable.put(Key, "statute");
               }
               if(data[3].equals("THES")){
                  metadataTable.put(Key, "thesis/dissertation");
               }
               if(data[3].equals("UNPB")){
                  metadataTable.put(Key, "unpublished work");
               }
               if(data[3].equals("VIDEO")){
                  metadataTable.put(Key, "video recording");
               }
               
            }
            if(Key.equals("AU")){
               String[] name = Map.split(" ");
               if(name.length == 1){
                  metadataTable.put("author"+authors+"_lname", name[0]);
                  authors++;
               }
               if(name.length == 2){
                  if((name[0].charAt(name[0].length()-1))==(',')){
                     name[0] =  name[0].replace(",","");
                     metadataTable.put("author"+authors+"_lname", name[0]);
                     metadataTable.put("author"+authors+"_fname", name[1]);
                     authors++;
                  }
                  else{
                     metadataTable.put("author"+authors+"_fname", name[0]);
                     metadataTable.put("author"+authors+"_lname", name[1]);
                     authors++;
                  }
               }
               if(name.length > 2){
               
                  if((name[0].charAt(name[0].length()-1))==(',')){
                     name[0] =  name[0].replace(",","");
                     metadataTable.put("author"+authors+"_lname", name[0]);
                     metadataTable.put("author"+authors+"_fname", name[1]);
                     authors++;
                  } else {
                     metadataTable.put("author"+authors+"_fname", name[0]);
                     if (name[name.length -1].equals("Jr.")||name[name.length -1].equals("Sr.")){
                        metadataTable.put("author"+authors+"_suffix", name[name.length -1]);
                        metadataTable.put("author"+authors+"_lname", name[name.length -2]);
                     } else {
                        metadataTable.put("author"+authors+"_lname", name[name.length - 1]);
                     }
                     authors++;
               }
               }
           
            }
            if(Key.equals("PY")){Key = "publication_date";metadataTable.put(Key, Map);}
            if(Key.equals("KW")){
               Key = "Keywords";
               if (temp == 0) {
                  metadataTable.put(Key, Map);
                  temp++;
               } 
               else if(temp == 1) {
            		metadataTable.put(Key, metadataTable.get(Key) + ", " + Map);
               }
            }
            if(Key.equals("DA")){Key = "date";metadataTable.put(Key, Map);}
            if(Key.equals("TI")){Key = "Title";metadataTable.put(Key, Map);}
            if(Key.equals("JO")){Key = "source publication";metadataTable.put(Key, Map);}
            if(Key.equals("SP")){Key = "First page";metadataTable.put(Key, Map);}
            if(Key.equals("EP")){Key = "Last page";metadataTable.put(Key, Map);}
            if(Key.equals("VL")){Key = "volnum";metadataTable.put(Key, Map);}
            if(Key.equals("IS")){Key = "issnum";metadataTable.put(Key, Map);}
            if(Key.equals("AB")){Key = "Abstract";metadataTable.put(Key, Map);}
            if(Key.equals("SN")){Key = "ISBN";metadataTable.put(Key, Map);}
            if(Key.equals("UR")){Key = "URL";metadataTable.put(Key, Map);}
            if(Key.equals("DO")){Key = "DOI";metadataTable.put(Key, Map);}
            if(Key.equals("ID")){Key = "Reference ID";metadataTable.put(Key, Map);}
            if(Key.equals("ER")){break;}
            Map = "";   
        }
return metadataTable;
}

/* ### BIB PARSER ###*/
public static HashMap<String, String> bibParser (String path) throws FileNotFoundException, IOException {
        
        HashMap<String, String> metadataTable = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        
        // Used to read the current line in the file
        String line;
        String Key;
        String Map = "";
        int authors = 1;
        
        // Skips first line (first line is irrelevant in .bib files)
        br.readLine();
        
        // Loops continues until it reaches the end of the file
        while((line = br.readLine()) != null) {
            Key = line;
            // Checks format of .bib file
            /*
                Some .bib files separate the data with "{" "}"
                and some separate with just quotations
                This first if statement checks the first .bib format
                *** Check .bib file examples in github to know what I mean ***
            */
            
            // Format 1 - WORK IN PROGRESS
            if (line.contains("{")) {
                String[] data = line.split("[={}]");
                // Testing purposes -Elias
                System.out.println("0 " + data[0]); // Key
                System.out.println("1 " + data[1]); // "={" replaced with ""
                System.out.println("2 " + data[2]); // Data
                System.out.println("3 " + data[3]); // Comma
                Key = data[0];
                Map = data[2];
		if (Key.equals("author")) {
                    
                // Split authors here (Authors are separated like so:
                //                     "John Doe and Marge Thatcher")  
                String[] data2 = Map.split(" and ");
                
                for (int i = 0; i < data2.length; i++) {
                    // Split authors once more. They are now only separated by " "
                    // We're using a List here so we're able to empty the array completely later
                    List<String> name = Arrays.asList(data2[i].split(" "));
                    if (name.size() > 2) {
                        // Author has middle name/inital
                        metadataTable.put("author"+authors+"_fname", name.get(0));
                        metadataTable.put("author"+authors+"_mname", name.get(1));
                        metadataTable.put("author"+authors+"_lname", name.get(2));
                        authors++;
                        // Empties array
                        name = new ArrayList<>();
                    } else {
                        // Author only has first and last name
                        metadataTable.put("author"+authors+"_fname", name.get(0));
                        metadataTable.put("author"+authors+"_lname", name.get(1));
                        authors++;
                        // Empties array
                        name = new ArrayList<>();
                    }
                }
                /*
                    Each data2[] value is a different author
                    They need to be split again into:
                        - first name/first inital
                        - middle name/middle initial
                        - last name/last inital
                    Then pushed to the metadataTable
                */
            }
            if(Key.equals("title")){Key = "Title";metadataTable.put(Key, Map);}
            if(Key.equals("booktitle")){Key = "source publication";metadataTable.put(Key, Map);}
            if(Key.equals("year")){Key = "publication_date";metadataTable.put(Key, Map);}
            if(Key.equals("volume")){Key = "volnum";metadataTable.put(Key, Map);}
            if (Key.equals("pages")) {
                String[] data3 = Map.split("-");
                metadataTable.put("First page", data3[0]);
                metadataTable.put("Last page", data3[1]);
            }
            if(Key.equals("abstract")){Key = "Abstract";metadataTable.put(Key, Map);}
            if (Key.equals("keywords")) {
                Map = Map.replace(";", ", ");
                metadataTable.put("Keywords", Map);
            }
            if(Key.equals("doi")){Key = "DOI";metadataTable.put(Key, Map);}
            if(Key.equals("ISSN")){Key = "ISBN";metadataTable.put(Key, Map);}
            }
            
            // Format 2 - WORK IN PROGRESS
            if (line.contains(" = ")) {
                String[] data4 = line.split(" = \"");
                // Testing purposes -Elias
                System.out.println("Key " + data4[0]); // Key
                System.out.println("Map " + data4[1]); // Data
                Key = data4[0];
                Map = data4[1].replace("\",", "");
            if(Key.equals("title")){Key = "Title";metadataTable.put(Key, Map);}
            if(Key.equals("journal")){Key = "source publication";metadataTable.put(Key, Map);}
            if(Key.equals("volume")){Key = "volnum";metadataTable.put(Key, Map);}
            if (Key.equals("pages")) {
                String[] data6 = Map.split(" - ");
                metadataTable.put("First page", data6[0]);
                metadataTable.put("Last page", data6[1]);
            }
            if(Key.equals("year")){Key = "publication_date";metadataTable.put(Key, Map);}
            if(Key.equals("issn")){Key = "ISBN";metadataTable.put(Key, Map);}
            if(Key.equals("url")){Key = "URL";metadataTable.put(Key, Map);}
            if(Key.equals("doi")){Key = "DOI";metadataTable.put(Key, Map);}
            if (Key.equals("author")) {
                
                // Split authors here (Authors are separated like so:
                //                     "John Doe and Marge Thatcher")  
                String[] data7 = Map.split(" and ");
                
                for (int i = 0; i < data7.length; i++) {
                    // Split authors once more. They are now only separated by " "
                    // We're using a List here so we're able to empty the array completely later
                    List<String> name = Arrays.asList(data7[i].split(" "));
                    if (name.size() > 2) {
                        // Author has middle name/inital
                        metadataTable.put("author"+authors+"_fname", name.get(0));
                        metadataTable.put("author"+authors+"_mname", name.get(1));
                        metadataTable.put("author"+authors+"_lname", name.get(2));
                        authors++;
                        // Empties array
                        name = new ArrayList<>();
                    } else {
                        // Author only has first and last name
                        metadataTable.put("author"+authors+"_fname", name.get(0));
                        metadataTable.put("author"+authors+"_lname", name.get(1));
                        authors++;
                        // Empties array
                        name = new ArrayList<>();
                    }
                }
            }
            if(Key.equals("keywords")){Key = "Keywords";metadataTable.put(Key, Map);}
            if(Key.equals("abstract")){Key = "abstract";metadataTable.put(Key, Map);}
            }
            
        }
        return metadataTable;
}

public static void main(String[] args) throws IOException {
    
    HashMap<String, String> metaTable = new HashMap<>();
    String input;
    
    // File chooser. Allows user to select any directory
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("Choose a folder");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);
    
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      System.out.println("Current directory: " + chooser.getCurrentDirectory());
      System.out.println("Selected file: " + chooser.getSelectedFile());
    } else {
      System.out.println("No Selection was made");
    }
    
    // Gets the name of the selected file and converts to string
    input = chooser.getSelectedFile().toString();
    
    // Opens selected file and calls respective parser
    File file = new File(input);
    File[] files = file.listFiles();
    PrintWriter writer = new PrintWriter("tempfile.csv", "UTF-8");
    File csvFile = CSVgen(writer);
    for (File f: files) {
        if (f.getName().contains(".ris")) {
            metaTable = risParser(f.getPath());
            // Get HTML source code of article
            // Parse for addition information
            // Update metaTable
            populateCSV(metaTable, csvFile, writer);
            System.out.println(f.getName());
        }
        if (f.getName().contains(".bib")) {
            metaTable = bibParser(f.getPath());
            // Get HTML source code of article
            // Parse for addition information
            // Update metaTable
            populateCSV(metaTable, csvFile, writer);
            System.out.println(f.getName());
        }
    }
    writer.close();
}

public static File CSVgen(PrintWriter writer) throws IOException { //This method sets the names for all the value types (published date, issue, journal, etc.)
    File tempfile = new File("tempfile.csv");
	/*if(tempfile.createNewFile()) {
            System.out.println("FILE CREATED");
	} else {
            System.out.println("FILE ALREADY EXISTS");
            throw new IOException("FILE ALREADY EXISTS");
	}*/
    writer.write("title,filename,source_fulltext_url,fulltext_url,version,copyright_statement,distribution_license,embargo_date,keywords,abstract,author1_fname,author1_mname,author1_lname,author1_suffix,author1_email,author1_institution,author1_is_corporate,author2_fname,author2_mname,author2_lname,author2_suffix,author2_email,author2_institution,author2_is_corporate,author3_fname,author3_mname,author3_lname,author3_suffix,author3_email,author3_institution,author3_is_corporate,author4_fname,author4_mname,author4_lname,author4_suffix,author4_email,author4_institution,author4_is_corporate,author5_fname,author5_mname,author5_lname,author5_suffix,author5_email,author5_institution,author5_is_corporate,author6_fname,author6_mname,author6_lname,author6_suffix,author6_email,author6_institution,author6_is_corporate,article_desc,disciplines,comments,create_openurl,custom_citation,document_type,doi,honors_pub,issn,volnum,issnum,source_publication,fpage,lpage,peer_reviewed,mcnair,orcid_id,publication_date,season\n");
    return tempfile;
}
	
public static void populateCSV(HashMap<String, String> input, File csvFile, PrintWriter writer) throws IOException { //This method populates a single row representing an article.
    String bigString = "";
    bigString = csvHelper(input, "Title", bigString);
    bigString += "!!!put FileName Here!!!,";
    bigString = csvHelper(input, "URL", bigString);
    bigString = csvHelper(input, "fulltext_url", bigString);
    bigString = csvHelper(input, "Version", bigString);
    bigString = csvHelper(input, "copyright_statement", bigString);
    bigString = csvHelper(input, "Distribution Liscence", bigString);
    bigString = csvHelper(input, "Embargo Date", bigString);
    bigString = csvHelper(input, "Keywords", bigString);
    bigString = csvHelper(input, "Abstract", bigString);
    for(int i = 1; i <= 6; i++) {
        bigString = csvHelper(input, "author" + i + "_fname", bigString);
        bigString = csvHelper(input, "author" + i + "_mname", bigString);
        bigString = csvHelper(input, "author" + i + "_lname", bigString);
        bigString = csvHelper(input, "author" + i + "_suffix", bigString);
        bigString = csvHelper(input, "author" + i + "_email", bigString);
        bigString = csvHelper(input, "author" + i + "_instutution", bigString);
        bigString = csvHelper(input, "author" + i + "_is_corporate", bigString);
    }
    bigString = csvHelper(input, "article_desc", bigString);
    bigString = csvHelper(input, "Disciplines", bigString);
    bigString = csvHelper(input, "comments", bigString);
    bigString = csvHelper(input, "create_openurl", bigString);
    bigString = csvHelper(input, "custom_citation", bigString);
    bigString = csvHelper(input, "Type", bigString);
    bigString = csvHelper(input, "DOI", bigString);
    bigString = csvHelper(input, "honors_pub", bigString);
    bigString = csvHelper(input, "ISBN", bigString);
    bigString = csvHelper(input, "volnum", bigString);
    bigString = csvHelper(input, "issnum", bigString);
    bigString = csvHelper(input, "source publication", bigString);
    bigString = csvHelper(input, "First page", bigString);
    bigString = csvHelper(input, "Last page", bigString);
    bigString = csvHelper(input, "Peer Reviewed", bigString);
    bigString = csvHelper(input, "mcnair", bigString);
    bigString = csvHelper(input, "orcid id", bigString);
    bigString = csvHelper(input, "publication_date", bigString);
    bigString = csvHelper(input, "Season", bigString);
    bigString += "\n";
    writer.write(bigString);
}

public static String csvHelper(HashMap<String, String> input, String check, String bigString) { //This method is just here to make the populate method not look like garbage.
    if(input.containsKey(check)) {
	bigString += "\"" + input.get(check) + "\"";
    }
    bigString += ",";
    return bigString;
}

}
