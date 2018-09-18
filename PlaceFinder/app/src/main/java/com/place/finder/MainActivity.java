package com.place.finder;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements
                OnMapReadyCallback,
                GoogleMap.OnMyLocationButtonClickListener,
                GoogleMap.OnMyLocationClickListener,
                GoogleMap.OnMarkerClickListener,
                LocationListener,
                BankCallbackListener{

    FullBottomSheetDialogFragment f;

    private LocationManager locationManager;
    private CharSequence[] filters = new String[]{"국민은행", "우리은행", "신한은행"};
    private GoogleMap mGoogleMap;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getFragmentManager();
        final MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.google_map);
        mapFragment.getMapAsync(this);

        ImageView user = findViewById(R.id.main_user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = LayoutInflater.from(v.getContext()).inflate(R.layout.user_profile, null, false);
                final TextView nick = view.findViewById(R.id.profile_sns_nick);
                TextView sns = view.findViewById(R.id.profile_sns_type);
                TextView logout = view.findViewById(R.id.logout);

                if(UserManager.getInstance().getType().equals("Google")) {
                    GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(MainActivity.this);
                    if (acct != null) {
                        String personName = acct.getDisplayName();
                        String personGivenName = acct.getGivenName();
                        String personFamilyName = acct.getFamilyName();
                        String personEmail = acct.getEmail();
                        String personId = acct.getId();
                        Uri personPhoto = acct.getPhotoUrl();

                        nick.setText(personName);
                    }
                } else if(UserManager.getInstance().getType().equals("KakaoTalk")) {
                    UserManagement.getInstance().me(new MeV2ResponseCallback() {
                        @Override
                        public void onSessionClosed(ErrorResult errorResult) {

                        }

                        @Override
                        public void onSuccess(MeV2Response result) {
                            nick.setText(result.getNickname());
                        }
                    });
                }

                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(UserManager.getInstance().getType().equals("Google")) {
                            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                    .requestEmail()
                                    .build();


                            GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(MainActivity.this, gso);
                            mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Utility.set(MainActivity.this, "sns", "");
                                    UserManager.getInstance().setType("");
                                    finish();
                                    Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                }
                            });
                        } else if(UserManager.getInstance().getType().equals("KakaoTalk")) {
                            UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
                                @Override
                                public void onCompleteLogout() {
                                    Utility.set(MainActivity.this, "sns", "");
                                    UserManager.getInstance().setType("");
                                    finish();
                                    Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);

                                }
                            });
                        }
                    }
                });

                sns.setText(Utility.get(MainActivity.this, "sns"));

                new MaterialDialog.Builder(MainActivity.this)
                        .customView(view, false)
                        .positiveText("확인")
                        .show();
            }
        });
        ImageView filter = findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(MainActivity.this)
                        .title("은행 필터")
                        .items(R.array.bank)
                        .itemsCallbackMultiChoice(new Integer[]{0, 1, 2}, new MaterialDialog.ListCallbackMultiChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                                filters = text;
                                return true;
                            }
                        })
                        .positiveText("확인")
                        .negativeText("취소")
                        .onAny(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                if(which == DialogAction.POSITIVE) {
                                    mapFragment.getMapAsync(MainActivity.this);
                                    Toast.makeText(MainActivity.this, "필터는 국민은행", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .show();
            }
        });

        TextView search = findViewById(R.id.main_search_item);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchDialog searchDialog = new SearchDialog();
                searchDialog.setBankCallbackListener(MainActivity.this);
                searchDialog.setStyle(android.app.DialogFragment.STYLE_NORMAL, R.style.AppTheme_FullScreen);
                searchDialog.show(getFragmentManager(), "");
            }
        });
    }

    private MarkerOptions getLatLng(String title, double latitude, double longitude) {
        LatLng l = new LatLng(latitude, longitude);
        MarkerOptions m = new MarkerOptions();
        m.position(l);
        m.title(title);
        return m;
    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mGoogleMap = googleMap;
        googleMap.clear();

        ArrayList<MarkerOptions> options = MarkerModel.getInstance().getMarkerList();

        for(MarkerOptions option: options) {
            for (CharSequence c: filters) {
                if(option.getTitle().contains(c)) {
                    if(c.equals("국민은행")) {
                        googleMap.addMarker(option)
                                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.kb_map));
                    } else if(c.equals("우리은행")) {
                        googleMap.addMarker(option)
                                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.woori_map));
                    } else if(c.equals("신한은행")) {

                    } else {
                        googleMap.addMarker(option);
                    }

                    Log.d("필터", "필터 포함되어있음");
                } else {
                    Log.d("필터", "필터 포함안됨");
                }
            }
        }

        googleMap.setOnMarkerClickListener(this);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(options.get(0).getPosition(), 14f));

        TedPermission.with(this)
                .setPermissionListener(new PermissionListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onPermissionGranted() {
                        googleMap.setMyLocationEnabled(true);
                        googleMap.setOnMyLocationButtonClickListener(MainActivity.this);
                        googleMap.setOnMyLocationClickListener(MainActivity.this);
                    }

                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {

                    }
                })
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                .check();
    }

    private void showBottomSheetDialogFullScreen() {
        f = new FullBottomSheetDialogFragment();
        f.show(getSupportFragmentManager(), "dialog");
    }



    @SuppressLint("MissingPermission")
    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "현재 위치값 받아오는중", Toast.LENGTH_SHORT).show();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, MainActivity.this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, MainActivity.this);
        return false;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "onMyLocationClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, "현재 위치 받아오기 성공! 리스트를 재 정렬합니다", Toast.LENGTH_SHORT).show();
        locationManager.removeUpdates(MainActivity.this);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(this, marker.getTitle(), Toast.LENGTH_SHORT).show();
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 17f));
        showBottomSheet(marker.getTitle());
        return false;
    }

    private void showBottomSheet(String title) {
        FullBottomSheetDialogFragment f = new FullBottomSheetDialogFragment();
        Bank bank = MarkerModel.getInstance().getBank(title);
        Bundle b = new Bundle();
        b.putSerializable("Bank", bank);
        f.setArguments(b);
        f.show(getSupportFragmentManager(), "dialog");

        LatLng latLng = new LatLng(bank.gX, bank.gY);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17f));
    }

    @Override
    public void onStartBank(String key, String name) {

        showBottomSheet(key);
    }
}
