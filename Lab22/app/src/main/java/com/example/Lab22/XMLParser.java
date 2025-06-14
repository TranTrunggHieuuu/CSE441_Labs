package com.example.ex22;

import android.net.http.HttpResponseCache;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ClientInfoStatus;

import kotlin.random.Random;

public class XMLParser {
    public String getXmlFromUrl(String url){
        String xml = null;
        try{
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            xml = EntityUtils.toString(httpEntity);
        }
        catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        catch (ClientProtocolException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return xml;
    }
}
