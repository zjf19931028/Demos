package com.awesome.recyclerviewdemo.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/13 17:16
 * Description:
 */
public interface APIService {
//    @GET("banner/json")
//    Call<String> getBannerList();

    //http://www.imooc.com/api/teacher?type=4&num=10
    @GET("api/teacher")/*api/teacher?type=4&num=10*/
    Call<Teacher> getCall(@Query("type") String type, @Query("num")String num);

    @GET("api/teacher")/*api/teacher?type=4&num=10*/
    Observable<Teacher> getInfoRx(@Query("type") int type, @Query("num")int num);
}
