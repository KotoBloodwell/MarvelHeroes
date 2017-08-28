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

    @GET("v1/public/comics/{seriesId}/characters?ts=1&apikey=28697e469dba62131372558a9436fdb7&hash=f857365d96b5565d485a98abfc542d17")
    Call <Basic<Data<ArrayList<SuperHero>>>> getSuperHeroes(@Path("seriesId") int seriesId);

}
