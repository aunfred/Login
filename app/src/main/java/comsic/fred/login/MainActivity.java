package comsic.fred.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEdiText,userEdiText,passEdiText;
    String nameString,userString,passString;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inti
        nameEdiText =(EditText)findViewById(R.id.txtName);
        userEdiText =(EditText)findViewById(R.id.txtUser);
        passEdiText =(EditText)findViewById(R.id.txtPass);
        loginButton = (Button)findViewById(R.id.btnlogin);

        //oncli
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick (View view){

                nameString = nameEdiText.getText().toString().trim();
                userString = userEdiText.getText().toString().trim();
                passString = passEdiText.getText().toString().trim();

              //check space
                if ((nameString.length() ==0) || (userString.length()==0) ||
                        (passString.length()==0)) {
                    Toast.makeText(getApplicationContext(),"กรุณากรอกข้อมูลให้ครบทุกช่อง",Toast.LENGTH_SHORT).show();

                }
                //check
                if ((userString.equals("admin")) || ((passString.equals("1234"))) {
                    Toast.makeText(getApplicationContext()," Login Success",Toast.LENGTH_SHORT).show();

                    //start Menu
                    Intent menuIntent = new Intent(MainActivity.this , Menu.class);
                    menuIntent.putExtra("Name",nameString);
                    startActivity(menuIntent);

                }else{
                    Toast.makeText(getApplicationContext()," login False",Toast.LENGTH_SHORT).show();

                }

            }
        });
        }
    }


