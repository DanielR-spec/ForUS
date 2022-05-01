package com.example.forus;

import com.android.volley.toolbox.HttpClientStack;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpHandler {

    public String post (String postURL){

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpost = new HttpPost(postURL);

            HttpResponse resp = httpclient.execute(httpost);
            HttpEntity ent = resp.getEntity();
            String text = EntityUtils.toString(ent);

            return text;

        }catch (Exception e) {
            return "error";
        }
    }
}
