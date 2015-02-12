package ca.appspace.android.pebblebee;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import ca.appspace.android.pebblebee.ecobee.AuthorizeResponse;

public abstract class ApplicationLinkedEventReceiver extends BroadcastReceiver {

    public abstract void onCodeReceived(AuthorizeResponse response);
    public abstract void onFailure(String message);
    public abstract void onApplicationLinked();

    private static final String AUTH_RESPONSE = "pebblebee.extra.AUTH_RESPONSE";
    private static final String ERROR_MESSAGE = "pebblebee.extra.ERROR_MESSAGE";

    private final static String LINK_CODE_RECEIVED = "pebblebee.action.LINK_CODE_RECEIVED";
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
        Intent intent = new Intent();
        intent.putExtra(ERROR_MESSAGE, message);
        return intent;
    }

    public static Intent createAuthResponseIntent(Context context, AuthorizeResponse code) {
        Intent intent = new Intent();
        intent.putExtra(AUTH_RESPONSE, code);
        return intent;
    }

    public static IntentFilter getFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(LINK_CODE_RECEIVED);
        return filter;
    }
}
