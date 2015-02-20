package ca.appspace.android.pebblebee;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import ca.appspace.android.pebblebee.ecobee.AuthorizeResponse;
import ca.appspace.android.pebblebee.ecobee.TokenResponse;

public abstract class ApplicationLinkedEventReceiver extends BroadcastReceiver {

    public abstract void onCodeReceived(AuthorizeResponse response);
    public abstract void onFailure(String message);
    public abstract void onApplicationLinked();

    private static final String AUTH_RESPONSE = "pebblebee.extra.AUTH_RESPONSE";
    private static final String TOKEN = "pebblebee.extra.TOKEN";
    private static final String ERROR_MESSAGE = "pebblebee.extra.ERROR_MESSAGE";

    private final static String LINK_CODE_RECEIVED = "pebblebee.action.LINK_CODE_RECEIVED";
    private final static String APP_LINKED = "pebblebee.action.APP_LINKED";
    private final static String ERROR = "pebblebee.action.ERROR";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case LINK_CODE_RECEIVED : {
                onCodeReceived((AuthorizeResponse) intent.getExtras().getSerializable(AUTH_RESPONSE));
                break;
            }
            case ERROR : {
                onFailure(intent.getExtras().getString(ERROR_MESSAGE));
                break;
            }

        }
    }

    public static Intent createErrorIntent(Context context, String message) {
        Intent intent = new Intent(ERROR);
        intent.putExtra(ERROR_MESSAGE, message);
        return intent;
    }

    public static Intent createAppLinkedIntent(Context context, TokenResponse token) {
        Intent intent = new Intent(APP_LINKED);
        intent.putExtra(TOKEN, token);
        return intent;
    }

    public static Intent createAuthResponseIntent(Context context, AuthorizeResponse code) {
        Intent intent = new Intent(LINK_CODE_RECEIVED);
        intent.putExtra(AUTH_RESPONSE, code);
        return intent;
    }

    public static IntentFilter getFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(LINK_CODE_RECEIVED);
        filter.addAction(ERROR);
        return filter;
    }
}
