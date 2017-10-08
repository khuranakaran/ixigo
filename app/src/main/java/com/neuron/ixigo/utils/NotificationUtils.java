package com.neuron.ixigo.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

import com.neuron.ixigo.R;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NotificationUtils {
    private static final String TAG = "Notification Utils";
    // static ProgressDialog progressDialog;
    Context context;
    private List<String> permissionsList;
    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    final private int MARSHMALLOW_PERMISSION_DIALOG = 100;
    final private int PERMISSION_DENIED_DIALOG = 101;
    public static boolean isMarshmallowPermissionDialogVisible = false;

    /**
     * Method to check if network is available or not.
     *
     * @return true if network is available.
     */
    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI")) {
                if (ni.isConnected()) {
                    haveConnectedWifi = true;
                }
            }
            if (ni.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (ni.isConnected()) {
                    haveConnectedMobile = true;
                }
            }
        }

        return haveConnectedWifi || haveConnectedMobile;
    }

    public static void appLogs(String tag, String value) {
        Log.e(tag, value);
    }

    public static void showToast(Context context, int messageId, int length) {
        if (context == null) {
            return;
        }

        Toast.makeText(context, messageId, length).show();
    }

    public static void showToast(Context context, String message, int length) {
        if (context == null) {
            return;
        }

        Toast.makeText(context, message, length).show();
    }


    public static void errorDialog(final Context context, String servermessage) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Message");
        alertDialog.setMessage(servermessage);
        alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        alertDialog.show();
    }


    public static String timeStampConversion(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time);
        String date = DateFormat.format("HH:mm", cal).toString();
        return date;
    }

    public static String duration(long timestamp1, long timestamp2){
        Calendar cal1 = Calendar.getInstance(Locale.ENGLISH);
        cal1.setTimeInMillis(timestamp1);
        Date date1 = cal1.getTime();

        Calendar cal2 = Calendar.getInstance(Locale.ENGLISH);
        cal2.setTimeInMillis(timestamp2);
        Date date2 = cal2.getTime();
        long millis = date2.getTime() - date1.getTime();
        Log.e("Yes1",""+ date1.getTime()+ " "+date2.getTime());
        int Hours = (int) (millis/(1000 * 60 * 60));
        int Mins = (int) (millis % (1000*60*60));

        return Hours + "h " + Mins + "m";
    }



    public static int flightLogos(String airLineCode) {
        switch (airLineCode) {
            case "6E":
                return R.drawable.indigo;
            case "SG":
                return R.drawable.spicejet;
            case "AI":
                return R.drawable.air_india;
            case "9W":
                return R.drawable.jet_airways;
        }
        return R.drawable.default_flight_logo;
    }

    public static String providerNames(int providerId){
        switch (providerId) {
        case 1:
        return "MakeMyTrip";
        case 2:
        return "Cleartrip";
        case 3:
        return "Yatra";
        case 4:
        return "Musafir";
    }
        return "MakeMyTrip";
    }
}

