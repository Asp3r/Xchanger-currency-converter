package Modelos;

import com.google.gson.*;

public class ConvertidorJsonEnDivisaObjeto {

    /*
    ESTA CASE OBTIENE UN JSON EN FORMATO STRING Y DEVUELVE UNA INSTANCIA DE DivisaOjb
    CON LOS conversion_rates DEL JSON COMO VARIABLES DEL OBJETO
    */

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) ORIGINAL
            .setPrettyPrinting()
            .create();

    public DivisaObj cambiosDivisa (String jsonComoString){

        //convierto el jsonDivisa en un objeto:

        JsonObject divisasObjeto = gson.fromJson(jsonComoString, JsonObject.class);

        //convierto la parte de conversion_rates del jsonObject en otro objeto:

        JsonElement conversionRatesComoJsonElement
                = divisasObjeto.get("conversion_rates");

        //Convierto el conversion_rates de jsonElement a JsonObject:

        JsonObject conversionRatesComoJsonObject
                = conversionRatesComoJsonElement.getAsJsonObject();

        return new DivisaObj(
                conversionRatesComoJsonObject.get("ARS").getAsDouble(),
                conversionRatesComoJsonObject.get("BOB").getAsDouble(),
                conversionRatesComoJsonObject.get("BRL").getAsDouble(),
                conversionRatesComoJsonObject.get("CLP").getAsDouble(),
                conversionRatesComoJsonObject.get("COP").getAsDouble(),
                conversionRatesComoJsonObject.get("USD").getAsDouble());

    }

}
