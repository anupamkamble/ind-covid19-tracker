package com.coal.covid_19tracker.utilities.alerts

import androidx.fragment.app.FragmentActivity
import stream.customalert.CustomAlertDialogue

/**
 * Created by anupam on 29,March,2020
 */

object Dialog {

    fun showAlert(activity: FragmentActivity?, msg: String){
        val alert = CustomAlertDialogue.Builder(activity)
            .setStyle(CustomAlertDialogue.Style.DIALOGUE)
            .setTitle("Details")
            .setMessage(msg)
            .setNegativeText("OK")
            .setOnNegativeClicked { view, dialog -> dialog.dismiss() }
            .setDecorView(activity?.window?.decorView)
            .build()
        alert.show()
    }


}