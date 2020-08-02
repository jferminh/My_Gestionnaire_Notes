package com.example.mygestionnairenotes.ui.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mygestionnairenotes.R
import com.example.mygestionnairenotes.data.model.StudentEntity
import kotlinx.android.synthetic.main.fragment_student_detail.*


class StudentDetailFragment : Fragment() {
    private lateinit var student: StudentEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            student = it.getParcelable("student")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(R.drawable.ic_launcher_foreground).centerCrop().into(img_student)
        lbl_number.text = student.number
        lbl_firstname.text = student.person?.firstName
        lbl_lastname.text = student.person?.lastName
        lbl_address.text = student.person?.address
    }
}