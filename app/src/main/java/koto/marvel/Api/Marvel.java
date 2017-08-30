package koto.marvel.Api;

import java.util.ArrayList;

import koto.marvel.Models.Basic;
import koto.marvel.Models.Data;
import koto.marvel.Models.SuperHero;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by KOTO on 26/08/2017.
 */

public interface Marvel {

    String BASE_URL = "https://gateway.marvel.com:443/";

    String API_KEY_KEY = "apikey";
    String API_KEY_VALUE = "28697e469dba62131372558a9436fdb7";

    String TIME_STAMP_KEY = "ts";
    String TIME_STAMP_VALUE = "1";

    String HASH_KEY = "hash";
    String HASH_VALUE = "f857365d96b5565d485a98abfc542d17";

    @GET("v1/public/comics/{seriesId}/characters")
    Call <Basic<Data<ArrayList<SuperHero>>>> getSuperHeroes(@Path("seriesId") int seriesId);

}
