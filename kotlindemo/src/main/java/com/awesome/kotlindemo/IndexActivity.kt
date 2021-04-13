package com.awesome.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.awesome.kotlindemo.login.LoginActivity
import com.awesome.kotlindemo.login.LogoutSuccessEvent
import com.awesome.kotlindemo.login.event.LoginSuccessEvent
import com.awesome.kotlindemo.wanadroid.WanAndroidFragment
import com.awesome.sdk.util.ToastUtils
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import com.jaeger.library.StatusBarUtil
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.activity_index.*
import kotlinx.android.synthetic.main.nav_header.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

private const val INDEX_VIEWPAGER_MOVIE_STR = "电影"
private const val INDEX_VIEWPAGER_ANDROID_STR = "安卓"
private const val INDEX_VIEWPAGER_ZHIHU_STR = "知乎"

class IndexActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var appBarLayoutVerticalOffset: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        setStatusBar()
        initDrawLayout()
        initViewPager()
    }

    private fun setStatusBar() {
        StatusBarUtil.setColorForDrawerLayout(this, drawer_layout, resources.getColor(R.color.colorPrimary), StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA)
    }

    public override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    public override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    private fun initDrawLayout() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            appBarLayoutVerticalOffset = verticalOffset
        })

        navigation.setNavigationItemSelectedListener(this)

        navigation.getHeaderView(0).findViewById<Button>(R.id.btn_goto_login).setOnClickListener {
            startActivity(Intent(this@IndexActivity, LoginActivity::class.java))
            drawer_layout.closeDrawer(GravityCompat.START)
        }

        checkLoginUserShow()
    }

    private fun checkLoginUserShow() {
        val defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this@IndexActivity)
        val loginUser = defaultSharedPreferences.getString("loginUser", null)
        val rlUnlogin = navigation.getHeaderView(0).findViewById<RelativeLayout>(R.id.rl_unlogin)
        val rlLogin = navigation.getHeaderView(0).findViewById<RelativeLayout>(R.id.rl_login)
        if (TextUtils.isEmpty(loginUser)) {
            rlUnlogin?.visibility = View.VISIBLE
            rlLogin?.visibility = View.INVISIBLE

            rlUnlogin?.postInvalidate()
        } else {
            rlLogin?.visibility = View.VISIBLE
            rlUnlogin?.visibility = View.INVISIBLE

            val user = Gson().fromJson(loginUser, User::class.java)
            val tvUsername = rlLogin.findViewById<TextView>(R.id.tv_username)
            tvUsername?.text = user.username
        }
    }

    private fun initViewPager() {
        val pages = FragmentPagerItems(this)
        arrayOf(INDEX_VIEWPAGER_ANDROID_STR, INDEX_VIEWPAGER_MOVIE_STR, INDEX_VIEWPAGER_ZHIHU_STR)
                .forEach {
                    when (it) {
                        INDEX_VIEWPAGER_ANDROID_STR -> pages.add(FragmentPagerItem.of("", WanAndroidFragment::class.java))
//                        INDEX_VIEWPAGER_MOVIE_STR -> {
//                            val element by lazy { FragmentPagerItem.of("", MovieFragment::class.java) }
//                            pages.add(element)
//                        }
                        INDEX_VIEWPAGER_ZHIHU_STR -> {
                            val element by lazy { FragmentPagerItem.of("", WanAndroidFragment::class.java) }
                            pages.add(element)
                        }
                    }
                }

        indexTabLayout.setCustomTabView { container, position, _ ->
            val icon = LayoutInflater.from(this@IndexActivity).inflate(R.layout.index_custom_tab_icon, container, false) as ImageView
            val res = this@IndexActivity.resources

            when (position) {
                0 -> icon.setImageDrawable(res.getDrawable(R.mipmap.index_icon_android))
//                1 -> icon.setImageDrawable(res.getDrawable(R.mipmap.index_icon_douban))
                1 -> icon.setImageDrawable(res.getDrawable(R.mipmap.index_icon_zhihu))
                else -> throw IllegalStateException("Invalid position: $position")
            }
            icon
        }

        indexViewPager.offscreenPageLimit = 3
        indexViewPager.adapter = FragmentPagerItemAdapter(supportFragmentManager, pages)
        indexTabLayout.setViewPager(indexViewPager)
    }

    override fun onNavigationItemSelected(it: MenuItem): Boolean {
        when (it.itemId) {
            R.id.nav_collect -> {
                val defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this@IndexActivity)
                val loginUser = defaultSharedPreferences.getString("loginUser", null)
                if (loginUser == null) {
                    ToastUtils.showToast(this@IndexActivity, "请先登录")
                } else {
//                    startActivity(Intent(this@IndexActivity, MyCollectActivity::class.java))
//                    drawer_layout.closeDrawer(GravityCompat.START)
                }
            }
            R.id.nav_open_source -> {
//                startActivity(Intent(this@IndexActivity, OpenSourceActivity::class.java))
//                drawer_layout.closeDrawer(GravityCompat.START)

            }
            R.id.nav_setting -> {
//                startActivity(Intent(this@IndexActivity, SettingActivity::class.java))
//                drawer_layout.closeDrawer(GravityCompat.START)

            }
        }
        return true
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onMessageEvent(event: LoginSuccessEvent) {
        checkLoginUserShow()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onMessageEvent(event: LogoutSuccessEvent) {
        checkLoginUserShow()
    }



}