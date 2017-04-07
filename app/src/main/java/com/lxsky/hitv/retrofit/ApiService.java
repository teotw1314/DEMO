package com.lxsky.hitv.retrofit;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by skyland on 2017/3/24
 */

@SuppressWarnings("unused")
public interface ApiService {



    @GET("service/getIpInfo.php/")
    Observable<ResponseBody> getData(@Query("ip") String ip);


    @GET("{url}")
    Observable<ResponseBody> executeGet(@Path("url") String url, @QueryMap Map<String, String> maps);

    @POST("{url}")
    Observable<ResponseBody> executePost(@Path("url") String url, @FieldMap Map<String, String> maps);

}
