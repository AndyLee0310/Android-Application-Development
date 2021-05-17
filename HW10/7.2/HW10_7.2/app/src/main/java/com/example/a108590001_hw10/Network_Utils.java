package com.example.a108590001_hw10;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Network_Utils {
    private static final String LOG_TAG = Network_Utils.class.getSimpleName();
    private static final String HTTP = "http";
    private static final String HTTPS = "https";

    static String getSourceCode(Context context, String qString, String trferProtocol)
    {
        HttpURLConnection httpUC = null;
        BufferedReader bReader = null;
        String htmlCode = null;
        String[] protocol = context.getResources().getStringArray(R.array.protocol);

        try{
            Uri builder;
            if(trferProtocol.equals(protocol[0])) {
                builder = Uri.parse(qString).buildUpon().scheme(HTTP).build();
            } else {
                builder = Uri.parse(qString).buildUpon().scheme(HTTPS).build();
            }

            URL requestURL = new URL(builder.toString());
            httpUC = (HttpURLConnection) requestURL.openConnection();
            httpUC.setRequestMethod("GET");
            httpUC.connect();

            InputStream inStream = httpUC.getInputStream();
            bReader = new BufferedReader(new InputStreamReader(inStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while((line = bReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }

            if (stringBuilder.length() == 0) {
                return null;
            }

            htmlCode = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (httpUC != null) {
                httpUC.disconnect();
            }

            if (bReader != null) {
                try {
                    bReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.d(LOG_TAG, htmlCode);
        return htmlCode;
    }
}
