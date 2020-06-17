package makoto.yoshida.uitesttutorial

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import makoto.yoshida.uitesttutorial.databinding.TestDialogFragmentBinding
import makoto.yoshida.uitesttutorial.viewmodel.TestDialogFragmentViewModel

@AndroidEntryPoint
class TestDialogFragment: DialogFragment() {
    private val vm by activityViewModels<TestDialogFragmentViewModel>()
    lateinit var binding: TestDialogFragmentBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        binding = DataBindingUtil.inflate(
            requireActivity().layoutInflater,
            R.layout.test_dialog_fragment,
            null,
            false
        )
        binding.lifecycleOwner = this
        binding.vm = vm

        builder.setView(binding.root)
        return builder.create()
    }
}