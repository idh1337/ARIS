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
import android.widget.TextView;
import android.widget.Toast;

public class ScannedBarcodes extends AppCompatActivity {
    private TextView showScannedCodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_scanned_barcodes);

        HandleEvents();
        FindViews();
    }

    private void FindViews() {
        showScannedCodes = (Button)findViewById(R.id.showScannedCodes);
    }

    private void HandleEvents() {
        ShowScannedCodes();
    }

    private void ShowScannedCodes() {
        showScannedCodes.setText("Hello World!");
    }
}
