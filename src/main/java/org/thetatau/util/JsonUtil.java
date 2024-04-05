package org.thetatau.util;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtil {
    public static JSONObject readJsonFromFile(String filePath) {
        try {
            String content = Files.readString(Paths.get(filePath));
            return new JSONObject(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
