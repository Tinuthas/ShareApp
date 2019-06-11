package br.com.vinicius.msgshareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.vinicius.msgshareapp.Constants
import br.com.vinicius.msgshareapp.R
import br.com.vinicius.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){

    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Safe Call ?.
        // Safe Call with let ?.let{}
        /*
        val bundle:Bundle? = intent.extras
        val msg = bundle!!.getString("message")
        showToast(msg, Toast.LENGTH_LONG)
        textViewUserMessage.text = msg*/

        val bundle:Bundle? = intent.extras
        bundle?.let {
            val msg:String? = bundle.getString(Constants.USER_MSG_KEY)
            showToast(msg!!, Toast.LENGTH_LONG)
            textViewUserMessage.text = msg
        }


    }
}