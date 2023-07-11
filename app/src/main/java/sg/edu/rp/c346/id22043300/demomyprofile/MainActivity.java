package sg.edu.rp.c346.id22043300.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);


    }
    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());
        // Step 1: Obtain the SharePreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // Step 2: Create a SharedPreferences Editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        // Step 3: Set a key-value pair in the editor
        prefEdit.putString("username", strName);
        prefEdit.putFloat("gpa", gpa);
        // Step 4: Call commit() to save the changes made to the SharedPreferences
        prefEdit.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Step 1: Obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // Step 2: Retrieve the saved data from the SharedPreferences
        // with a default value if no matching data
        String username = prefs.getString("username", "No username");
        float gpa = prefs.getFloat("gpa", 0.0f);

        etName.setText(username);
        etGPA.setText(String.valueOf(gpa));

        Toast toast = Toast.makeText(MainActivity.this, "Welcome back "+etName.getText().toString(), Toast.LENGTH_LONG);
        toast.show();
    }
}