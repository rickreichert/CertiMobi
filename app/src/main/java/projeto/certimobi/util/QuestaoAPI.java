package projeto.certimobi.util;
import java.util.List;

import okhttp3.RequestBody;
import projeto.certimobi.domain.QuestaoAlternativa;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface QuestaoAPI {

    public static final String BASE_URL = "https://ricardoreichert.000webhostapp.com/api/";

    @GET("package/ctrl/{ctrlQuestao}")
    Call<QuestaoAlternativa> getLuxuryQuestao(@Path("ctrlQuestao") String ctrl);


    @FormUrlEncoded
    @POST("package/ctrl/CtrlQuestao.php")
    Call<QuestaoAlternativa> getOneQuestao( @Field("method") String method);


    @FormUrlEncoded
    @POST("package/ctrl/CtrlQuestao.php")
    Call<List<QuestaoAlternativa>> getManyQuestoes(@Field("method") String method);

    @Multipart
    @POST("package/ctrl/CtrlQuestao.php")
    Call<QuestaoAlternativa> sendImg(@Part("method") String method, @Part("name_image") String imageName, @Part("binary_image") RequestBody requestBody);

    @FormUrlEncoded
    @POST("package/ctrl/CtrlQuestao.php")
    Call<QuestaoAlternativa> sendHeader(@Header("mega-test") String megaTest, @Field("method") String method);

    @FormUrlEncoded
    @POST("package/ctrl/CtrlQuestao.php")
    Call<QuestaoAlternativa> saveQuestoes( @Field("method") String method, @Field("Questoes") String QuestoesJson);
}
