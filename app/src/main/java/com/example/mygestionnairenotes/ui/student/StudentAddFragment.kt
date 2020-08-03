package com.example.mygestionnairenotes.ui.student

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
import com.example.mygestionnairenotes.data.local.StudentDataSourceImpl
import com.example.mygestionnairenotes.data.model.Person
import com.example.mygestionnairenotes.data.model.StudentEntity
import com.example.mygestionnairenotes.domain.StudentUseCaseImpl
import kotlinx.android.synthetic.main.fragment_student_add.*


class StudentAddFragment : Fragment() {
    private val viewModel by activityViewModels<StudentViewModel> {
        StudentVMFactory(
            StudentUseCaseImpl(
                StudentDataSourceImpl(
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
        return inflater.inflate(R.layout.fragment_student_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ext_save_fab.setOnClickListener {
            viewModel.insertStudent(
                StudentEntity(
                    text_number.text.toString(),
                    Person(
                        text_prenom.text.toString(),
                        text_nom.text.toString(),
                        text_adresse.text.toString(),
                        text_commune.text.toString(),
                        "",
                        text_codigoPostal.text.toString(),
                        text_email.text.toString(),
                        text_telephone.text.toString(),
                        "Masculin",
                        ""

                    )

                )
            )
            Toast.makeText(requireContext(), "Etudiant enregistré", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_studentAddFragment_to_navigation_etudiant)
            true
        }


    }
}
