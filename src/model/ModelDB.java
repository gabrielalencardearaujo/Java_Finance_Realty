package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
// import app.modelo.InterFinanciamento;
import java.util.List;


public class ModelDB {
  private static Path path = Paths.get("data/Financiamentos.txt").toAbsolutePath();

  public static List<String>  getDatabase() throws IOException {
    ModelDB.checkExistFile();
    List<String> fileRead = Files.readAllLines(path);
    return fileRead;
  }

  public static void setDatabase(String financiamento) throws IOException {
    ModelDB.checkExistFile();
    Files.writeString(path, "Financiamento\n", StandardOpenOption.APPEND);
    Files.writeString(path, financiamento, StandardOpenOption.APPEND);
    Files.writeString(path, "\n\n", StandardOpenOption.APPEND);
  }

  public static void checkExistFile() {
    try{
      if(Files.notExists(path)) {
        Files.createFile(path);
      } 

    }catch(IOException err) {
      System.out.println("Nao foi possivel criar o arquivo. Tente novamente.");
      System.out.println(err);
    }
  }
}
