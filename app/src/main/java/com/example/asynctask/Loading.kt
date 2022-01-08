package com.example.asynctask

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import androidx.core.widget.ContentLoadingProgressBar
import java.util.concurrent.TimeUnit

@SuppressLint("StaticFieldLeak")
class Loading (numberTextView: TextView, context: Context) : AsyncTask<Void, Void, Int>() {

//    private lateinit var loadingProgressBar: ContentLoadingProgressBar
    lateinit var progressDialog: ProgressDialog
    private val resultNumber = numberTextView
    val cntx = context

    override fun onPreExecute() {
        super.onPreExecute()
//        loadingProgressBar.show()
        progressDialog = ProgressDialog(cntx)
        progressDialog.setMessage("Подождите, идет загрузка...")
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    override fun doInBackground(vararg p0: Void?): Int {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (e: InterruptedException) {
            e.printStackTrace();
        }
//        loadingProgressBar.hide()
        return (1..100000).random()
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        progressDialog.dismiss()
        resultNumber.text = result.toString()
    }
}