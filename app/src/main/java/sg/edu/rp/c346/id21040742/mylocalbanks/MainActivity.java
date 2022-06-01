package sg.edu.rp.c346.id21040742.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button dbs;
    Button uob;
    Button ocbc;
    String wordClicked = "";
    Boolean status1 = false;
    Boolean status2 = false;
    Boolean status3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbsButton);
        uob = findViewById(R.id.uobButton);
        ocbc = findViewById(R.id.ocbcButton);

        registerForContextMenu((dbs));
        registerForContextMenu((ocbc));
        registerForContextMenu((uob));

        dbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentView);
            }
        });

        uob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentView);
            }
        });


        ocbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentView);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Visit Website");
        menu.add(0, 1, 1, "Call Hotline");
        menu.add(0, 2, 2, "Toggle Favourite");

        if (v == dbs) {
            wordClicked = "DBS";
        } else if (v == ocbc) {
            wordClicked = "OCBC";
        } else if (v == uob) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            uob.setText("UOB");
            ocbc.setText("OCBC");
            return true;
        } else if (id == R.id.chineseSelection) {
            dbs.setText("星展银行");
            uob.setText("华侨银行");
            ocbc.setText("大华银行");
            return true;
        } else {
            dbs.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);

                return true; //menu item successfully handled

            } else if (item.getItemId() == 0) {
                //code for action
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentView);
                return true;  //menu item successfully handled
            }

            else if (item.getItemId() == 2) {
                if(status1 == false) {
                    dbs.setTextColor(Color.parseColor("#FFFF00"));
                    Toast.makeText(MainActivity.this, "Added to Favourite", Toast.LENGTH_SHORT).show();
                    status1 = true;
                }
                else if(true) {
                    dbs.setTextColor(Color.parseColor("#FFFFFF"));
                    status1 = false;
                    Toast.makeText(MainActivity.this, "Remove from Favourite", Toast.LENGTH_SHORT).show();
                }

            }
        }

        if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);

                return true; //menu item successfully handled

            } else if (item.getItemId() == 0) {
                //code for action
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentView);
                return true;  //menu item successfully handled
            }



            else if (item.getItemId() == 2) {
                if(status2 == false) {
                    ocbc.setTextColor(Color.parseColor("#FFFF00"));
                    Toast.makeText(MainActivity.this, "Added to Favourite", Toast.LENGTH_SHORT).show();
                    status2 = true;
                }
                else if(true) {
                    ocbc.setTextColor(Color.parseColor("#FFFFFF"));
                    status2 = false;
                    Toast.makeText(MainActivity.this, "Remove from Favourite", Toast.LENGTH_SHORT).show();
                }

            }
        }

        if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 1) {
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall);

                return true; //menu item successfully handled

            } else if (item.getItemId() == 0) {
                //code for action
                Intent intentView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentView);
                return true;  //menu item successfully handled
            }
            else if (item.getItemId() == 2) {
                if(status3 == false) {
                    uob.setTextColor(Color.parseColor("#FFFF00"));
                    Toast.makeText(MainActivity.this, "Added to Favourite", Toast.LENGTH_SHORT).show();
                    status3 = true;
                }
                else if(true) {
                    uob.setTextColor(Color.parseColor("#FFFFFF"));
                    status3 = false;
                    Toast.makeText(MainActivity.this, "Remove from Favourite", Toast.LENGTH_SHORT).show();
                }

            }


        }
    return super.onContextItemSelected(item);

    }


}