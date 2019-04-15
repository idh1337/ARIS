package com.example.aris;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    private Button firstButton;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private Button scanIt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);

        FindViews();
        HandleEvents();

    }

    private void HandleEvents() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ohh you found me!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert();
            }
        });
        scanIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScanBarcode();
            }


        });
    }
    private void ScanBarcode() {
        new IntentIntegrator(this).initiateScan(); // `this` is the current Activity
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Get the results:
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void showAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Its me Mr. Alert!");
        alertDialog.setMessage("Task acomplished!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Good by Mr. Alert",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        //Notification n = NotificationExtras.buildWithBackgroundColor(this, b, 0xffff0000);
        //alertDialog.
        alertDialog.show();
    }

    private void FindViews() {
        firstButton = (Button) findViewById(R.id.firstButton) ;
        fab = (FloatingActionButton) findViewById(R.id.fab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        scanIt = (Button)findViewById(R.id.scanBarcode);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
