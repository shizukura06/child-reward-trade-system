package cloud.lucero.crts.ui.login;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class FacebookUtils {

    public interface FacebookUserCallback {
        void onUserFetched(String name, String email);
    }

    public static void useLoginInformation(Activity activity, AccessToken accessToken, FacebookUserCallback callback) {
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        String name = object.optString("name");
                        String email = object.optString("email");

                        // Save login state and user info in SharedPreferences
                        SharedPreferences.Editor editor = activity.getSharedPreferences("login_credentials", Activity.MODE_PRIVATE).edit();
                        editor.putBoolean("isLogged", true);
                        editor.putString("name", name);
                        editor.putString("email", email);
                        editor.apply();

                        // Callback with user info
                        if (callback != null) {
                            callback.onUserFetched(name, email);
                        }

                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email");
        request.setParameters(parameters);
        request.executeAsync();
    }
}