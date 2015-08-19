package ekembi.xu.com.sharedpreferences;

import android.util.Base64;
import java.io.UnsupportedEncodingException;


public class DecodeInfo {

    public String decodeString(String value) {
        try {
            byte[] data = Base64.decode(value, Base64.DEFAULT);
            return new String(data, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            return "Error during encoding";
        }
    }
}
