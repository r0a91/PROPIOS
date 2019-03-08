
import java.util.*;
import java.io.*;

public class LoggerFactory {

	

  //Factory Method
  public Logger getLogger(boolean isFileLoggin) {
    if (isFileLoggin) {
      return new FileLogger();
    } else {
      return new ConsoleLogger();
    }
  }

}
