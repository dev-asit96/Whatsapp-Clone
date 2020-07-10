package com.asit.chatoo.Fragments;

import Notification.MyResponse;
import Notification.Sender;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    String API_KEY = "AAAA1CwhTb0:APA91bGWWn7EITLQ3wBcrQPM6cWG-7Eap6broRcd1Oak5UTkEIhIKNsWqSVOD0_HiwOaPzSvIQOZre5ueKVR9_VdsW-KNFeKFwil-55sPd1oFOGZIG7Kx3eTcaHLdEhoQa3xgTefxt9q";
    @Headers({"Authorization:key="+API_KEY, "Content-Type:application/json"})

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
