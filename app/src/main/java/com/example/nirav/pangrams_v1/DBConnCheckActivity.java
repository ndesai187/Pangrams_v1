package com.example.nirav.pangrams_v1;

import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nirav on 19/10/16.
 */
public class DBConnCheckActivity extends AsyncTask<Void,Void,String> {

    @Override
    protected String doInBackground(Void... params) {
        String checkDBlink = "http://www.niravlearningweb.com/myPHP/scripts/test_conn.php";
        BufferedReader reader = null;
        String response_conn = "";
        HttpURLConnection client1 = null;

        try {

            URL urldbcheck = new URL( checkDBlink );
            client1 = (HttpURLConnection) urldbcheck.openConnection();
            client1.setRequestMethod( "GET" );
            client1.connect();

            InputStream is_check = client1.getInputStream();
            StringBuffer buffer1 = new StringBuffer();
            if (is_check == null) {
                return "Nothing to read!";
            }
            reader = new BufferedReader( new InputStreamReader( is_check ) );

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer1.append( line + "\n" );
            }

            if (buffer1.length() == 0) {
                // Stream was empty.  No point in parsing.
                return "Nothing to parse!";
            }

            response_conn = buffer1.toString();
            System.out.println(response_conn);
            //Toast.makeText( DBConnCheckActivity.this, response_conn, Toast.LENGTH_LONG ).show();
            return response_conn;

        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        } finally {
            if (client1 != null) {
                client1.disconnect();
            }
        }
    }

    /*@Override
    protected void onPostExecute(String s) {
        return s;

    }*/
}