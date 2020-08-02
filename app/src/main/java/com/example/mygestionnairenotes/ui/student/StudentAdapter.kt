package com.example.mygestionnairenotes.ui.student

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygestionnairenotes.R
import com.example.mygestionnairenotes.base.BaseViewHolder
import com.example.mygestionnairenotes.data.model.StudentEntity
import kotlinx.android.synthetic.main.student_row.view.*

class StudentAdapter(
    private val context: Context,
    private val studentsList: MutableList<StudentEntity>,
    private val itemClickListener: StudentOnClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface StudentOnClickListener{
        fun StudentOnClick(studentEntity: StudentEntity, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return StudentViewHolder(
            LayoutInflater.from(context).inflate(R.layout.student_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is StudentViewHolder -> holder.bind(studentsList[position], position)
        }
    }

    inner class StudentViewHolder(itemView: View) : BaseViewHolder<StudentEntity>(itemView) {
        override fun bind(item: StudentEntity, position: Int) {
            Glide.with(context).load(item.person?.image).centerCrop().into(itemView.img_student)
            itemView.txt_lastName.text = item.person?.lastName
            itemView.txt_firstName.text = item.person?.firstName
            itemView.setOnClickListener { itemClickListener.StudentOnClick(item, position) }
        }

    }
}