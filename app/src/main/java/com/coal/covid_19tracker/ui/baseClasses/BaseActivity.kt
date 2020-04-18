package com.coal.covid_19tracker.ui.baseClasses

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.coal.covid_19tracker.TrackerApplicationClass
import com.coal.covid_19tracker.di.components.ActivityComponent
import com.coal.covid_19tracker.di.components.DaggerActivityComponent
import com.coal.covid_19tracker.di.modules.ActivityModule
import com.coal.covid_19tracker.utilities.logs.AppLogger
import javax.inject.Inject

/**
 * Created by anupam on 26,March,2020
 */


abstract class BaseActivity<VM: BaseViewModel> : AppCompatActivity(){

    companion object{
        val TAG  =  "BaseActivity"
    }

    @Inject
    lateinit var viewModel: VM
    lateinit var networkChangeReceiver: BroadcastReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDependencies(buildActivityComponent())  // injecting dependency
        buildActivityComponent() //creating activity component
        setContentView(provideResourceId()) // one setContentView method for all acitivities, gets the resource id from the child class(activity)
        setupView(savedInstanceState) // for storing savedInstanceState
        setupObservers() // base activityObserver
        setUpBroadCastReceiver() //local board cast receiver
        viewModel.onCreate() //after setup base activity calling viewmodel's onCreate method, tell that activity's setup is done
    }


    /**
     * local broadCast reciever
     */
    private fun setUpBroadCastReceiver() {
        networkChangeReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                AppLogger.d("app", "Network connectivity change")
                onNetWorkChange()
            }
        }
    }

    /**
     * registering boardcast reciever
     */
    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkChangeReceiver, intentFilter)
    }

    /**
     * de-registering boardcast reciever
     */

    override fun onPause() {
        super.onPause()
        unregisterReceiver(networkChangeReceiver);
    }

    /**
     * building activity component, providing acivitycomponent to child activity to its abstract method injectDependencies
     */

    fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as TrackerApplicationClass).appComponent)
            .activityModule(ActivityModule(this))
            .build()


    /**
     * Base activity's observers
     */
    protected open fun setupObservers() {

    }

    //overridable funcations :: to give their own functionality for child classes
    open fun goBack() = onBackPressed()
    protected open fun onNetWorkChange(){}
    open fun isNetWorkConnected() = viewModel.checkInternetConnectionWithMessage()


    //abstract function that child has to override
    @LayoutRes
    protected  abstract  fun provideResourceId (): Int
    protected abstract fun setupView(savedInstanceState: Bundle?)
    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

}