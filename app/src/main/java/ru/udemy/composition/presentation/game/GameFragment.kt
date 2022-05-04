package ru.udemy.composition.presentation.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.udemy.composition.R
import ru.udemy.composition.databinding.FragmentGameBinding
import ru.udemy.composition.domain.entity.GameResult
import ru.udemy.composition.domain.entity.GameSettings
import ru.udemy.composition.domain.entity.Level
import ru.udemy.composition.presentation.gamefinished.GameFinishedFragment

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private lateinit var level: Level

    companion object {

        private const val KEY_LEVEL = "level"
        const val NAME = "GameFragment"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL, level)
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvOption1.setOnClickListener {
            launchGameFinishedFragment(GameResult(true, 10, 10, GameSettings(1, 1, 1, 1)))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun parseArgs() {
        requireArguments().getParcelable<Level>(KEY_LEVEL)?.let { result ->
            level = result
        }
    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}