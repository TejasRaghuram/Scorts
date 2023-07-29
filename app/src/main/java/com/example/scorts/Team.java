package com.example.scorts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

public class Team extends AppCompatActivity {

    // ... (previous code remains the same)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make the activity full-screen
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_team);

        // Create a fake array of team data
        ArrayList<TeamView> team = new ArrayList<>();

        team.add(new TeamView("Vignesh", 100, 100, "India"));
        team.add(new TeamView("Sachin", 100, 0, "India"));


        // Create an adapter
        TeamViewAdapter adapter = new TeamViewAdapter(this, 0, team);

        // Set the adapter to the list view
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    public class AsyncThrea extends AsyncTask<Void, Void, Void>
    {
        protected Void doInBackground(Void...voids)
        {
            try{
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://api.verbwire.com/v1/nft/data/owned?walletAddress=0xA3bD282A780FC68109169213D49C572135Fa2Aa4&chain=goerli")
                        .get()
                        .addHeader("accept", "application/json")
                        .addHeader("X-API-Key", "sk_live_37e84f82-35e0-46e2-ba99-dc5cecb29f70")
                        .build();

                Response response = client.newCall(request).execute();
                System.out.println(response.toString());
            }catch (Exception e)
            {
                System.out.println("Reception Failed");
            }

            return null;
        }
    }

    public class AsyncThread extends AsyncTask<Void, Void, Void>
    {
        protected Void doInBackground(Void...voids)
        {
            try {
                String aString = "-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"chain\"\r\n\r\ngoerli\r\n-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"name\"\r\n\r\n"+name.getText().toString()+"\r\n-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"filePath\"\r\n\r\ndata:text/rtf;name=ScrewVerbVie.rtf;base64,e1xydGYxXGFuc2lcYW5zaWNwZzEyNTJcY29jb2FydGYyNzA4Clxjb2NvYXRleHRzY2FsaW5nMFxjb2NvYXBsYXRmb3JtMHtcZm9udHRibFxmMFxmc3dpc3NcZmNoYXJzZXQwIEhlbHZldGljYTt9CntcY29sb3J0Ymw7XHJlZDI1NVxncmVlbjI1NVxibHVlMjU1O30Ke1wqXGV4cGFuZGVkY29sb3J0Ymw7O30KXG1hcmdsMTQ0MFxtYXJncjE0NDBcdmlld3cxMTUyMFx2aWV3aDg0MDBcdmlld2tpbmQwClxwYXJkXHR4NzIwXHR4MTQ0MFx0eDIxNjBcdHgyODgwXHR4MzYwMFx0eDQzMjBcdHg1MDQwXHR4NTc2MFx0eDY0ODBcdHg3MjAwXHR4NzkyMFx0eDg2NDBccGFyZGlybmF0dXJhbFxwYXJ0aWdodGVuZmFjdG9yMAoKXGYwXGZzMjQgXGNmMCBTY30=\r\n-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"description\"\r\n\r\n"+team.getText().toString()+"\r\n-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"recipientAddress\"\r\n\r\n0xA3bD282A780FC68109169213D49C572135Fa2Aa4\r\n-----011000010111000001101001--\r\n\r\n";


                OkHttpClient client = new OkHttpClient();

                MediaType mediaType = MediaType.parse("multipart/form-data; boundary=---011000010111000001101001");
                RequestBody body = RequestBody.create(mediaType, aString);
                Request request = new Request.Builder()
                        .url("https://api.verbwire.com/v1/nft/mint/quickMintFromFile")
                        .post(body)
                        .addHeader("accept", "application/json")
                        .addHeader("content-type", "multipart/form-data; boundary=---011000010111000001101001")
                        .addHeader("X-API-Key", "sk_live_37e84f82-35e0-46e2-ba99-dc5cecb29f70")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    System.out.println(response.toString());
                    finalView.setText("Done");
                } catch (IOException e) {
                    finalView.setText(e.toString());
                    throw new RuntimeException(e);
                }

                System.out.println("DONE");
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
            }
            return null;
        }


    }

}
