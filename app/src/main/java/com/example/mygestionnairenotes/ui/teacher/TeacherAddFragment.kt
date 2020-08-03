package com.example.mygestionnairenotes.ui.teacher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mygestionnairenotes.AppDatabase
import com.example.mygestionnairenotes.R
import com.example.mygestionnairenotes.data.local.TeacherDataSourceImpl
import com.example.mygestionnairenotes.data.model.Person
import com.example.mygestionnairenotes.data.model.TeacherEntity
import com.example.mygestionnairenotes.domain.TeacherUseCaseImpl
import kotlinx.android.synthetic.main.fragment_teacher_add.*


class TeacherAddFragment : Fragment() {
    private val viewModel by activityViewModels<TeacherViewModel> {
        TeacherVMFactory(
            TeacherUseCaseImpl(
                TeacherDataSourceImpl(
                    AppDatabase.getDatabase(requireActivity().applicationContext)
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ext_save_fab_teacher.setOnClickListener {
            viewModel.insertTeacher(
                TeacherEntity(
                    text_numberTeacher.text.toString(),
                    Person(
                        text_prenomTeacher.text.toString(),
                        text_nomTeacher.text.toString(),
                        text_adresseTeacher.text.toString(),
                        text_communeTeacher.text.toString(),
                        "",
                        text_codigoPostalTeacher.text.toString(),
                        text_emailTeacher.text.toString(),
                        text_telephoneTeacher.text.toString(),
                        "Masculin",
                        ""
                    )
                )
            )
            Toast.makeText(requireContext(), "Enseignant enregistré", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_teacherAddFragment_to_navigation_enseignant)
            true
        }
    }


}