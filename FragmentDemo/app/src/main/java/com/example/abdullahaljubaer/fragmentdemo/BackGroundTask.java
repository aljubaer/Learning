package com.example.abdullahaljubaer.fragmentdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by ABDULLAH AL JUBAER on 23-01-18.
 */

public class BackGroundTask extends AsyncTask {

    Context context;

    public BackGroundTask(Context context) {
        this.context = context;
    }
    @Override
    protected Object doInBackground(Object[] objects) {

        String regUrl = "http://172.16.34.133/tutorial/register.php";
        String method = (String) objects[0];
        String text = "";

        if (method.equals("register")){
            String name = (String) objects[1];
            String id = (String) objects[2];
            String password = (String) objects[3];
            String email = (String) objects[4];

            try {
                URL url = new URL(regUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(outputStream, "UTF-8")
                );

                String data = URLEncoder.encode("name", "UTF-8")+"="+URLEncoder.encode(name, "UTF-8")+"&"
                        + URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(id, "UTF-8")+"&"
                        + URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8")+"&"
                        + URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                int statusCode = httpURLConnection.getResponseCode();
                if (statusCode == 200) {

                    BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null)
                        sb.append(line).append("\n");

                    text = sb.toString();
                    bufferedWriter.close();
                }

            } catch (MalformedURLException e) {
                System.out.printf("NO");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        Toast.makeText(context, (String) o, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

}
