package com.place.finder;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class MarkerModel {
    private static MarkerModel instance;
    private ArrayList<MarkerOptions> markerOptions = null;
    private ArrayList<Marker> markers = new ArrayList<>();
    private HashMap<String, Bank> bankList = new HashMap<>();

    public static MarkerModel getInstance() {
        if(instance == null) {
            instance = new MarkerModel();
        }

        return instance;
    }

    public void setMarker(ArrayList<Marker> markers) {
        this.markers = markers;
    }

    public ArrayList<Marker> getMarkers() {
        return this.markers;
    }

    public ArrayList<MarkerOptions> getMarkerList() {
        if(markerOptions == null) {
            markerOptions = new ArrayList<>();

            markerOptions.add(getLatLng("국민은행 신사중앙지점", 37.518919f, 127.024672f));
            markerOptions.add(getLatLng("국민은행 런던지점", 51.514234f, -0.089630f));
            markerOptions.add(getLatLng("국민은행 도쿄지점", 35.670154f, 139.756829f));
            markerOptions.add(getLatLng("우리은행 신사동지점", 37.516884f, 127.019716f));

            bankList.put("국민은행 신사중앙지점",
                    addBank("국민은행 신사중앙지점", "국민은행",
                            "서울특별시 강남구 도산대로 149 진우빌딩",
                            "서울특별시 강남구 신사동 539-10",
                            "02-543-7862", "www.kbstar.com/",
                            37.518919f, 127.024672f));

            bankList.put("국민은행 런던지점",
                    addBank("국민은행 런던지점", "국민은행",
                            "6F, Princes Court, 7 Princes St, London EC2R 8AQ 영국",
                            "GW76+M5 시티오브런던 영국 London",
                            "+44 20 7710 8300", "global.kbstar.com",
                            51.514214f, -0.089625f));


            bankList.put("국민은행 도쿄지점",
                    addBank("국민은행 도쿄지점", "국민은행",
                            "14F, 1 Chome-2-2 Uchisaiwaicho, 千代田区, Chiyoda, Tokyo 100-0011 일본",
                            "14F, １丁目-２-2 内幸町 千代田区, 東京都 100-0011",
                            "+81 3-5657-0550", "global.kbstar.com",
                            35.670119f, 139.756791f));

            bankList.put("우리은행 신사동지점",
                    addBank("우리은행 신사동지점", "우리은행",
                            "서울특별시 강남구 강남대로 616 신사美타워",
                            "서울특별시 강남구 신사동 501",
                            "02-544-9884", "www.wooribank.com/",
                            37.516881f, 127.019745f));

            return markerOptions;
        }

        return markerOptions;
    }

    public Bank getBank(String key) {
        return bankList.get(key);
    }

    private Bank addBank(String key, String bankName, String newAddress, String oldAddress, String phone, String site, double gX, double gY) {
        Bank b = new Bank();
        b.name = key;
        b.bankName = bankName;
        b.newAddress = newAddress;
        b.oldAddress = oldAddress;
        b.phone = phone;
        b.site = site;
        b.gX = gX;
        b.gY = gY;

        return b;
    }

    private MarkerOptions getLatLng(String title, double latitude, double longitude) {
        LatLng l = new LatLng(latitude, longitude);
        MarkerOptions m = new MarkerOptions();
        m.position(l);
        m.title(title);
        return m;
    }
}
