package com.example.mygestionnairenotes.ui.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mygestionnairenotes.R

class TeacherFragment : Fragment() {

    private lateinit var teacherViewModel: TeacherViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        teacherViewModel =
                ViewModelProviders.of(this).get(TeacherViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_teacher, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        teacherViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}