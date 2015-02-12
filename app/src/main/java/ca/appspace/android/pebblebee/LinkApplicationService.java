package ca.appspace.android.pebblebee;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.preference.PreferenceManager;

import ca.appspace.android.pebblebee.ecobee.AuthorizeResponse;
import ca.appspace.android.pebblebee.ecobee.EcobeeAPI;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LinkApplicationService extends Service {

    private static final String TAG = LinkApplicationService.class.getSimpleName();
    private final Messenger _messenger = new Messenger(new IncomingHandler());
    public final static int REQUEST_NEW_CODE = 1;

    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REQUEST_NEW_CODE : {
                    Bundle data = msg.getData();

                    break;
                }
                default:
                    super.handleMessage(msg);
            }
        }
    }



    @Override
    public IBinder onBind(Intent intent) {
        return _messenger.getBinder();
    }


}
