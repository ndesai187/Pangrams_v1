package com.example.nirav.pangrams_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class CheckPangramsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_check_pangrams );

        final Button b1 = (Button) findViewById(R.id.ClickHere );
        final EditText ed1 = (EditText) findViewById( R.id.ui1 );
        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText( CheckPangramsActivity.this, "hijo de puta", Toast.LENGTH_LONG ).show();
                String user_input1 = null;
                user_input1 = ed1.getText().toString();
                Toast.makeText( CheckPangramsActivity.this, "You typed : " + user_input1, Toast.LENGTH_LONG ).show();

            }
        } );


    /*Pangrams pg = new Pangrams();
        pg.userInput();
        Toast.makeText(this,"hijo de puta",Toast.LENGTH_LONG).show();*/


}

    public void checkDBConn(View view){
        /*String s = null;
        try {
            s = new DBConnCheckActivity().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Toast.makeText( CheckPangramsActivity.this, s, Toast.LENGTH_LONG ).show();*/
        new DBConnCheckActivity().execute(  );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.check_pangrams, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected( item );
    }

    //dummy for commit
}
