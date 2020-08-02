package com.example.mygestionnairenotes.ui.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygestionnairenotes.AppDatabase
import com.example.mygestionnairenotes.R
import com.example.mygestionnairenotes.data.local.StudentDataSourceImpl
import com.example.mygestionnairenotes.data.model.Person
import com.example.mygestionnairenotes.data.model.StudentEntity
import com.example.mygestionnairenotes.domain.StudentUseCaseImpl
import com.example.mygestionnairenotes.vo.Resource
import kotlinx.android.synthetic.main.content_student.*
import kotlinx.android.synthetic.main.fragment_student.*

class StudentFragment : Fragment(), StudentAdapter.StudentOnClickListener {

    private val viewModel by activityViewModels<StudentViewModel> {
        StudentVMFactory(
            StudentUseCaseImpl(
                StudentDataSourceImpl(
                    AppDatabase.getDatabase(requireActivity().applicationContext)
                )
            )
        )
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
        fab.setOnClickListener {
//            viewModel.insertStudent(
//                StudentEntity(
//                    "14632045",
//                    Person(
//                        "Julio",
//                        "Fermin",
//                        "102 rue Victor Duquesnay",
//                        "Schoelcher",
//                        "DOM",
//                        "97233",
//                        "jfermin79@gmail.com",
//                        "0696299677",
//                        "Masculin",
//                        "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Leader_Price_2010_Logo.svg/1200px-Leader_Price_2010_Logo.svg.png"
//                    )
//                )
//            )
//            Toast.makeText(requireContext(), "saved", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_navigation_etudiant_to_studentAddFragment)

        }
    }

    private fun setupObservers() {
        viewModel.fetchStudentList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    rv_etudiant.adapter =
                        StudentAdapter(requireContext(), it.data.toMutableList(), this)
                }
                is Resource.Failure -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error ${it.exception}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        rv_etudiant.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
    }

    override fun StudentOnClick(studentEntity: StudentEntity, position: Int) {
        val bundle = Bundle()
        bundle.putParcelable("student", studentEntity)
        findNavController().navigate(R.id.action_navigation_etudiant_to_studentDetailFragment, bundle)
    }
}