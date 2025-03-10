package uk.ac.ucl.model;

import java.io.Reader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Model
{
  // The example code in this class should be replaced by your Model class code.
  // The data should be stored in a suitable data structure.
  private static final String FILE_PATH = "data/notes.csv"; // Change to your CSV file path

  public int getNextId() {
    int rowCount = 0;
    try (Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
         CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

      List<CSVRecord> records = csvParser.getRecords();
      rowCount = records.size(); // Number of rows (each row represents a note)

    } catch (IOException e) {
      System.out.println("File not found or empty, starting with ID 1.");
    }
    return rowCount + 1; // Next ID is current size + 1
  }

  public void writeToCsv(int id, String title, String content) {
    try (FileWriter writer = new FileWriter(FILE_PATH, true);
         CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {


      csvPrinter.printRecord(id, title, content); // Writes a row with given values
      csvPrinter.flush();

      System.out.println("Data successfully written to CSV.");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
//  public List<String> getPatientNames()
//  {
//    return readFile("data/patients100.csv");
//  }

  // This method illustrates how to read csv data from a file.
  // The data files are stored in the root directory of the project (the directory your project is in),
  // in the directory named data.
  public List<List<String>> readFile(String fileName) {
    List<List<String>> allData = new ArrayList<>();  // List to store all rows

    try (Reader reader = new FileReader(fileName);
         CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

      for (CSVRecord csvRecord : csvParser) {
        List<String> row = new ArrayList<>();  // To store individual row data

        // Iterate through all columns in the current row
        for (int i = 0; i < csvRecord.size(); i++) {
          row.add(csvRecord.get(i));  // Add each column value in the row
        }

        allData.add(row);  // Add the row to the list of all data
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return allData;  // Return the entire list of rows (data)
  }

  // This also returns dummy data. The real version should use the keyword parameter to search
  // the data and return a list of matching items.
  public List<List<String>> searchFor(String keyword) {
     // Contents list
    List<List<String>> data = readFile(FILE_PATH);
    List<String> filteredTitles = new ArrayList<>();
    List<String> filteredContents = new ArrayList<>();

    for (int i = 0; i < data.size(); i++) {
      if (data.get(i).get(1).toLowerCase().contains(keyword.toLowerCase())) { // Case-insensitive match
        filteredTitles.add(data.get(i).get(1));
        filteredContents.add(data.get(i).get(2));
      }
    }

    return List.of(filteredTitles, filteredContents); // Return as list of lists
  }

}
