package Adapter

import Models.User
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R
import kotlinx.android.synthetic.main.item_rv.view.*

class UserAdapter(val myClick: MyClick,var context: Context,private val userList:List<User>):RecyclerView.Adapter<UserAdapter.Vh>() {

    inner class Vh(var itemRv: View) : RecyclerView.ViewHolder(itemRv){
        fun onBind(user:User,pos:Int){
            itemRv.txt_item.text = user.name

            itemRv.txt_item2.text = user.number

            itemRv.card.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))

            itemRv.image_item.setOnClickListener {
                myClick.click(pos)
            }
            itemRv.delete.setOnClickListener {
                myClick.click(pos)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false))

    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(userList[position],position)
        holder.itemRv.card.setOnClickListener {
            Toast.makeText(context, "${userList[position].name} $position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = userList.size

    interface MyClick{
        fun click(pos:Int)
        fun delete(pos:Int)
    }

}