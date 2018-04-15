package fileUtility;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

/**
 * Created by puneeth on 11/04/2018.
 */
public class CSVUtil {

    private String csvFileName;
    private static Reader inputFile;

    public CSVUtil (String csvFilePath) throws Exception{

        this.csvFileName = csvFilePath;
    }

    public List<String[]> getCsvValues() throws IOException {

        // This will load csv file
        CSVReader reader = new CSVReader(new FileReader(
                csvFileName));

        //"C:\\Users\\kedika\\Downloads\\IdentityE2ETest\\src\\main\\resources\\files\\data.csv"

        // this will load csv content into list
        List<String[]> list = reader.readAll();

        System.out.println("Total rows which we have is " + list);


        // create Iterator reference
        Iterator<String[]> i1= list.iterator();

        // Iterate all values
        while(i1.hasNext()){
            String[] str=i1.next();
            System.out.print(" Values are ");

            for(int i=0;i<str.length;i++)
            {
                System.out.print(" "+str[i]);
            }
            System.out.println("   ");

        }
/*

        String[] nextline;

        while ((nextline = reader.readNext())!=null) {
            String vehicleReg = nextline[0];
            String vehicleMake = nextline[1];
            String vehicleColour = nextline[2];
        }
*/

        return list;
    }

}
