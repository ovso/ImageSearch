package io.github.ovso.imagesearch.view.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import io.github.ovso.imagesearch.R
import io.github.ovso.imagesearch.databinding.ActivityMainBinding
import io.github.ovso.imagesearch.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.drawer_layout
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.app_bar_main.toolbar

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
  private var viewModel: MainViewModel? = null
  private var searchView: SearchView? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setupBinding(savedInstanceState)
    setupListUpdate();
    setupActionBar()
    setupDrawer()
    setupNavView()
  }

  private fun setupNavView() {
    nav_view.setNavigationItemSelectedListener(this)
  }

  private fun setupDrawer() {
    val toggle = ActionBarDrawerToggle(
        this, drawer_layout, toolbar, R.string.navigation_drawer_open,
        R.string.navigation_drawer_close
    )
    drawer_layout.addDrawerListener(toggle)
    toggle.syncState()
  }

  private fun setupActionBar() {
    setSupportActionBar(toolbar)
  }

  private fun setupBinding(savedInstanceState: Bundle?) {
    viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        .create(MainViewModel::class.java)
    val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    if (savedInstanceState == null) {
      viewModel!!.init()
    }
    binding.vm = viewModel
    binding.executePendingBindings()
  }

  private fun setupListUpdate() {
    viewModel?.loading?.value = View.VISIBLE
    viewModel?.mutableLiveData?.observe(this, Observer {
      viewModel?.loading?.value = View.GONE
      if (it.isNullOrEmpty()) {
        viewModel?.showEmpty?.value = View.VISIBLE
      } else {
        viewModel?.showEmpty?.value = View.GONE
        viewModel?.setItemsInAdapter(it)
      }
    })

  }

  override fun onBackPressed() {
    if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
      drawer_layout.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds mutableLiveData to the action bar if it is present.
    menuInflater.inflate(R.menu.main, menu)
    searchView = menu.findItem(R.id.action_search).actionView as SearchView
    searchView?.setOnQueryTextListener(viewModel?.onQueryTextChange)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    when (item.itemId) {
      R.id.action_search -> {

        return true
      }
      else -> return super.onOptionsItemSelected(item)
    }
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    // Handle navigation view item clicks here.
    when (item.itemId) {
      R.id.nav_camera -> {
        // Handle the camera action
      }
      R.id.nav_gallery -> {

      }
      R.id.nav_slideshow -> {

      }
      R.id.nav_manage -> {

      }
      R.id.nav_share -> {

      }
      R.id.nav_send -> {

      }
    }

    drawer_layout.closeDrawer(GravityCompat.START)
    return true
  }
}