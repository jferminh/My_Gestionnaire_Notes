package com.example.mygestionnairenotes.ui.teacher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mygestionnairenotes.R
import com.example.mygestionnairenotes.data.model.TeacherEntity
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_teacher_detail.*


class TeacherDetailFragment : Fragment() {
    private lateinit var teacher: TeacherEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            teacher = it.getParcelable("teacher")!!
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(R.drawable.ic_boy).into(img_teacher)
        lbl_numberTeacher.text = "Num: " + teacher.number
        lbl_lastNameTeacher.text = teacher.person?.firstName + " " + teacher.person?.lastName
        lbl_phoneTeacher.text =  teacher.person?.phone
        lbl_adressTeacher.text = teacher.person?.address
        lbl_cityTeacher.text = teacher.person?.city
        lbl_zipTeacher.text = teacher.person?.zip
        lbl_emailTeacher.text = teacher.person?.email
    }

}