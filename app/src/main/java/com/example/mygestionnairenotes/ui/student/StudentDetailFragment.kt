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
//        window.decorView.apply{
//            system
//        }

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
//        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        Glide.with(requireContext()).load(R.drawable.ic_boy).into(img_student)
        lbl_number.text = "Num étu: " + student.number
//        lbl_firstName.text = student.person?.firstName
        lbl_lastName.text = student.person?.firstName + " " + student.person?.lastName
        lbl_phone.text =  student.person?.phone
        lbl_adress.text = student.person?.address
        lbl_city.text = student.person?.city
        lbl_zip.text = student.person?.zip
        lbl_email.text = student.person?.email
    }
}