package tw.edu.ccu.cs.xuhan.study_viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vp = findViewById<ViewPager2>(R.id.vp)
        var titles = arrayOf("安全","快速","匿名","無國界")
        var imgs = arrayOf(R.drawable.shield,R.drawable.quick,R.drawable.unknown,R.drawable.geolocalization)
        vp.adapter = PagerAdapter(titles,imgs)

        val indicator = findViewById<TabLayout>(R.id.indicator)

        TabLayoutMediator(indicator, vp) { tab, position ->
            tab.text = "${position + 1}"
        }.attach()

    }
}