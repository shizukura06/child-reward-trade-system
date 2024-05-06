package cloud.lucero.crts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import cloud.lucero.crts.control.DbConn;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    DbConn conn;
    Connection connection;
    TextView name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        tabLayout = findViewById(R.id.tabs);
        viewPager2 = findViewById(R.id.viewpager2);
        name = findViewById(R.id.child_name);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        try {
            connection = DbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM crts_child WHERE id = ?");
            statement.setString(1, "1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                name.setText(resultSet.getString("name"));
            }
            connection.close();
        } catch (Exception ex) {
            Log.e("Error", ex.getMessage());
        }
    }
}