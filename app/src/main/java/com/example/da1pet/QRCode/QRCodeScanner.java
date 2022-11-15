package com.example.da1pet.QRCode;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.da1pet.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class QRCodeScanner extends AppCompatActivity {
    Button btnClick;
    TextView txtName, txtDiachi;
    ImageView imgHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scanner);
    btnClick.findViewById(R.id.btnClick);
    txtName.findViewById(R.id.txtName);
    txtDiachi.findViewById(R.id.txtDiaChi);
    imgHinh.findViewById(R.id.imageHinh);

        IntentIntegrator intentIntegrator=new IntentIntegrator(this);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentIntegrator.initiateScan();

            }
        });

    }
    // Register the launcher and result handler
    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Toast.makeText(QRCodeScanner.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(QRCodeScanner.this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                }
            });

    // Launch
    public void onButtonClick(View view) {
        barcodeLauncher.launch(new ScanOptions());
    }

}