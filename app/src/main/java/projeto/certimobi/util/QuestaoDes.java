package projeto.certimobi.util;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import projeto.certimobi.domain.QuestaoAlternativa;

public class QuestaoDes implements JsonDeserializer<Object> {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement QuestaoAlternativa = json.getAsJsonObject();
        ArrayList<JsonElement> array = new ArrayList<JsonElement>();
        List<QuestaoAlternativa> fim = new ArrayList<QuestaoAlternativa>();
        Integer c = 0;

        try {
            while ((json.getAsJsonObject().get("" + c)) != null) {
                array.add(QuestaoAlternativa = json.getAsJsonObject().get("" + c));
                c++;
            }
        } catch (Exception e) {
            for (JsonElement jc : array){
                fim.add(new Gson().fromJson(jc, QuestaoAlternativa.class));
            }
        }finally {
            for (JsonElement jc : array){
                fim.add(new Gson().fromJson(jc, QuestaoAlternativa.class));
            }
            return fim;
        }

    }
}
