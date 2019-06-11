package br.com.vinicius.msgshareapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.vinicius.msgshareapp.models.Hobby
import br.com.vinicius.msgshareapp.R
import br.com.vinicius.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[holder.adapterPosition]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener{
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " Clicked!")}
            }

            itemView.imageShare.setOnClickListener{
                shareImageClick()
            }
        }

        private fun shareImageClick() {
            currentHobby?.let {
                val message: String = "My hobby is: ${currentHobby!!.title}"
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"
                context.startActivity(Intent.createChooser(intent, "Please select app: "))
            }
        }

        fun setData(hobby: Hobby?, pos: Int) {
            itemView.textViewTitle.text = hobby!!.title

            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}