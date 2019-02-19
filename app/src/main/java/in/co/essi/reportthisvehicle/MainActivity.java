package in.co.essi.reportthisvehicle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout llcomplaints,llapprove,lldis;
    RelativeLayout rlview;
    TextView tvcom,tvapp,tvdis;
    ImageView ivcom,ivapp,ivdis;
    TextView tvheader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("");

        tvheader=findViewById(R.id.tvheader);

        llcomplaints=findViewById(R.id.llcomplaints);
        llapprove=findViewById(R.id.llapproved);
        lldis=findViewById(R.id.lldis);

        rlview=findViewById(R.id.view);

        tvcom=findViewById(R.id.tvcom);
        tvapp=findViewById(R.id.tvapp);
        tvdis=findViewById(R.id.tvdis);

        ivcom=findViewById(R.id.ivcom);
        ivapp=findViewById(R.id.ivapp);
        ivdis=findViewById(R.id.ivdis);

        complaints();

        llcomplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                complaints();
            }
        });

        llapprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approved();
            }
        });

        lldis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disapproved();
            }
        });


    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    RelativeLayout rlreport;

    void complaints(){
        LayoutInflater inflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.complaints,null);
        rlview.removeAllViews();
        rlview.addView(v);

        tvheader.setText("My  Complaints");

        tvcom.setTextSize(getResources().getDimension(R.dimen.textsizebig));
        tvapp.setTextSize(getResources().getDimension(R.dimen.textsizesmall));
        tvdis.setTextSize(getResources().getDimension(R.dimen.textsizesmall));

        tvcom.setTextColor(Color.parseColor("#FFFFFF"));
        tvapp.setTextColor(Color.parseColor("#E6B0AA"));
        tvdis.setTextColor(Color.parseColor("#E6B0AA"));

        ivcom.setColorFilter(Color.parseColor("#FFFFFF"));
        ivapp.setColorFilter(Color.parseColor("#E6B0AA"));
        ivdis.setColorFilter(Color.parseColor("#E6B0AA"));

        rlreport=v.findViewById(R.id.rlreport);
        rlreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CameraActivity.class);
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");


        }
    }

    void approved(){
        View v=getLayoutInflater().inflate(R.layout.approved,null);
        rlview.removeAllViews();
        rlview.addView(v);

        tvheader.setText("Approved  Complaints");

        tvcom.setTextSize(getResources().getDimension(R.dimen.textsizesmall));
        tvapp.setTextSize(getResources().getDimension(R.dimen.textsizebig));
        tvdis.setTextSize(getResources().getDimension(R.dimen.textsizesmall));

        tvcom.setTextColor(Color.parseColor("#E6B0AA"));
        tvapp.setTextColor(Color.parseColor("#FFFFFF"));
        tvdis.setTextColor(Color.parseColor("#E6B0AA"));

        ivcom.setColorFilter(Color.parseColor("#E6B0AA"));
        ivapp.setColorFilter(Color.parseColor("#FFFFFF"));
        ivdis.setColorFilter(Color.parseColor("#E6B0AA"));

    }

    void disapproved(){
        View v=getLayoutInflater().inflate(R.layout.disapproved,null);
        rlview.removeAllViews();
        rlview.addView(v);

        tvheader.setText("Rejected  Complaints");

        tvcom.setTextSize(getResources().getDimension(R.dimen.textsizesmall));
        tvapp.setTextSize(getResources().getDimension(R.dimen.textsizesmall));
        tvdis.setTextSize(getResources().getDimension(R.dimen.textsizebig));

        tvcom.setTextColor(Color.parseColor("#E6B0AA"));
        tvapp.setTextColor(Color.parseColor("#E6B0AA"));
        tvdis.setTextColor(Color.parseColor("#FFFFFF"));

        ivcom.setColorFilter(Color.parseColor("#E6B0AA"));
        ivapp.setColorFilter(Color.parseColor("#E6B0AA"));
        ivdis.setColorFilter(Color.parseColor("#FFFFFF"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
