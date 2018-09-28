package com.example.dwu.a20180927;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class hr_MarkerModel {
    private static hr_MarkerModel instance;
    private ArrayList<MarkerOptions> markerOptions = null;
    private ArrayList<Marker> markers = new ArrayList<>();
    private HashMap<String, Bank> bankList = new HashMap<>();

    public static hr_MarkerModel getInstance() {
        if(instance == null) {
            instance = new hr_MarkerModel();
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

            markerOptions.add(getLatLng("국민은행 도쿄지점(Tokyo Branch)", 35.6700529, 139.75672069999996));
            markerOptions.add(getLatLng("국민은행 런던지점(London Branch)", 51.514234f, -0.089630f));
            markerOptions.add(getLatLng("국민은행 오클랜드지점 (Auckland Branch Branch)", -36.8499084, 174.76240180000002));
            markerOptions.add(getLatLng("국민은행 호치민지점 (Ho Chi Minh City Branch )", 10.7814332, 106.70015869999997));
            markerOptions.add(getLatLng("국민은행 홍콩지점 (Hong Kong Branch )", 22.2797504, 114.1736684));

            markerOptions.add(getLatLng("우리은행 혜화동지점 (Hyehwa Branch)", 37.5849219,127.00107789999993));
            markerOptions.add(getLatLng("우리은행 상하이지점 (Shanghi Branch)", 31.211101, 121.405981));
            markerOptions.add(getLatLng("우리은행 시드니지점 (Sydney Branch)", -33.8710299, 151.2057714));
            markerOptions.add(getLatLng("우리은행 방글라데시지점 (BANGLADESH - DHAKA Branch)", 23.7834555, 90.41656820000003));
            markerOptions.add(getLatLng("우리은행 바레인지점 (Bahrain Branch)", 31.211101, 121.405981));
            markerOptions.add(getLatLng("우리은행 오중로지점 (Cambodia Branch)", 11.5339993, 104.91262340000003));
            markerOptions.add(getLatLng("우리은행 홍콩지점 (Hong kong Branch)", 22.277581, 114.16631200000006));
            markerOptions.add(getLatLng("우리은행 이란지점 (Iran Branch)", 35.7948495, 51.407966999999985));
            markerOptions.add(getLatLng("우리은행 첸나이지점 (CHENNAI Branch,India)", 12.9653851, 80.24704280000003));
            markerOptions.add(getLatLng("우리은행 하노이지점 (Hanoi Branch)",  21.01686, 105.78374159999998));
            markerOptions.add(getLatLng("우리은행 싱가폴지점 (Singapore Branch)", 35.6656575, 139.76102630000003));
            markerOptions.add(getLatLng("우리은행 두바이지점 (Dubai Branch)", 25.2139644, 55.28290519999996));
            markerOptions.add(getLatLng("우리은행 런던지점 (London Branch)", 51.5124447, -0.07904499999995096));
            markerOptions.add(getLatLng("우리은행 도쿄지점 (Tokyo Branch)", 35.6656575, 139.76102630000003));
            markerOptions.add(getLatLng("우리은행 뉴욕지점 (New York Branch)", 40.7546045, -73.974658900000013));

            markerOptions.add(getLatLng("농협은행 뉴욕지점 (New York Branch) ", 40.759736, -73.97680459999998));
            markerOptions.add(getLatLng("농협은행 바레인지점(BAHRAIN Branch)", 26.237012, 50.57714199999998));

            markerOptions.add(getLatLng("하나은행 아부다비지점(Abu Dhabi Branch)", 24.458718, 54.321781999999985));
            markerOptions.add(getLatLng("하나은행 두바이지점(Dubai Branch)", 25.2597568, 55.32103469999993));
            markerOptions.add(getLatLng("하나은행 바레인지점(Bahrain Branch)", 26.2342172, 50.57734920000007));
            markerOptions.add(getLatLng("하나은행 시드니지점(Sydney Branch)", -33.8658594, 151.2116714));
            markerOptions.add(getLatLng("하나은행 상파울로지점(Sao Paulo Branch)", -23.6220618, -46.6997614));
            markerOptions.add(getLatLng("하나은행 파리지점(Paris Branch)", 48.8700449, 2.3079056000000264));
            markerOptions.add(getLatLng("하나은행 하나은행 토론토지점(Toronto Branch)", 43.7648261, -79.41280230000001));
            markerOptions.add(getLatLng("하나은행 암스텔담지점(Toronto Branch)", 52.2806114, 4.841526799999997));
            markerOptions.add(getLatLng("하나은행 독일지점(Germany Branch)", 50.11719919999999, 8.664386799999988));
            markerOptions.add(getLatLng("하나은행 홍콩지점(Hong Kong Branch)",  22.27994, 114.16407900000002));
            markerOptions.add(getLatLng("하나은행 첸나이지점(Chennai Branch)", 13.0440983, 80.27036670000007));
            markerOptions.add(getLatLng("하나은행 인도네시아 본점(Indonesia Branch)", -6.2210217, 106.81427789999998));
            markerOptions.add(getLatLng("하나은행 도쿄지점(Tokyo Branch)", 35.6763594, 139.7622278));
            markerOptions.add(getLatLng("하나은행 오사카지점(Osaka Branch)", 34.6910047, 135.5002349));
            markerOptions.add(getLatLng("하나은행 하노이지점(Hanoi Branch)", 21.0308761, 105.81256800000006));
            markerOptions.add(getLatLng("하나은행 마닐라지점(Osaka Branch)", 14.558135, 121.02676599999995));
            markerOptions.add(getLatLng("하나은행 호치민지점(Ho Chi Minh City Branch)", 10.7769296, 106.69828410000002));
            markerOptions.add(getLatLng("하나은행 뉴욕지점 (New York Branch)", 40.7620173, -73.97099630000002));
            markerOptions.add(getLatLng("하나은행 런던지점(London Branch)", 51.5140901, -0.09073250000005828));

            markerOptions.add(getLatLng("기업은행 마닐라지점(Manila Branch)", 14.5531174, 121.0533074));
            markerOptions.add(getLatLng("기업은행 뉴욕지점(New York Branch)", 40.7476831, -73.98786969999998));
            markerOptions.add(getLatLng("기업은행 도쿄지점(Tokyo Branch)", 35.6634944, 139.74452599999995));
            markerOptions.add(getLatLng("기업은행 홍콩지점(Hong Kong Branch)", 22.277581, 114.16631200000006));
            markerOptions.add(getLatLng("기업은행 런던지점(London Branch)",  51.5152095, -0.08383639999999559));
            markerOptions.add(getLatLng("기업은행 호치민지점(Ho Chi Minh City Branch)", 10.781063, 106.698442));
            markerOptions.add(getLatLng("기업은행 하노이지점(Hanoi Branch)",  21.0168415, 105.78375240000003));
            markerOptions.add(getLatLng("기업은행 뉴델리지점(New Delhi Branch)",  28.551684, 77.12269309999999));
            markerOptions.add(getLatLng("기업은행 베이징분행(Beijing Branch)",  39.933117, 116.45275700000002));
            markerOptions.add(getLatLng("기업은행 텐진분행(Tianjin Branch)",  39.119347, 117.19260699999995));
            markerOptions.add(getLatLng("기업은행 칭다오분행(Qingdao Branch)", 36.1002207, 120.46623090000003));


            bankList.put("국민은행 도쿄지점(Tokyo Branch)",
                    addBank("국민은행 도쿄지점", "국민은행",
                            "Hibiyadai Bldg, 14F, 1-2-2 Uchisaiwaicho, Chiyoda-ku, Tokyo 100-0011, Japan",
                            "Mon~Fri, 09:00 ~ 15:00",
                            "81-3-5657-0550", "www.kbstar.com/",
                            37.518919f, 127.024672f));

            bankList.put("국민은행 런던지점(NewYork Branch)",
                    addBank("국민은행 런던지점", "국민은행",
                            "6th Floor, Princes court, 7 Princess Street, London EC2R 8AQ, UK",
                            "Mon~Fri, 08:30~17:00",
                            "44-20-7710-8300", "global.kbstar.com",
                            51.514214f, -0.089625f));
            bankList.put("국민은행 오클랜드지점 (Auckland Branch Branch)",
                    addBank("국민은행 오클랜드지점", "국민은행",
                            "Level 19, Auckland Coucil, 135 Albert Street, PO Box 7506, Wellesley Street, Auckland CBD, New Zealand, 1010",
                            "Mon~Fri, 09:00~16:30",
                            "+64 9 366 1000", "global.kbstar.com",
                            -36.8499084, 174.76240180000002));
            bankList.put("국민은행 호치민지점 (Auckland Branch Branch)",
                    addBank("국민은행 호치민지점", "국민은행",
                            "3F MPlaza Saigon 39 Le Duan Street, District 1, Hochiminh City, Vietnam",
                            "Mon~Fri, 08:30~16:30",
                            "84-28-3827-9000", "global.kbstar.com",
                            -36.8499084, 174.76240180000002));
            bankList.put("국민은행 홍콩지점 (Hong Kong Branch )",
                    addBank("국민은행 홍콩지점", "국민은행",
                            "Suite 1101 and 1106,11/F.,Central Plaza, 18 Harbour Road, Wanchai, Hong Kong",
                            "Mon~Fri, 08:30~16:30",
                            "852-2530-3633", "global.kbstar.com",
                            -36.8499084, 174.76240180000002));

            bankList.put("우리은행 혜화동지점 (Hyehwa Branch/외국인특화점)",
                    addBank("우리은행 혜화동지점", "우리은행",
                            "서울특별시 종로구 창경궁로 270 (혜화동, 우리은행)",
                            "Mon~Fri, 9:00 ~ 16:00",
                            "02)766-5321", "http://www.wooribankchina.com/",
                            37.5849219,127.00107789999993));
            bankList.put("우리은행 상하이 지점(shanghi Branch)",
                    addBank("우리은행 상하이지점", "우리은행",
                            "Hongqiao Bridge, 창닝 구 중국 200336",
                            "Mon~Fri, 9:30 ~ 16:00",
                            "400 6789 001", "http://www.wooribankchina.com/",
                            31.211101, 121.405981));
            bankList.put("우리은행 시드니지점 (Sydney Branch)",
                    addBank("우리은행 시드니지점", "우리은행",
                            "Suite 25.03, Level 25, 363 George Street, Sydney NSW 2000 Australia",
                            "Mon~Fri, 9:30 ~ 16:00",
                            "61-2-8222-2200", "http://www.wooribankchina.com/",
                            -33.8710299, 151.2057714));
            bankList.put("우리은행 방글라데시지점 (BANGLADESH - DHAKA Branch)",
                    addBank("우리은행 방글라데시지점", "우리은행",
                            "SUVASTU IMAM SQUARE (1ST FLOOR & 4TH FLOOR), 65 GULSHAN AVENUE, DHAKA-1212, BANGLADESH",
                            "Sun ~ Thu, 10:00 ~ 16:00 ※ Friday,Saturday Closed",
                            "880-2-58813270~3", "http://www.wooribankchina.com/",
                            23.7834555, 90.41656820000003));
            bankList.put("우리은행 바레인지점 (BANGLADESH - DHAKA Branch)",
                    addBank("우리은행 바레인지점", "우리은행",
                            "4th Floor, Entrance 1, Manama Centre Building, Manama, Bahrain",
                            "Sun ~ Thu, 07:30 ~ 14:30",
                            "973-17-223503", "http://www.wooribankchina.com/",
                            26.237012, 50.57714199999998));
            bankList.put("우리은행 오중로지점 ( Wuzhong Rd Branch)",
                    addBank("우리은행 오중로지점", "우리은행",
                            "上海市 闵行区 吴中路1068号 燎申国际大厦1层C室" +
                                    "1C, Liaoshen Building, 1068 Wuzhong Road, Minhang District, Shanghai, 201103, China",
                            "Mon ~ Fri, 09:00 ~ 16:30",
                            "86-021-6446-7887", "http://www.wooribankchina.com/",
                            31.177935, 121.386346));
            bankList.put("우리은행 홍콩지점 ( Wuzhong Rd Branch)",
                    addBank("우리은행 홍콩지점", "우리은행",
                            "Suite 1401, Two Pacific Place, 88 Queensway, Hong Kong" ,
                            "Mon ~ Fri, 09:30 ~ 16:30",
                            "852-2521-8016", "http://www.wooribankchina.com/",
                            22.277581, 114.16631200000006));
            bankList.put("우리은행 이란지점 (Iran Branch)",
                    addBank("우리은행 이란지점", "우리은행",
                            "1st Floor, NO. 18, Jim ST., Moghadas Ardebili St., Mahmoudiyeh, Tehran," +
                                    " Iran Postal Code 1985653511" ,
                            "Sat ~ wed, 09:00 ~ 18:00(local time)",
                            "+98 21 2204 6975", "http://www.wooribankchina.com/",
                            35.7948495, 51.407966999999985));
            bankList.put("우리은행 첸나이지점 (CHENNAI Branch,India)",
                    addBank("우리은행 이란지점", "우리은행",
                            "Lotte India, 2nd Floor, No: 4/169, Rajiv Gandhi Salai (OMR), Kandhanchavadi," +
                                    "Perungudi Taluk, Chennai - 600096, Tamilnadu, India" ,
                            "Mon ~ Fri, 9:30 am - 4:30 pm " +
                                         "Sat.(1st, 3rd & 5th) : 9:30 am - 4:30 pm " +
                                         "※ Sat.(2nd & 4th), Sun. and Holidays closed",
                            "91-44-3346-6900", "http://www.wooribankchina.com/",
                            12.9653851, 80.24704280000003));
            bankList.put("우리은행 도쿄지점 (Tokyo Branch)",
                    addBank("우리은행 도쿄지점", "우리은행",
                            "Shiodome City Center 10th Floor Higashi-Shimbashi 1-Chome 5-2, Minato-ku, Tokyo",
                            "Mon ~ Fri,09:00 ~ 15:00" ,
                            "81-3-6891-5600", "http://www.wooribankchina.com/",
                            35.6656575, 139.76102630000003));
            bankList.put("우리은행 하노이지점 (Hanoi Branch)",
                    addBank("우리은행 하노이지점", "우리은행",
                            "24F, Keangnam Landmark 72, E6 Pham Hung Road, Tu Liem District. Hanoi, Vietnam",
                            "Mon ~ Fri, 08:30 ~ 12:00 / 13:00 ~ 16:30",
                            "024-3831-5281" , "http://www.wooribankchina.com/",
                            35.6656575, 139.76102630000003));
            bankList.put("우리은행 싱가폴지점 (Singapore Branch)",
                    addBank("우리은행 싱가폴지점", "우리은행",
                            "10 Marina Boulevard #13-05 MBFC Tower 2 Singapore 018983",
                            "Mon ~ Fri,  08:30 ~ 12:00 / 13:00 ~ 16:30",
                            "65-6422-2000" , "http://www.wooribankchina.com/",
                            1.2794767, 103.85386470000003));
            bankList.put("우리은행 두바이지점 (Dubai Branch)",
                    addBank("우리은행 두바이지점", "우리은행",
                            "1102A, The Gate Building, East Wing, Dubai International Financial Centre, P.O. Box 506760, Dubai, United Arab Emirates",
                            "Sun-Thu, 8:00 ~ 17:00",
                            "971-4-325-8365" , "http://www.wooribankchina.com/",
                            25.2139644, 55.28290519999996));
            bankList.put("우리은행 런던지점 (London Branch)",
                    addBank("우리은행 런던지점", "우리은행",
                            "9th Floor, 71 Fenchurch Street, London, EC3M 4BR, UK",
                            "Mon ~ Fri, 09:30 ~ 16:30",
                            "44-207-680-0680" , "http://www.wooribankchina.com/",
                            25.2139644, 55.28290519999996));
            bankList.put("우리은행 뉴욕지점 (NewYork Branch)",
                    addBank("우리은행 뉴욕지점", "우리은행",
                            "245 Park Avenue, 43rd Floor (46th ST & 47th St 사이) New York, NY 10167, U.S.A.",
                            "Mon ~ Fri, 09:30 ~ 16:00",
                            "1-212-949-1900" , "http://www.wooribankchina.com/",
                            40.7546045, -73.974658900000016));


            bankList.put("농협은행 뉴욕지점 (NewYork Branch)",
                    addBank("농협은행 뉴욕지점(NewYork Branch)", "농협은행",
                            "650 Fifth Ave.(52nd St.) 25th floor, New York, NY 10019",
                            "Mon ~ Fri, 09:00 ~17:00",
                            "+1 212-399-8100", "https://banking.nonghyup.com/servlet/PGMN0001R.view",
                            (float) 40.759736, -73.97680459999998));

            bankList.put("농협은행 하노이지점(Hanoi Branch)",
                    addBank("농협은행 하노이지점(Hanoi Branch)", "농협은행",
                            "14Fl., Lotte Center Hanoi, No. 54 Lieu Giai Str., Cong Vi Ward, Ba Dinh Dist., Hanoi",
                            "Mon ~ Fri, 08:30 ~ 12:00 / 13:00 ~ 16:30",
                            "971-2-681-7188", "https://banking.nonghyup.com/servlet/PGMN0001R.view",
                            21.032168, 105.81242700000007));

            bankList.put("하나은행 아부다비지점(Abu Dhabi Branch)",
                    addBank("하나은행 아부다비 지점(Abu Dhabi Branch)", "하나은행",
                            "8th Floor, Office Tower No.3, Etihad Towers, Al Ras Al Akhdar Street, Abu Dhabi, United Arab Emirates,(P.O.Box: 45636)",
                            "Sun-Thu, 8:30 ~ 17:30",
                            "971-4-228-1133", "https://www.kebhana.com/",
                            24.458718, 54.321781999999985));
            bankList.put("하나은행 두바이지점(Dubai Branch)",
                    addBank("하나은행 두바이 지점(Dubai Branch)", "하나은행",
                            "Office No.202 (Block A) 2nd Floor Concorde Complex Bldg., Dubai, U.A.E",
                            "Sun-Thu, 8:00 ~ 17:00",
                            "971-4-228-1133", "https://www.kebhana.com/",
                            25.2597568, 55.32103469999993));
            bankList.put("하나은행 시드니지점(Sydney Branch)",
                    addBank("하나은행 시드니지점(Sydney Branch)", "하나은행",
                            "Suite 1203, Level 12, Chifley Tower, 2 Chifley Square, Sydney NSW 2000 AUSTRALIA",
                            "Mon - Fri, 8:30 ~ 17:30",
                            " 61-2-9231-6333 ", "https://www.kebhana.com/",
                            -33.8658594, 151.2116714));
            bankList.put("하나은행 바레인지점 (BANGLADESH - DHAKA Branch)",
                    addBank("하나은행 바레인지점 (BANGLADESH - DHAKA Branch)", "하나은행",
                            "5th Floor, Yateem Center Bldg., Al Khalifa Road P.O. Box 5767, Manama, Bahrain",
                            "Sun - Thu, 07:30 ~ 16:00",
                            " +973-1722 9333 ", "https://www.kebhana.com/",
                            26.2342172, 50.57734920000007));
            bankList.put("하나은행 상파울로지점(Sao Paulo Branch)",
                    addBank("하나은행 상파울로 지점(Sao Paulo Branch)", "하나은행",
                            "Office No.202 (Block A) 2nd Floor Concorde Complex Bldg., Dubai, U.A.E",
                            "MON ~ FRI, 10:00 AM ~ 4:00 PM",
                            " +55-11-5188-1122 ", "https://www.kebhana.com/",
                            -23.6220618, -46.6997614));
            bankList.put("하나은행  파리지점(Paris Branch)",
                    addBank("하나은행  파리지점(Paris Branch)", "하나은행",
                            "Office No.202 (Block A) 2nd Floor Concorde Complex Bldg., Dubai, U.A.E",
                            "MON ~ FRI, 09:00 AM ~ 12:00 PM"+ "13:00 AM ~ 16:00 PM",
                            " +55-11-5188-1122 ", "https://www.kebhana.com/",
                            48.8700449, 2.3079056000000264));
            bankList.put("하나은행 토론토 지점(Toronto Branch)",
                    addBank("하나은행 토론토 지점(Toronto Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            43.7648261, -79.41280230000001));
            bankList.put("하나은행 암스텔담지점(Toronto Branch)",
                    addBank("하나은행 암스텔담지점(Toronto Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            52.2806114, 4.841526799999997));
            bankList.put("하나은행 독일지점(Germany Branch)",
                    addBank("하나은행 독일지점(Germany Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            50.11719919999999, 8.664386799999988));
            bankList.put("하나은행 홍콩지점(Hong Kong Branch)",
                    addBank("하나은행 홍콩지점(Hong Kong Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            22.27994, 114.16407900000002));
            bankList.put("하나은행 첸나이지점(Chennai Branch)",
                    addBank("하나은행 첸나이지점(Chennai Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            13.0440983, 80.27036670000007));
            bankList.put("하나은행 인도네시아 본점(Indonesia Branch)",
                    addBank("하나은행 인도네시아 본점(Indonesia Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            -6.2210217, 106.81427789999998));
            bankList.put("하나은행 도쿄지점(Tokyo Branch)",
                    addBank("하나은행 도쿄지점(Tokyo Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            35.6763594, 139.7622278));
            bankList.put("하나은행 오사카지점(Osaka Branch)",
                    addBank("하나은행 오사카지점(Osaka Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            34.6910047, 135.5002349));
            bankList.put("하나은행 하노이지점(Hanoi Branch)",
                    addBank("하나은행 도쿄지점(Tokyo Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            21.0308761, 105.81256800000006));
            bankList.put("하나은행 마닐라지점(Osaka Branch)",
                    addBank("하나은행 마닐라지점(Osaka Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            14.558135, 121.02676599999995));
            bankList.put("하나은행 호치민지점(Ho Chi Minh City Branch)",
                    addBank("하나은행 호치민지점(Ho Chi Minh City Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            10.7769296, 106.69828410000002));
            bankList.put("하나은행 뉴욕지점 (New York Branch)",
                    addBank("하나은행 뉴욕지점 (New York Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            40.7620173, -73.97099630000002));
            bankList.put("하나은행 런던지점(London Branch)",
                    addBank("하나은행 런던지점(London Branch)", "하나은행",
                            "4950 Yonge Street, Suite 1101,Toronto, Ontario, Canada M2N 6K1",
                            "MON ~ FRI, 09:30 AM ~ 16:00 PM",
                            "1-416-222-5200", "https://www.kebhana.com/",
                            51.5140901, -0.09073250000005828));

            bankList.put("기업은행 마닐라 지점(Manila Branch)",
                    addBank("기업은행 마닐라 지점(Manila Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            14.5531174, 121.0533074));
            bankList.put("기업은행 뉴욕지점(New York Branch)",
                    addBank("기업은행 뉴욕지점(New York Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            40.7476831, -73.98786969999998));
            bankList.put("기업은행 도쿄지점(Tokyo Branch)",
                    addBank("기업은행 도쿄지점(Tokyo Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            35.6634944, 139.74452599999995));
            bankList.put("기업은행 홍콩지점(Hong Kong Branch)",
                    addBank("기업은행 홍콩지점(Hong Kong Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            22.277581, 114.16631200000006));
            bankList.put("기업은행 런던지점(London Branch)",
                    addBank("기업은행 런던지점(London Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            51.5152095, -0.08383639999999559));
            bankList.put("기업은행 호치민지점(Ho Chi Minh City Branch)",
                    addBank("기업은행 호치민지점(Ho Chi Minh City Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            10.781063, 106.698442));
            bankList.put("기업은행 하노이지점(Hanoi Branch)",
                    addBank("기업은행 하노이지점(Hanoi Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            21.0168415, 105.78375240000003));
            bankList.put("기업은행 기업은행 뉴델리지점(New Delhi Branch)",
                    addBank("기업은행 기업은행 뉴델리지점(New Delhi Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            28.551684, 77.12269309999999));
            bankList.put("기업은행 기업은행 베이징분행(Beijing Branch)",
                    addBank("기업은행 기업은행 베이징분행(Beijing Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            39.933117, 116.45275700000002));
            bankList.put("기업은행 텐진분행(Tianjin Branch)",
                    addBank("기업은행 텐진분행(Tianjin Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            39.119347, 117.19260699999995));
            bankList.put("기업은행 칭다오분행(Qingdao Branch)",
                    addBank("기업은행 칭다오분행(Qingdao Branch)", "기업은행",
                            "Unit 801/802 One World Place 32nd St, Bonifacio Global City, Taguig City, Metro Manila",
                            " One World Place, 9th Ave, Taguig, Metro Manila, 필리핀",
                            "63-2-643-0700", "https://www.ibk.co.kr/",
                            36.1002207, 120.46623090000003));
            return markerOptions;
        }

        return markerOptions;
    }



    public Bank getBank(String key) {
        return bankList.get(key);
    }

    public boolean isBank(String key) {
        return bankList.containsKey(key);
    }

    private Bank addBank(String key, String bankName, String Address, String Businesshours,String phone, String site, double gX, double gY) {
        Bank b = new Bank();
        b.name = key;
        b.bankName = bankName;
        b.Address = Address;
        b.Businesshours = Businesshours;
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
