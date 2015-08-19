package ekembi.xu.com.sharedpreferences;

import android.util.Base64;
import java.io.UnsupportedEncodingException;


public class EncodeInfo {

    public String encodeString(String value) {
        try {
            byte[] data = value.getBytes("UTF-8");
            return Base64.encodeToString(data, Base64.DEFAULT);
        }
        catch (UnsupportedEncodingException e) {
            return "Error during encoding";
        }
    }


}
