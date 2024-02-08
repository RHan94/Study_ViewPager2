package tw.edu.ccu.cs.xuhan.study_viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TableLayout
import androidx.core.content.ContextCompat
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

        val indicator = findViewById<LinearLayout>(R.id.indicator)


         fun setupIndicators(count: Int) {
            val indicators = arrayOfNulls<ImageView>(count)
            val layoutParams: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(100, 100)
            layoutParams.setMargins(8, 0, 8, 0)
            for (i in indicators.indices) {
                indicators[i] = ImageView(this).apply {
                    this.setImageDrawable(ContextCompat.getDrawable(
                        context,
                        R.drawable.unselected) // 指定未選中圓點的樣式
                    )
                    this.layoutParams = layoutParams
                }
                indicator.addView(indicators[i])
            }
        }

        setupIndicators(imgs.size)

        fun updateIndicator(position: Int) {
            val childCount = indicator.childCount
            for (i in 0 until childCount) {
                val imageView = indicator.getChildAt(i) as ImageView
                if (i == position) {
                    imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.selected)) // 選中狀態
                } else {
                    imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.unselected)) // 未選中狀態
                }
            }
        }

        vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicator(position)
            }
        })

    }



}