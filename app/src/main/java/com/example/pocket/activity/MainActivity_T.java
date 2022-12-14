package com.example.pocket.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pocket.R;
import com.example.pocket.class_.cctv.CctvAdapter;
import com.example.pocket.class_.cctv.CctvVO;
import com.example.pocket.class_.database.DbHelper;
import com.example.pocket.fragment.Fra_cctv_T;
import com.example.pocket.fragment.Fra_chat_T;
import com.example.pocket.fragment.Fra_mypage_T;
import com.example.pocket.fragment.Fra_board;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity_T extends AppCompatActivity {
    BottomNavigationView bnv;
    FrameLayout fl;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    DbHelper dbHelper = new DbHelper();
    Bitmap bitmap;
    CctvVO data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_t);
        bnv = findViewById(R.id.bnv);
        fl = findViewById(R.id.fl);
        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        editor = pref.edit();

        // 어플을 처음 실행시켜줄때 첫화면이 Fragment1이 되게하기위해
        getSupportFragmentManager().beginTransaction().replace(
                R.id.fl, new Fra_cctv_T()).commit();






        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // 매개변수 menuItem => 내가 선택한 메뉴객체
                // 내가 선택한 아이탬의 id속성을 가져와서 어떤 메뉴를 선택했는지 판단
                switch (item.getItemId()){
                    case R.id.tab1:
                        String contentCctv = null;

                        do{
                            for(int i = 0 ; i<40;i++) {
                                contentCctv = dbHelper.connectServer("http://210.183.87.95:5000/CCTVlist", String.valueOf(pref.getString("scCode", "0")));

                            }
                            Log.v("CCTV", contentCctv);
                            editor.putString("contentCctv", contentCctv);

                            editor.apply();


                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.fl, new Fra_cctv_T()).commit();
                        }while (contentCctv==null);

                        break;

                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.fl, new Fra_chat_T()).commit();
                        break;
                    case R.id.tab3:
                        String content = null;

                        do{
                               for(int i = 0 ; i<40;i++) {
                                   content = dbHelper.connectServer("http://210.183.87.95:5000/list2", String.valueOf(pref.getString("scCode", "0")));

                               }
                                editor.putString("content", content);

                                editor.apply();

                                getSupportFragmentManager().beginTransaction().replace(
                                        R.id.fl, new Fra_board()).commit();
                            }while (content==null);




                        break;
                    case R.id.tab4:
                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.fl, new Fra_mypage_T()).commit();
                        break;
                }

                //event 처리가 끝나지 않았다
                //LongClick 일반클릭 안먹힘
                //return --> true 이벤트 종료를 감지해야한다

                return true;
            }
        });

        // bottombar에서 선택한 메뉴에 따라 FrameLayout에 올라갈
        // Fragment가 결정이 된다
        // : 어떤 메뉴가 선택 되었는지 알아내야함
        // 그래서 메뉴아이템에 Id값을 줬다!!

        // Fragment를 구현하는 방법
        // NavigatonView에서 선택한 메뉴에 따라
        // FragmentLayout에 표시할 Fragment를 바꾼다!



        // 1) 4번 Fragment에 버튼 넣고 Event주기
        // 2) 1번 Fragment에 WebView 넣고 Web띄우기
        // 3) 1)+2)
        // 4번에서 EditText에 url 작성후 버튼 누르면 URL정보를 Fragment1로 보내서
        // 웹페이지 띄우기




    }
}