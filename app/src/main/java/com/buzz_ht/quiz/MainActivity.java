package com.buzz_ht.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.buzz_ht.quiz.adapter.Adapter;
import com.buzz_ht.quiz.model.Quiz;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle actionBarDrawerToggle;
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    TextView textView;
    FirebaseAuth firebaseAuth;
    NavigationView navigationView;
    LinearLayout forFrags;

    RecyclerView recyclerView;
    Adapter adapter;
    List<Quiz> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intilz();
        setUpViews();
        staticData();


        adapter = new Adapter(MainActivity.this, list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onNavigationItem(item);
                return false;
            }
        });
    }

    private void onNavigationItem(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btnProfile:

                Toast.makeText(getApplicationContext(), "HEELLLEELEdasdasdasd", Toast.LENGTH_SHORT).show();

                break;


            case R.id.btnAttribution:
                Toast.makeText(getApplicationContext(), "HEELLLEELEdasdasdasd", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnRate:
                Toast.makeText(getApplicationContext(), "HEELLLEELEdasdasdasd", Toast.LENGTH_SHORT).show();

                break;

        }


    }

    private void staticData() {

        list = new ArrayList<>();
        list.add(new Quiz(1, "General Knowledge", R.drawable.gk));
        list.add(new Quiz(2, "Science", R.drawable.science));
        list.add(new Quiz(3, "History", R.drawable.history));
        list.add(new Quiz(4, "Geography", R.drawable.geography));
        list.add(new Quiz(5, "Economics", R.drawable.economics));
        list.add(new Quiz(6, "Constitution", R.drawable.constitution));
        list.add(new Quiz(7, "Synonyms", R.drawable.eng_sy));
        list.add(new Quiz(8, "English Grammar\n(Coming Soon)", R.drawable.english_grammer));
        list.add(new Quiz(9, "Current Affair\n(Coming Soon)", R.drawable.current));


    }

    private void intilz() {

        toolbar = findViewById(R.id.appBarMaterial);
        drawerLayout = findViewById(R.id.ll);
        recyclerView = findViewById(R.id.recyclerView);
        firebaseAuth = FirebaseAuth.getInstance();
        navigationView = findViewById(R.id.navigationView);
        forFrags = findViewById(R.id.forFrags);
    }

    private void setUpViews() {
        setUpDrawerLayout();
        //setUpRecyclerView();

    }


    private void setUpDrawerLayout() {

        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.app_name, R.string.app_name);

        View hView = navigationView.getHeaderView(0);
        TextView textView = hView.findViewById(R.id.textemail);
        textView.setText(firebaseAuth.getCurrentUser().getEmail());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}