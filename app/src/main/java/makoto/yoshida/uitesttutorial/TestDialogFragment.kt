package makoto.yoshida.uitesttutorial

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import makoto.yoshida.uitesttutorial.viewmodel.TestDialogFragmentViewModel

class TestDialogFragment: DialogFragment() {
    val vm by lazy {
        ViewModelProviders.of(this).get(TestDialogFragmentViewModel::class.java)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val view = requireActivity().layoutInflater.inflate(R.layout.test_dialog_fragment, null)
        builder.setView(view)
        return builder.create()
    }
}