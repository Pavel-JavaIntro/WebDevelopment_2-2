package by.pavka.wd22.model.reader;

import java.io.*;
import java.util.ResourceBundle;

public class TextFileReader {
  private static final String filePath = ResourceBundle.getBundle("textfile")
          .getString("file_path");

  public String read() throws IOException {
    StringBuilder builder = new StringBuilder();
    try(InputStream is = getClass().getResourceAsStream(filePath); BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(is))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        builder.append(line);
      }
    }
    return builder.toString();
  }
}
