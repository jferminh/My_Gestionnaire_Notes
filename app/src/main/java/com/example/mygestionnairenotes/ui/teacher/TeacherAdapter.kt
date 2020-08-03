package com.example.mygestionnairenotes.ui.teacher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygestionnairenotes.R
import com.example.mygestionnairenotes.base.BaseViewHolder
import com.example.mygestionnairenotes.data.model.TeacherEntity
import kotlinx.android.synthetic.main.student_row.view.*


class TeacherAdapter (
    private val context: Context,
    private val teacherList: MutableList<TeacherEntity>,
    private val itemClickListener: TeacherOnClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface TeacherOnClickListener{
        fun TeacherOnClick(teacherEntity: TeacherEntity, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return TeacherViewHolder(
            LayoutInflater.from(context).inflate(R.layout.student_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return teacherList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is TeacherViewHolder -> holder.bind(teacherList[position], position)
        }
    }

    inner class TeacherViewHolder(itemView: View) : BaseViewHolder<TeacherEntity>(itemView) {
        override fun bind(item: TeacherEntity, position: Int) {
            Glide.with(context).load(R.drawable.ic_boy).centerCrop().into(itemView.img_student)
            itemView.txt_lastName.text = item.person?.lastName
            itemView.txt_firstName.text = item.person?.firstName
            itemView.setOnClickListener { itemClickListener.TeacherOnClick(item,position) }
        }
    }
}