package com.example.learnonapp.Utilts;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.FileProvider;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import de.hdodenhof.circleimageview.BuildConfig;

public class DownloadTask {

    private static final String TAG = "Download Task";
    private final Context context;
    private String downloadUrl = "", downloadFileName = "";
    public DownloadTask(Context context, String filename, String downloadUrl) {
        this.context = context;
        this.downloadUrl = downloadUrl;
        downloadFileName = filename;
        Log.e(TAG, downloadFileName);
        new DownloadingTask().execute();
    }

    private class DownloadingTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog pdia;
        File apkStorage = null;
        File outputFile = null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdia = new ProgressDialog(context);
            pdia.setMessage("Please wait while downloading..");
            pdia.show();
        }

        @Override
        protected void onPostExecute(Void result) {
            pdia.dismiss();
            try {
                if (outputFile != null) {
                    if (outputFile.exists()) {
                        try {
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            Uri path = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", outputFile);
                            intent.setDataAndType(path, "application/pdf");
                            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //download permission
                            context.startActivity(intent);
                        } catch (android.content.ActivityNotFoundException e) {
                            Toast.makeText(context,"No Pdf viewer found!",Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(context,"File not found",Toast.LENGTH_LONG).show();
                    }
                }
            }
            catch (Exception e) {
                Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG).show();
                pdia.dismiss();
            }
            super.onPostExecute(result);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                URL url = new URL(downloadUrl);//Create Download URl
                HttpURLConnection c = (HttpURLConnection) url.openConnection();//Open Url Connection
                c.setRequestMethod("GET");//Set Request Method to "GET" since we are grtting data
                c.connect();//connect the URL Connection
                if (c.getResponseCode() != HttpURLConnection.HTTP_OK) {

                    Log.e(TAG, "Server returned HTTP " + c.getResponseCode()
                            + " " + c.getResponseMessage());
                }

                if (new com.example.learnonapp.Utilts.CheckForSDCard().isSDCardPresent()) {
                    apkStorage = new File(
                            Environment.getExternalStorageDirectory() + "/document");
                } else
                    Toast.makeText(context, "Oops!! There is no SD Card.", Toast.LENGTH_SHORT).show();
                //If File is not present create directory
                if (!apkStorage.exists()) {
                    apkStorage.mkdir();
                    Log.e(TAG, "Directory Created.");
                }
                //outputFile = new File(context.getCacheDir(), "LawPdfs");
                outputFile = new File(apkStorage, downloadFileName);//Create Output file in Main File
                //Create New File if not present
                if (!outputFile.exists()) {
                    outputFile.createNewFile();
                    Log.e(TAG, "File Created");
                }
                FileOutputStream fos = new FileOutputStream(outputFile);//Get OutputStream for NewFile Location
                InputStream is = c.getInputStream();//Get InputStream for connection
                byte[] buffer = new byte[1024];//Set buffer type
                int len1 = 0;//init length
                while ((len1 = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len1);//Write new file
                }
                //Close all connection after doing task
                fos.close();
                is.close();
            } catch (Exception e) {
                //Read exception if something went wrong
                e.printStackTrace();
                outputFile = null;
                Log.e(TAG, "Download Error Exception " + e.getMessage());
            }
            return null;
        }
    }
}