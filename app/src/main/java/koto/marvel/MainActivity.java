package koto.marvel;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import koto.marvel.Api.Marvel;
import koto.marvel.Api.MarvelService;
import koto.marvel.Models.Basic;
import koto.marvel.Models.Data;
import koto.marvel.Models.SuperHero;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final int ID_SERIE = 354;
    FrameLayout frameLayout;
    public static final String HERO_LIST_FRAGMENT = "HERO_LIST_FRAGMENT";
    public static final String ARRAY_LIST_HEROES = "ARRAY_LIST_HEROES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<Basic<Data<ArrayList<SuperHero>>>> callSuperHero = MarvelService.getMarvelApi().getSuperHeroes(ID_SERIE);

        callSuperHero.enqueue(new Callback<Basic<Data<ArrayList<SuperHero>>>>() {
            @Override
            public void onResponse(Call<Basic<Data<ArrayList<SuperHero>>>> call, Response<Basic<Data<ArrayList<SuperHero>>>> response) {
                Toast.makeText(MainActivity.this, response.body().getData().getResults().get(0).getName(), Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();

                bundle.putParcelableArrayList(ARRAY_LIST_HEROES,response.body().getData().getResults());

                frameLayout = (FrameLayout) findViewById(R.id.placeholder);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                HerloListFragment heroListFragment = new HerloListFragment();
                fragmentTransaction.add(R.id.placeholder,heroListFragment, HERO_LIST_FRAGMENT);
                fragmentTransaction.commit();

            }

            @Override
            public void onFailure(Call<Basic<Data<ArrayList<SuperHero>>>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
