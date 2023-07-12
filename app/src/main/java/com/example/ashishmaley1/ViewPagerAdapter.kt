package com.example.ashishmaley1
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(private val context: Context) : PagerAdapter() {
    interface OnboardingListener {
        fun onNextClicked()
    }

    internal var onboardingListener: OnboardingListener? = null

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    private val background = arrayOf(
        R.drawable.img,
        R.drawable.img_1,
        R.drawable.img_2
    )

    private val pageAmin = arrayOf(
        "About Us", "Our Mission", "Our Vision"
    )

    private val textArr = arrayOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam."
    )
    private val progressIndex = arrayOf(
        33.4,66.6,100.0
    )


    override fun getCount(): Int = pageAmin.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    @SuppressLint("MissingInflatedId")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = layoutInflater.inflate(R.layout.slider, container, false)
        val img = view.findViewById<View>(R.id.img)
        val heading = view.findViewById<View>(R.id.heading)
        val title = view.findViewById<View>(R.id.tit)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        val ready = view.findViewById<ImageView>(R.id.readybtn)
        val nextArrow = view.findViewById<ImageView>(R.id.nextArrow)
        if (img is ImageView) {
            img.setImageResource(background[position])
        }

        if (heading is TextView) {
            heading.text = pageAmin[position]
        }

        if (title is TextView) {
            title.text = textArr[position]
        }

        if (position == 2) {
            progressBar.visibility = View.GONE
            nextArrow.visibility = View.GONE
            ready.visibility = View.VISIBLE
        }

        progressBar.progress = progressIndex[position].toInt()

        nextArrow.setOnClickListener {
            onboardingListener?.onNextClicked()
        }

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}
