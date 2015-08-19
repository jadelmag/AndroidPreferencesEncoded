package ekembi.xu.com.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextInput;
    Button btnSave;
    Button btnLoad;
    TextView textViewDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupVariables();
        setupSelectors();
    }

    private void setupVariables() {

        editTextInput = (EditText) findViewById(R.id.editTextInput);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        textViewDefault = (TextView) findViewById(R.id.textViewDefault);
    }

    private void setupSelectors() {
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewDefault.getText().toString().equals("")) {
                    textViewDefault.setText("Empty text");
                }
                else {
                    textViewDefault.setText(loadStringFromMyPreferences(editTextInput.getText().toString()));
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStringInPreferences("text",editTextInput.getText().toString());
                textViewDefault.setText("Saved in preferences with key: text");
            }
        });
    }

    // Preferences Methods

    /* Save Methods */

    // Save String
    public void saveStringInPreferences(String key, String stringToSave) {

        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, stringToSave);
        editor.commit();
    }

    // Save Boolean
    public void saveBooleanInPreferences(String key, Boolean booleanToSave) {

        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, booleanToSave);
        editor.commit();
    }

    // Save Int
    public void saveIntInPreferences(String key, int intToSave) {

        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, intToSave);
        editor.commit();
    }

    // Save Float
    public void saveFloatInPreferences(String key, float floatToSave) {

        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(key, floatToSave);
        editor.commit();
    }

    // Save Long
    public void saveLongInPreferences(String key, long longToSave) {

        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, longToSave);
        editor.commit();
    }

    /* Load Methods */

    // Load String
    public String loadStringFromMyPreferences(String key) {
        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        return preferences.getString(key, "String not found");
    }

    // Load Boolean
    public Boolean loadBooleanFromMyPreferences(String key) {
        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }

    // Load Int
    public int loadIntFromMyPreferences(String key) {
        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        return preferences.getInt(key, -1);
    }

    // Load Float
    public Float loadFloatFromMyPreferences(String key) {
        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        return preferences.getFloat(key, -1);
    }

    // Load Long
    public Long loadLongFromMyPreferences(String key) {
        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        return preferences.getLong(key, -1);
    }



    /* Save Methods as String Encoded */

    // Encode and Save String
    public void saveStringAsStringEncodedInPreferences(String key, String stringToSave) {

        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, new EncodeInfo().encodeString(stringToSave));
        editor.commit();
    }

    // Encode and Save Boolean
    public void saveBooleanAsStringEncodedInPreferences(String key, Boolean booleanToSave) {

        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, new EncodeInfo().encodeString(String.valueOf(booleanToSave)));
        editor.commit();
    }

    // Encode and Save Int
    public void saveIntAsStringEncodedInPreferences(String key, int intToSave) {

        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, new EncodeInfo().encodeString(String.valueOf(intToSave)));
        editor.commit();
    }

    // Encode and Save Float
    public void saveFloatAsStringEncodedInPreferences(String key, float floatToSave) {

        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, new EncodeInfo().encodeString(String.valueOf(floatToSave)));
        editor.commit();
    }

    // Encode and Save Long
    public void saveLongAsStringEncodedInPreferences(String key, long longToSave) {

        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, new EncodeInfo().encodeString(String.valueOf(longToSave)));
        editor.commit();
    }


    /* Load Encoded Methods */

    // Load Encoded String
    public String loadEncodedTypeFromMyPreferences(String key) {
        SharedPreferences preferences = getSharedPreferences("My Preferences", Context.MODE_PRIVATE);
        return new DecodeInfo().decodeString(preferences.getString(key, "String not found"));
    }

}
