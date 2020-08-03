package com.example.mygestionnairenotes.ui.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
import com.example.mygestionnairenotes.data.local.TeacherDataSourceImpl
import com.example.mygestionnairenotes.data.model.TeacherEntity
import com.example.mygestionnairenotes.domain.TeacherUseCaseImpl
import com.example.mygestionnairenotes.vo.Resource
import kotlinx.android.synthetic.main.content_teacher.*
import kotlinx.android.synthetic.main.fragment_teacher.*

class TeacherFragment : Fragment(), TeacherAdapter.TeacherOnClickListener {

    private val viewModel by activityViewModels<TeacherViewModel> {
        TeacherVMFactory(
            TeacherUseCaseImpl(
                TeacherDataSourceImpl(
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
        val root = inflater.inflate(R.layout.fragment_teacher, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
        fab_teacher.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_enseignant_to_teacherAddFragment)
        }
    }
    private fun setupObservers(){
        viewModel.fetchTeacherList.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading -> {
                    progressBarTeacher.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBarTeacher.visibility = View.GONE
                    rv_teacher.adapter =
                        TeacherAdapter(requireContext(),it.data.toMutableList(), this)

                }
                is Resource.Failure -> {
                    progressBarTeacher.visibility = View.GONE
                    Toast.makeText(requireContext(), "Error ${it.exception}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }
    private fun setupRecyclerView(){
        rv_teacher.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
        }
    }

    override fun TeacherOnClick(teacherEntity: TeacherEntity, position: Int) {
        val bundle = Bundle()
        bundle.putParcelable("teacher", teacherEntity)
        findNavController().navigate(R.id.action_navigation_enseignant_to_teacherDetailFragment, bundle)
    }
}