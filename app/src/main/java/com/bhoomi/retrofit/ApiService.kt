package com.bhoomi.retrofit

import com.bhoomi.Data.LogResponces
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

   /* @GET("login.php")
    fun loginData(@Query("user")user: String, @Query("pass")pass: String):Call<LoginResponces>
*/
   @POST("UserLogin")
   fun looginData(@Field("username")username: String, @Field("password")password: String): Call<LogResponces>

    /* @POST("fetchusers")
     fun fetchUserDetails(@Body request: HomePageRequest): Call<HomePageResponse>

     @POST("getallmodeofpay")
     fun getPaymentMode(@Body request: PaymentModeRequest): Call<PaymentModeReponse>

     @POST("topupamtdropdown")
     fun getTopupAmt(@Body request: TopAmtRequest): Call<TopAmtResponse>

     @POST("addmanualtopup")
     fun addManualTopup(@Body request: AddManualTopRequest): Call<AddManualTopResponse>

     @POST("receiveamttopup")
     fun receivedManualTop(@Body request: ReceivedAmtTopRequest): Call<ReceivedAmtTopResponse>

     @POST("getallfranopelist")
     fun getAllFranopeList(@Body request: GetFranListRequest): Call<GetAllFranListResponse>

     @POST("dashboardcountdetail")
     fun dashboardUserDetails(@Body request: DashboardCountDetailsRequest): Call<DashboardCountDetailsResponse>

     @POST("searchuser")
     fun getSearchUserDetails(@Body request: SearchUserRequest): Call<DashboardCountDetailsResponse>

     @POST("getalluserinfo")
     fun getAllUserInfoDetails(@Body request: GetAllUserInfoRequest): Cal<GetAllUserInfoResponce>

     @POST("resetpassword")
     fun resetPassword(@Body request: ResetPasswordRequest): Call<ResetPasswordResponse>

     @POST("resetmacaddress")
     fun macReset(@Body request: ResetMacAddressRequest): Call<ResetMacAddressResponse>
 */

}