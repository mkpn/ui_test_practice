package makoto.yoshida.uitesttutorial

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import makoto.yoshida.uitesttutorial.databinding.TestDialogFragmentBinding
import makoto.yoshida.uitesttutorial.viewmodel.TestDialogFragmentViewModel

class TestDialogFragment: DialogFragment() {
    val vm by viewModels<TestDialogFragmentViewModel>()
    lateinit var binding: TestDialogFragmentBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        vm.setup(requireContext())
        binding = DataBindingUtil.inflate(
            requireActivity().layoutInflater,
            R.layout.test_dialog_fragment,
            null,
            false
        )

        binding.vm = vm
        binding.lifecycleOwner = this

        builder.setView(binding.root)
        return builder.create()
    }
}