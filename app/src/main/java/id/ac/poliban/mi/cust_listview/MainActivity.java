package id.ac.poliban.mi.cust_listview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;




public class MainActivity extends AppCompatActivity {

    private List<Country> countries = new ArrayList<>();
    private ListView lvCountry;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCountry = findViewById(R.id.listView);

        countries.addAll(CountryData.getAllCountry());

        adapter = new CountryListAdapter(countries);
        lvCountry.setAdapter(adapter);

        lvCountry.setOnItemClickListener(((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Negara yang Anda Pilih")
                    .setMessage("Anda memilih: "+
                            countries.get(position).getCountryName())
                    .setPositiveButton("OK",null).show();
        }));

        //buat toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        //pasang toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Purnama");
        toolbar.setSubtitle("https://github/Purnama-Mi5B");
        toolbar.setLogo(android.R.drawable.ic_dialog_map);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mi_list_country:
//                Toast.makeText(this, "Andre Memilih: "+item.getItemId(), Toast.LENGTH_SHORT).show();
                break;
            case  R.id.mi_card_country:
//                Toast.makeText(this, "Andre Memilih: "+item.getItemId(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}