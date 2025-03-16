package uk.ac.ucl.model;

import java.io.*;
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

  private static final String FILE_PATH = "data/notes.csv";

  public int getNextId() {
    List<List<String>> allData = readFile(FILE_PATH);
    if (allData == null || allData.isEmpty()) {
      return 1; // Handle empty or null case
    }
    int lastID = Integer.parseInt(allData.get(allData.size() - 1).get(0));
    return lastID + 1; // Next ID is current size + 1
  }


  public void writeToCsv(int id, String category, String title, String content, String url, String image) {
    try (FileWriter writer = new FileWriter(FILE_PATH, true);
         CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
      csvPrinter.printRecord(id, category, title, content, url, image); // Writes a row with given values
      csvPrinter.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }


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



  public List<List<String>> searchFor(String keyword) {
    // Read file into a list of lists
    List<List<String>> data = readFile(FILE_PATH);
    List<String> filteredTitles = new ArrayList<>();
    List<String> filteredIndex = new ArrayList<>();
    for (List<String> note : data) {
      boolean matchFound = false;
      // Check if index 1 exists and matches the keyword
      if (note.size() > 1 && note.get(1).toLowerCase().contains(keyword.toLowerCase())) {
        matchFound = true;
      }
      // Check if index 2 exists and matches the keyword
      if (note.size() > 2 && note.get(2).toLowerCase().contains(keyword.toLowerCase())) {
        matchFound = true;
      }
      // Check if index 3 exists and matches the keyword
      if (note.size() > 3 && note.get(3).toLowerCase().contains(keyword.toLowerCase())) {
        matchFound = true;
      }
      // Check if index 4 exists and matches the keyword
      if (note.size() > 4 && note.get(4).toLowerCase().contains(keyword.toLowerCase())) {
        matchFound = true;
      }
      // If any match is found, add the entry
      if (matchFound) {
        filteredIndex.add(note.get(0)); // ID (Assuming always present)
        filteredTitles.add(note.size() > 2 ? note.get(2) : "Untitled"); // Title (Check existence)
      }
    }
    return List.of(filteredIndex, filteredTitles); // Return as list of lists
  }



  public List<String> getNoteById(int id) {
    List<String> noteDetails = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
      System.out.println("Searching for note with ID: " + id);
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(","); // Assuming CSV uses commas
        if (values.length >= 2) {
          int noteId = Integer.parseInt(values[0]); // First column is ID
          if (noteId == id) {
            if (values.length > 1 && !values[1].trim().isEmpty()) noteDetails.add(values[1].trim());
            if (values.length > 2 && !values[2].trim().isEmpty()) noteDetails.add(values[2].trim());
            if (values.length > 3 && !values[3].trim().isEmpty()) noteDetails.add(values[3].trim());
            if (values.length > 4 && !values[4].trim().isEmpty()) noteDetails.add(values[4].trim());
            if (values.length > 5 && !values[5].trim().isEmpty()) noteDetails.add(values[5].trim());
            return noteDetails; // Return as soon as we find the matching note
          }
        }
      }
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    }
    return null; // If note is not found
  }



  public void editNote(int id, String newCategory, String newTitle, String newContent, String URL, String Image) {
    List<String> updatedLines = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(",");
        if (values.length >= 3) {
          int noteId = Integer.parseInt(values[0]);
          if (noteId == id) {
            // Replace with updated values
            line = id + "," + newCategory + "," + newTitle + "," + newContent + "," + URL + "," + Image;
          }
        }
        updatedLines.add(line);
      }
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    }
    // Write back to CSV
    try (FileWriter writer = new FileWriter(FILE_PATH);
         BufferedWriter bw = new BufferedWriter(writer)) {
      for (String updatedLine : updatedLines) {
        bw.write(updatedLine);
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



  public void deleteNote(int id) {
    List<String> updatedLines = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(",");
        if (values.length >= 3) {
          int noteId = Integer.parseInt(values[0]);
          if (noteId == id) {
            continue; // Skip this line (note will be deleted)
          }
        }
        updatedLines.add(line);
      }
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    }
    // Write back the updated CSV
    try (FileWriter writer = new FileWriter(FILE_PATH);
         BufferedWriter bw = new BufferedWriter(writer)) {
      for (String updatedLine : updatedLines) {
        bw.write(updatedLine);
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



  public List<List<String>> filterNotesByCategory(String category) {
    List<List<String>> allNotes = readFile(FILE_PATH);
    if (category == null || category.isEmpty()) {
      return allNotes; // Return all notes if no category is selected
    }
    List<List<String>> filteredNotes = new ArrayList<>();
    for (List<String> note : allNotes) {
      if (note.get(1).equalsIgnoreCase(category)) { // Assuming category is in index 5
        filteredNotes.add(note);
      }
    }
    return filteredNotes;
  }

}
