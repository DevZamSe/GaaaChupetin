package com.kaito.parte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mercadopago.android.px.core.MercadoPagoCheckout;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DatosActivity extends AppCompatActivity {

    TextView tvnombre, tvvendedor, tvprecio, tvventas,tvdescripcion;
    ImageView imageView;
    Button button;
    Bundle bundle;
    Modelo mod = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        tvnombre = (TextView) findViewById(R.id.textView5);
        tvvendedor = (TextView) findViewById(R.id.textView4);
        tvdescripcion = (TextView) findViewById(R.id.textView7);
        tvprecio = (TextView) findViewById(R.id.tvprecio);

        tvventas = (TextView) findViewById(R.id.textView9);

        imageView = (ImageView) findViewById(R.id.imageView);

        button = (Button) findViewById(R.id.button4);

        bundle = getIntent().getExtras();
        mod = (Modelo) bundle.getSerializable("objeto");
        tvnombre.setText(mod.getNombre());
        tvvendedor.setText(mod.getVendedor());
        tvdescripcion.setText(mod.getDescripcion());
        tvprecio.setText(mod.getPrecio());
        //tvubicacion.setText(mod.getUbicacion());
        tvventas.setText(mod.getVentas()+"");
        Picasso.with(this).load(mod.getUrl()).into(imageView);
        getID();
        WebView view = findViewById(R.id.webView);

        view.getSettings().setAllowFileAccessFromFileURLs(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        view.getSettings().setDomStorageEnabled(true);
        view.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setDisplayZoomControls(false);
        view.getSettings().setBuiltInZoomControls(true);
        view.loadUrl("https://sharp-mccarthy-f50d52.netlify.com/");

        view.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoading (WebView view, String url){
                return false;
            }
        });

        WebView view1 = findViewById(R.id.webView2);

        view1.getSettings().setAllowFileAccessFromFileURLs(true);
        view1.getSettings().setBuiltInZoomControls(true);
        view1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        view1.getSettings().setDomStorageEnabled(true);
        view1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        view1.getSettings().setJavaScriptEnabled(true);
        view1.getSettings().setDisplayZoomControls(false);
        view1.getSettings().setBuiltInZoomControls(true);
        view1.loadUrl("https://assistant-chat-us-south.watsonplatform.net/web/public/5b861af8-c741-4390-af6f-39bd76449300");

        view.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoading (WebView view, String url){
                return false;
            }
        });


        button.setOnClickListener(
                v -> new MercadoPagoCheckout.Builder("TEST-2b85324f-35e4-4ad6-a486-1135c621cfae","161054091-fa9f8011-bcf5-4403-bc1f-a4fae8451c89").build().startPayment(this,1));
    }

    private void getID() {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{  \"payer\": {\n        \"name\": \"Jose\",\n        \"surname\": \"Bravo\",\n        \"email\": \"sdasdasd@gmail.com\",\n        \"phone\": {\n            \"area_code\": \"+51\",\n            \"number\": \"984537258\"\n        },\n        \"identification\": {\n            \"type\": \"DNI\",\n            \"number\": \"72915745\"\n        }\n    }, \"items\": [\n        {\n        \"title\": \"Laptop Gamer\",\n        \"description\": \"Laptop Nueva\",\n        \"quantity\": 1,\n        \"currency_id\": \"PEN\",\n        \"unit_price\": 169\n        }\n    ]\n}");
        Request request = new Request.Builder()
                .url("https://api.mercadopago.com/checkout/preferences?access_token=TEST-6655090400443592-110812-fefbb161681d6a2452d184896e601b2c-161054091%0A")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Agent", "PostmanRuntime/7.19.0")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "d55ca033-a5f8-449c-830a-8bad650aedd7,cea5a669-47b2-41c3-bd78-a6fbe49c12fb")
                .addHeader("Host", "api.mercadopago.com")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Content-Length", "495")
                .addHeader("Connection", "keep-alive")
                .addHeader("cache-control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
