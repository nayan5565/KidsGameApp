package com.example.nayan.kidsgame.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by NAYAN on 9/5/2016.
 */
public class DownLoadAsyncTask extends AsyncTask<String, Integer, Boolean> {
    private Context context;
    private String path;
    private ProgressDialog progressDialog;

    public DownLoadAsyncTask(Context context, String path) {
        this.context = context;
        this.path = path;
    }

    @Override
    protected void onPreExecute() {
        progressDialog=ProgressDialog.show(context,null,"downloading.... 0%");
        Log.e("DOWNLOAD","start:"+path);
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        Log.e("DOWNLOAD_RUN","url:"+strings[0]);
        int count;
        try {
            URL url = new URL(strings[0]);
            URLConnection connection = url.openConnection();
            connection.connect();
            int lengthOfFile = connection.getContentLength();
            InputStream inputStream = new BufferedInputStream(url.openStream());
            OutputStream outputStream = new FileOutputStream(path);
            byte data[] = new byte[1024];
            long total=0;
            while ((count = inputStream.read(data)) != -1) {
                total += count;
                publishProgress((int)total*100/lengthOfFile);
                outputStream.write(data,0,count);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.e("DOWNLOAD_PROG","%:"+values[0]);
        progressDialog.setMessage(Utils.ASSETS_DOWNLOAD_MASSAGE +values[0]+"%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        Log.e("DOWNLOAD_POST","completed");
        progressDialog.dismiss();
    }
}
